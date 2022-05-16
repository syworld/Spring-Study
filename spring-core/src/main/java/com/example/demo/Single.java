package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Single {

  // Singleton 스콥의 빈이 한번만 세팅 되므로 프로토타입 빈이 업데이트가 되지 않음
  // 싱글톤 빈이 프로토타입 빈을 참조중에 업데이트 방법
  // 1) scoped-proxy
  // 2) Object-Provider
  // 3) Provider (표준)
  @Autowired
  Proto proto;


  public Proto getProto(){
    return this.proto;
  }

}
