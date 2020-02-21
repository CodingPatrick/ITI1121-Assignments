public class HumanPlayer implements Player {

	int position;

	public void play(TicTacToeGame game){
		/* checks if its playable
		if it is then asks for a valid input (code from a1
		when correct input provided, plays in on the game
		
		scanner for an int
		conditions for it to be between 0 and lines*columns
		check if position is valid
		if it is then just contiue
		*/

		String answer = Utils.console.readLine();
		position = Integer.parseInt(answer)-1;
         
   		while (position < 0 || position >= (game.lines*game.columns)||game.valueAt(position) != CellValue.EMPTY){
   			System.out.println("Index isn't acceptable, enter another one: ");
   			answer = Utils.console.readLine();
			position = Integer.parseInt(answer)-1;
   		}
		game.play(position);
	}
}
