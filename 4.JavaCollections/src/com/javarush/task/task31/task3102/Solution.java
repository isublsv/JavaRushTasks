package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.*;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File rootDir = new File(root);
        ArrayList<String> list = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();

        Collections.addAll(fileTree, rootDir.listFiles());

        while (!fileTree.isEmpty())
        {
            File currentFile = fileTree.remove();
            if(currentFile.isDirectory()){
                Collections.addAll(fileTree, currentFile.listFiles());
            } else {
                list.add(currentFile.getAbsolutePath());
            }
        }
        return list;

/*        Queue<File> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();
        File file = new File(root);
        queue.add(file);
        while (!queue.isEmpty()) {
            for (File currentFile : file.listFiles()) {
                if (currentFile.isDirectory()) {
                    queue.add(currentFile);
                } else result.add(currentFile.getAbsolutePath());
            }
            file = queue.poll();
        }
        return result;*/
    }

    public static void main(String[] args) throws IOException {
        getFileTree("D:\\Other\\").forEach(System.out::println);
    }
}
