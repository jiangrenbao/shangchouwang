package com.test.NotAop;

import org.springframework.stereotype.Service;

/**
 * parkerJ
 * 2021/11/4
 * description：
 * function：
 */
@Service("bbb")
public class BBBServiceImpl implements BBBService {
    @Override
    public String showBBBName(String name) {
        System.out.println("showName方法执行");
        return name;
    }
}
