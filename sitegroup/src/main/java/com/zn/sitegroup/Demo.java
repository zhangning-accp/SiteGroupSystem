package com.zn.sitegroup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by zn on 2018/12/13.
 */
@Slf4j

public class Demo {
    @Autowired
    Bean bean;
    public void test(){
        log.info("test");
        bean.print();
    }
    public static void main(String [] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        Demo demo = (Demo)context.getBean("demo");
        demo.test();;
    }
}
