package Manager;

import Model.Cache;
import Response.CacheGetResponse;
import Response.CacheSetResponse;

import java.util.ArrayList;
import java.util.List;

public class CacheManager {
    private static List<Cache> layers = new ArrayList<>();
    private static int size = 0;
    public static Cache addLayer(Cache cache){
        layers.add(cache);
        return cache;
    }

    public static CacheSetResponse set(String key, String value){
        Long totalCost = 0L;
        for(Cache cache: layers){
            totalCost += cache.getReadCost();
            if(!cache.isPresent(key)){
                cache.write(key, value);
                totalCost += cache.getWriteCost();
            }

        }
        return new CacheSetResponse(totalCost);
    }

    public static CacheGetResponse get(String key){
        Long totalCost = 0L;
        String value = null;
        int dataPresentAtLayer = 0;
        for(Cache cache : layers){
            totalCost += cache.getReadCost();
            if(cache.isPresent(key)){
                value = cache.getDataMap().get(key);
                dataPresentAtLayer = cache.getLayer();
                break;
            }
        }
        for(int i=0;i<dataPresentAtLayer ;i++){
            totalCost += layers.get(i).getWriteCost();
            layers.get(i).write(key, value);
        }
        return new CacheGetResponse(totalCost, value);
    }
}
