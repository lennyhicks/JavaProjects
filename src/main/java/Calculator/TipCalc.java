package Calculator;

import java.util.InputMismatchException;

/**
 * Created by lennyhicks on 10/11/16.
 */
public class TipCalc extends Main {

    public void start()
    {
        String[] opts = {"Excellent - 25% Tip", "Great - 20% Tip", "Good - 15% Tip", "Bad - 10% Tip", "Terrible - 5% Tip"};
        debug("What was your total Bill amount");
        try
        {
        double billAmount = opt.nextDouble();
        debug("How good was your service?");
        for(int i = 0; i < opts.length; i++){
            debug(i+1+".) "+opts[i]);
        }
        debug(opts.length+1+".) Main Menu");

            int satis = opt.nextInt();
            Double satisfac = getSatisfaction(satis);
            debug("Enter additional comments");
            String com = opt.nextLine();
            Double tipAmount = billAmount * satisfac;
            save(new String[]{"Tip Amount: " + df.format(tipAmount), "Comments: " + com}, "tips");
            debug("Tip Amount: " + df.format(tipAmount) + " Comments: " + com);
            main(null);
        }catch (InputMismatchException e){
            debug("Please input a valid selection");
            main(null);
        }
    }

    public Double getSatisfaction(int satis){
        switch (satis){
            case 1: return .25;
            case 2: return .20;
            case 3: return .15;
            case 4: return .10;
            case 5: return .05;
            default: main(null); return null;
        }
    }
}
