package com.zxb.mybatis.test;

import com.zxb.mybatis.mapper.usermapper;
import com.zxb.mybatis.pojo.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 赵学博
 * @create 2022-09-27 16:28
 */
public class mybatistest {
    /*
SqlSession默认不自动提交事物可以使用sqlSessionFactory.openSession(true);
     */

    @Test
    public void testmybtis() throws Exception {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlsessionfatorbuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        usermapper mapper = sqlSession.getMapper(usermapper.class);
        //测试功能
        int resilt = mapper.insertuser();
        // sqlSession.commit();
        System.out.println("resilt" + resilt);
    }

    @Test
    public void testupdate() throws Exception {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlsessionfatorbuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        usermapper mapper = sqlSession.getMapper(usermapper.class);
        boolean updateuser = mapper.updateuser();
        if (!updateuser){
            System.out.println("修改失败");
        }
        System.out.println("修改成功");
    }

    @Test
    public void testdelete() throws Exception {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlsessionfatorbuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        usermapper mapper = sqlSession.getMapper(usermapper.class);
        //mapper.updateuser();
        mapper.deleteuser();
    }

    @Test
    public void testuserId() throws Exception {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlsessionfatorbuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        usermapper mapper = sqlSession.getMapper(usermapper.class);
        user user = mapper.getuserId();
        System.out.println(user);
    }
}
