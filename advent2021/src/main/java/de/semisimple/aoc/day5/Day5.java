package de.semisimple.aoc.day5;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day5 {

  public static void main(String[] args) {
    Path path = Paths.get("advent2021/src/main/resources/day5/input");
    try (Stream<String> lines = Files.lines(path)) {
      IntersectionScanner intersectionScanner = new IntersectionScanner();
      final long intersections = intersectionScanner.scan(lines);

      System.out.println("Intersections: " + intersections);

    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
