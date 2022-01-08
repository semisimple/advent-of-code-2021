package de.semisimple.aoc.day1;

import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MeasuringDevice {

  private final IncreaseMeasure increasometer;

  public Long countIncreases(Stream<Integer> measure){
    return measure
        .map(increasometer::evaluate)
        .filter(Change.INCREASE::equals)
        .count();
  }

}
