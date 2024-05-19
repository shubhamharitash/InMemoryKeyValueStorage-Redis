package service;

import javafx.util.Pair;

import java.util.List;

public interface CommandService {
    public String get(String key);
    public String put(String key, List<Pair<String, String>> listOfAttributePairs);
    public void delete(String key);
    public List<String> search(String attributeKey, String attributeValue);
    public List<String> keys();
    public void exit();
}
