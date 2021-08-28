package com.sqlpay.project.async.controller;

import cn.hutool.core.collection.CollUtil;
import com.sqlpay.project.async.service.AsyncTaskManager;
import com.sqlpay.project.async.vo.AsyncTaskInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <h1>异步任务服务对外提供的 API</h1>
 */
@Slf4j
@RestController
@RequestMapping("/test/async")
public class AsyncGoodsController {

    private final AsyncTaskManager asyncTaskManager;

    public AsyncGoodsController(AsyncTaskManager asyncTaskManager) {
        this.asyncTaskManager = asyncTaskManager;
    }

    @PostMapping("/import-goods")
    public AsyncTaskInfo importGoods() {
        List<String> goodsInfos = CollUtil.toList("商品1", "商品2");
        return asyncTaskManager.submit(goodsInfos);
    }

    @GetMapping("/task-info")
    public AsyncTaskInfo getTaskInfo(@RequestParam String taskId) {
        return asyncTaskManager.getTaskInfo(taskId);
    }
}
