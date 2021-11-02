package Model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public abstract class Cache {
    private Long size;
    private CachePolicy policy;
    private long readCost;
    private Long writeCost;
    private LinkedList<String> keys;
    private HashMap<String, String> dataMap;
    private int layer;

    public Cache(Long size, CachePolicy policy, Long readCost, Long writeCost, int layer) {
        this.size = size;
        this.policy = policy;
        this.readCost = readCost;
        this.writeCost = writeCost;
        this.keys = new LinkedList<>();
        this.dataMap = new HashMap<>();
        this.layer = layer;

    }
    public abstract void write(String key, String value);
    public abstract String read(String key);
    public abstract boolean isPresent(String content);

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public Long getSize() {
        return size;
    }

    public CachePolicy getPolicy() {
        return policy;
    }

    public Long getReadCost() {
        return readCost;
    }

    public Long getWriteCost() {
        return writeCost;
    }

    public LinkedList<String> getKeys() {
        return keys;
    }

    public HashMap<String, String> getDataMap() {
        return dataMap;
    }
}

