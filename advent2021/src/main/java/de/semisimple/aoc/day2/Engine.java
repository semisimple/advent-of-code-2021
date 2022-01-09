package de.semisimple.aoc.day2;

import java.util.stream.Stream;
import lombok.Getter;

@Getter
public class Engine {

  private Position position = new Position(0, 0);

  public void run(Stream<String> lines) {
    lines.map(Instruction::parse)
        .forEach(this::accept);
  }

  public void accept(Instruction instruction) {
    this.position = instruction.apply(position);
  }

}
