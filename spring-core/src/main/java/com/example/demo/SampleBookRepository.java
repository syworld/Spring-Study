package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/*
  @Primary: 같은 타입의 빈이 여러 개 있을 때 주입 우선순위
 */
@Repository @Primary
public class SampleBookRepository implements BookRepository{

}
