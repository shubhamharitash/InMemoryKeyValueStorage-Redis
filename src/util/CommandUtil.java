package util;

import javafx.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandUtil {
    public static Map<String,Object> listOfPairToMapConvertor(List<Pair<String, String>> listOfAttributePairs){
        return listOfAttributePairs.stream()
                .collect(Collectors.toMap(pair -> pair.getKey(), pair->pair.getValue()));
    }
}
