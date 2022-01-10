package domain;

import json.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private final Tuple<String, Integer>[] marks;

    @SafeVarargs
    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.marks = exams.clone();
    }

    private Boolean isPassed(int mark){
        int minMarkToPass = 3;
        return mark >= minMarkToPass;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject jsonObject = super.toJsonObject();

        if (marks.length == 0){
            jsonObject.add(new JsonPair("exams", new JsonArray()));
            return jsonObject;
        }

        JsonObject[] MarksJsonArr = new JsonObject[marks.length];

        MarksJsonArr[0] = new JsonObject(new JsonPair("hello", new JsonBoolean(true)));

        for (int i = 0; i < marks.length; i++) {
            JsonObject internalJsonObject = new JsonObject();

            internalJsonObject.add(new JsonPair("course", new JsonString(marks[i].getKey())));
            internalJsonObject.add(new JsonPair("mark", new JsonNumber(marks[i].getValue())));
            internalJsonObject.add(new JsonPair("passed", new JsonBoolean(isPassed(marks[i].getValue()))));

            MarksJsonArr[i] = internalJsonObject;

        }

        jsonObject.add(new JsonPair("exams", new JsonArray(MarksJsonArr)));

        return jsonObject;
    }
}