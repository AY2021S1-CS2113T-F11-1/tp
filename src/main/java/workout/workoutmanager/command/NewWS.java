package workout.workoutmanager.command;

import storage.WorkOutManagerStorage;
import workout.workoutsession.WorkoutSession;

public class NewWS implements Command{

    @Override
    public void execute(String[] args) {
        WorkoutSession ws = new WorkoutSession();
        ws.workoutSessionStart();
        WorkOutManagerStorage.add(ws);
    }
}
