package toDoList;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by lennyhicks on 10/11/16.
 */





public class ToDo {
    String invalidSelection = "Please Enter a Valid Selection";
    Scanner input = new Scanner(System.in);
    JSONParser parser = new JSONParser();
    JSONObject json = new JSONObject();
    String filePath = "toDo.txt";
    JSONArray groceries = new JSONArray();
    JSONArray toDo = new JSONArray();
    JSONArray personal = new JSONArray();

    public static void main(String[] args){
        ToDo todo = new ToDo();
        todo.start();
    }

public void start() {
    firstLoad();
    debug("Welcome to your ToDoList9001");
    debug("1.) Show all list");
    debug("2.) Show a list");
    debug("3.) Add item to list");
    debug("4.) Remove from list");
    debug("5.) Help");
    debug("6.) Quit");
try {


    int choice = input.nextInt();
    switch (choice) {
        case 1:
            showAll();
            break;
        case 2:
            showList();
            break;
        case 3:
            addItem();
            break;
        case 4:
            removeItem();
            break;
        case 5:
            showHelp();
            break;
        case 6:
            debug("Have a good day");
            System.exit(50);
            break;
        default:
            debug(invalidSelection);
            main(null);
            break;
    }
}catch (Exception e){
    debug(invalidSelection);
    main(null);
}
}

    public void addItem(){
        debug("Which list would you like to add an item to?");
        debug("1.) ToDo List");
        debug("2.) Grocery List");
        debug("3.) Personal List");
        debug("4.) Main Menu");
        try {
            int choice = input.nextInt();
            input.nextLine();
            if (choice < 4) {
                debug("Enter the item you wish to add");
                String name = input.nextLine();
                debug("What is the priority of your item");
                debug("1.) High");
                debug("2.) Normal");
                debug("3.) Low");
                int pri = input.nextInt();
                input.nextLine();
                String prior = "";
                switch (pri) {
                    case 1:
                        prior = "HIGH";
                        break;
                    case 2:
                        prior = "NORMAL";
                        break;
                    case 3:
                        prior = "LOW";
                        break;
                    default:
                        debug(invalidSelection);
                }
                switch (choice) {
                    case 1:
                        addToArray(toDo, newObj(prior, name));
                        break;
                    case 2:
                        addToArray(groceries, newObj(prior, name));
                        break;
                    case 3:
                        addToArray(personal, newObj(prior, name));
                        break;
                    default:
                        main(null);
                        break;
                }
                debug("Item Successfully added");
                debug("Would you like to add another?");
                debug("1.) Yes");
                debug("2.) No");
                int choose = input.nextInt();
                switch (choose) {
                    case 1:
                        addItem();
                        break;
                    default:
                        main(null);
                }

            }
            main(null);
        }catch (Exception e){
            debug(invalidSelection);
            main(null);
        }

    }

    public void removeItem(){
        debug("Which list would you like to remove an item from?");
        debug("1.) ToDo List");
        debug("2.) Grocery List");
        debug("3.) Personal List");
        debug("4.) Main Menu");
        try {
            int choice = input.nextInt();
            JSONArray arr = new JSONArray();
            switch (choice) {
                case 1:
                    arr = toDo;
                    break;
                case 2:
                    arr = groceries;
                    break;
                case 3:
                    arr = personal;
                    break;
                case 4:
                    main(null);
                    break;
                default:
                    debug(invalidSelection);
                    main(null);
                    break;
            }
            if (choice < 4) {
                debug("Would you like to remove by Priority or Name");
                debug("1.) Priority");
                debug("2.) Name");
                int choose = input.nextInt();
                switch (choose) {
                    case 1:
                        removeByPriority(arr); break;
                    case 2:
                        removeByItem(arr); break;
                    default:
                        debug(invalidSelection);
                        removeItem();
                        break;
                }
            }
        }catch (Exception e) {

            debug(invalidSelection);
            main(null);
        }
    }

    public void showAll(){
        debug("---- Listing ToDo List ----");
        show(toDo);
        debug("---- Listing Grocery List ----");
        show(groceries);
        debug("---- Listing Personal List ----");
        show(personal);
        main(null);
    }

    public void showList(){
        JSONArray arr = new JSONArray();
        debug("Which list would you like to show?");
        debug("1.) ToDo List");
        debug("2.) Grocery List");
        debug("3.) Personal List");
        debug("4.) Main Menu");
        try {
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    arr = toDo;
                    break;
                case 2:
                    arr = groceries;
                    break;
                case 3:
                    arr = personal;
                    break;
                case 4:
                    main(null);
                    break;
                default:
                    debug("Please enter a valid selection");
                    main(null);
                    break;
            }
            debug("How would you like to show your list?");
            debug("1.) Show list by priority");
            debug("2.) Show entire list");
            debug("3.) Main Menu");
            int choose = input.nextInt();
            input.nextLine();
            switch (choose) {
                case 1:
                    listPriorities(arr);
                    main(null);
                    break;
                case 2:
                    show(arr);
                    main(null);
                    break;
                case 3:
                    main(null);
                    break;
                default:
                    debug("Please enter a valid selection");
                    main(null);
                    break;
            }
        }catch (Exception e){
            debug(invalidSelection);
            main(null);
        }

    }

    public void showHelp(){
        debug("Welcome to ToDoList9000!");
        debug("You can make any selection from the main menu");
        debug("Your list will be saved between visits to the program");
        debug("You have options to show entire list or show a list by priority");
        debug("Type anything and press [ENTER] to continue");
        String next = input.next();
         main(null);

    }

    public void debug(String msg){
        System.out.println(msg);
    }


    public JSONObject newObj(String priority, String item){

        JSONObject obj = new JSONObject();
        obj.put(priority,item);
        return obj;
    }

    public void addToArray(JSONArray arr, JSONObject obj){
        arr.add(0, obj);
        save();
    }

    public void listPriorities(JSONArray arr) {
        String priority = "";
        debug("Enter the Priority you would like to list");
        debug("1.) High");
        debug("2.) Normal");
        debug("3.) Low");
        debug("4.) Main Menu");
        try {
            int pri = input.nextInt();
            input.nextLine();

            switch (pri) {
                case 1:
                    priority = "HIGH";
                    break;
                case 2:
                    priority = "NORMAL";
                    break;
                case 3:
                    priority = "LOW";
                    break;
                default:
                    main(null);
                    break;
            }
            if (arr.size() > 0) {
                for (int i = 0; i < arr.size(); i++) {

                    try {
                        JSONObject json = (JSONObject) parser.parse("" + arr.get(i));
                        if (json.get(priority) != null) {
                            debug("[" + priority + "] " + json.get(priority));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
            }
        }catch (Exception e){
            debug(invalidSelection);
            main(null);
        }
    }

    public void removeByPriority(JSONArray arr) {
        String priority = "";
        debug("Enter the Priority you would like to remove");
        debug("1.) Low");
        debug("2.) Normal");
        debug("3.) High");
        debug("4.) Main Menu");
        try {
            int prio = input.nextInt();
            input.nextLine();

            switch (prio) {
                case 1:
                    priority = "LOW";
                    break;
                case 2:
                    priority = "NORMAL";
                    break;
                case 3:
                    priority = "HIGH";
                    break;
                default:
                    main(null);
                    break;
            }

            if (arr.size() > 0) {

                debug("Removing All " + priority + " priority items");
                for (int i = arr.size() - 1; i >= 0; i--) {

                    try {
                        JSONObject json = (JSONObject) parser.parse("" + arr.get(i));
                        if (json.get(priority) != null) {

                            arr.remove(arr.get(i));
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
                save();
            }
        }catch (Exception e){
            debug(invalidSelection);
            main(null);
        }
        main(null);
    }

    public void removeByItem(JSONArray arr) {

        debug("[WARNING] This will delete all items in the list containing this name");
        debug("Enter the item you wish to remove");
        String name = input.next();

        if (arr.size() > 0) {
            for (int i = arr.size()-1; i >= 0; i--) {

                try {
                    JSONObject json = (JSONObject) parser.parse("" + arr.get(i));
                    if (json.toJSONString().contains(name)) {
                            arr.remove(i);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
            save();
        }
        main(null);
    }

    public void firstLoad(){
            try {

                Object obj = parser.parse(new FileReader(filePath));
                JSONObject jsonObject = (JSONObject) obj;
                JSONObject maybe = (JSONObject) jsonObject.get("List");
                JSONArray GroceryList = (JSONArray) maybe.get("Groceries");

                for (int i = 0; i < GroceryList.size(); i++) {
                    groceries.add(GroceryList.get(i));
                }
                JSONArray ToDoList = (JSONArray) maybe.get("ToDo");
                for (int i = 0; i < ToDoList.size(); i++) {
                    toDo.add(ToDoList.get(i));
                }
                JSONArray Personal = (JSONArray) maybe.get("Personal");
                for (int i = 0; i < Personal.size(); i++) {
                    personal.add(Personal.get(i));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public void show(JSONArray arr){

        if (arr.size() > 0) {
            for (int i = arr.size()-1; i >= 0; i--) {

                try {
                    JSONObject json = (JSONObject) parser.parse("" + arr.get(i));
                    if (json.get("HIGH") != null) {
                        debug("[HIGH] "+json.get("HIGH"));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
            for (int i = arr.size()-1; i >= 0; i--) {

                try {
                    JSONObject json = (JSONObject) parser.parse("" + arr.get(i));
                    if (json.get("NORMAL") != null) {
                        debug("[NORMAL] "+json.get("NORMAL"));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
            for (int i = arr.size()-1; i >= 0; i--) {

                try {
                    JSONObject json = (JSONObject) parser.parse("" + arr.get(i));
                    if (json.get("LOW") != null) {
                        debug("[LOW] "+json.get("LOW"));
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }
        }

    }

    public void save(){

        JSONObject obj = new JSONObject();

        json.put("Groceries", groceries);
        json.put("ToDo", toDo);
        json.put("Personal", personal);

        obj.put("List", json);
        try {
            try (FileWriter file = new FileWriter(filePath)) {
                file.write(obj.toJSONString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}