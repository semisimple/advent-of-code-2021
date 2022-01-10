package de.semisimple.aoc.day3;

import java.util.BitSet;
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

  public int length() {
    return numbers.length;
  }

  public long toLong() {
    BitSet bitSet = new BitSet();
    for (int i = 0; i < numbers.length; i++) {
      boolean bit = numbers[i] > 0;
      bitSet.set((numbers.length - 1) - i, bit);
    }
    return bitSet.toLongArray()[0];
  }

  public int get(int i) {
    return numbers[i];
  }

  public boolean getAsBoolean(int i) {
    return numbers[i] == 1;
  }
}
