package repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SchemaRegistryRepository {
    public SchemaRegistryRepository() {
        keyDataTypeMap=new ConcurrentHashMap<>();
    }

    public static Map<String, String> getKeyDataTypeMap() {
        return keyDataTypeMap;
    }

    public static void setKeyDataTypeMap(Map<String, String> keyDataTypeMap) {
        SchemaRegistryRepository.keyDataTypeMap = keyDataTypeMap;
    }

    static Map<String,String> keyDataTypeMap;
}
