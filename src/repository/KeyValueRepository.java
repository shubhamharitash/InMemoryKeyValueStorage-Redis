package repository;

import dto.KeyValueMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KeyValueRepository {
    public KeyValueRepository() {
        KeyMap = new ConcurrentHashMap<>();
    }

    public static Map<String, KeyValueMap> getKeyMap() {
        return KeyMap;
    }

    public static void setKeyMap(Map<String, KeyValueMap> keyMap) {
        KeyMap = keyMap;
    }

  public static Map<String, KeyValueMap> KeyMap;

}
