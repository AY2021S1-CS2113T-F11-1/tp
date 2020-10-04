package workout.workoutmanager;

import storage.WorkOutManagerStorage;
import workout.workoutmanager.command.Command;

import java.util.Arrays;
import java.util.Scanner;

public class WorkoutManager {

    private final CommandLib cl;

    public WorkoutManager() {
        WorkOutManagerStorage.init();
        cl = new CommandLib();
        cl.initWorkoutManagerCL();
    }

    public void start() {
        WorkoutManagerUI.printOpening();
        Scanner sc = new Scanner(System.in);
        while(true) {
            String command = sc.nextLine();
            String[] commParts = WorkoutManagerParser.parse(command);

            try {
                processCommand(commParts);
            } catch (ExitException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        WorkoutManagerUI.printBye();
    }

    public void processCommand(String[] commands) throws ExitException {
        Command command = cl.get(commands[0]);
        command.execute(Arrays.copyOfRange(commands, 1, commands.length));
    }
}
