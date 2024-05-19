package service.impl;

import dto.KeyValueMap;
import javafx.util.Pair;
import repository.KeyValueRepository;
import repository.SchemaRegistryRepository;
import service.DataTypeChecker;
import service.SchemaRegistryService;

import java.util.List;
import java.util.Map;

public class SchemaRegistryServiceImpl implements SchemaRegistryService {

    Map<String, KeyValueMap> keyValueRepository = KeyValueRepository.getKeyMap();
    Map<String,String> schemaRegistryRepository= SchemaRegistryRepository.getKeyDataTypeMap();

    @Override
    public void registerSchema(List<Pair<String, String>> listOfAttributePairs) {
        listOfAttributePairs.forEach(pair->
            schemaRegistryRepository.put(pair.getKey(), DataTypeChecker.determineType(pair.getValue()))
            );
    }

    @Override
    public boolean validateSchema(List<Pair<String, String>> listOfAttributePairs) {
        listOfAttributePairs.forEach(pair->
                schemaRegistryRepository.get(pair.getKey()).equals(DataTypeChecker.determineType(pair.getValue()))
        );

      Object isInvalid= listOfAttributePairs.stream().filter(pair->
                !schemaRegistryRepository.get(pair.getKey()).equals(DataTypeChecker.determineType(pair.getValue()))
                ).findFirst().orElse(null);

      return isInvalid==null;
    }
}
