package com.zxb.mybatis.mapper;

import com.zxb.mybatis.pojo.user;

/**
 * @author 赵学博
 * @create 2022-09-27 16:02
 */
public interface usermapper {
         /*
           mybatis面向接口编程的两个一致
           映射文件的namespacey要和mapper接口的全类名保持一致
           映射文件中sql语句的id要和mapper接口中的方法名一致
           表-实体类-mapper接口-映射文件
          */
     /**
      添加用户信息
      */
    int insertuser();
    /**
     * 修改用户信息
     */
    boolean  updateuser();
    /**
     * 删除用户信息
     */
    void deleteuser();
    /**
     * 根据用户id查询用户信息
     */
    user getuserId();
}
