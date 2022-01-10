package json;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    Map<String, Json> jsonObject = new LinkedHashMap<>();

    public JsonObject(JsonPair... jsonPairs) {
        for (JsonPair pair : jsonPairs) {
            jsonObject.put(pair.getKey(), pair.getValue());
        }
    }


    private String getJsonObjectBody() {

        StringBuilder jsonObjectString = new StringBuilder();
        Iterator<Map.Entry<String, Json>> jsonIterator
                = jsonObject.entrySet().iterator();

        while (jsonIterator.hasNext()) {
            Map.Entry<String, Json> json = (Map.Entry<String, Json>) jsonIterator.next();
            jsonObjectString.append(json.getKey() + ": " + json.getValue().toJson());
            if (jsonIterator.hasNext()) {
                jsonObjectString.append(", ");
            }
        }
        return jsonObjectString.toString();
    }

    @Override
    public String toJson() {
        String jsonString = "{";

        return "{" + getJsonObjectBody() + "}";
    }

    public void add(JsonPair jsonPair) {
        // ToDo
        jsonObject.put(jsonPair.getKey(), jsonPair.getValue());
    }

    private boolean contains(String name) {
        return jsonObject.containsKey(name);
    }

    public Json find(String name) {
        // ToDo
        if (contains(name)) {
            return jsonObject.get(name);
        }
        return null;
    }

    public JsonObject projection(String... names) {
        // ToDo
        JsonObject newJsonObject = new JsonObject();

        for (String name : names) {
            Json value = find(name);
            if (value != null) {
                newJsonObject.add(new JsonPair(name, value));
            }
        }

        return newJsonObject;

    }
}
