package com.spboot.redis.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author feifei
 * @Classname RedisMessageListener
 * @Description TODO
 * @Date 2019/9/4 17:07
 * @Created by 陈群飞
 */
@Component
public class RedisMessageListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String body=new String(message.getBody());
        String topic=new String(pattern);

        System.out.println(body);
        System.out.println(topic);
    }
}
