import java.util.LinkedList;


public class ComputerMenacePlayer extends Player {

	// YOUR CODE HERE

		private LinkedList<LinkedList<MenaceTicTacToeGame>> allGames;

	public ComputerMenacePlayer(){
		super();

		allGames = new LinkedList<LinkedList<MenaceTicTacToeGame>>();

		// start with the empty game
		allGames.add(new LinkedList<MenaceTicTacToeGame>());
		allGames.get(0).add(new MenaceTicTacToeGame());

		//build the new games by adding the next moves to the
		// previously built games
		for(int i=1; i<= 9; i++) {
			LinkedList<MenaceTicTacToeGame> newList;
			newList = new LinkedList<MenaceTicTacToeGame>();
			allGames.add(newList);
			for(MenaceTicTacToeGame game: allGames.get(i-1)){
				if(game.getGameState() == GameState.PLAYING) {
					for(int j = 0;
						j < 9;
						j++) {
						if(game.valueAt(j) == CellValue.EMPTY) {
							MenaceTicTacToeGame newGame = new MenaceTicTacToeGame(game,j);
							//checking that this game was not already found
							boolean isNew = true;
							for(MenaceTicTacToeGame existingGame: allGames.get(i)){
								if(newGame.equalsWithSymmetry(existingGame)){
									isNew = false;
									break;
								}
							}
							if(isNew) {
								newList.add(newGame);
							}					
						}
					}
				}

			}
		}

		// now adding the game outcomes
		for(int i=8; i>= 0; i--) {
			for(MenaceTicTacToeGame game: allGames.get(i)){
				if(game.getGameOutcome() == MenaceTicTacToeGame.NOT_SET) {
					for(int j=0;
						j < 9;
						j++) {
						if(game.valueAt(j) == CellValue.EMPTY) {
							MenaceTicTacToeGame newGame = new MenaceTicTacToeGame(game,j);
							//looking for the game reached by j is played
							for(MenaceTicTacToeGame existingGame: allGames.get(i+1)){
								if(newGame.equalsWithSymmetry(existingGame)){
									// reverse the outcome
									if(existingGame.getGameOutcome() == MenaceTicTacToeGame.WIN) {
										game.setMoveOutcome(j,MenaceTicTacToeGame.LOSE);
									} else if(existingGame.getGameOutcome() == MenaceTicTacToeGame.LOSE) {
										game.setMoveOutcome(j,MenaceTicTacToeGame.WIN);
									} else if(existingGame.getGameOutcome() == MenaceTicTacToeGame.DRAW) {
										game.setMoveOutcome(j,MenaceTicTacToeGame.DRAW);
									} else {
										System.out.println(existingGame);

										throw new IllegalStateException("This should not be happening");
									}
									break;
								}
							}						
						}
					}
				}

			}
		}

	}


	public  void play(TicTacToeGame game) {

		if(game.getLevel() == game.lines*game.columns){
			throw new IllegalArgumentException("Game is finished already!");
		}
	
		// find the menaceGame corresponding to the state of game
		for(MenaceTicTacToeGame perfectGame: allGames.get(game.getLevel())){
			if(perfectGame.equalsWithSymmetry(game)){
				game.play(perfectGame.choosePerfectMove());
				return;
			}
		}

		//Should never reach here
		throw new IllegalStateException("Game not found: " + game);

	}

}