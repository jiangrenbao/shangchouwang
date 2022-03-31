package com.test;

import com.test.NotAop.BBBService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * parkerJ
 * 2021/11/4
 * description：
 * function：
 */
public class AopMain {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*BBBService aService = (BBBService) ac.getBean("bbb");
        aService.showBBBName("parkerJ");*/
        AService aService = (AService) ac.getBean("aaa");
        aService.showName("parkerJ");
    }
}
