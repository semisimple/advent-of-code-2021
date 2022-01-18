package de.semisimple.aoc.day5;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class LineTest {

  @Test
  void stream_horizontalLines_streamsPoints() {
    final Line l0 = Line.parse("0,5 -> 2,5");
    final Line l1 = Line.parse("-2,2 -> 0,2");

    assertTrue(l0.isHorizontalOrVertical());
    final var pointsL0 = l0.streamPoints().collect(Collectors.toList());
    assertEquals(new Point(0, 5), pointsL0.get(0));
    assertEquals(new Point(1, 5), pointsL0.get(1));
    assertEquals(new Point(2, 5), pointsL0.get(2));
    final var pointsL1 = l1.streamPoints().collect(Collectors.toList());
    assertEquals(new Point(-2, 2), pointsL1.get(0));
    assertEquals(new Point(-1, 2), pointsL1.get(1));
    assertEquals(new Point(0, 2), pointsL1.get(2));

  }

  @Test
  void stream_verticalLines_streamsPoints() {
    final Line l0 = Line.parse("2,3 -> 2,5");
    final Line l1 = Line.parse("-1,2 -> -1,4");

    assertTrue(l0.isHorizontalOrVertical());
    final var pointsL0 = l0.streamPoints().collect(Collectors.toList());
    assertEquals(new Point(2, 3), pointsL0.get(0));
    assertEquals(new Point(2, 4), pointsL0.get(1));
    assertEquals(new Point(2, 5), pointsL0.get(2));
    final var pointsL1 = l1.streamPoints().collect(Collectors.toList());
    assertEquals(new Point(-1, 2), pointsL1.get(0));
    assertEquals(new Point(-1, 3), pointsL1.get(1));
    assertEquals(new Point(-1, 4), pointsL1.get(2));

  }

  @Test
  void stream_diagonalLines_streamsPoints() {
    final Line l0 = Line.parse("0,0 -> 2,2");
    final Line l1 = Line.parse("0,0 -> -2,2");
    final Line l2 = Line.parse("0,0 -> 2,-2");
    final Line l3 = Line.parse("0,0 -> -2,-2");

    assertFalse(l0.isHorizontalOrVertical());
    final var pointsL0 = l0.streamPoints().collect(Collectors.toList());
    assertEquals(new Point(0, 0), pointsL0.get(0));
    assertEquals(new Point(1, 1), pointsL0.get(1));
    assertEquals(new Point(2, 2), pointsL0.get(2));

    assertFalse(l1.isHorizontalOrVertical());
    final var pointsL1 = l1.streamPoints().collect(Collectors.toList());
    assertEquals(new Point(-2, 2), pointsL1.get(0));
    assertEquals(new Point(-1, 1), pointsL1.get(1));
    assertEquals(new Point(0, 0), pointsL1.get(2));

    assertFalse(l2.isHorizontalOrVertical());
    final var pointsL2 = l2.streamPoints().collect(Collectors.toList());
    assertEquals(new Point(0, 0), pointsL2.get(0));
    assertEquals(new Point(1, -1), pointsL2.get(1));
    assertEquals(new Point(2, -2), pointsL2.get(2));

    assertFalse(l3.isHorizontalOrVertical());
    final var pointsL3 = l3.streamPoints().collect(Collectors.toList());
    assertEquals(new Point(-2, -2), pointsL3.get(0));
    assertEquals(new Point(-1, -1), pointsL3.get(1));
    assertEquals(new Point(0, 0), pointsL3.get(2));
  }
}