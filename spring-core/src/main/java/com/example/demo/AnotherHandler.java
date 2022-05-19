package com.example.demo;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/*
  발생된 event를 받아서 처리. 기본적으로 synchronized.
  순서를 정하고 싶다면 @Order와 함께 사용한다.
  비동기적으로 실행하고 싶다면 @Async와 함께 사용한다.
  스프링 4.2 부터는 @EventListener를 사용해서 빈의 메소드에 사용할 수 있다.
 */

@Component
public class AnotherHandler {

//  @Order(Ordered.HIGHEST_PRECEDENCE)
  @EventListener
  @Async
  public void handle(MyEvent myEvent){
    System.out.println(Thread.currentThread().toString());
    System.out.println("Another handler: "+ myEvent.getData());
  }

  /*
  스프링이 제공하는 기본 이벤트
  -ContextRefreshedEvent: ApplicationContext를 초기화 또는 리프래시 했을 때 발생.
  -ContextStartedEvent: ApplicationContext를 start()하여 라이프사이클 빈들이 시작
  신호를 받은 시점에 발생.
  -ContextStoppedEvent: ApplicationContext를 stop()하여 라이프사이클 빈들이 정지
  신호를 받은 시점에 발생.
  -ContextClosedEvent: ApplicationContext를 close()하여 싱글톤 빈 소멸되는 시점에
  발생.
  -RequestHandledEvent: HTTP 요청을 처리했을 때 발생.
   */
  @EventListener
  @Async
  public void handle(ContextRefreshedEvent event){
    System.out.println(Thread.currentThread().toString());
    System.out.println("ContextRefreshedEvent");
  }

  @EventListener
  @Async
  public void handle(ContextClosedEvent event){
    System.out.println(Thread.currentThread().toString());
    System.out.println("ContextClosedEvent");
  }

}
