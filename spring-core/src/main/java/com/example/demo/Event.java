package com.example.demo;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Event {

  @NotNull
  Integer id;

  @Min(10)
  String title;

  public Integer getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
