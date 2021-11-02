package Response;

public class CacheGetResponse extends CacheResponse{
    String value;

    public CacheGetResponse(Long cost, String value) {
        super(cost);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
