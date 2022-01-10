package de.semisimple.aoc.day3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OxygenDiagnostic {

  private final List<BinaryNumber> numbers;
  private final int length;

  public static OxygenDiagnostic scan(Stream<String> sample) {
    final List<BinaryNumber> numbers = sample.map(BinaryNumber::parse)
        .collect(Collectors.toList());
    final int length = numbers.get(0).length();

    return new OxygenDiagnostic(numbers, length);
  }

  public long evaluateOxygenRate() {
    if (numbers.size() == 1) {
      return numbers.get(0).toLong();
    }
    List<BinaryNumber> binaryNumbers = numbers;
    for (int i = 0; i < length; i++) {
      binaryNumbers = filterForOxygenRate(binaryNumbers, i);
      if (binaryNumbers.size() == 1) {
        return binaryNumbers.get(0).toLong();
      }
    }
    throw new IllegalStateException("Did not find an Oxygenrate. Values left" + binaryNumbers);
  }

  public long evaluateCO2Rate() {
    List<BinaryNumber> binaryNumbers = numbers;
    for (int i = 0; i < length; i++) {
      binaryNumbers = filterForCO2Rate(binaryNumbers, i);
      if (binaryNumbers.size() == 1) {
        return binaryNumbers.get(0).toLong();
      }
    }
    throw new IllegalStateException("Did not find an oxygenrate. Values left" + binaryNumbers);
  }

  private List<BinaryNumber> filterForOxygenRate(List<BinaryNumber> binaryNumbers, int i) {
    boolean mostCommonBit = mostCommonBit(binaryNumbers, i);
    return binaryNumbers.stream()
        .filter(binaryNumber -> binaryNumber.getAsBoolean(i) == mostCommonBit)
        .collect(Collectors.toList());
  }

  private List<BinaryNumber> filterForCO2Rate(List<BinaryNumber> binaryNumbers, int i) {
    boolean leastCommonBit = leastCommonBit(binaryNumbers, i);
    return binaryNumbers.stream()
        .filter(binaryNumber -> binaryNumber.getAsBoolean(i) == leastCommonBit)
        .collect(Collectors.toList());
  }

  private boolean mostCommonBit(List<BinaryNumber> binaryNumbers, int i) {
    final int sum = binaryNumbers
        .stream()
        .mapToInt(it -> it.get(i))
        .sum();
    final int size = binaryNumbers.size();
    final long roundedHalf = Math.round((size + 0.0) / 2.0);
    final boolean b = (sum - roundedHalf) >= 0;
    return b;
  }

  private boolean leastCommonBit(List<BinaryNumber> binaryNumbers, int i) {
    return !mostCommonBit(binaryNumbers, i);
  }

}