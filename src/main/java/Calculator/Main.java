package Calculator;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by lennyhicks on 10/11/16.
 */
public class Main {

    DecimalFormat df = new DecimalFormat("0.00");
    Scanner opt = new Scanner(System.in);
    Double full = 0.0;
    Double pri = 0.0;

    public static void main(String[] args){
        Main m = new Main();

        m.start();
    }
    public void debug(String msg){
        System.out.println(msg);
    }
    public void start(){
        debug("What would you like to do today?");
        debug("1.) Calculate");
        debug("2.) Calculate Tip");
        debug("3.) Groceries");
        debug("4.) See past calculations");
        debug("5.) Help");
        debug("6.) Quit");
        try {
            int choice = opt.nextInt();
            goTo(choice);
        }catch (InputMismatchException eeeeeeeeeeeeeee){
            debug("Please enter a valid Selection");
            main(null);
        }
    }
    public void goTo(int choice){

        Calc c = new Calc();
        TipCalc t = new TipCalc();
        Groceries g = new Groceries();
        History h = new History();
        Help he = new Help();
        switch (choice){

            case 1: c.start(); break;
            case 2: t.start(); break;
            case 3: g.start(); break;
            case 4: h.start(); break;
            case 5: he.start(); break;
            case 6: quit(); break;
            default: main(null); break;
        }
    }

    public void quit(){
        debug("Have a good Day");
        System.exit(1);
    }
    public void save(String args[], String name){

        String concat ="";
        FileWriter save = null;
        try {
            save = new FileWriter(name+".txt", true);
            for (int i = 0; i < args.length; i++){
                concat += args[i] + " ";
            }
            save.write(concat+"\n");
            save.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Double fullPrice;
public Double addPrice(Double pri){

    fullPrice += pri;
    return fullPrice;
}
    public void doMath(String equal) {
            ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByName("JavaScript");
            try {
                int answer = (int) engine.eval(equal);
                String fullEquation = ("Your answer: " + equal + " = " + answer);
                debug(fullEquation);
                save(new String[]{fullEquation}, "calc");
                Main.main(null);

            } catch (Exception ex) {
                debug("Please enter a valid input");
                Main.main(null);
            }
        }
    }

