package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File csvFile = new File("src/main/resources/Задача ВС Java Сбер.csv");

        Scanner in = new Scanner(csvFile);
        in.useDelimiter("\n");
        List<City> cities = new ArrayList<>();

        while (in.hasNext()) {
            String[] splitedNext = in.next().split(";");
            cities.add(
                    new City(
                            splitedNext[1],
                            splitedNext[2],
                            splitedNext[3],
                            Integer.parseInt(splitedNext[4]),
                            splitedNext[5].trim()
                    )
            );
        }

        City maxpopulCity = cities.stream().max(Comparator.comparing(city -> city.population)).orElseThrow();
        System.out.println(
                "[" + cities.indexOf(maxpopulCity) + "]" + " = "
                        + String.format("%,d", maxpopulCity.population) + "\n");


        cities.sort(
                Comparator.comparing(city -> city.name.toLowerCase())
        );

        List<City> sortedCityByDistAndCity = cities.stream()
                .sorted(
                        Comparator.comparing(City::getDistrict)
                                .thenComparing(City::getName)

                )
                .toList();

        System.out.println(cities);
        System.out.println(sortedCityByDistAndCity);


    }

    public static class City {
        private final String name;// наименование города
        private final String region; // регион
        private final String district; // федеральный округ
        private final int population; // количество жителей города
        private final String foundation; // дата основания или первое упоминан

        public City(String name, String region, String district, int population, String foundation) {
            this.name = name;
            this.region = region;
            this.district = district;
            this.population = population;
            this.foundation = foundation;
        }


        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    ", region='" + region + '\'' +
                    ", district='" + district + '\'' +
                    ", population=" + population +
                    ", foundation='" + foundation + '\'' +
                    '}' + "\n\n";
        }

        public String getName() {
            return name;
        }

        public String getDistrict() {
            return district;
        }
    }
}
