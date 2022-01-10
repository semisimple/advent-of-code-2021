package de.semisimple.aoc.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class DiagnosticTest {

  @Test
  void scan_sampleInput_diagnosticShouldReturnRates() {
    final Stream<String> sample = Stream.of(
        "00100",
        "11110",
        "10110",
        "10111",
        "10101",
        "01111",
        "00111",
        "11100",
        "10000",
        "11001",
        "00010",
        "01010"
    );

    Diagnostic diagnostic = new Diagnostic();

    diagnostic.scan(sample);

    long g = diagnostic.evaluateGammaRate();
    assertEquals(22, g);
    long e = diagnostic.evaluateEpsilonRate();
    assertEquals(9, e);
  }


}