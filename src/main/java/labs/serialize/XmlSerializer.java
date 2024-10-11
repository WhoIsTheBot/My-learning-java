package labs.serialize;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.IOException;

public class XmlSerializer<T> implements Serializer<T> {
    private final Class<T> type;
    private final XmlMapper xmlMapper = new XmlMapper();

    public XmlSerializer(Class<T> type) {
        this.type = type;
    }

    @Override
    public String serialize(T entity) {
        try {
            return xmlMapper.writeValueAsString(entity);
        } catch (IOException e) {
            throw new RuntimeException("Error serializing entity", e);
        }
    }

    @Override
    public T deserialize(String data) {
        try {
            return xmlMapper.readValue(data, type);
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing entity", e);
        }
    }

    @Override
    public void writeToFile(T entity, String filePath) {
        try {
            xmlMapper.writeValue(new File(filePath), entity);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }

    @Override
    public T readFromFile(String filePath) {
        try {
            return xmlMapper.readValue(new File(filePath), type);
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file", e);
        }
    }
}
