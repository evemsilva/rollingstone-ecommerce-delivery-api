package com.rollingstone.aspects;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerAspect {

    private final Logger logger = LoggerFactory.getLogger(RestControllerAspect.class);

    private final Counter deliveryCreatedCounter = Metrics.counter("com.rollingstone.delivery.created");

    @Before("execution(public * com.rollingstone.spring.controller.*Controller.*(..))")
    public void generalAllMethodASpect() {
	logger.info("All Method Calls invoke this general aspect method");
    }

    @AfterReturning("execution(public * com.rollingstone.spring.controller.*Controller.createDelivery(..)))")
    public void getsCalledOnDeliverySave() {
	logger.info("This aspect is fired when the createdDelivery method of the controller is called");
	deliveryCreatedCounter.increment();
    }
}
