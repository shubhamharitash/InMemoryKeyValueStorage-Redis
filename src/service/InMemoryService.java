package service;

import repository.KeyValueRepository;
import repository.SchemaRegistryRepository;

public class InMemoryService {
    public InMemoryService() {
        KeyValueRepository keyValueRepository=new KeyValueRepository();
        SchemaRegistryRepository schemaRegistryRepository=new SchemaRegistryRepository();
    }
}
