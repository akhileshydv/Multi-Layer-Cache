package Response;

public abstract class CacheResponse {
    Long cost;

    public CacheResponse(Long cost) {
        this.cost = cost;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }
}
