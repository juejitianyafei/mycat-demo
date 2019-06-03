package com.hx.demo.mycat.spi;

import java.util.ServiceLoader;

/**
 * @author wangfei
 * @date 2019/5/27 15:53
 */
public class JavaSPITest {
    public static void main(String[] args) {
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");
        serviceLoader.forEach(Robot::sayHello);
    }
}
