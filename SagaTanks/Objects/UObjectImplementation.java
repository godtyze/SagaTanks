package SagaTanks.Objects;

import java.util.HashMap;

public class UObjectImplementation implements UObject{
    private HashMap<String, Object> options;

    public UObjectImplementation() {
        options = new HashMap<>();
    }

    @Override
    public void set(String key, Object value){
        options.put(key, value);
    }

    @Override
    public Object get(String key){
        return options.getOrDefault(key, null);
    }
}
