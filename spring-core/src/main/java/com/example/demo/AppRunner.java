package com.example.demo;

import java.util.Arrays;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
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

  // EnvironmentCapable
  @Autowired
  TestBookRepository testBookRepository;

  @Value("${app.about}")
  String appAbout;


  // MessageSource
  @Autowired
  MessageSource messageSource;

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


    // EnvironmentCapable
    Environment environment = ctx.getEnvironment();
    // profile
    System.out.println(Arrays.toString(environment.getActiveProfiles()));
    System.out.println(Arrays.toString(environment.getDefaultProfiles()));
    // property
    /**
     * StandardServletEnvironment의 우선순위
     * ServletConfig 매개변수
     * ServletContext 매개변수
     * JNDI (java:comp/env/)
     * JVM 시스템 프로퍼티 (-Dkey=”value”)
     * JVM 시스템 환경 변수 (운영 체제 환경 변수)
     */
    System.out.println(environment.getProperty("app.name")); // JVM system property -Dkey="value"
    System.out.println(environment.getProperty("app.about"));
    System.out.println(environment.getProperty(appAbout));

    // MessageSource
    while(true){
      System.out.println(messageSource.getClass()); // resource bundle을 읽음
      System.out.println(messageSource.getMessage("greeting", new String[]{"Tom"}, Locale.KOREA));
      System.out.println(messageSource.getMessage("greeting", new String[]{"Tom"}, Locale.getDefault()));
      Thread.sleep(1000l);
    }


  }



}
