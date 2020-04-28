package com.example.feigntimeoutdemo;

import feign.RetryableException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@EnableFeignClients(basePackageClasses = DemoClient.class)
@TestPropertySource(properties = {
        "server.port=8081",
        "spring.cloud.loadbalancer.ribbon.enabled=false",
        "spring.cloud.discovery.client.simple.instances.demo-client[0].uri=http://localhost:${server.port}",
        // ToDo: Only configuring the read-timeout is not enough
        // "feign.client.config.demo-client.connect-timeout=10000",
        "feign.client.config.demo-client.read-timeout=500"
})
class NotYetWorkingTimeoutDemoTests {

    @Autowired
    private DemoClient demoClient;

	@Test
    public void testTimeout() {
        RetryableException retryableException = assertThrows(RetryableException.class, () -> demoClient.customTimeout(1000));
        assertThat(retryableException.getMessage()).startsWith("Read timed out");
    }

}
