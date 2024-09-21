package com.supplyboost.Exercises.StreamsFilesAndDirectories;

import java.io.File;

public class _8_FolderSize {

    public static String folder ="F:\\Documents\\SoftUni\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04-Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";

    public static void main(String[] args) {
        File file = new File(folder);

        System.out.println("Folder size: " + getFolderSize(file));
    }

    public static long getFolderSize(File folder) {
        long length = 0;

        File[] files = folder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    length += file.length();
                } else {
                    length += getFolderSize(file);
                }
            }
        }
        return length;
    }
}
