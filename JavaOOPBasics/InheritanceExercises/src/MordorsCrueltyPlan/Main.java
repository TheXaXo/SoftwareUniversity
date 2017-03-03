package MordorsCrueltyPlan;

import MordorsCrueltyPlan.kindsOfFood.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] foodEaten = Arrays.stream(reader.readLine().split(" "))
                .map(food -> food.trim())
                .toArray(String[]::new);

        Gandalf gandalf = new Gandalf();

        for (String foodName : foodEaten) {
            switch (foodName.toLowerCase()) {
                case "apple":
                    Apple apple = new Apple();
                    gandalf.feed(apple);
                    break;

                case "cram":
                    Cram cram = new Cram();
                    gandalf.feed(cram);
                    break;

                case "honeycake":
                    HoneyCake honeyCake = new HoneyCake();
                    gandalf.feed(honeyCake);
                    break;

                case "lembas":
                    Lembas lembas = new Lembas();
                    gandalf.feed(lembas);
                    break;

                case "melon":
                    Melon melon = new Melon();
                    gandalf.feed(melon);
                    break;

                case "mushrooms":
                    Mushrooms mushrooms = new Mushrooms();
                    gandalf.feed(mushrooms);
                    break;

                default:
                    UnknownFood unknownFood = new UnknownFood();
                    gandalf.feed(unknownFood);
                    break;
            }
        }

        System.out.println(gandalf.calculatePointsOfHappiness());
        System.out.println(gandalf.getMood());
    }
}