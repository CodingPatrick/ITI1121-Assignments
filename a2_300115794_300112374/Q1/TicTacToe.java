public class TicTacToe{

   /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If two parameters line  and column
     * are passed, they are used. 
     * Otherwise, a default value is used. Defaults values are also
     * used if the paramters are too small (less than 2).
     * 
     * @param args
     *            command line parameters
     */

    public static void main(String[] args) {

        StudentInfo.display();

        TicTacToeGame game;
        int lines = 3;
        int columns = 3;
        int win = 3;

   
        try{
            if (args.length >= 2) {
                lines = Integer.parseInt(args[0]);
                if(lines<2){
                    System.out.println("Invalid argument, using default...");
                    lines = 3;
                }
                columns = Integer.parseInt(args[1]);
                if(columns<2){
                    System.out.println("Invalid argument, using default...");
                    columns = 3;
                }
            }
            if (args.length >= 3){
                win = Integer.parseInt(args[2]);
                if(win<2){
                    System.out.println("Invalid argument, using default...");
                    win = 3;
                }
            } 
            if (args.length > 3){
                System.out.println("Too many arguments. Only the first 3 are used.");
            } 

        } catch(NumberFormatException e){
            System.out.println("Invalid argument, using default...");
            lines   = 3;
            columns  = 3;
            win = 3;
        }
        
        Player[] players;

        int genLevel = 0;
        boolean keepPlaying = true;
        int playerTurn=0;

        players = new Player[2];

        players[0] = new HumanPlayer();
        players[1] = new ComputerRandomPlayer();

        
        while (keepPlaying){
            game = new TicTacToeGame(lines, columns,win);
            
            while (game.getGameState() == GameState.PLAYING){ 
                if (genLevel == 0){     
                    playerTurn = Utils.generator.nextInt(2); // either 0 or 1
                }
                else {
                    if (genLevel == 1 && playerTurn == 1){
                        playerTurn = 0;
                        genLevel++;
                    } // this is to prevent an error when the bot is picked to play first
                    else{
                        playerTurn = genLevel % 2;
                    }
                }
                System.out.println("Player " + (playerTurn +1) + " turn."); 
                if (players[playerTurn] instanceof ComputerRandomPlayer){  // checks if its a bot (doesnt print the boarf when its the bot)
                    players[playerTurn].play(game);
                    genLevel++;
                }
                else{
                    System.out.println(game); 
                    System.out.print(game.nextCellValue() + " to play: "); 
                    players[playerTurn].play(game);
                    genLevel++;
                }
            }
            System.out.println(game);
            System.out.print("Play again (Y)?: "); 
            String answer = Utils.console.readLine();
            if (!(answer.equals("y") || answer.equals("Y"))) { // if the answer is not yes, changes keep playing to false and ends loop
              keepPlaying = false;
            }
        }
    }
}
 
