package storage.diet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import diet.dietsession.DietSession;
import diet.dietsession.Food;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class holds the data loaded during runtime and read and writes to the local storage.
 */
public class Storage {

    private static final String FILEPATH = "saves/diet/";
    private static Gson gson;
    private static File file = null;
    private static Logger logger = Logger.getLogger("java.storage.diet");


    /**
     * Initialise the database with locally stored data.
     * If the local file is not found. It creates the relevant file and folder.
     * @throws IOException If director or file cannot be created.
     */
    public void init(String filePath) throws IOException {
        logger.log(Level.INFO, "creating diet session save file");

        gson = new GsonBuilder().setPrettyPrinting()
                .create();

        //creates the file
        String fileName = "saves/diet/" + filePath + ".json";
        file = new File(fileName);
        file.getParentFile().mkdirs();
        file.createNewFile();
    }

    /**
     * Write the content in TaskList to a local file.
     *
     * @throws IOException If director or file cannot be created.
     */
    public void writeToStorage(String filePath, ArrayList<Food> taskList) throws IOException {
        logger.log(Level.INFO, "saving file to location");
        File file = new File(filePath);
        FileWriter writer = new FileWriter(file.getPath());
        gson.toJson(taskList, writer);
        logger.log(Level.INFO, "file saving complete");
        writer.flush();
        writer.close();
    }

    /**
     * Write the content in dietSession to a local file.
     * If the local file is not found. It creates the relevant file and folder.
     * @throws IOException If director or file cannot be created.
     */
    public void writeToStorageDietSession(String filePath, DietSession dietSession) throws IOException {
        logger.log(Level.INFO, "saving file to location");
        File file = new File(FILEPATH + filePath + ".json");
        FileWriter writer = new FileWriter(file.getPath());
        gson.toJson(dietSession, writer);
        logger.log(Level.INFO, "file saving complete");
        writer.flush();
        writer.close();
    }

    public void readFileContents(String filePath, ArrayList<Food> taskList) throws FileNotFoundException {
        File file = new File(filePath);

        Type taskListType = new TypeToken<ArrayList<Food>>(){}.getType();

        JsonReader reader = new JsonReader(new FileReader(file.getPath()));
        taskList.clear();
        taskList.addAll(gson.fromJson(reader, taskListType));
    }

        public DietSession readDietSession (String filePath) throws FileNotFoundException {
            Gson gson = new Gson();
            File file = new File(System.getProperty("user.dir") + "/"
                    + FILEPATH + filePath);
            DietSession dietSession;

            Reader reader = new FileReader(file.getPath());
            dietSession = gson.fromJson(reader, DietSession.class);
            return dietSession;
        }
    }
