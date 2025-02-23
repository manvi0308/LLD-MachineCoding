package AIBasedGameEngine.api;

import AIBasedGameEngine.boards.TicTaeToe;
import AIBasedGameEngine.gamestate.*;

public class GameEngine {
    public static void main(String[] args) {

    }

    public Board start(String boardName){
        if(boardName.equals("TicTacToe")){
            return new TicTaeToe();
        }
        return new Board();
    }

    public void move(Board board, Player player, Move move){
        if(board instanceof TicTaeToe){
            TicTaeToe board1 = (TicTaeToe) board;
            board1.setCell(Move.getCell(), player.getSymbol());
        }else{
            throw new  IllegalArgumentException();
        }
    }

    public Move suggestMove(Board board){
        if(board instanceof  TicTaeToe){
            TicTaeToe board1 = (TicTaeToe) board;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(board1.getCells(i, j) == null){
                        return new Move(new Cell(i, j));
                    }
                }
            }

        }
        throw new IllegalStateException();

    }
    public GameResult isComplete(Board board){
        // whether game is complete or not complete
        if(board instanceof TicTaeToe){
            String firstCharacter = "-";

            boolean rowComplete = true;
            for(int i = 0; i < 3; i++){
                rowComplete = true;
                firstCharacter = ((TicTaeToe) board).getCells(i, 0);
                for(int j = 1; j < 3; j++){
                    if(!((TicTaeToe) board).getCells(i, j).equals(firstCharacter)){
                        rowComplete = false;
                        break;
                    }
                }

                if(rowComplete)
                    break;
            }
        }

        return new GameResult();
    }
}
