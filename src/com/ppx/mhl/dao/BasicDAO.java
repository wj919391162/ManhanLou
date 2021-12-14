package com.ppx.mhl.dao;


import com.ppx.mhl.utils.JdbcUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *是其他dao的父类
 * * @version 1.8
 **/

public class BasicDAO<T> {  //泛型指定具体的类型

    private QueryRunner qr = new QueryRunner();

    //开通用的dml操作 针对任意的表
    public int update(String sql,Object... parameters){

        Connection connection = null;
        try {
            connection = JdbcUtilsByDruid.getConnection();
            int rows = qr.update(connection, sql, parameters);
            return rows;
        } catch (SQLException e) {
           throw new RuntimeException();
        } finally {
            JdbcUtilsByDruid.close(null,null,connection);
        }
    }

    /**
     * @param parameters 传入？
     * @param clazz 传入一个类的class对象
     * @return 根据Ppx.class 返回对应的arraylist集合
     **/
    //返回多个对象，针对任意表 查询多个多行结果
    public List<T> queryMulti(String sql,Class<T> clazz,Object... parameters){
        Connection connection = null;

        try {
            connection = JdbcUtilsByDruid.getConnection();
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), parameters);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JdbcUtilsByDruid.close(null,null,connection);
        }
    }

    //查询单行
    public T querySingle(String sql,Class<T> clazz,Object... parameters){
        Connection connection = null;

        try {
            connection = JdbcUtilsByDruid.getConnection();
            return qr.query(connection,sql,new BeanHandler<T>(clazz),parameters);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JdbcUtilsByDruid.close(null,null,connection);
        }
    }

    //查询单行单列，返回单值
    public Object queryScalar(String sql,Object... parameters){
        Connection connection = null;

        try {
            connection = JdbcUtilsByDruid.getConnection();
            return qr.query(connection,sql,new ScalarHandler(),parameters);
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            JdbcUtilsByDruid.close(null,null,connection);
        }
    }
}
