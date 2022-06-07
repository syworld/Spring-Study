package com.example.demo.databinder;

import java.beans.PropertyEditorSupport;

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
