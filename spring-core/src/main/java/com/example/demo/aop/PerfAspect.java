package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/*
- Aspect: 각각의 모듈. 흩어진 관심사를 모듈화
- Target: 적용 대상
- Advice: 해야할 일
- Pointcut: 어디에 적용. Join Point의 subset
- Join Point: Advice가 끼어들 수 있는 지점.
 */

@Component
@Aspect
public class PerfAspect {

  // Advice
  @Around("execution(* com.example..*.EventService.*(..))")
  public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {
    long begin = System.currentTimeMillis();
    Object retVal = pjp.proceed(); // 메소드 호출
    System.out.println(System.currentTimeMillis() - begin);
    return retVal;
  }
}