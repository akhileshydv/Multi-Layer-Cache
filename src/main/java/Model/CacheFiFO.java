package Model;

import java.util.List;
import java.util.Map;

public class CacheFiFO extends Cache{

    public CacheFiFO(Long size, CachePolicy policy, Long readCost, Long writeCost, int layer) {
        super(size, policy, readCost, writeCost,layer);
    }


    @Override
    public void write(String key, String value) {
        if(this.getDataMap().containsKey(key)){
            this.getKeys().removeIf(entry -> entry.equals(key));
            this.getKeys().addLast(key);
            this.getDataMap().put(key, value);
        }
        else if(this.getKeys().size() < this.getSize()){
            this.getKeys().addLast(key);
            this.getDataMap().put(key, value);
        }
        else{
            this.getDataMap().remove(this.getKeys().getFirst());
            this.getKeys().removeFirst();
            this.getKeys().addLast(key);
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
