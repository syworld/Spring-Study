package com.example.demo.databinder;

import java.beans.PropertyEditorSupport;

/*
PropertyEditor
- 스프링 3.0 이전까지 DataBinder가 변환 작업 사용하던 인터페이스
- DataBinder: 입력값은 대부분 “문자열”인데, 그 값을 객체가 가지고 있는 int, long, Boolean, Date 등 심지어 Event, Book 같은 도메인 타입으로도 변환해서 넣어주는 기능.
- 쓰레드-세이프 하지 않음 (상태 정보 저장 하고 있음, 따라서 싱글톤 빈으로 사용하면 위험)
- Object와 String 간의 변환만 할 수 있어, 사용 범위가 제한적임
 */
public class EventEditor extends PropertyEditorSupport {

  @Override
  public String getAsText() {
    Event event = (Event) getValue();
    return event.getId().toString();
  }

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    // property의 value가 스레드끼리 공유됨
    // not Thread safe -> Bean 등록해서 사용 주의. Thread Scope Bean으로 지정해서 사용해야함 or 등록하지 않음
    setValue(new Event(Integer.parseInt(text)));
  }
}
