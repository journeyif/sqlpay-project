package com.sqlpay.project.result;

import com.alibaba.fastjson.JSONObject;
import com.sqlpay.project.config.annotation.IgnoreResponseAdvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiangy
 * @date 2021 - 08 - 15 - 16:20
 */
@Slf4j
@RestController
@RequestMapping("/test/result")
public class BrandController {

    @PostMapping("/save")
    public Brand save(@RequestBody Brand brand) {
        log.error("save param:[{}]", JSONObject.toJSONString(brand));
        return brand;
    }

    @GetMapping("/list")
    public List<Brand> list() {
        List<Brand> list = new ArrayList<>();
        Brand brand1 = Brand.builder().name("品牌1").build();
        Brand brand2 = Brand.builder().name("品牌2").build();
        Brand brand3 = Brand.builder().name("品牌3").build();
        list.add(brand1);
        list.add(brand2);
        list.add(brand3);
        return list;
    }

    @GetMapping("/ignoreList")
    @IgnoreResponseAdvice
    public List<Brand> ignoreList() {
        List<Brand> list = new ArrayList<>();
        Brand brand1 = Brand.builder().name("品牌1").build();
        Brand brand2 = Brand.builder().name("品牌2").build();
        Brand brand3 = Brand.builder().name("品牌3").build();
        list.add(brand1);
        list.add(brand2);
        list.add(brand3);
        return list;
    }

    @GetMapping("/threwTest")
    public Object threwTest(int i) {
        if (i == 0) {
            throw new RuntimeException("threwException");
        }
        return i;
    }

    @GetMapping("/returnStr")
    public Object returnStr() {
        return "str";
    }

    @GetMapping(value = "/returnStrUTF8", produces = "application/json; charset=UTF-8")
    public Object returnStrUTF8() {
        return "str";
    }
}
