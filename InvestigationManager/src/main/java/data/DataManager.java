package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Case;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private final ObjectMapper mapper;

    public DataManager() {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JavaTimeModule());
    }

    public <T> void saveList(List<T> list, String fileName) {
        try {
            mapper.writeValue(new File(fileName), list);
            System.out.println("Lista salva em " + fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public <T> List<T> loadList(String fileName, Class<T> clazz) {
        try {
            return mapper.readValue(new File(fileName), mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public ObjectMapper getMapper() {
        return mapper;
    }
}
