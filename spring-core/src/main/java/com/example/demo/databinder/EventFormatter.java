package com.example.demo.databinder;

import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/*
Formatter
- PropertyEditor 대체제
- Object와 String 간의 변환을 담당한다.
- 문자열을 Locale에 따라 다국화하는 기능도 제공한다. (optional)
- FormatterRegistry에 등록해서 사용
 */
public class EventFormatter implements Formatter<Event> {


  @Override
  public String print(Event object, Locale locale) {
    return object.getId().toString();
  }

  @Override
  public Event parse(String text, Locale locale) throws ParseException {
    return new Event(Integer.parseInt(text));
  }
}
