package com.codurance;

import static com.codurance.Cell.CellState.ALIVE;
import static com.codurance.Cell.CellState.DEAD;

public class Cell {

  private final CellState state;

  public CellState getState() {
    return state;
  }

  public enum CellState {
    ALIVE,
    DEAD
  }

  public Cell(CellState state) {
    this.state = state;
  }

  public CellState getNextState(int neighbours) {
    if (state == ALIVE){
      return neighbours > 1 && neighbours < 4 ? ALIVE : DEAD;
    }else {
      return neighbours == 3 ? ALIVE : DEAD;
    }
  }

}
