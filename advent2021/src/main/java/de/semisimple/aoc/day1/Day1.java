package de.semisimple.aoc.day1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day1 {

  public static void main(String[] args) {
    Path path = Paths.get("advent2021/src/main/resources/day1/input");


    try (Stream<String> lines = Files.lines(path)) {
      final Long countIncreases = MeasureDevice.countIncreases(lines.map(Integer::parseInt));

      System.out.println("Measurements larger than previous: " + countIncreases);
    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
