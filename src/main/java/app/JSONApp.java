package app;

import domain.*;
import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {

    private static void print(Json json) {
        System.out.println(json.toJson());
    }

    public static JsonObject sessionResult() {
        final int OOP_MARK = 3, ENGLISH_MARK = 5, MATH_MARK = 2;

        Student student = new Student("Andrii", "Rodionov", 2,
                new Tuple<>("OOP", OOP_MARK),
                new Tuple<>("English", ENGLISH_MARK),
                new Tuple<>("Math", MATH_MARK));

        return student.toJsonObject();
    }
}
