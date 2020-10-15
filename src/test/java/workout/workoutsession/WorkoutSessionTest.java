package workout.workoutsession;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorkoutSessionTest {

    @Test
    void workoutSessionStart() {
            WorkoutSession ws = new WorkoutSession();
            ws.workoutSessionStart();
    }
}