package com.naga.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect 
public class TransferMonitoringAspect {
	
	  @Pointcut("execution(* com.naga.service.TransferService.transfer(..))")
	  public void transfer() { }
}
