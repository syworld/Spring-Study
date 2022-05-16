package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

  @Autowired
  Single single;

  @Autowired
  Proto proto;

  @Override
  public void run(ApplicationArguments args) throws Exception{
    // Singleton : application 전체에서 하나의 인스턴스만 사용
    //    com.example.demo.Proto@73d3e555
    //    com.example.demo.Proto@73d3e555
    //    com.example.demo.Single@2b037cfc
    System.out.println(proto);
    System.out.println(single.getProto());
    System.out.println(single);

  }



}
