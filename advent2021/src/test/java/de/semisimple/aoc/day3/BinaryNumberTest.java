package de.semisimple.aoc.day3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.BitSet;
import org.junit.jupiter.api.Test;

class BinaryNumberTest {

  @Test
  void parsed_sampleInput_correctArray() {
    final BinaryNumber parse = BinaryNumber.parse("010010");
    assertArrayEquals(new int[]{0, 1, 0, 0, 1, 0}, parse.getNumbers());
  }

  @Test
  void name() {
    final BitSet bitSet = new BitSet();
    bitSet.set(1, true);
    bitSet.set(2, true);
    bitSet.set(4, true);

    final long l = bitSet.toLongArray()[0];
    System.out.println(l);

  }
}