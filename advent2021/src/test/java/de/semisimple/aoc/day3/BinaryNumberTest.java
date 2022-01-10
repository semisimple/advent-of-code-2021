package de.semisimple.aoc.day3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BinaryNumberTest {

  @Test
  void parsed_sampleInput_correctArray() {
    final BinaryNumber parse = BinaryNumber.parse("010010");
    assertArrayEquals(new int[]{0, 1, 0, 0, 1, 0}, parse.getNumbers());
  }

  @Test
  void toLong_sampleInput_returnsCorrectLongValue() {
    final BinaryNumber parse = BinaryNumber.parse("00010");

    assertEquals(2L, parse.toLong());
  }
}