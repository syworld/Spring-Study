package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 해당 클래스 위치부터 빈들을 찾아 빈을 등록한다.
@Configuration
@ComponentScan(basePackageClasses = DemoApplication.class)
public class ApplicationConfig {

//  @Bean
//  public BookRepository bookRepository(){
//    return new BookRepository();
//  }
//
//  @Bean
//  public BookService bookService(){
//    BookService bookService = new BookService();
//    // 직접 주입안하고 코드에서 Autowired 해도됨 (생성자 주입시)
//    bookService.setBookRepository(bookRepository());
//    return bookService;
//  }

}
