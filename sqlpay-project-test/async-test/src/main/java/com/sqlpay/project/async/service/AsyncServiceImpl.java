package com.sqlpay.project.async.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <h1>异步服务接口实现</h1>
 */
@Slf4j
@Service
public class AsyncServiceImpl implements IAsyncService {

    /**
     * <h2>异步任务需要加上注解, 并指定使用的线程池</h2>
     */
    @Async("getAsyncExecutor")
    @Override
    public void asyncImportGoods(List<String> goodsInfos, String taskId) {

        log.info("async task running taskId: [{}]", taskId);

        StopWatch watch = StopWatch.createStarted();

        //int i = 7 / 0;
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        watch.stop();
        log.info("check and import goods success: [{}ms]",
                watch.getTime(TimeUnit.MILLISECONDS));
    }

}
