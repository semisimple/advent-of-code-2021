package de.semisimple.aoc.day2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day2 {

  public static void main(String[] args) {
    Path path = Paths.get("advent2021/src/main/resources/day2/input");
    try (Stream<String> lines = Files.lines(path)) {
      Engine engine = new Engine();
      engine.run(lines);

      final Position position = engine.getPosition();

      System.out.println("" + position + " , Product: " + position.multiplyCoordinates());

    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
