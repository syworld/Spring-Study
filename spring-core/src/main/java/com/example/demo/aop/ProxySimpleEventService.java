package com.example.demo.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Proxy: 기존 코드를 건드리지 않고 성능을 측정한다. 접근 제어 및 부가 가능 추가
// Primary로 AopRunner에 주입된다.
@Primary
@Component
public class ProxySimpleEventService implements EventService{

  // real subject를 주입받음
  @Autowired
  SimpleEventService simpleEventService;

  @Override
  public void createEvent() {
    long begin = System.currentTimeMillis();
    simpleEventService.createEvent();
    System.out.println(System.currentTimeMillis() - begin);
  }

  @Override
  public void publishEvent() {
    long begin = System.currentTimeMillis();
    simpleEventService.publishEvent();
    System.out.println(System.currentTimeMillis() - begin);
  }

  @Override
  public void deleteEvent() {
    simpleEventService.deleteEvent();
  }
}
