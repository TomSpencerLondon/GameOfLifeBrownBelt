package com.codurance;

import static com.codurance.Cell.CellState.ALIVE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codurance.Cell.CellState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// 1. Any live Cell with fewer than 2 live neighbours dies,
// as if caused by under-population
// 2. Any live cell with two or three live neighbours
// lives on to the next generation
// 3. Any live cell with more than three
// live neighbours dies, as if by overcrowding
// 4. any dead cell with exactly three live
// neighbours becomes a live cell as if by reproduction


public class CellShould {

  @ParameterizedTest
  @CsvSource({
      "0",
      "1"
  })
  void die_with_zero_or_one_neighbours(int neighbours) {
    Cell cell = new Cell(ALIVE);
    cell.update(neighbours);
    CellState result = cell.getState();

    assertEquals(CellState.DEAD, result);
  }

  @Test
  void become_alive_with_three_neighbours() {
    Cell cell = new Cell(CellState.DEAD);
    cell.update(3);
    CellState result = cell.getState();

    assertEquals(ALIVE, result);
  }

  @Test
  void stay_dead_with_two_neighbours() {
    Cell cell = new Cell(CellState.DEAD);

    cell.update(2);

    CellState result = cell.getState();

    assertEquals(CellState.DEAD, result);
  }

  @ParameterizedTest
  @CsvSource({
      "2",
      "3"
  })
  void should_live_on_with_two_or_three_neighbours(int neighbours) {
    Cell cell = new Cell(ALIVE);

    cell.update(neighbours);
    CellState result = cell.getState();

    assertEquals(ALIVE, result);
  }

  @ParameterizedTest
  @CsvSource({
      "4",
      "5",
      "6",
      "7",
      "8"
  })
  void live_cell_dies_with_four_or_more_neighbours(int neighbours) {
    Cell cell = new Cell(ALIVE);
    cell.update(neighbours);
    CellState result = cell.getState();
    assertEquals(CellState.DEAD, result);
  }

  @ParameterizedTest
  @CsvSource({
      "ALIVE",
      "DEAD"
  })
  void return_its_state(String initialState) {
    CellState input = CellState.valueOf(initialState);

    Cell cell = new Cell(input);

    assertEquals(input, cell.getState());
  }
}
