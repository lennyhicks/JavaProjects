package Calculator;

/**
 * Created by lennyhicks on 10/11/16.
 */
public class Calc extends Main{
    public void start(){
        debug("Please enter your equation");
        String eqation = opt.nextLine();
        doMath(eqation);
    }

}
