package com.hx.demo.mycat.spi.impl;

import com.hx.demo.mycat.spi.Robot;

/**
 * @author wangfei
 * @date 2019/5/27 15:50
 */
public class BaiduRobot implements Robot {
    @Override
    public void sayHello() {
        System.out.println("BaiduRobot...sayHello");
    }
}
