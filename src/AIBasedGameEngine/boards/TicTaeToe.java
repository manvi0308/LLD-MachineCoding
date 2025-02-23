package AIBasedGameEngine.boards;

import AIBasedGameEngine.gamestate.Board;
import AIBasedGameEngine.gamestate.Cell;

public class TicTaeToe extends Board {

    String[][] cells = new String[3][3];
    public String getCells(int i, int j) {
        return cells[i][j];
    }
    public void setCell(Cell cell, String  symbol){
        cells[cell.row][cell.col] = symbol;
    }
}