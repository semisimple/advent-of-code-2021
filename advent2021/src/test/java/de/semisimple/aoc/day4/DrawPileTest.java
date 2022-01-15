package de.semisimple.aoc.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class DrawPileTest {


  @Test
  void stream_parsedInteger_returnsSameOrder() {
    final DrawPile drawPile = DrawPile.parse("1,2,9,8");

    final List<Integer> result = drawPile.stream().collect(Collectors.toList());

    assertEquals(4, result.size());
    assertEquals(1, result.get(0));
    assertEquals(2, result.get(1));
    assertEquals(9, result.get(2));
    assertEquals(8, result.get(3));

  }
}