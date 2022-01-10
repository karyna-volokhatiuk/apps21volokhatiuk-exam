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
        int OOP_mark = 3, English_mark = 5, Math_mark = 2;

        Student student = new Student("Andrii", "Rodionov", 2,
                new Tuple<>("OOP", OOP_mark),
                new Tuple<>("English", English_mark),
                new Tuple<>("Math", Math_mark));

        return student.toJsonObject();
    }
}
