package de.semisimple.aoc.day3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day3 {

  public static void main(String[] args) {
    Path path = Paths.get("advent2021/src/main/resources/day3/input");
    try (Stream<String> lines = Files.lines(path)) {
      final List<String> stringList = lines.collect(Collectors.toList());
      EnergyDiagnostic diagnostic = new EnergyDiagnostic();
      diagnostic.scan(stringList.stream());

      long g = diagnostic.evaluateGammaRate();
      long e = diagnostic.evaluateEpsilonRate();

      final OxygenDiagnostic oxygenDiagnostic = OxygenDiagnostic.scan(stringList.stream());

      final long o2 = oxygenDiagnostic.evaluateOxygenRate();
      final long co2 = oxygenDiagnostic.evaluateCO2Rate();

      System.out.println("Gamma: " + g + ", Epsilon: " + e + " , Product: " + (e * g));
      System.out.println("O2: " + o2 + ", CO2: " + co2 + " , Product: " + (o2 * co2));

    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
