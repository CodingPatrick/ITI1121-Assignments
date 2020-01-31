/**
 * An enum class that defines the
 * values <b>Empty</b>,  <b>X</b>
 * and <b>O</b>.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

enum CellValue {
	EMPTY, X, O;

}

/* 
initial thoughts:
you have the number of the cell that the player wants to play on
so you do like 
	if cell[numOfCell] != void 
		if cell[numOfCell] == X
			value = X
			return value
		else
			value = O
			return )
	else
		value = empty
		return value 
*/