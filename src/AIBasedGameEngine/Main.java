package AIBasedGameEngine;

import AIBasedGameEngine.api.GameEngine;
import AIBasedGameEngine.gamestate.Board;
import AIBasedGameEngine.gamestate.Cell;
import AIBasedGameEngine.gamestate.Move;
import AIBasedGameEngine.gamestate.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("TicTacToe");
        int row;
        int col;
        // make moves in a loop
        while (!gameEngine.isComplete(board).isOver()) {
            Player computer = new Player("0"), opponent = new Player("X");
            System.out.println("Make your move");
            Scanner scanner = new Scanner(System.in);
            row = scanner.nextInt();
            col = scanner.nextInt();

            Move oppMove = new Move(new Cell(row, col));
            gameEngine.move(board, opponent, oppMove);

            if (!gameEngine.isComplete(board).isOver()) {
                Move computerMove = gameEngine.suggestMove(board);
                gameEngine.move(board, computer, computerMove);
            }
        }
        System.out.println("Game result " + gameEngine.isComplete(board));

    }
}
