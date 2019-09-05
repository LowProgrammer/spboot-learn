package com.spboot.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @author feifei
 * @Classname RedisController
 * @Description TODO
 * @Date 2019/9/4 11:33
 * @Created by 陈群飞
 */
@Controller
@RequestMapping("/redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate=null;

    @Autowired
    private StringRedisTemplate stringRedisTemplate=null;


    /**
     * @author feifei
     * @param
     * @Description TODO Redis发布订阅信息
     * @Date 2019/9/4 17:22
     */
    public void sendMessage(){

        redisTemplate.convertAndSend("topic","message");
    }

    @RequestMapping("/stirngAndHash")
    @ResponseBody
    public Map<String,Object> testStringAndHash(){
        redisTemplate.opsForValue().set("name","123");
        redisTemplate.opsForValue().set("int_key","1");
        stringRedisTemplate.opsForValue().set("int","1");
        stringRedisTemplate.opsForValue().increment("int",1);
        Jedis jedis=(Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();

        jedis.decr("int");
        Map<String,String> hash=new HashMap<>();
        hash.put("field1","value1");
        hash.put("field2","value2");
        stringRedisTemplate.opsForHash().putAll("hash",hash);

        stringRedisTemplate.opsForHash().put("hash","filed3","value3");
        BoundHashOperations hashops=stringRedisTemplate.boundHashOps("hash");
        hashops.delete("field1","field2");
        hashops.put("field4","value5");
        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping("/list")
    @ResponseBody
    public Map<String,Object> testlist(){
        stringRedisTemplate.opsForList().leftPushAll("list1","v2","v4","v6","v8","v10");
        stringRedisTemplate.opsForList().rightPushAll("list2","v1","v2","v3","v4","v5","v6");

        BoundListOperations listOperations=stringRedisTemplate.boundListOps("list2");
        Object result1=listOperations.rightPop();
        System.out.println(result1);
        Object result2=listOperations.index(1);
        System.out.println("result2:======="+result2);
        listOperations.leftPush("v0");
        Long size=listOperations.size();

        List elements=listOperations.range(0,size-2);
        for (int i = 0; i <elements.size() ; i++) {
            System.out.println(elements.get(i));
        }
        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;

    }
    @RequestMapping("/set")
    @ResponseBody
    public Map<String,Object> testSet(){

        stringRedisTemplate.opsForSet().add("set1","v1","v1","v2","v3","v4"
        ,"v5");
        stringRedisTemplate.opsForSet().add("set2","v2","v4","v6","v8");
        BoundSetOperations setOperations=stringRedisTemplate.boundSetOps("set1");
        setOperations.add("v6","v7");
        setOperations.remove("v1","v7");

        Set set1=setOperations.members();
        for (Iterator iterator=set1.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
        Long size=setOperations.size();

        Set ibter=setOperations.intersect("set2");
        Iterator iterator=ibter.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        setOperations.intersectAndStore("set2","inter");

        Set diff=setOperations.diff("set2");
        setOperations.diffAndStore("set2","diff");

        Set union=setOperations.union("set2");
        setOperations.unionAndStore("set2","union");



        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping("/zset")
    @ResponseBody
    public Map<String,Object> testZset(){

        Set<ZSetOperations.TypedTuple<String>> typedTupleSet=new HashSet<>();
        for (int i = 0; i < 9; i++) {
            double score=i*0.1;

            ZSetOperations.TypedTuple<String> typedTuple=new DefaultTypedTuple<>("value"+i,score);
            typedTupleSet.add(typedTuple);
        }

        stringRedisTemplate.opsForZSet().add("zset1",typedTupleSet);

        BoundZSetOperations<String,String> zSetOperations=stringRedisTemplate.boundZSetOps("zset1");

        zSetOperations.add("value10",0.26);
        Set<String> setRange=zSetOperations.range(1,6);
        Set<String> setScore=zSetOperations.rangeByScore(0.2,0.6);

        RedisZSetCommands.Range range=new RedisZSetCommands.Range();
        range.gt("value3");

        range.lte("value8");

        Set<String> setLex=zSetOperations.rangeByLex(range);
        zSetOperations.remove("value9","value2");

        Double score=zSetOperations.score("value8");
        Set<ZSetOperations.TypedTuple<String>> rangeSet=zSetOperations.rangeWithScores(1,6);
        Set<ZSetOperations.TypedTuple<String>> scoreSet=zSetOperations.rangeByScoreWithScores(1,6);
        Set<String> reverseSet=zSetOperations.reverseRange(2,8);

        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }
    @RequestMapping("/multi")
    @ResponseBody
    public Map<String,Object> testMulti(){
        redisTemplate.opsForValue().set("key1","value1");

        List list= (List) redisTemplate.execute(
                new SessionCallback() {
                    @Override
                    public Object execute(RedisOperations operations) throws DataAccessException {

                        operations.watch("key1");
                        operations.multi();
                        operations.opsForValue().set("key2","value2");
                      // operations.opsForValue().set("key1",1);

                        Object value2=operations.opsForValue().get("key2");
                        System.out.println("命令在队列，所以value为null"+value2);
                        operations.opsForValue().set("key3","value3");
                        Object value3=operations.opsForValue().get("key3");
                        System.out.println("命令在队列，所以value为null"+value3);
                        return operations.exec();
                    }
                }
        );
        System.out.println(list);
        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping("/pipeline")
    @ResponseBody
    public Map<String,Object> testPipeline(){
        Long start=System.currentTimeMillis();
        List list=redisTemplate.executePipelined(new SessionCallback() {

            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                for (int i = 0; i <= 100000; i++) {
                    operations.opsForValue().set("pipeline_"+i,"value_"+i);
                    String value= (String) operations.opsForValue().get("pipeline_"+i);
                    if (i==100000){
                        System.out.println("命令只是队列，所以值为空"+value);
                    }
                }

                return null;
            }
        });
        Long end=System.currentTimeMillis();
        System.out.println("耗时："+(end-start)+"毫秒");

        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping("/lua")
    @ResponseBody
    public Map<String,Object> testLua(){
        DefaultRedisScript<String> rs=new DefaultRedisScript<>();
        rs.setScriptText("return 'Hello Redis'");

        rs.setResultType(String.class);

        RedisSerializer<String> stringRedisSerializer=redisTemplate.getStringSerializer();

        String str= (String) redisTemplate.execute(rs,stringRedisSerializer,stringRedisSerializer,null);

        Map<String,Object> map=new HashMap<>();
        map.put("success",str);
        return map;
    }

    @RequestMapping("/lua2")
    @ResponseBody
    public Map<String,Object> testLua2(String key1,String key2,String value1,String value2){
        String lua="redis.call('set',KEYS[1],ARVG[1])\n" +
                "redis.call('set',KEYS[2],ARVG[2])\n" +
                "local str1=redis.call('get',KEYS[1])\n" +
                "local str2=redis.call('get',KEYS[2])\n" +
                "if str1==str2 then\n" +
                "return 1\n" +
                "end\n" +
                "return 0";
        System.out.println(lua);
        DefaultRedisScript<Long> rs=new DefaultRedisScript<>();
        rs.setScriptText(lua);
        rs.setResultType(Long.class);
        RedisSerializer<String> serializer=redisTemplate.getStringSerializer();

        List<String> keyList=new ArrayList<>();
        keyList.add(key1);
        keyList.add(key2);

        Long result= (Long) redisTemplate.execute(rs,serializer,serializer,keyList,value1,value2);
        Map<String,Object> map=new HashMap<>();
        map.put("success",result);
        return map;
    }
}
