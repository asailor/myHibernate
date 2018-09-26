package com.itcast.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class test {
    @Test
    public void  text(){
        //1.加载核心文件，并且封装对象
     //   Configuration cfg=new Configuration();
      //  cfg.configure();
        //2.创建SessionFactory对象  读取核心文件  根据映射关系 配置数据库后把表创建
     //   SessionFactory sessionFactory=cfg.buildSessionFactory();
        // 3.创建Session对象  类似链接
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        //4.开启事务
        Transaction tx =session.beginTransaction();
        //数据库操作
//        User user=session.get(User.class,1);   修改操作
//        user.setUsername("信息");
//        user.setAddress("九院");
//        session.update(user);
        User user=new User();
        user.setUsername("薇恩");
        user.setPassword("123");
        user.setAddress("瓦罗兰大陆");
        session.save(user);


        //6.释放资源
        tx.commit();
        session.close();
        sessionFactory.close();;


    }


}
