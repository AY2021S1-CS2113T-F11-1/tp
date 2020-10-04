package storage;

import workout.workoutsession.WorkoutSession;

import java.util.ArrayList;
import java.util.List;

public class WorkOutManagerStorage {
    private static List<WorkoutSession> pastRecords;

    public static void init() {
        pastRecords = new ArrayList<>();
    }

    public static void list(String args[]) {
        int index = 0;
        if(args == null) {
            for(WorkoutSession ws : pastRecords) {
                System.out.print(index + " ");
                System.out.println(ws);
            }
        }
    }

    public static void add(WorkoutSession newSession) {
        pastRecords.add(newSession);
    }
}
