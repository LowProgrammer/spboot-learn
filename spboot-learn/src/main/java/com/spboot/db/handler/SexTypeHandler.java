package com.spboot.db.handler;

import com.spboot.db.enums.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author feifei
 * @Classname SexTypeHandler
 * @Description TODO
 * @Date 2019/8/13 14:26
 * @Created by ChenS
 */
@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(value = SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {
    /**
     *@description 设置非空性别参数
     *@param ps,i,parameter,jdbcType
     *@returns
     *@author feifei
     *@data 2019/8/13
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int idx, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(idx,parameter.getId());
    }

    /**
     *@description 通过列名读取性别
     *@param rs,columnName
     *@returns
     *@author feifei
     *@data 2019/8/13
     */
    @Override
    public SexEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int sex=rs.getInt(columnName);
        if(sex!=1&&sex!=2){
            return null;
        }
        return SexEnum.getEnumById(sex);
    }

    /**
     *@description 通过下标读取性别
     *@param rs,columnIndex
     *@returns
     *@author feifei
     *@data 2019/8/13
     */
    @Override
    public SexEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int sex=rs.getInt(columnIndex);
        if(sex!=1&&sex!=2){
            return null;
        }
        return SexEnum.getEnumById(sex);
    }

    /**
     *@description 通过存储过程读取性别
     *@param cs columnIndex
     *@returns
     *@author feifei
     *@data 2019/8/13
     */
    @Override
    public SexEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int sex=cs.getInt(columnIndex);
        if(sex!=1&&sex!=2){
            return null;
        }
        return SexEnum.getEnumById(sex);
    }
}
