package Calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Created by lennyhicks on 10/11/16.
 */
public class Groceries extends Main {

    public void start(){
        debug("Please input the name of your grocery item");
        String nam = opt.nextLine();
        debug("Please input the price of your grocery.");
        try {
            pri = opt.nextDouble();

        save(new String[] {nam, ": "+pri}, "groceries");
        getFull();
        main(null);
        } catch (InputMismatchException e){
            debug("Please enter a valid price.");
            start();
        }
    }

    public void getFull(){
    String csvFile = "groceries.txt";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ":";
        Double fullPrice = 0.0;
        try {
        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {
            String[] item = line.split(cvsSplitBy);
            fullPrice += Double.parseDouble(item[1]);
        }
            debug("Subtotal: "+df.format(fullPrice)+" - Total with taxes: "+df.format(fullPrice*1.06));
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
}
