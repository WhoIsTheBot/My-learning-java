package labs.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class JsonSerializer<T> implements Serializer<T> {
    private final Class<T> type;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonSerializer(Class<T> type) {
        this.type = type;
    }

    @Override
    public String serialize(T entity) {
        try {
            return objectMapper.writeValueAsString(entity);
        } catch (IOException e) {
            throw new RuntimeException("Error serializing entity", e);
        }
    }

    @Override
    public T deserialize(String data) {
        try {
            return objectMapper.readValue(data, type);
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing entity", e);
        }
    }

    @Override
    public void writeToFile(T entity, String filePath) {
        try {
            objectMapper.writeValue(new File(filePath), entity);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }

    @Override
    public T readFromFile(String filePath) {
        try {
            return objectMapper.readValue(new File(filePath), type);
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file", e);
        }
    }
}