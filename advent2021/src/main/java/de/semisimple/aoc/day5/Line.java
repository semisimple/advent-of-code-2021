package de.semisimple.aoc.day5;

import java.util.stream.IntStream;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Line {

  final int x1;
  final int y1;

  final int x2;
  final int y2;


  public static Line parse(String line) {
    final String[] points = line.split(" -> ");
    final String[] p1 = points[0].split(",");
    final String[] p2 = points[1].split(",");

    return new Line(
        Integer.parseInt(p1[0]),
        Integer.parseInt(p1[1]),
        Integer.parseInt(p2[0]),
        Integer.parseInt(p2[1])
    );

  }

  public boolean isHorizontalOrVertical() {
    return x1 == x2 || y1 == y2;
  }

  public Stream<Point> streamPoints() {
    final int distanceX = x2 - x1;
    final int distanceY = y2 - y1;

    if (distanceX == 0) {
      return streamVertically(distanceY);
    } else if (distanceY == 0) {
      return streamHorizontally(distanceX);
    } else {
      return streamDiagonally(distanceX, distanceY);
    }

  }

  private Stream<Point> streamDiagonally(int distanceX, int distanceY) {
    final int diff = distanceX - distanceY;
    if (diff == 0) {
      return streamDistance(distanceX).mapToObj(it -> new Point(x1 + it, y1 + it));
    } else {
      return streamDistance(distanceX).mapToObj(it -> new Point(x1 + it, y1 - it));
    }
  }

  private Stream<Point> streamHorizontally(int distanceX) {
    return streamDistance(distanceX).mapToObj(it -> new Point(x1 + it, y1));
  }

  private IntStream streamDistance(int distance) {
    if (distance > 0) {
      return IntStream.rangeClosed(0, distance);
    } else {
      return IntStream.rangeClosed(distance, 0);
    }
  }

  private Stream<Point> streamVertically(int distanceY) {
    return streamDistance(distanceY).mapToObj(it -> new Point(x1, y1 + it));
  }
}
