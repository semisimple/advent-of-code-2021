package de.semisimple.aoc.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PositionTest {

  @ParameterizedTest
  @MethodSource("sampleInputsForMultiplication")
  void multiplyCoordinates_sampleInput_returnsProduct(int h, int d, int expected) {
    final Position position = new Position(h, d, 0);

    assertEquals(expected, position.multiplyCoordinates());
  }

  private static Stream<Arguments> sampleInputsForMultiplication() {
    return Stream.of(Arguments.of(2, 3, 6), Arguments.of(5, -3, -15));
  }

  @Test
  void move_twoHorizontalThreeUp_correctPosition() {
    final Position position = new Position(1, 2, 0);

    final Position result = position.move(2, -3);

    assertNotEquals(result, position);
    assertEquals(3, result.getHorizontalPosition());
    assertEquals(-1, result.getDepth());
  }
}