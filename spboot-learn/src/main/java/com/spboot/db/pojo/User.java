package com.spboot.db.pojo;

import com.spboot.db.enums.SexEnum;
import org.apache.ibatis.type.Alias;

/**
 * @author feifei
 * @Classname User
 * @Description TODO
 * @Date 2019/8/13 13:29
 * @Created by ChenS
 */
@Alias(value = "user")
public class User {
    private Long id=null;
    private String username=null;
    private SexEnum sex=null;
    private String note=null;
}
