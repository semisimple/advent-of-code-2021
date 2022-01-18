package de.semisimple.aoc.day5;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntersectionScanner {

  public long scanVerticalOrHorizontal(Stream<String> sample) {
    final Map<String, Long> collect = sample.map(Line::parse)
        .filter(Line::isHorizontalOrVertical)
        .flatMap(Line::streamPoints)
        .collect(Collectors.groupingBy(Point::getKey, Collectors.counting()));

    return collect.values().stream()
        .filter(it -> it > 1)
        .count();
  }

  public long scan(Stream<String> sample) {
    final Map<String, Long> collect = sample.map(Line::parse)
        .flatMap(Line::streamPoints)
        .collect(Collectors.groupingBy(Point::getKey, Collectors.counting()));

    return collect.values().stream()
        .filter(it -> it > 1)
        .count();
  }
}
