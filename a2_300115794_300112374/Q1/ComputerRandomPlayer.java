public class ComputerRandomPlayer extends Player {

	boolean valid;
	int ranNumber;
	TicTacToeGame game;

	public void play(game){
		/* checks if its playable
		chooses a random input
		if valid plays and returns

		for 1<= number <= lines*columns:
		number = 1 + generator.nextInt(lines*columns);
		*/
		ranNumber =  1 + generator.nextInt(lines*columns);
		while (game.board[ranNumber] != CellValue.EMPTY){
			ranNumber =  1 + generator.nextInt(lines*columns);
			}
		}
		game.board[ranNumber] = game.nextCellValue();
		game.level++;
		if(game.gameState != GameState.PLAYING) {
			System.out.println("hum, extending a finished game... keeping original winner");
		}	
		else {
			game.setGameState(i);			
		}


	}
}