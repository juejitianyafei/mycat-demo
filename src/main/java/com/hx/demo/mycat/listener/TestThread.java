package com.hx.demo.mycat.listener;

/**
 * @author wangfei
 * @date 2019/5/22 10:15
 */
public class TestThread implements Runnable
{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("spring start excute ......");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
