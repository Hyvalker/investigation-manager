package data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.Case;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private ObjectMapper mapper;

    public DataManager() {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.registerModule(new JavaTimeModule());
    }

    public ObjectMapper getMapper(){
        return mapper;
    }

    public void saveCases(List<Case> caseList, String fileName){
        try{
            mapper.writeValue(new File(fileName), caseList);
            System.out.println("Cases salvos em " + fileName);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public List<Case> loadCases(String fileName) {
        try {
            return mapper.readValue(new File(fileName), new com.fasterxml.jackson.core.type.TypeReference<List<Case>>() {});
        } catch(Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
