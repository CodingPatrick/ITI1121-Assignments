import java.util.LinkedList;
import java.util.ListIterator;

public class ListOfGamesGenerator {
  

   /**
  * generates all different games for the specified
  * parameters. Each game is recorded only once. 
  * once a game is finished, it is not extended further
  * @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
    * @param sizeWin
    *  the number of cells that must be aligned to win.
    * @return
    * a list of lists of game instances, ordered by levels
    */
  public static LinkedList<LinkedList<TicTacToeGame>> generateAllGames(int lines, int columns, int winLength){

    //YOUR CODE HERE

    /*
       
       We need to build a loop that completes TicTacToe games to a win or draw. (it has to be complete)
       
       We have to check with the "equals" function in TicTacToeGame.java to se if there's any games with the same 
       state. If there is, we don't list that one because we don't want any duplicated in our list.

       It says in the instructions to NOT INCLUDE ANY EMPTY LISTS. So what I understand from that is that we have to 
       make sure our list finishes at the right time. Ex: In 2 by 2, the game always finished at 3 moves, so we don't
       have to put a "Level 4" list for that one because it would be empty as all the games are already done.
      

      while loop to initialize the first linked list by creating lines*columns elements]
    */
    LinkedList<LinkedList<TicTacToeGame>> mainList = new LinkedList<LinkedList<TicTacToeGame>>(); // create a main list
    TicTacToeGame game = new TicTacToeGame(lines, columns, winLength);
   

    for (int i=0; i < lines*columns; i++){
      LinkedList<TicTacToeGame> subList = new LinkedList<TicTacToeGame>();  // for every index of the main list you create a sublist
      for (int k=0; k<subList.size(); k++){
        if (game.equals(k)){
          subList.remove(k); // removes dupes from sublist
        }
      }
      for (int j=0; j< lines*columns; j++){
        if ((game.valueAt(j) == CellValue.EMPTY) && (game.getGameState() == GameState.PLAYING)){ 
          subList.add(new TicTacToeGame(game, j)); //if the position is valid, creates a new game at position
        }
      }
      mainList.add(subList); //add sublist to mainlist
    }
    return mainList;
  }
}
