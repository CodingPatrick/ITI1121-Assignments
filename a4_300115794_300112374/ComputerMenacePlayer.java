import java.util.LinkedList;


public class ComputerMenacePlayer extends Player {

	private LinkedList<LinkedList<MenaceTicTacToeGame>> allGames;

	// generates all possible games 
	public ComputerMenacePlayer(){
		super();

		allGames = new LinkedList<LinkedList<MenaceTicTacToeGame>>();

		allGames.add(new LinkedList<MenaceTicTacToeGame>());
		allGames.get(0).add(new MenaceTicTacToeGame());

		for(int i=1; i<=9; i++){
			LinkedList<MenaceTicTacToeGame> newList;
			newList = new LinkedList<MenaceTicTacToeGame>();
			allGames.add(newList);
			for (MenaceTicTacToeGame game: allGames.get(i-1)){
				if (game.getGameState() == GameState.PLAYING){
					for (int j=0; j < 9; j++){
						if(game.valueAt(j) == CellValue.EMPTY){
							MenaceTicTacToeGame newGame = new MenaceTicTacToeGame(game, j);
							boolean isNew = true;
							for(MenaceTicTacToeGame existingGame; allGames.get(i)){
								if (newGame.equalsWithSymmetry(existingGame)){
									isNew = false;
									break
								}
							}
							if (isNew){
								newList.add(newGame);
							}
						}
					}
				}
			}
		}

		/*
		I have no idea what this is doing...
		*/
		for(int i=8; i>= 0; i--) {
			for(PerfectTicTacToeGame game: allGames.get(i)){
				if(game.getGameOutcome() == PerfectTicTacToeGame.NOT_SET) {
					for(int j=0;
						j < 9;
						j++) {
						if(game.valueAt(j) == CellValue.EMPTY) {
							PerfectTicTacToeGame newGame = new PerfectTicTacToeGame(game,j);
							//looking for the game reached by j is played
							for(PerfectTicTacToeGame existingGame: allGames.get(i+1)){
								if(newGame.equalsWithSymmetry(existingGame)){
									// reverse the outcome
									if(existingGame.getGameOutcome() == PerfectTicTacToeGame.WIN) {
										game.setMoveOutcome(j,PerfectTicTacToeGame.LOSE);
									} else if(existingGame.getGameOutcome() == PerfectTicTacToeGame.LOSE) {
										game.setMoveOutcome(j,PerfectTicTacToeGame.WIN);
									} else if(existingGame.getGameOutcome() == PerfectTicTacToeGame.DRAW) {
										game.setMoveOutcome(j,PerfectTicTacToeGame.DRAW);
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

	// making the game play
	public void play(TicTacToeGame game){
		if (game.getLevel() == game.lines*game.columns){
			throw new IllegalArgumentException("game is already done");
		}

		for (MenaceTicTacToeGame menaceGame: allGames.get(game.getLevel())){
			if(menaceGame.equalsWithSymmetry(game)){
				game.play(menaceGame.chooseMove());
				return;
			}
		}
		throw new IllegalStateException("game not found: " + game);
	}
}
