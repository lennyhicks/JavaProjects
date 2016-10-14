package Calculator;

import java.io.*;
import java.nio.charset.Charset;
import java.util.InputMismatchException;

/**
 * Created by lennyhicks on 10/11/16.
 */
public class History extends Main {
    public void start(){
        debug("Which history would you like to see?");
        debug("1.) Calculator");
        debug("2.) Tips");
        debug("3.) Groceries");
        debug("4.) Clear History");
        debug("5.) Main Menu");
        try {
            int choice = opt.nextInt();
            opt.nextLine();
            getChoice(choice);
        }catch (InputMismatchException e) {
            debug("Please enter a valid Selection");
            start();
        }


    }
    public void getChoice(int choice){
        switch (choice){
            case 1: showHist("calc"); break;
            case 2: showHist("tips"); break;
            case 3: showHist("groceries"); break;
            case 4: clearHistory(); break;
            default: main(null); break;
        }
    }

    public void showHist(String name) {
        String fileName = name+".txt";
        debug("Searching for "+name+ " History");
        String line;

        try {
            InputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);

            while ((line = br.readLine()) != null) {
                debug(line);
            }

            main(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void clearHistory(){
        String[] names = {"calc", "groceries", "tips"};
        for (int i = 0; i < names.length; i++) {
            try {
                FileWriter erase = new FileWriter(names[i]+".txt");
                erase.flush();
                erase.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        debug("History Cleared");
        main(null);
    }
}
