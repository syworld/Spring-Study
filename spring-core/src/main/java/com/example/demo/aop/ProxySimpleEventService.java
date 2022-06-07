package com.example.demo.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Proxy: 기존 코드를 건드리지 않고 성능을 측정한다. 접근 제어 및 부가 가능 추가
// Primary로 AopRunner에 주입된다.

// 1. 아래 proxy class를 제거하면,
// 2. SimpleEventService가 빈에 등록된다.
// 3. 런타임에 spring이 AbstractAutoProxyCreator(BeanPostProcessor)에 의해 SimpleEventService를 감싸는 프록시 빈을 생성해서 대신 스프링 빈에 등록해준다.

//@Primary
//@Component
//public class ProxySimpleEventService implements EventService{
//
//  // real subject를 주입받음
//  @Autowired
//  SimpleEventService simpleEventService;
//
//  @Override
//  public void createEvent() {
//    long begin = System.currentTimeMillis();
//    simpleEventService.createEvent();
//    System.out.println(System.currentTimeMillis() - begin);
//  }
//
//  @Override
//  public void publishEvent() {
//    long begin = System.currentTimeMillis();
//    simpleEventService.publishEvent();
//    System.out.println(System.currentTimeMillis() - begin);
//  }
//
//  @Override
//  public void deleteEvent() {
//    simpleEventService.deleteEvent();
//  }
//}
