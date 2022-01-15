package de.semisimple.aoc.day4;

import static java.util.function.Predicate.not;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BingoGame {

  private final DrawPile drawPile;
  private final List<Board> boards;

  public static BingoGame of(List<String> lines) {
    DrawPile drawPile = DrawPile.parse(lines.get(0));

    final ArrayList<Board> boards = new ArrayList<>();
    for (int i = 2; i + 4 < lines.size(); i = i + 6) {
      final String[] strings = lines.stream().skip(i)
          .limit(5)
          .toArray(String[]::new);

      final Board b = Board.parse(strings);
      boards.add(b);
    }

    return new BingoGame(drawPile, boards);
  }

  public Board findfirstWinningBoard() {
    return drawPile.stream()
        .flatMap(
            it -> boards.stream()
                .filter(not(Board::hasWon))
                .map(b -> b.flagIfPresent(it))
                .filter(Board::hasWon)
        )
        .findFirst()
        .orElseThrow(() -> new IllegalStateException("No winning board!"));
  }

  public Board findLastWinningBoard() {
    final List<Board> winningBoards = drawPile.stream()
        .flatMap(
            it -> boards.stream()
                .filter(not(Board::hasWon))
                .map(b -> b.flagIfPresent(it))
                .filter(Board::hasWon)
        )
        .collect(Collectors.toList());
    return getlastBoard(winningBoards);
  }

  private Board getlastBoard(List<Board> winningBoards) {
    final int lastIndex = winningBoards.size() - 1;
    return winningBoards.get(lastIndex);
  }

}

