package com.example.feigntimeoutdemo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("demo-client")
public interface DemoClient {

    @GetMapping
    String customTimeout(@RequestParam(required = false) int timeoutMillis);

}