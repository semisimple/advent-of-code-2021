package de.semisimple.aoc.day5;


import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
public class Point {

  private final int x;
  private final int y;

  public String getKey() {
    return "{" + x + "," + y + "}";
  }
}
