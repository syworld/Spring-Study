package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

// Prototype 지정시 빈을 받아올 때마다 새로운 인스턴스가 됨
// proxyMode = ScopedProxyMode.TARGET_CLASS: Proxy로 감싸라. proto를 직접참조하지 않게함
@Component @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Proto {

  // 문제 없음. singleton scope의 빈은 항상 동일함
  @Autowired
  Single single;

}
