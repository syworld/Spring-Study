package com.example.demo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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

  // ApplicationEventPublisher
  @Autowired
  ApplicationEventPublisher publishEvent;

  // ResourceLoader
  @Autowired
  ResourceLoader resourceLoader;

  // Validator
  @Autowired
  Validator validator;

  // DefaultFormatting
  @Autowired
  ConversionService conversionService;

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
//    while(true){
//      System.out.println(messageSource.getClass()); // resource bundle을 읽음
//      System.out.println(messageSource.getMessage("greeting", new String[]{"Tom"}, Locale.KOREA));
//      System.out.println(messageSource.getMessage("greeting", new String[]{"Tom"}, Locale.getDefault()));
//      Thread.sleep(1000l);
//    }


    // ApplicationEventPublisher 이벤트 발생
    publishEvent.publishEvent(new MyEvent(this, 100));

    // ResourceLoader 리소스를 읽어옴
    System.out.println(resourceLoader.getClass()); // class org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext
    // Resource resource = resourceLoader.getResource("test.txt"); // class org.springframework.web.context.support.ServletContextResource 찾을 수 없음

    Resource resource = resourceLoader.getResource("classpath:test.txt");
    System.out.println(resource.getClass()); // class org.springframework.core.io.ClassPathResource

    System.out.println(resource.exists());
    System.out.println(resource.getDescription());
    System.out.println(Files.readString(Path.of(resource.getURI())));


    // Validator #1 직접 구현

    //    true
    //----error code----
    //notEmpty.event.title
    //notEmpty.title
    //notEmpty.java.lang.String
    //notEmpty
    //Empty title not allowed
//    Event event = new Event();
//    EventValidator eventValidator = new EventValidator();
//    Errors errors = new BeanPropertyBindingResult(event, "event");
//    eventValidator.validate(event, errors);
//    System.out.println(errors.hasErrors());
//    errors.getAllErrors().forEach(e-> {
//      System.out.println("----error code----");
//      Arrays.stream(e.getCodes()).forEach(System.out::println);
//      System.out.println(e.getDefaultMessage());
//    });


    // Validator #2 SpringBoot에서는 LocalValidatorFactoryBean 빈으로 자동 등록

    //class org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
    //true
    //----error code----
    //Min.event.title
    //Min.title
    //Min.java.lang.String
    //Min
    //10 이상이어야 합니다
    //----error code----
    //NotNull.event.id
    //NotNull.id
    //NotNull.java.lang.Integer
    //NotNull
    //널이어서는 안됩니다
    System.out.println(validator.getClass());
    Event event = new Event();
    event.setTitle("WW");
    Errors errors = new BeanPropertyBindingResult(event, "event");
    validator.validate(event, errors);

    System.out.println(errors.hasErrors());

    errors.getAllErrors().forEach(e-> {
      System.out.println("----error code----");
      Arrays.stream(e.getCodes()).forEach(System.out::println);
      System.out.println(e.getDefaultMessage());
    });

    //class org.springframework.boot.autoconfigure.web.format.WebConversionService : Spring Boot 가 제공. DefaultFormatConversionService 상속
    System.out.println(conversionService.getClass().toString());
    System.out.println(conversionService);
  }



}
