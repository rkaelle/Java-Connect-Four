import java.util.*;

public class ConnectFourGame implements ConnectFourRules
{   //Instance Data
    Board myBoard;
    public ConnectFourGame(){
        myBoard = new Board(8,6);
    }
  //play the game here
    public int checkVertical(){return -1;};
    public int checkHorizontal(){return -1;};
    public int checkDIAGdown(){return -1;};
    public int checkDIAGup(){return -1;};
  
  public void play(){
    boolean winner = false;
    System.out.println("Lets begin...\n\n");
    int roundNo = 1;
    while (winner == false){
      
      int computerPos = computerMove();
      if(computerPos == -1){
        computerPos = (genValue())-1;
      }
      myBoard.place(false,computerPos);
      System.out.println("Round #"+roundNo+"\n\nComputer = o\t\tUser = x\n\n"+myBoard);

      Scanner userPlace = new Scanner(System.in);
      System.out.print("Enter which column you would like to place your piece: ");
      int userPos = userPlace.nextInt()-1;
      myBoard.place(true,userPos);
      if(checkWin() == true){
        winner = true;
        System.out.println("Winner!!");
      }
      
      System.out.println("Computer = o\t\tUser = x\n"+myBoard+"\n__________________________________________________\n");
      roundNo++;
    }
  }

  private int computerMove(){
    int move = -1;
    for(int i = 0; i < myBoard.boardLength(); i++){
        for(int j = 1; j < myBoard.boardWidth(); j++){
            if(j+3 < myBoard.boardWidth() && myBoard.getBoard()[j][i] == "O" && myBoard.getBoard()[j+1][i] == "O" && myBoard.getBoard()[j+2][i] == "O" && myBoard.getBoard()[j+3][i] == "_") {
                move = i;
                return move;
            }
        }
    }
    for(int i = 0; i < myBoard.boardLength(); i++){
        for(int j = 1; j < myBoard.boardWidth(); j++){
            if(j+3 < myBoard.boardWidth() && myBoard.getBoard()[j][i] == "X" && myBoard.getBoard()[j+1][i] == "X" && myBoard.getBoard()[j+2][i] == "X" && myBoard.getBoard()[j+3][i] == "_") {
                move = i;
                return move;
            }
        }
    }
    return move;
}



  public int genValue(){
    return (int)(1+ (myBoard.boardLength()-1) * Math.random());
  }

  public boolean checkWin() {
    int boardLength = myBoard.boardLength();
    int boardWidth = myBoard.boardWidth();
    String[][] board = myBoard.getBoard();
    int moves = myBoard.getMoves();
    // check for horizontal win
    for (int i = 1; i < boardWidth; i++) {
        for (int j = 0; j < boardLength - 3; j++) {
            if (board[i][j] != "_" && board[i][j] == board[i][j + 1] && board[i][j + 1] == board[i][j + 2] && board[i][j + 2] == board[i][j + 3]) {
                System.out.println("Winner is: " + board[i][j]);
                return true;
            }
        }
    }

    // check for vertical win
    for (int i = 1; i < boardWidth - 3; i++) {
        for (int j = 0; j < boardLength; j++) {
            if (board[i][j] != "_" && board[i][j] == board[i + 1][j] && board[i + 1][j] == board[i + 2][j] && board[i + 2][j] == board[i + 3][j]) {
                System.out.println("Winner is: " + board[i][j]);
                return true;
            }
        }
    }

    // check for diagonal win (top-left to bottom-right)
    for (int i = 1; i < boardWidth - 3; i++) {
        for (int j = 0; j < boardLength - 3; j++) {
            if (board[i][j] != "_" && board[i][j] == board[i + 1][j + 1] && board[i + 1][j + 1] == board[i + 2][j + 2] && board[i + 2][j + 2] == board[i + 3][j + 3]) {
                System.out.println("Winner is: " + board[i][j]);
                return true;
            }
        }
    }

    // check for diagonal win (top-right to bottom-left)
    for (int i = 1; i < boardWidth - 3; i++) {
        for (int j = 3; j < boardLength; j++) {
            if (board[i][j] != "_" && board[i][j] == board[i + 1][j - 1] && board[i + 1][j - 1] == board[i + 2][j - 2] && board[i + 2][j - 2] == board[i + 3][j - 3]) {
                System.out.println("Winner is: " + board[i][j]);
                return true;
            }
        }
    }
    if (moves == (boardWidth-1) * boardLength) {
        System.out.println("It's a draw!");
        return true;
    } else{
      return false;
    }
  }

}