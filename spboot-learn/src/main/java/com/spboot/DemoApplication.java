package com.spboot;

import com.spboot.aop.MyAspect;
import com.spboot.redis.config.RedisConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.PostConstruct;

/**
 * @author feifei
 * @Classname DemoApplication
 * @Description TODO
 * @Date 2019/7/29 14:10
 * @Created by ChenS
 */
@SpringBootApplication(scanBasePackages = {"com.spboot"})
@MapperScan(basePackages = "com.spboot.*")
@EnableCaching
public class DemoApplication {
//    @Bean(name = "myaspect")
//    public MyAspect initMyAspect(){
//        return new MyAspect();
//
    @Autowired
    private RedisTemplate redisTemplate=null;

    @Autowired
    private RedisConnectionFactory connectionFactory=null;
    @Autowired
    private MessageListener redisMsgListener=null;

    //任务池
    private ThreadPoolTaskScheduler taskScheduler=null;

    @Bean
    public ThreadPoolTaskScheduler initTaskScheduler(){
        if (taskScheduler!=null){
            return taskScheduler;
        }
        taskScheduler=new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return  taskScheduler;
    }
    @Bean
    public RedisMessageListenerContainer initRedisContainer(){
        RedisMessageListenerContainer container=new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setTaskExecutor(initTaskScheduler());
        Topic topic=new ChannelTopic("topic1");
        container.addMessageListener(redisMsgListener,topic);
        return container;
    }

    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    private void initRedisTemplate(){
        RedisSerializer serializer=redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);

    }
    public static void main(String[] args){
//        ApplicationContext ctx=new AnnotationConfigApplicationContext(RedisConfig.class);
//        RedisTemplate redisTemplate=ctx.getBean(RedisTemplate.class);
////        redisTemplate.opsForValue().set("key1","value1");
////        redisTemplate.opsForHash().put("hash","filed","havlue");
//        useSessionCallback(redisTemplate);
       SpringApplication.run(DemoApplication.class,args);
    }

    /**
     * @author feifei
     * @param
     * @param redisTemplate
     * @Description TODO 使用sessioncallback一次连接执行多次插入
     * Rediscallback方法更偏向于底层，但可修改序列化机制
     * @Date 2019/9/4 11:08
     * @Created by 陈群飞
     * @return
     */
    public static void useSessionCallback(RedisTemplate redisTemplate){
        redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                operations.opsForValue().set("key2","value2");
                operations.opsForHash().put("hash1","field","hvalue");
                return null;
            }
        }
        );
    };

    @Autowired
    PlatformTransactionManager transactionManager=null;

    @PostConstruct
    public void viewTranscationManager(){
        System.out.println(transactionManager.getClass().getName());
    }
}
