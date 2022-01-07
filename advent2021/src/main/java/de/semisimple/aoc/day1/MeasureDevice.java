package de.semisimple.aoc.day1;

import java.util.stream.Stream;

public class MeasureDevice {

  public static Long countIncreases(Stream<Integer> measure){
    final var increasometer = new Increasometer();
    return measure
        .map(increasometer::nextInput)
        .filter(it -> Change.INCREASE == it)
        .count();
  }

}
