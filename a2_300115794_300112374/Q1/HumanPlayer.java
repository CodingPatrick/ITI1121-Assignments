
public class HumanPlayer extends Player {

	TicTacToeGame game;
	int position;

	public void play(game){
		/* checks if its playable
		if it is then asks for a valid input (code from a1
		when correct input provided, plays in on the game
		
		scanner for an int
		conditions for it to be between 0 and lines*columns
		check if position is valid
		if it is then just contiue
		*/

		String answer = console.readLine();
		position = Integer.parseInt(answer)-1;

		if(position < 0 || position >= game.lines*game.columns){
			System.out.println("Illegal position: " + position);
			return;
		}
		if(game.board[position] != CellValue.EMPTY) {
			System.out.println("CellValue not empty: " + position + " in game " + toString());		
			return;	
		}
		// idk if this works because idk if im calling the variables correctly
		game.board[position] = game.nextCellValue();
		game.level++;
		if(game.gameState != GameState.PLAYING) {
			System.out.println("hum, extending a finished game... keeping original winner");
		} else {
			game.setGameState(position);
		}

	}
}
