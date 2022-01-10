package de.semisimple.aoc.day3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Day3 {

  public static void main(String[] args) {
    Path path = Paths.get("advent2021/src/main/resources/day3/input");
    try (Stream<String> lines = Files.lines(path)) {
      Diagnostic diagnostic = new Diagnostic();
      diagnostic.scan(lines);

      long g = diagnostic.evaluateGammaRate();
      long e = diagnostic.evaluateEpsilonRate();

      System.out.println("Gamma: " + g + ", Epsilon: " + e + " , Product: " + (e * g));

    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
