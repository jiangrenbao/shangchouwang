package com.test;

import org.springframework.stereotype.Service;

/**
 * parkerJ
 * 2021/11/4
 * description：
 * function：
 */
@Service("aaa")
public class AServiceImpl implements AService {
    @Override
    public String showName(String name) {
        System.out.println("showName方法执行");
        return name;
    }
}
