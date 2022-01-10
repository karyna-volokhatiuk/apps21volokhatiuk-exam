package json;

import lombok.Getter;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
@Getter
public class JsonPair extends Tuple<String, Json> {

    public JsonPair(String name, Json value) {
        super(name, value);
    }
}
