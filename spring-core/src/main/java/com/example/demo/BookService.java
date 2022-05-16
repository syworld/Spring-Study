package com.example.demo;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  /**
   * Autowired : 1) 생성자 2) setter 3) 필드
   * BookRepository가 bean에 등록 안하는 경우 @Autowired는 에러남
   * Autowired(required=false)를 사용하면 해당 타입의 빈이 있다면 스프링이 자동으로 주입을 해주지만 없다면 안해주는 것이고,
   * Autowired를 사용하지 않는다면 해당 타입의 빈이 있더라도 주입을 안한다.
   */


  /*
  Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
   */

//  @Autowired() @Qualifier("sampleBookRepository")
//  BookRepository bookRepository;

  @Autowired
  List<BookRepository> bookRepositories;

  /*
    BookRepository가 bean에 등록되어야만 BookService를 생성할 수 잇음 (생성자 주입)
   */
//  @Autowired
//  public BookService(BookRepository bookRepository){
//    this.bookRepository = bookRepository;
//  }


//  @Autowired(required = false)
//  public void setBookRepository(BookRepository bookRepository){
//      this.bookRepository = bookRepository;
//  }


  // bean 주입 이후 lifecycle callback
  @PostConstruct
  public void setup(){
    System.out.println(bookRepositories);
  }


}
