public class MenaceTicTacToeGame extends TicTacToeGame {
	
	// YOUR CODE HERE

	public static final int NOT_SET = 0;
	public static final int WIN  = 1;
	public static final int LOSE = 2;
	public static final int DRAW = 3;
	private int[] outcomes;
	private int gameOutcome;

	// constructor for MenaceTicTacToeGame
	public MenaceTicTacToeGame(){
		super(3,3,3);
		outcomes = new int[9];
		gameOutcome = NOT_SET;
		// there should be a way to initialize all the bead numbers with linkedlist
	}

	// constructor for MenaceTicTacToeGame
	public MenaceTicTacToeGame(MenaceTicTacToeGame base, int next){
		super(base,next);
		outcomes = new int[9];
		gameOutcome = NOT_SET;
		// there should be a way to initialize all the bead numbers with linkedlist
	}

	// this function keeps track of the outcome of a specific move
	public void setMoveOutcome(int move, int outcome){
		if(move < 0 || move >= outcomes.length || 
		outcome < WIN || outcome > DRAW || outcomes[move] != 0 ) {
			throw new IllegalArgumentException();
		}
		outcomes[move] = outcome;
		if(outcome == WIN) {
			gameOutcome = WIN; 
		} else if (outcome == DRAW && gameOutcome != WIN ) {
			gameOutcome = DRAW; 
		} else if (outcome == LOSE && gameOutcome == NOT_SET) {
			gameOutcome = LOSE;
		}
	}

	/* this function should be changed to check if menace has won lost or tied
	it will then return a number
	so change it to be if getGameState() == GameState.OWIN then its a loss because Menace will always be X
	and then draw is GameState.DRAW and lose is GameState.OWIN
	*/
	public int getGameOutcome() {
		if(getGameState() == GameState.XWIN || getGameState() == GameState.OWIN ){
			// from the viewpoint of a player who would have to play next, a
			// game that has just been won is losing
			return LOSE; 
		} else if(getGameState() == GameState.DRAW ){
			return DRAW;
		} else {
			return gameOutcome;
		}
	}

	/*
	this function is completly wrong, firstly it should be changed to chooseMove instead of PerfectMove
	to work, you have to work with the beads. So it chooses a random move from the beads (probablity impacts it)
	*/
	public int choosePerfectMove(){
		if(getGameState() != GameState.PLAYING){
			throw new IllegalStateException("Game already finished");
		}
		int choices = 0;
		for(int i : outcomes) {
			if(i == gameOutcome)
				choices++;
		}


		int randomChoice = Utils.generator.nextInt(choices);
		int currentSelection = 0;
		boolean search = true;
		while(search) {
			if(outcomes[transformedBoard[currentSelection]] == gameOutcome){
				if(randomChoice == 0) {
					search = false;
				} else {
					randomChoice--;
					currentSelection++;
				}
			} else {
				currentSelection++;
			}
		}
		return currentSelection;
	}

}
