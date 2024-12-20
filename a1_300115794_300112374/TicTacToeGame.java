 /**
 * The class <b>TicTacToeGame</b> is the
 * class that implements the Tic Tac Toe Game.
 * It contains the grid and tracks its progress.
 * It automatically maintain the current state of
 * the game as players are making moves.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class TicTacToeGame {

// FINISH THE VARIABLE DECLARATION
   /**
	* The board of the game, stored as a one dimension array.
	*/
	public CellValue[] board;

   /**
	* level records the number of rounds that have been
	* played so far. 
	*/
	public int level;

   /**
	* gameState records the current state of the game.
	*/
	public GameState gameState = GameState.PLAYING;


   /**
	* lines is the number of lines in the grid
	*/
	public int lines;
	

   /**
	* columns is the number of columns in the grid
	*/
	public int columns;

   /**
	* sizeWin is the number of cell of the same type
	* that must be aligned to win the game
	*/
	public int sizeWin;
	

   /**
	* default constructor, for a game of 3x3, which must
	* align 3 cells
	*/
	public TicTacToeGame(){
		lines = 3;
		columns = 3;
		sizeWin = 3;
		board = new CellValue[lines*columns];
		for (int i=0; i<board.length; i++){
			board[i] = CellValue.EMPTY;
		}

	}

   /**
	* constructor allowing to specify the number of lines
	* and the number of columns for the game. 3 cells must
	* be aligned.
   	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
  	*/
	public TicTacToeGame(int lines, int columns){	
		board = new CellValue[lines*columns];
		sizeWin = 3;
		for (int i=0; i<board.length; i++){
			board[i] = CellValue.EMPTY;
		}
	}

   /**
	* constructor allowing to specify the number of lines
	* and the number of columns for the game, as well as 
	* the number of cells that must be aligned to win.
   	* @param lines
    *  the number of lines in the game
    * @param columns
    *  the number of columns in the game
    * @param sizeWin
    *  the number of cells that must be aligned to win.
  	*/
	public TicTacToeGame(int lines, int columns, int sizeWin){
		board = new CellValue[lines*columns];
		for (int i=0; i<board.length; i++){
			board[i] = CellValue.EMPTY;
		}
	}



   /**
	* getter for the variable lines
	* @return
	* 	the value of lines
	*/
	public int getLines(){
		return lines;
	}

   /**
	* getter for the variable columns
	* @return
	* 	the value of columns
	*/
	public int getColumns(){		
		return columns;
	}

   /**
	* getter for the variable level
	* @return
	* 	the value of level
	*/
	public int getLevel(){	
		return level;
	}

  	/**
	* getter for the variable sizeWin
	* @return
	* 	the value of sizeWin
	*/
	public int getSizeWin(){
		return sizeWin;
	}

   /**
	* getter for the variable gameState
	* @return
	* 	the value of gameState
	*/
	public GameState getGameState(){
		return gameState;

	}

   /**
	* returns the cellValue that is expected next,
	* in other word, which played (X or O) should 
	* play next.
	* This method does not modify the state of the
	* game.
	* @return 
    *  the value of the enum CellValue corresponding
    * to the next expected value.
  	*/
	public CellValue nextCellValue(){
		if (level % 2 == 0){
			return CellValue.X;
		}
		else{
			return CellValue.O;
		}
	}

   /**
	* returns the value  of the cell at
	* index i.
	* If the index is invalid, an error message is
	* printed out. The behaviour is then unspecified
   	* @param i
    *  the index of the cell in the array board
    * @return 
    *  the value at index i in the variable board.
  	*/
	public CellValue valueAt(int i) {
		if (0<i && i<=lines*columns){
			return board[i-1];
		}
		else {
			return null;

		}
	}

   /**
	* This method is called when the next move has been
	* decided by the next player. It receives the index
	* of the cell to play as parameter.
	* If the index is invalid, an error message is
	* printed out. The behaviour is then unspecified
	* If the chosen cell is not empty, an error message is
	* printed out. The behaviour is then unspecified
	* If the move is valide, the board is updated, as well
	* as the state of the game.
	* To faciliate testing, is is acceptable to keep playing
	* after a game is already won. If that is the case, the
	* a message should be printed out and the move recorded. 
	* the  winner of the game is the player who won first
   	* @param i
    *  the index of the cell in the array board that has been 
    * selected by the next player
  	*/
	public void play(int i) {
		//System.out.print(i+" i"); 
		if (0> i-1 || i-1>board.length){
			System.out.print("\n invalid index \n"); // test purposes
		}
		else if (board[i-1] != CellValue.EMPTY){
			System.out.print("\n Index value is invalid, cell is not empty\n");
		}

		else{
			board[i-1] = nextCellValue();
			setGameState(i-1);
			System.out.println(level);
			toString();
			System.out.println(getGameState());
			level++;
			if (level == 9){
				gameState = GameState.DRAW;
				System.out.print("\nIt is a draw!\n");
			}
			//System.out.print("\n" + gameState); // test purposes
			if (gameState != GameState.PLAYING){
				if (gameState == GameState.XWIN){
					System.out.print("\nX has won!\n");
				}
				else if (gameState == GameState.OWIN){
					System.out.print("\nO has won!\n");
				}
				else {
					gameState = GameState.DRAW;
					System.out.print("\nIt is a draw!\n");
				}
			}

		}

		/* so basically this is the part that happens when someone puts a number to play on
		* so first you convert the index number to i-1, so then you check if i-1 < 0 || i-1 > lines*columns
		* if it is then print out an error 
		* so then you check if board[i-1] != CellValue.EMPTY
		* print out an error
		* so if the move is valid, board[i-1] = nextCellValue()
		* then you do round ++
		* setGameState 
		* toString print with the added thing
		* getGameState, if == gameState.PLAYING; then break
		* else then you print out either X or O wins or draw
		* have to initialize a one time use variable that stores the winner BUT doesnt change if you keep playing
		*/

	
	}


   /**
	* A helper method which updates the gameState variable
	* correctly after the cell at index i was just set in
	* the method play(int i)
	* The method assumes that prior to setting the cell
	* at index i, the gameState variable was correctly set.
	* it also assumes that it is only called if the game was
	* not already finished when the cell at index i was played
	* (i.e. the game was playing). Therefore, it only needs to 
	* check if playing at index i has concluded the game, and if
	* set the oucome correctly
	* 
   	* @param i
    *  the index of the cell in the array board that has just 
    * been set
  	*/


	private void setGameState(int i){

		int countV = 1;
		int countH = 1;
		int countDr = 1;
		int countDl = 1; 
		int j;

		// check vertical
		if(gameState == GameState.PLAYING){
			for(j = 0; j < sizeWin;){
				if( board[i] == board[j + columns]){
					countV = countV + 1;
				}
				j = j + columns;
			}
			for(j = 0; j < sizeWin;){
				if( board[i] == board[j - columns]){
					countV = countV + 1;
				}
				j = j - columns;
			}
			if(countV == sizeWin){
				if (level % 2 == 0){
					gameState = GameState.XWIN;
				}
				else{
					gameState = GameState.OWIN;
				}
			}
		}

		// check horizontal
		if(gameState == GameState.PLAYING){
			for(j = 0; j < sizeWin;){
				if( board[i] == board[j + 1]){
					countH = countH + 1;
				}
				j = j + 1;
			}
			for(j = 0; j < sizeWin;){
				if( board[i] == board[j - 1]){
					countH = countH + 1;
				}
				j = j - 1;
			}

			if(countH == sizeWin){
				if (level % 2 == 0){
					gameState = GameState.XWIN;
				}
				else{
					gameState = GameState.OWIN;
				}
			}
		}

		// check diagonal "/"
		if(gameState == GameState.PLAYING){
			for(j = 0; j < sizeWin;){
				if( board[i] == board[j + (columns - 1)]){
					countDr = countDr + 1;
				}
				j = j + (columns - 1);
			}
			for(j = 0; j < sizeWin;){
				if( board[i] == board[j - (columns - 1)]){
					countDr = countDr + 1;
				}
				j = j - (columns - 1);
			}
			if(countDr == sizeWin){
				if (level % 2 == 0){
					gameState = GameState.XWIN;
				}
				else{
					gameState = GameState.OWIN;
				}
			}
		}

		// check diagonal "\"
		if(gameState == GameState.PLAYING){
			for(j = 0; j < sizeWin;){
				if( board[i] == board[j + (columns + 1)]){
					countDl = countDl + 1;
				}
				j = j + (columns + 1);
			}
			for(j = 0; j < sizeWin;){
				if( board[i] == board[j - (columns + 1)]){
					countDl = countDl + 1;
				}
				j = j - (columns + 1);
			}
			if(countDl == sizeWin){
				if (level % 2 == 0){
					gameState = GameState.XWIN;
				}
				else{
					gameState = GameState.OWIN;
				}
			}
		}
	}



   /**
	* Returns a String representation of the game matching
	* the example provided in the assignment's description
	* 
   	* @return
    *  String representation of the game
  	*/

	public String toString(){
		final String nextLine;

		nextLine = System.getProperty("line.separator");
		String thisLine = "";
        String boardString = "";
        int cellz=0;
        String cell;

        for (int i=0; i<lines; i++){
        	for (int j=0; j<columns; j++){
        		if (board[cellz]==CellValue.X){
        			cell = "X";
        		}
        		else if (board[cellz]==CellValue.O){
        			cell = "O";
        		}
        		else {
        			cell = " ";
        		}
        		thisLine += (cell+ " | ");
        		cellz++;
        	}
        	boardString += thisLine + nextLine;
        	thisLine = "";
        }
        System.out.println(boardString);
        return boardString;

		/* so here we do a nested for loop, print board[index] for a cell then + "|" while j < columns
		* then print "----" which is the size of a cell x the number of columns i guess
		* then it loops and does it for i < lines
		* now i need a counter for the cells 
		* so ill initialize it before the loop and just do cellz++ in the j for loop
		*/

	}

}
