public class ComputerRandomPlayer implements Player {

	boolean valid;
	int ranNumber;

	public void play(TicTacToeGame game){
		/* checks if its playable
		chooses a random input
		if valid plays and returns

		for 1<= number <= lines*columns:
		number = 1 + generator.nextInt(lines*columns);
		*/

		// idk if this works because idk if im calling the variables correctly

		ranNumber = Utils.generator.nextInt(game.lines*game.columns);

		while (game.valueAt(ranNumber) != CellValue.EMPTY) {
           	ranNumber = Utils.generator.nextInt(game.lines*game.columns);
		}
		
		game.play(ranNumber);


	}
}
