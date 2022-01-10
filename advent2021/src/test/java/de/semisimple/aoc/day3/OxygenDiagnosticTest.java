package de.semisimple.aoc.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class OxygenDiagnosticTest {

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

    final OxygenDiagnostic scan = OxygenDiagnostic.scan(sample);
    final long o2 = scan.evaluateOxygenRate();
    assertEquals(23L, o2);
    final long co2 = scan.evaluateCO2Rate();
    assertEquals(10, co2);
  }
}