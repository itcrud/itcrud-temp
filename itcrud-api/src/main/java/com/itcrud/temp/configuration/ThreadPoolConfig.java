package com.itcrud.temp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author: Joker
 * @Desc:
 * @Date: 2018/12/22 15:53
 * @Modified By:
 * @Project_name: itcrud-temp
 * @Version 1.0
 */
@Configuration
public class ThreadPoolConfig {

    //线程池（可创建多个）
    @Bean("executor")
    public Executor executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);//核心线程数
        executor.setKeepAliveSeconds(60);//最大存活时间
        executor.setQueueCapacity(100);//队列容量
        executor.setMaxPoolSize(20);//最大线程数据
        executor.setThreadNamePrefix("Pool");//线程名前缀
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//达到最下线程数采用策略
        executor.initialize();
        return executor;
    }
}
