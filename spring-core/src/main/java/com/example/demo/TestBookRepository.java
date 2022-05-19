package com.example.demo;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;


/**
 * 프로파일 정의하기
 * 1) 클래스에 정의
 *  @Configuration @Profile(“test”)
 *  @Component @Profile(“test”)
 * 2) 메소드에 정의
 *  @Bean @Profile(“test”)
 */
@Repository
@Profile("!prod")
public class TestBookRepository implements BookRepository{


}
