package labs.serialize;

import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;

public class YamlSerializer<T> implements Serializer<T> {
    private final Class<T> type;
    private final Yaml yaml = new Yaml();

    public YamlSerializer(Class<T> type) {
        this.type = type;
    }

    @Override
    public String serialize(T entity) {
        return yaml.dump(entity);
    }

    @Override
    public T deserialize(String data) {
        return yaml.loadAs(data, type);
    }

    @Override
    public void writeToFile(T entity, String filePath) {
        try (Writer writer = new FileWriter(filePath)) {
            yaml.dump(entity, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }

    @Override
    public T readFromFile(String filePath) {
        try (InputStream inputStream = new FileInputStream(filePath)) {
            return yaml.loadAs(inputStream, type);
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file", e);
        }
    }
}

