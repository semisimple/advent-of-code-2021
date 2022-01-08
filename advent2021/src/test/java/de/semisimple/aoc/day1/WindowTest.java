package de.semisimple.aoc.day1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WindowTest {


  @Test
  void next_slidesValue_correctSum() {
    final Window window = new Window(2,1,0);
    final Window next = window.next(3);

    assertEquals(window.sum(), 3);
    assertEquals(next.sum(), 6);
  }
}