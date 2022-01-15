package de.semisimple.aoc.day4;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day4 {

  public static void main(String[] args) {
    Path path = Paths.get("advent2021/src/main/resources/day4/input");
    try (Stream<String> lines = Files.lines(path)) {
      final List<String> game = lines.collect(Collectors.toList());
      BingoGame bingoGame = BingoGame.of(game);

      final Board board = bingoGame.findfirstWinningBoard();
      board.getWinningField();
      final int score = board.calculateScore();
      System.out.println("first winning score: " + score);

      final Board lastWinningBoard = BingoGame.of(game).findLastWinningBoard();
      final int lastScore = lastWinningBoard.calculateScore();

      System.out.println("last winning score: " + lastScore);


    } catch (Exception e) {
      System.err.println(e);
    }
  }
}
