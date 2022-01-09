package de.semisimple.aoc.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class EngineTest {

  Engine engine = new Engine();

  @Test
  void run_sampleInstructions_shouldEndInPosition_h15_d10() {
    final Stream<String> sample = Stream.of(
        "forward 5",
        "down 5",
        "forward 8",
        "up 3",
        "down 8",
        "forward 2"
    );

    engine.run(sample);

    final Position result = engine.getPosition();
    assertEquals(15, result.getHorizontalPosition());
    assertEquals(10, result.getDepth());
  }
}