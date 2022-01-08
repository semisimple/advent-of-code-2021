package de.semisimple.aoc.day1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;

class MeasuringDeviceTest {

  @Test
  void countIncreases_sampleInput_shouldCountIncreases() {
    final Stream<Integer> sample = Stream.of(199,
        200,
        208,
        210,
        200,
        207,
        240,
        269,
        260,
        263);
    final MeasuringDevice measureDevice = new MeasuringDevice(new IncreaseIndicator());

    final Long increases = measureDevice.countIncreases(sample);

    assertEquals(7,increases);
  }
  @Test
  void countIncreases_sampleInput_shouldCountWindowedIncreases() {
    final Stream<Integer> sample = Stream.of(199,
        200,
        208,
        210,
        200,
        207,
        240,
        269,
        260,
        263);
    final MeasuringDevice measureDevice = new MeasuringDevice(new WindowIncreaseIndicator());

    final Long increases = measureDevice.countIncreases(sample);

    assertEquals(5,increases);
  }
}