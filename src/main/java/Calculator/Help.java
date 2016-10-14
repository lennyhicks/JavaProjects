package Calculator;

/**
 * Created by lennyhicks on 10/11/16.
 */
public class Help extends Main{
    public void start(){
        debug("Welcome to CalOver9000. Made by: Lenny Hicks");
        debug("Do some Math calculations in the Calculator menu");
        debug("Calculate a tip in our Tip Menu");
        debug("View your history in our History menu.");
        debug("Type anything and hit ENTER to return to main menu.");
        String choice = opt.next();
        if(choice != null){
            main(null);
        }
    }
}
