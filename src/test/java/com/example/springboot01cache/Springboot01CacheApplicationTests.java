package com.example.springboot01cache;

import com.example.springboot01cache.cache.mapper.EmployeeMapper;
import com.example.springboot01cache.cache.service.EmployeeService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

    /* 数据库实体类 */
    @Autowired()
    EmployeeMapper employeeMapper;
    @Test
    public void mybatisTest(){
        System.out.println(employeeMapper.getEmployeeById(2));
    }

    @Autowired
    AmqpAdmin amqpAdmin;

    /**
     * direct   直连模式
     * fanout   发布/订阅模式
     * topic    匹配订阅模式
     * headers
     * custom   自定义模式
     */
   @Test
    public void rabbitMQtest(){
       /* 创建交换器 */
       amqpAdmin.declareExchange(new DirectExchange("direct_EX"));
       amqpAdmin.declareExchange(new FanoutExchange("fanout_EX"));
       amqpAdmin.declareExchange(new TopicExchange("topic_EX"));

       /* 创建队列 */
       amqpAdmin.declareQueue(new Queue("direct_queue"));
       amqpAdmin.declareQueue(new Queue("fanout_queue"));
       amqpAdmin.declareQueue(new Queue("queue_fanout"));
       amqpAdmin.declareQueue(new Queue("topic_queue"));

       /* 绑定 */
       //String destination, Binding.DestinationType destinationType, String exchange, String routingKey, Map<String, Object> arguments
       String[] exchange = {"direct_EX", "fanout_EX"};
       String[] queue = {"direct_queue", "fanout_queue", "queue_fanout", "topic_queue"};
       for(String ex:exchange){
           for(String qu:queue){
               amqpAdmin.declareBinding(new Binding(qu, Binding.DestinationType.QUEUE, ex, qu, null));
           }
       }
       /* 配置模式发送数据 */
       amqpAdmin.declareBinding(new Binding("direct_queue", Binding.DestinationType.QUEUE, "topic_EX", "#.queue", null));
       amqpAdmin.declareBinding(new Binding("fanout_queue", Binding.DestinationType.QUEUE, "topic_EX", "#.queue", null));
       amqpAdmin.declareBinding(new Binding("queue_fanout", Binding.DestinationType.QUEUE, "topic_EX", "queue.#", null));
       amqpAdmin.declareBinding(new Binding("topic_queue", Binding.DestinationType.QUEUE, "topic_EX", "topic.#", null));
   }

   @Autowired
   RabbitTemplate rabbitTemplate;
   @Test
   public void rabbitMQSend(){
       //rabbitTemplate.convertAndSend("fanout_EX", "topic_queue", "这是发给fanout_queue队列的数据");
       Map<String, String> map = new HashMap<>();
       map.put("1", "one");
       map.put("2", "two");
       map.put("3", "three");
       rabbitTemplate.convertAndSend("direct_EX", "direct_queue", "12345");
   }

   @Autowired
    RedisCacheManager redisCacheManager;
   @Autowired
    EmployeeService employeeService;
   @Test
   public void test(){
       System.out.println(employeeMapper.getEmployeeById(1));
       for (String name:redisCacheManager.getCacheNames()){
           System.out.println(name);
       }
       /*RedisCache redisCache = (RedisCache) redisCacheManager.getCache("AmpById_1");
       System.out.println(redisCache.getName());
       System.out.println(redisCache.get("getAmpById_1"));*/
   }
}