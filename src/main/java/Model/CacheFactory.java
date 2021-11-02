package Model;

public class CacheFactory {

    public static Cache getCache(String policy, Long size, CachePolicy cachePolicy, Long readCost, Long writeCost, int layer){
        switch(policy){
            case "FIFO":
                return new CacheFiFO(size, cachePolicy, readCost, writeCost, layer);
            case "LRU":
                return new CacheLRU(size, cachePolicy, readCost, writeCost, layer);
            default:
                return null;
        }
    }
}
