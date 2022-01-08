package de.semisimple.aoc.day1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
public class Window {

  private final Integer a;
  private final Integer b;
  private final Integer c;


  public Window next(Integer next){
    return new Window(next,a,b);
  }

  public boolean isUsable(){
    return a!=null && b!=null && c!=null;
  }

  public Integer sum(){
    if(isUsable()){
      return a+b+c;
    }else {
      throw new IllegalStateException("Window is not usable. A value is missing.");
    }
  }
}
