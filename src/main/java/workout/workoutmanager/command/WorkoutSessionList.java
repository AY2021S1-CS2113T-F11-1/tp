package workout.workoutmanager.command;

import storage.WorkOutManagerStorage;

public class WorkoutSessionList implements Command{
    @Override
    public void execute(String[] args) {
        WorkOutManagerStorage.list(args);
    }
}
