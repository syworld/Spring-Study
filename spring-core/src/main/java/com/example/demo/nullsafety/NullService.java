package com.example.demo.nullsafety;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

/*
spring 5에 추가된 Null 관련 애노테이션
- @NonNull
- @Nullable
- @NonNullApi (패키지 레벨 설정)
- @NonNullFields (패키지 레벨 설정)
툴을 사용하여 컴파일 시점에 최대한 NullPointerException을 방지한다.
 */
@Service
public class NullService {

  @NonNull
  public String createEvent(@NonNull String name) {
    return "hello" + name;
  }

}
