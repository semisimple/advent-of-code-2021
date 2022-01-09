package de.semisimple.aoc.day2;

import java.util.function.BiFunction;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Direction {

  DOWN((p, i) -> p.move(0, i)),
  UP((p, i) -> p.move(0, -i)),
  FORWARD((p, i) -> p.move(i, 0));

  private final BiFunction<Position, Integer, Position> movement;

  public static Direction parseDirection(String s) {
    return Direction.valueOf(s.toUpperCase());
  }

  public Position move(Position position, int amount) {
    return this.movement.apply(position, amount);
  }
}
