package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Collections;

import java.util.List;


import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.TRUNCATE_EXISTING;

public class Main {
    public static void main(String[] args) {

        Path pathIn = Paths.get("input1.txt");
        Path pathOut = Paths.get("output.txt");

        List<String> read;
        try {
            read = Files.readAllLines(pathIn);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<String> result = new ArrayList<>();
        if (!read.isEmpty()) {
            String[] dcSolution = read.get(0).split(" ");

            int countDc = Integer.parseInt(dcSolution[0]);
            int countServers = Integer.parseInt(dcSolution[1]);

            int[][] dc = new int[countDc][countServers];

            int[] countOfReboot = new int[countDc];
            int[] countOfDisables = new int[countDc];

            List<String> actions = read.subList(1, read.size());
            actions.forEach(a -> {

                String[] act = a.split(" ");

                switch (act[0]) {
                    case "DISABLE" -> {
                        int numDc = Integer.parseInt(act[1]) - 1;
                        int numServer = Integer.parseInt(act[2]) - 1;
                        if (dc[numDc][numServer] == 0) {
                            countOfDisables[numDc]++;
                        }
                        dc[numDc][numServer]++;


                    }//добавить выключенный сервер
                    case "RESET" -> {
                        int numDc = Integer.parseInt(act[1]) - 1;
                        for (int i :
                                dc[numDc]) {
                            dc[numDc][i] = 0;
                        }
                        countOfReboot[numDc]++;
                        countOfDisables[numDc] = 0;
                    } //перезапустить датацентр
                    case "GETMAX" -> {

                        List<Integer> countsRes = new ArrayList<>();
                        for (int i = 0; i < countDc; i++) {
                            countsRes.add(countOfReboot[i] * (countServers - countOfDisables[i]));

                        }
                        if (!countsRes.isEmpty()) {
                            int maxValue = Collections.max(countsRes);
                            for (int i = 0; i < countDc; i++) {
                                if (countsRes.get(i) == maxValue) {
                                    result.add(String.valueOf(i + 1));
                                    break;
                                }
                            }
                        }
                    }//посчитать максимальные
                    case "GETMIN" -> {
                        List<Integer> countsRes = new ArrayList<>();
                        for (int i = 0; i < countDc; i++) {
                            countsRes.add(countOfReboot[i] * (countServers - countOfDisables[i]));

                        }
                        if (!countsRes.isEmpty()) {
                            int minValue = Collections.min(countsRes);
                            for (int i = 0; i < countDc; i++) {
                                if (countsRes.get(i) == minValue) {
                                    result.add(String.valueOf(i + 1));
                                    break;
                                }
                            }
                        }
                    } //посчитать минимальные
                }
            });

            try {
                Files.write(pathOut, result, CREATE, TRUNCATE_EXISTING); //вывод ответа
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }

}