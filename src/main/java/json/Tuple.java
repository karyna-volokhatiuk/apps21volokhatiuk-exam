package json;
import lombok.Getter;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
@Getter
public class Tuple<K, V> {
    private final K key;
    private final V value;

    public Tuple(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
