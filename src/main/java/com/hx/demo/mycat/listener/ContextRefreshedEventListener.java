package com.hx.demo.mycat.listener;

import lombok.Getter;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangfei
 * @date 2019/5/22 10:10
 */
@Component
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Getter
    private ScheduledExecutorService scheduledThreadPool;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
//        scheduledThreadPool = new ScheduledThreadPoolExecutor(
//                2,
//                new BasicThreadFactory.Builder()
//                        .namingPattern("monitor-schedule-pool-%d")
//                        .daemon(true)
//                        .build());
//        scheduledThreadPool.scheduleWithFixedDelay(new TestThread(), 0, 10, TimeUnit.SECONDS);

    }


}
