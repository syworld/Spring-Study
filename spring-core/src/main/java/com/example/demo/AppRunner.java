package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

//  @Autowired
//  Single single;
//
//  @Autowired
//  Proto proto;


  @Autowired
  ApplicationContext ctx;

  @Override
  public void run(ApplicationArguments args) throws Exception{
    // Singleton : application 전체에서 하나의 인스턴스만 사용
    //    com.example.demo.Proto@73d3e555
    //    com.example.demo.Proto@73d3e555
    //    com.example.demo.Single@2b037cfc
    //    System.out.println(proto);
    //    System.out.println(single.getProto());
    //    System.out.println(single);


//    PROTO
//    com.example.demo.Proto@43a0a32d
//    com.example.demo.Proto@396ef8b2
//    com.example.demo.Proto@72825400
//    SINGLE
//    com.example.demo.Single@19ee1ae6
//    com.example.demo.Single@19ee1ae6
//    com.example.demo.Single@19ee1ae6


//    proxyMode = ScopedProxyMode.TARGET_CLASS 일 경우는 매번 다른 인스턴스
//    PROTO BY SINGLE
//    com.example.demo.Proto@5f117b3d
//    com.example.demo.Proto@5f117b3d
//    com.example.demo.Proto@5f117b3d
    System.out.println("PROTO");
    System.out.println(ctx.getBean(Proto.class));
    System.out.println(ctx.getBean(Proto.class));
    System.out.println(ctx.getBean(Proto.class));
    System.out.println("SINGLE");
    System.out.println(ctx.getBean(Single.class));
    System.out.println(ctx.getBean(Single.class));
    System.out.println(ctx.getBean(Single.class));
    System.out.println("PROTO BY SINGLE");
    System.out.println(ctx.getBean(Single.class).getProto());
    System.out.println(ctx.getBean(Single.class).getProto());
    System.out.println(ctx.getBean(Single.class).getProto());



  }



}
