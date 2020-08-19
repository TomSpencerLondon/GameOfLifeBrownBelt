package com.codurance;

import static com.codurance.App.X;

import com.codurance.Cell.CellState;

public class BoardFormatter {

  private CellState[][] nextWorld;

  public BoardFormatter(CellState[]... nextWorld) {
    this.nextWorld = nextWorld;
  }

  public void invoke() {
    for(int j = 0; j < nextWorld.length; j++){
      StringBuilder builder = new StringBuilder();
      for(int k = 0; k < nextWorld[j].length; k++){
        if(nextWorld[j][k] == X) {
          builder.append("X");
        } else builder.append("O");
      }
      System.out.println(builder.toString());
    }
    System.out.println("------------------------------");
  }

}
