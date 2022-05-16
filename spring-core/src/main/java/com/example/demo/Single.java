package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Single {


  // Singleton 스콥의 빈이 한번만 세팅 되므로 proto가 갱신되지 않음
  @Autowired
  Proto proto;


  public Proto getProto(){
    return this.proto;
  }

}
