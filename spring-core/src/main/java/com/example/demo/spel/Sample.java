package com.example.demo.spel;

import org.springframework.stereotype.Component;

@Component
public class Sample {

  private int data = 200;

  public void setData(int data) {
    this.data = data;
  }

  public int getData() {
    return data;
  }

}
