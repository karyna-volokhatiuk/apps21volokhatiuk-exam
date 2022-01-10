package domain;

import json.*;


/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private final Tuple<String, Integer>[] marks;

    @SafeVarargs
    public Student(String name,
                   String surname,
                   Integer year,
                   Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.marks = exams.clone();
    }

    private boolean isPassed(int mark) {
        final int MIM_MARKS_TO_PASS = 3;
        return mark >= MIM_MARKS_TO_PASS;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonObject jsonObject = super.toJsonObject();

        if (marks.length == 0) {
            jsonObject.add(new JsonPair("exams", new JsonArray()));
            return jsonObject;
        }

        JsonObject[] MarksJsonArr = new JsonObject[marks.length];

        for (int i = 0; i < marks.length; i++) {
            JsonObject internalJsonObject = new JsonObject();

            internalJsonObject.add(new JsonPair("course",
                    new JsonString(marks[i].getKey())));
            internalJsonObject.add(new JsonPair("mark",
                    new JsonNumber(marks[i].getValue())));
            internalJsonObject.add(new JsonPair("passed",
                    new JsonBoolean(isPassed(marks[i].getValue()))));

            MarksJsonArr[i] = internalJsonObject;

        }

        jsonObject.add(new JsonPair("exams", new JsonArray(MarksJsonArr)));

        return jsonObject;
    }
}