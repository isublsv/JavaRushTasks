package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

/* 
Что внутри папки?
*/
public class Solution {

    static long totalFolders = 0;
    static long totalFiles = 0;
    static long totalSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String pathStr = conReader.readLine();
        conReader.close();

        Path pth = Paths.get(pathStr);

        if (!Files.isDirectory(pth)) {
            System.out.printf(pth.toAbsolutePath().toString() + " - не папка");
            return;
        }

        Files.walkFileTree(pth, new Visitior());

        System.out.println("Всего папок - " + (totalFolders-1));
        System.out.println("Всего файлов - " + totalFiles);
        System.out.println("Общий размер - " + totalSize);

    }

    private static class Visitior extends SimpleFileVisitor<Path> {
        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            totalFolders += 1;
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            totalFiles += 1;
            totalSize = totalSize + attrs.size();
            return CONTINUE;
        }
    }

   /* private static int dirCount = -1;
    private static int fileCount = 0;
    private static long total = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String pathStr = conReader.readLine();
        conReader.close();

        Path path = Paths.get(pathStr);
        if (!Files.isDirectory(path)) System.out.println(path.toString() + "- не папка");
        else {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (attrs.isRegularFile()) fileCount++;
                    total += attrs.size();
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    dirCount++;
                    return FileVisitResult.CONTINUE;
                }
            });
        }

        System.out.println("Всего папок - " + dirCount);
        System.out.println("Всего файлов - " + fileCount);
        System.out.println("Общий размер - " + total);
    }*/
}
