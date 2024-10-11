package labs.serialize;

public interface Serializer<T> {
    String serialize(T entity);

    T deserialize(String data);

    void writeToFile(T entity, String filePath);

    T readFromFile(String filePath);
}
