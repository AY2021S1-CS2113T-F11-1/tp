package workout.workoutsession;

import workout.workoutsession.exercise.Exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class WorkoutSession {
    private boolean endWorkoutSession = false;
    private final ArrayList<Exercise> exercise;

    private WorkoutSession() {

        this.exercise = new ArrayList<>();
    }

    private void setEndWorkoutSessionF() {

        this.endWorkoutSession = false;
    }

    private void setEndWorkoutSessionT() {

        this.endWorkoutSession = true;
    }

    public void workoutSessionStart() {

        setEndWorkoutSessionF();

        while (!endWorkoutSession) {
            workoutSessionProcessCommand();
        }
    }

    private void workoutSessionProcessCommand() {

        Scanner in = new Scanner(System.in);
        String[] input = WorkoutSessionParser.workoutSessionParser(in.nextLine().trim());

        switch (input[0].toLowerCase()) {

        case "add":
            exercise.add(WorkoutSessionParser.addParser(input));
            break;
        case "list":
            printList();
            break;
        case "delete":
            exercise.remove(WorkoutSessionParser.deleteParser(input));
            break;
        case "bye":
            setEndWorkoutSessionT();
            break;
        default:

        }
    }

    private void printList() {

        for (int i = 0; i < exercise.size(); i++) {
            System.out.println((i + 1) + ": " + exercise.get(i).toString());
        }
    }

}
