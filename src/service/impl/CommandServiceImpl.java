package service.impl;

import dto.KeyValueMap;
import javafx.util.Pair;
import repository.KeyValueRepository;
import service.CommandService;
import service.SchemaRegistryService;
import util.CommandUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class CommandServiceImpl implements CommandService {

    Map<String,KeyValueMap> keyValueRepository = KeyValueRepository.getKeyMap();
    SchemaRegistryService schemaRegistryService=new SchemaRegistryServiceImpl();

    @Override
    public String get(String key) {
        if (keyValueRepository.get(key)==null)
            return "No entry found for "+key;
        Map<String,Object> attributeMap= keyValueRepository.get(key).getAttributes();
        return attributeMap.toString().replace("{","").replace("}","");
    }

    @Override
    public String put(String key, List<Pair<String, String>> listOfAttributePairs) {
        if (keyValueRepository.size()>0 && !schemaRegistryService.validateSchema(listOfAttributePairs)){
            return "Data Type Error";
        }

       Map<String,Object> attributesMap=CommandUtil.listOfPairToMapConvertor(listOfAttributePairs);

        //NEW ENTRY
        schemaRegistryService.registerSchema(listOfAttributePairs);

        if (keyValueRepository.get(key)==null)
        {
            KeyValueMap keyValueMap=new KeyValueMap(key,attributesMap);
            keyValueRepository.put(key,keyValueMap);
        }else {
            keyValueRepository.get(key).setAttributes(attributesMap);
        }
        return "";
    }



    @Override
    public void delete(String key) {
        keyValueRepository.remove(key);
    }

    @Override
    public List<String> search(String attributeKey, String attributeValue) {

        Set<String> keys=new ConcurrentSkipListSet<>();

        for (String key:keyValueRepository.keySet()) {

            Map<String,Object> attributes=keyValueRepository.get(key).getAttributes();

            for (String attributesKey:attributes.keySet()) {
                if (attributeKey.equals(attributeKey) && attributes.get(attributeKey).equals(attributeValue)){
                    keys.add(key);
                }
            }
        }
        return  keys.stream().collect(Collectors.toList());
    }

    @Override
    public List<String> keys() {
    return keyValueRepository.keySet().stream().collect(Collectors.toList());
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
