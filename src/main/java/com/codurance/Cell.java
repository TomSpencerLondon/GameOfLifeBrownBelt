package com.codurance;

import static com.codurance.Cell.CellState.ALIVE;
import static com.codurance.Cell.CellState.DEAD;

public class Cell {

  private CellState state;

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

  public void update(int neighbours) {
    if (state == ALIVE){
      state = neighbours > 1 && neighbours < 4 ? ALIVE : DEAD;
    }else {
      state = neighbours == 3 ? ALIVE : DEAD;
    }
  }

}
