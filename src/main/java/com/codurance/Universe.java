package com.codurance;

import com.codurance.Cell.CellState;

public class Universe {

  private final CellState[][] cellStates;

  public Universe(CellState[][] cellStates) {
    this.cellStates = cellStates;
  }

  public CellState[][] getState() {
    return cellStates;
  }
}
