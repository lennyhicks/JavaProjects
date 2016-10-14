package Zoo;

import java.util.Scanner;

/**
 * Created by lennyhicks on 10/13/16.
 *
 * Can view exibits and animals inf/ preregistrator give discount if done/ get a lot of information/
 * Emp can add remove animals/visitors view,
 * visitor count
 *
 * Animals . exibit species. area 51.
 */
public class MainMenu extends Main{



    public void start() {
        Employee emp = new Employee("Fred", 1, "No", 1, "no");
        Visistor vis = new Visistor(null, 0, null);
        Fish fish = new Fish(null, null);
        Gorilla gor = new Gorilla(null, null);
        Tiger tig = new Tiger(null, null);
        Animal ani = new Animal(null, null);
        Scanner input = new Scanner(System.in);


        debug("Welcome to Zoo Kiosk 9001");
        debug("1.) List Animals");
        debug("2.) Add Gorrila");
        debug("3.) Add Fish");
        debug("4.) Add Tiger");
        debug("5.) List Employees");
        debug("6.) Add Employee");
        debug("7.) List Visitors");
        debug("8.) Add Visitors");
        debug("9.) Quit");
        try {
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    ani.listAnimals();
                    start();
                    break;
                case 2:
                    gor.addGorilla();
                    start();
                    break;
                case 3:
                    fish.addFish();
                    start();
                    break;
                case 4:
                    tig.addTiger();
                    start();
                    break;
                case 5:
                    emp.listEmployee();
                    start();
                    break;
                case 6:
                    emp.addEmployee();
                    start();
                    break;
                case 7:
                    vis.listVisitor();
                    start();
                    break;
                case 8:
                    vis.addVisitor();
                    start();
                    break;
                case 9:
                    System.exit(1); break;
                default: start();

            }
        }catch (Exception e){
            debug("Errors");
            start();
        }
    }
}
