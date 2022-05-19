package com.example.demo;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/*
  발생된 event를 받아서 처리
 */
@Component
public class MyEventHandler implements ApplicationListener<MyEvent> {

  @Override
  public void onApplicationEvent(MyEvent event) {
    System.out.println("Data: "+ event.getData());
  }
}
