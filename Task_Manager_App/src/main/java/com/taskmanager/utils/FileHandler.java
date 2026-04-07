package com.taskmanager.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_NAME = "tasks.txt";

    //  Save Tasks
    public static void saveTasks(List<String> tasks) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  Load Tasks
    public static List<String> loadTasks() {
        List<String> tasks = new ArrayList<>();

        File file = new File(FILE_NAME);
        if (!file.exists()) return tasks;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tasks;
    }
}