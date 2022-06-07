package com.example.demo.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;
/*
Spring Expression Language
객체 그래프를 조회하고 조작하는 기능을 제공한다.
내부적으로 ExpressionParser 객체를 통해 SpEL의 표현식을 파싱하고 StandardEvaluationContext 객체를 통해 스프링 빈을 가져온다.
- {“표현식"}
- ${“프로퍼티"}
- 표현식은 프로퍼티를 가질 수 있지만, 반대는 불가능
- @Value, @Query 등에서 쓰인다.
 */
@Component
public class SpelRunner implements ApplicationRunner {

  @Value("#{1+1}")
  int value;

  @Value("#{'HELLO' + 'World'}")
  String greeting;

  @Value("#{1 eq 1}")
  boolean trueOrFalse;

  @Value("${my.value}") // property
  String myVal;

  @Value("#{${my.value} eq 100}") // 표현식 안에서 property 사용 가능
  boolean isMyVal100;

  @Value("#{'spring'}")
  String spring;

  @Value("#{sample.data}") // bean 으로 등록된 객체
  int sampleData;

  @Override
  public void run(ApplicationArguments args) throws Exception {

    //==============
    //2
    //HELLOWorld
    //true
    //100
    //true
    //spring
    //200

    System.out.println("==============");
    System.out.println(value);
    System.out.println(greeting);
    System.out.println(trueOrFalse);
    System.out.println(myVal);
    System.out.println(isMyVal100);
    System.out.println(spring);
    System.out.println(sampleData);

    // SpEL 구성
    // 102
    ExpressionParser parser = new SpelExpressionParser();
    Expression expression = parser.parseExpression("2+100");
    Integer value = expression.getValue(Integer.class); // SpEL에서 ConversionService에 의해 변환
    System.out.println(value);

  }
}
