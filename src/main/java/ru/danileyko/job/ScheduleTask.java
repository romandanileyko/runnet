package ru.danileyko.job;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.*;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by danil on 28.07.2017.
 */
@Configuration
@EnableScheduling
public class ScheduleTask{

    @Scheduled(fixedDelay = 60*1000)
    public void testTask(){
        System.out.println("Test Task by Scheduler");
    }
}
