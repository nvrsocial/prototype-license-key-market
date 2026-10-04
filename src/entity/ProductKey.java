package entity;

public class ProductKey {
    private long id;
    private String key;

    public ProductKey(long id, String key) {
        this.id = id;
        this.key = key;
    }

    public long getId() {
        return id;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "ProductKey{" +
                "id=" + id +
                ", key='" + key + '\'' +
                '}';
    }
}
