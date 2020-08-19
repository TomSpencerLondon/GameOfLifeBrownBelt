package com.codurance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.codurance.Cell.CellState;
import org.junit.jupiter.api.Test;

public class CellShould {

  @Test
  void die_with_one_neighbour() {
    Cell cell = new Cell(Cell.CellState.ALIVE);

    CellState result = cell.getNextState();

    assertEquals(Cell.CellState.DEAD, result);
  }

}
