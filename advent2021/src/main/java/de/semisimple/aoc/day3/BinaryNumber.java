package de.semisimple.aoc.day3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BinaryNumber {

  private final int[] numbers;

  public static BinaryNumber parse(final String s) {
    final String[] split = s.split("");

    int[] parsed = new int[s.length()];

    for (int i = 0; i < s.length(); i++) {
      parsed[i] = Integer.parseInt(split[i]);
    }
    return new BinaryNumber(parsed);
  }

}
