import java.util.*;

// ConnectFourGame class implements the ConnectFourRules interface
public class ConnectFourGame implements ConnectFourRules
{   
    //Instance Data
    Board myBoard;
    // constructor that creates the game board
    public ConnectFourGame(){
        myBoard = new Board(8,6);
    }

    //methods for checking for wins that return -1
    public int checkVertical(){return -1;}
    public int checkHorizontal(){return -1;}
    public int checkDIAGdown(){return -1;}
    public int checkDIAGup(){return -1;}
  
    // main method to run the game
    public void play(){
        boolean winner = false;
        System.out.println("Lets begin...\n\n");
        int roundNo = 1;
        // loop to keep game running until a winner is found
        while (winner == false){
          
            // computer move
            int computerPos = computerMove();
            // if computerMove returns -1, then generate a random move
            if(computerPos == -1){
                computerPos = (genValue());
            }
            // place the computer's move on the board
            myBoard.place(false,computerPos);
            // print the current round and the current game board
            System.out.println("Round #"+roundNo+"\n\nComputer = o\t\tUser = x\n\n"+myBoard);

            // get user's move
            Scanner userPlace = new Scanner(System.in);
            System.out.print("Enter which column you would like to place your piece: ");
            int userPos = userPlace.nextInt()-1;
            // place user's move on the board
            myBoard.place(true,userPos);
            // check if there is a winner, if true, set winner to true
            if(checkWin() == true){
              System.out.println("Winner!!");  
              winner = true;
            } else{
                clearScreen();
            }

            // increment round number
            roundNo++;
        }
    }
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
   }
//method to return the computers next move
  private int computerMove(){
    int move = -1;
   // check for three in a row horizontally for computer
    for(int i = 0; i < myBoard.boardLength(); i++){
        for(int j = 1; j < myBoard.boardWidth(); j++){
            if(j+3 < myBoard.boardWidth() && myBoard.getBoard()[j][i] == "O" && myBoard.getBoard()[j+1][i] == "O" && myBoard.getBoard()[j+2][i] == "O" && myBoard.getBoard()[j+3][i] == "_") {
                move = i;
                return move;
            }
        }
    }
 // check for three in a row horizontally for user
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