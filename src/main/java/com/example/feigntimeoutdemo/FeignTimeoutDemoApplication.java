package com.example.feigntimeoutdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class FeignTimeoutDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignTimeoutDemoApplication.class, args);
	}

	@RestController
    static class DemoController {
	    @GetMapping
        public ResponseEntity<String> customTimeout(@RequestParam(required = false) int timeoutMillis) throws InterruptedException {
	        Thread.sleep(timeoutMillis);
	        return ResponseEntity.ok("just woke up!");
        }
    }

}
