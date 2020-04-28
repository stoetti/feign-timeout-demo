# Feign timeout Demo

Small Sample project for reproducing an [issue](https://github.com/spring-cloud/spring-cloud-openfeign/issues/324) with configuration of the spring
-openfeign library.
There are two test-classes [WorkingTimeoutDemoTests](blob/master/src/mainjava/com/example/feigntimeoutdemo/WorkingTimeoutDemoTests.java) 
demonstrating the current limitations to configure the read-timeout and another 
[NotYetWorkingTimeoutDemoTests](blob/master/src/mainjava/com/example/feigntimeoutdemo/NotYetWorkingTimeoutDemoTests.java) demonstrating the expected behavior.  
