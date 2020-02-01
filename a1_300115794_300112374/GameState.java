/**
 * An enum class that defines the
 * values <b>PLAYING</b>,  <b>DRAW</b>,
 *  <b>XWIN</b> and <b>OWIN</b>
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

enum GameState{

	// YOUR CODE HERE

	PLAYING, 
	DRAW, 
	XWIN, 
	OWIN;

}

private GameState currentState = PLAYING;
private int countV = 1;
private int countH = 1;
private int countD = 1;

public void setCurrentState(GameState currentState) {

	// check vertical
	if(currentState == PLAYING){
		for(int i = 0; i < sizeWin; i++){
			if( board[i] == board[i + lines.length]){
				countV = countV + 1;
			}
			if( board[i] == board[i - lines.length]){
				countV = counV + 1
			}
		}
		if(countV == sizeWin){
			if (level % 2 == 0){
				currentState = XWIN;
			}
			else{
				currentState = OWIN;
			}
		}
	}

	// check horizontal
	else if(currentState == PLAYING){
		for(int i = 0; i < sizeWin; i++){
			if( board[i] == board[i + 1]){
				countH = countH + 1;
			}
			if( board[i] == board[i - 1]){
				countH = countH + 1
			}
		}
		if(countH == sizeWin){
			if (level % 2 == 0){
				currentState = XWIN;
			}
			else{
				currentState = OWIN;
			}
		}
	}

	// check diagonal

}


/* for gamestate, we have to use CellValue. 
verify game state in this order:
	if board isnt full:
		- check if X wins
		- check if O wins
		else:
			- playing
	else:
		- verify if X wins
		- verify if O wins
		else:
			- draw

to check if there is a vertical line,
you do the numOfCell == numOfCell + (or - depending on position) numOfColums
to check horizontal just check numOfCell == all the ones beside it
diagnonal its tricky so ill get back to this later

use sizeWin from TicTacToeGame.java to determine how many in a row are needed for a win

*/



