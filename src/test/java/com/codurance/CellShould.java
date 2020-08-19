package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codurance.Cell.CellState;
import org.junit.jupiter.api.Test;

// 1. Any live Cell with fewer than 2 live neighbours dies,
// as if caused by under-population
// 2. Any live cell with two or three live neighbours
// lives on to the next generation
// 3. Any live cell with more than three
// live neighbours dies, as if by overcrowding
// 4. any dead cell with exactly three live
// neighbours becomes a live cell as if by reproduction


public class CellShould {

  @Test
  void die_with_zero_neighbours() {
    Cell cell = new Cell(CellState.ALIVE);
    CellState result = cell.getNextState(0);

    assertEquals(CellState.DEAD, result);
  }

  @Test
  void die_with_one_neighbour() {
    Cell cell = new Cell(CellState.ALIVE);

    CellState result = cell.getNextState(0);

    assertEquals(CellState.DEAD, result);
  }

  @Test
  void should_live_on_with_two_neighbours() {
    Cell cell = new Cell(CellState.ALIVE);

    CellState result = cell.getNextState(2);

    assertEquals(CellState.ALIVE, result);
  }

  @Test
  void should_live_on_with_three_neighbours() {
    Cell cell = new Cell(CellState.ALIVE);

    CellState result = cell.getNextState(3);

    assertEquals(CellState.ALIVE, result);
  }

  @Test
  void live_cell_dies_with_four_neighbours() {
    Cell cell = new Cell(CellState.ALIVE);
    CellState result = cell.getNextState(4);
    assertEquals(CellState.DEAD, result);
  }
}
