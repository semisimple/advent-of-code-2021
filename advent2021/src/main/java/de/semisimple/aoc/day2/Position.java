package de.semisimple.aoc.day2;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class Position {

  private final int horizontalPosition;
  private final int depth;
  private final int aim;

  public Position move(int h, int d) {
    return new Position(horizontalPosition + h, depth + d, aim);
  }

  public Position aim(int a) {
    return new Position(horizontalPosition, depth, aim + a);
  }

  public int multiplyCoordinates() {
    return horizontalPosition * depth;
  }
}
