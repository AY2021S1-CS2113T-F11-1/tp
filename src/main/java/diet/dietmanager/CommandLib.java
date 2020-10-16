package diet.dietmanager;

import diet.dietmanager.command.Command;
import diet.dietmanager.command.DietSessionCreate;
import diet.dietmanager.command.DietSessionDelete;
import diet.dietmanager.command.DietSessionList;
import diet.dietmanager.command.DietSessionLoad;
import diet.dietmanager.command.DietSessionWrong;

import java.util.Hashtable;

public class CommandLib {

    public Hashtable<String, Command> library;

    public CommandLib() {
        library = new Hashtable<>();
    }

    public void initDietManagerCL() {
        this.library.put("list", new DietSessionList());
        this.library.put("meal", new DietSessionCreate());
        this.library.put("load", new DietSessionLoad());
        this.library.put("delete", new DietSessionDelete());
    }

    public Command get(String keyword) {
        if (library.containsKey(keyword)) {
            return library.get(keyword);
        } else {
            return new DietSessionWrong();
        }
    }
}
