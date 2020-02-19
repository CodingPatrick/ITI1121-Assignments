

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
        
        // YOUR CODE HERE
        /*
        big while loop (while game.GetameState == GameState.PLAYING)
        idk how to use the list of players atm
          my guess is to have human as 0 and bot as 1 and then alternate between the two when finding turns
          but im not rlly sure how to do that rn
        to see who starts, if (level == 0){
        random number = generator.nextInt(2); ==> so either 0 or 1 for the list
        then you know whos turn it is to play
        if its robot, just call the computer and thats it
        otherwise call human player then print when its succesful
        when theres a winner, scanner for y to play again
        if not a y then break
        if it is a y then reitiniate game and everything execept for level
            for this im thinking putting an even bigger loop on top of the hwile
            so ex while keepPlaying and we initiate keepPlaying as true
            initiate a variable for genLevel=0 before the loops
            so that if they wanna keep playing, before restarting the bigger loop, assign genLevel += level
            after initializing game again, do level += genLevel

        }
        */

    }

}
