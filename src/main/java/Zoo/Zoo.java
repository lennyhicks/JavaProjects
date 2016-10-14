package Zoo;


import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by lennyhicks on 10/13/16.
 */
public class Zoo extends MainMenu {
    Scanner input = new Scanner(System.in);
    String name;

    static ArrayList<Visistor> visistor = new ArrayList<>();
    static ArrayList<Employee> employee = new ArrayList<>();
    static ArrayList<Animal> animal = new ArrayList<>();
    public Zoo(String name){
        this.name = name;
    }




}
