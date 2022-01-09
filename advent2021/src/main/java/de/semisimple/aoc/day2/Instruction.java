package de.semisimple.aoc.day2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Instruction {

  private final Direction direction;
  private final int amount;

  public static Instruction parse(String line) {

    final String[] s = line.split(" ");
    int amount = Integer.parseInt(s[1]);
    Direction direction = Direction.parseDirection(s[0]);
    return new Instruction(direction, amount);
  }

  public Position apply(Position position) {
    return direction.move(position, amount);
  }
}