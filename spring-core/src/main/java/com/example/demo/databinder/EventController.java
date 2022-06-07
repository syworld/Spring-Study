package com.example.demo.databinder;


import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

  @InitBinder
  public void init(WebDataBinder webDataBinder){
    webDataBinder.registerCustomEditor(Event.class, new EventEditor());
  }

  @GetMapping("/event/{event}")
  public String getEvent(@PathVariable Event event){
    // EventBinder에 의해 {event} 문자열로 들어온 값을 숫자로 변환된다.
    System.out.println(event);
    return event.getId().toString();
  }
}
