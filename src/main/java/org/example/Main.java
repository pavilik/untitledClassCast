package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
     /*   Пример:

        records -> {
            "Andrew:something i can talk",
                    "Ben:me too",
                    "Andrew:more and more"
            "Sam: I can talk endlessly so I will speak more and more",
                    null
        } -> Sam, Andrew

        /* Требуется реализовать метод позволяющий найти автора(ов) с наибольшим количеством сказанных слов:
         * список авторов : реплики ; число на вывод
         */
        List<String> records = Arrays.asList(
                "Andrew:something i can talk",
                "Ben:me too",
                "Andrew:more and more",
                "Sam: I can talk endlessly so I will speak more and more"
                );
        List<String> autors = findTheMostTalkingAuthors(records, 2);
        System.out.println(autors);

    }
    public static List<String> findTheMostTalkingAuthors(List<String> records, Integer numToView) {
        Map<String,Integer> map = new HashMap<>();
        for(String str : records) {

            String [] autorText = str.split(":");
            Integer countReplic = autorText[1].split(" ").length;
            if (map.containsKey(autorText[0])) {
                map.put(autorText[0], map.get(autorText[0])+countReplic);
            }
            else {
                map.put(autorText[0], countReplic);
            }

        }

return map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
        .map(Map.Entry::getKey)
        .limit(numToView)
        .toList();
    }
}
