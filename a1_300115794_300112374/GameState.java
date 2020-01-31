/**
 * An enum class that defines the
 * values <b>PLAYING</b>,  <b>DRAW</b>,
 *  <b>XWIN</b> and <b>OWIN</b>
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

enum GameState{
	PLAYING, DRAW, XWIN, OWIN;
	// YOUR CODE HERE
	
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

