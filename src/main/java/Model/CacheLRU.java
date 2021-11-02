package Model;

public class CacheLRU extends Cache{

    public CacheLRU(Long size, CachePolicy policy, Long readCost, Long writeCost, int layer) {
        super(size, policy, readCost, writeCost, layer);
    }

    @Override
    public void write(String key, String value) {
        if(this.getDataMap().containsKey(key)){
            this.getKeys().removeIf(entry -> entry.equals(key));
            this.getKeys().add(0, key);
            this.getDataMap().put(key, value);
        }
        else if(this.getKeys().size() < this.getSize()){
            this.getKeys().add(key);
            this.getDataMap().put(key, value);
        }
        else{
            this.getDataMap().remove(this.getKeys().removeLast());
            this.getKeys().removeLast();
            this.getKeys().addFirst(key);
            this.getDataMap().put(key, value);
        }
    }

    @Override
    public String read(String key) {
        return this.getDataMap().get(key);
    }

    @Override
    public boolean isPresent(String key) {
        return this.getDataMap().containsKey(key);
    }
}
