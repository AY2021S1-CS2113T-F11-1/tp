package workout.workoutmanager;

import workout.workoutmanager.command.NewWS;
import workout.workoutmanager.command.Command;
import workout.workoutmanager.command.WorkoutSessionList;

import java.util.Hashtable;

public class CommandLib {

    public Hashtable<String, Command> library;

    public CommandLib() {
        library = new Hashtable<>();
    }

    public void initWorkoutManagerCL() {
        this.library.put("list", new WorkoutSessionList());
        this.library.put("new", new NewWS());
    }

    public Command get(String keyword) {
        return library.get(keyword);
    }
}
