public class Board
{
  //computer = o user = x
//construct and print the board 6 by 7
  String[][] board;
  private int moves;

  public Board(int row, int col){
    board = new String[row+1][col];
    for(int r = 0; r < row+1; r++){
      for(int c=0;c<col;c++){
        if(r==0){
          board[r][c] = Integer.toString(c+1);
        }else{
          board[r][c] = "_";
        }
      }
    }
  }


  public String toString(){
    String print = "";
    for(int r = 0; r < board.length; r++){
      for(int c=0;c<board[r].length;c++){
        print +="|";
        print+=board[r][c];
      }
      print +="|";
      print +="\n";
    }
    return print;
  }

  public int boardLength(){
    return board[0].length;
  }

  public int boardWidth(){
    return board.length;
  }

    //if player == true it means the user is the player and false if computer
    public void place(boolean player, int pos) {
    for (int i = board.length - 1; i >= 0; i--) {
        if (board[i][pos] == "_") {
            board[i][pos] = player ? "x" : "o";
            break;
        }
    }
    moves++;
  }


  public String[][] getBoard() {
    return board;
  }

  public void setBoard(String[][] board) {
      this.board = board;
  }

  public int getMoves() {
    return moves;
}

public void setMoves(int moves) {
    this.moves = moves;
}

}