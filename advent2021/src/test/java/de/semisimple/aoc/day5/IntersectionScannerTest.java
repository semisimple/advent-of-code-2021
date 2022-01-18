package de.semisimple.aoc.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class IntersectionScannerTest {

  @Test
  void scanVerticalOrHorizontal_sampleInput_countsIntersections() {
    Stream<String> sample = getSample();

    IntersectionScanner intersectionScanner = new IntersectionScanner();

    long intersections = intersectionScanner.scanVerticalOrHorizontal(sample);

    assertEquals(5, intersections);
  }

  @Test
  void scan_sampleInput_countsIntersections() {
    Stream<String> sample = getSample();

    IntersectionScanner intersectionScanner = new IntersectionScanner();

    long intersections = intersectionScanner.scan(sample);

    assertEquals(12, intersections);
  }

  private Stream<String> getSample() {
    return Stream.of("0,9 -> 5,9",
        "8,0 -> 0,8",
        "9,4 -> 3,4",
        "2,2 -> 2,1",
        "7,0 -> 7,4",
        "6,4 -> 2,0",
        "0,9 -> 2,9",
        "3,4 -> 1,4",
        "0,0 -> 8,8",
        "5,5 -> 8,2");
  }
}