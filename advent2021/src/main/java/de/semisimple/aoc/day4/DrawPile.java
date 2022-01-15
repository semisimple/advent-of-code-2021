package de.semisimple.aoc.day4;

import java.util.Arrays;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DrawPile {

  private final Stream<Integer> draws;

  public static DrawPile parse(String s) {
    final String[] split = s.split(",");
    final Stream<Integer> integerStream = Arrays.stream(split).map(Integer::parseInt);
    return new DrawPile(integerStream);
  }

  public Stream<Integer> stream() {
    return draws;
  }
}
