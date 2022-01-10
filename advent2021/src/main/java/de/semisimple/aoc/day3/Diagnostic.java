package de.semisimple.aoc.day3;

import java.util.BitSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Diagnostic {

  private int[] summed;
  private int totalElements = 0;

  public void scan(Stream<String> sample) {
    sample.map(BinaryNumber::parse)
        .forEach(this::sum);
  }

  private void sum(BinaryNumber binaryNumber) {
    final int[] numbers = binaryNumber.getNumbers();
    if (summed == null) {
      summed = new int[numbers.length];
    }

    IntStream.range(0, numbers.length)
        .forEach(i -> summed[i] = summed[i] + numbers[i]);
    totalElements++;
  }


  public long evaluateGammaRate() {
    BitSet bitSet = new BitSet();
    for (int i = 0; i < summed.length; i++) {
      boolean bit = summed[i] - (totalElements / 2) > 0;
      bitSet.set((summed.length - 1) - i, bit);
    }
    return bitSet.toLongArray()[0];
  }

  public long evaluateEpsilonRate() {
    BitSet bitSet = new BitSet();
    for (int i = 0; i < summed.length; i++) {
      boolean bit = summed[i] - (totalElements / 2) <= 0;
      bitSet.set((summed.length - 1) - i, bit);
    }
    return bitSet.toLongArray()[0];
  }
}
