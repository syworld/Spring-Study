package com.example.demo;

import org.springframework.context.ApplicationEvent;
/*
스프링 4.2 부터는 이 클래스를 상속받지 않아도 이벤트로 사용할 수 있다.
 */
public class MyEvent extends ApplicationEvent {
  private int data;


  public MyEvent(Object source) {
    super(source);
  }

  public MyEvent(Object source, int data) {
    super(source);
    this.data = data;
  }

  public int getData() {
    return data;
  }
}
