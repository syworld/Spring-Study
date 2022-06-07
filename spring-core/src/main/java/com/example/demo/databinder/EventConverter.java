package com.example.demo.databinder;

import org.springframework.core.convert.converter.Converter;

/*
Converter<source, destination>
상태 정보 없음 == Stateless == 쓰레드세이프
ConverterRegistry에 등록해서 사용
 */
public class EventConverter {

  public static class StringToEventConverter implements Converter<String, Event> {

    @Override
    public Event convert(String source) {
      return new Event(Integer.parseInt(source));
    }
  }

  public static class EventStringToConverter implements Converter<Event, String> {

    @Override
    public String convert(Event source) {
      return source.getId().toString();
    }
  }


}
