package someTest.retaincache;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by shuailu on 5/27/16.
 */
public class RetainBestCache<K, T extends Rankable> {

    private DataSource<K, T> ds;
    private final int maxSize;
    private int size;
    PriorityQueue<Map.Entry<K, T>> priorityQueue;

    Map<K, T> cache;


    /* Constructor with a data source (assumed to be slow) and a cache size */
    public RetainBestCache(DataSource<K, T> ds, int entriesToRetain) {
        // Implementation here
        this.ds = ds;
        maxSize = entriesToRetain;
        cache = new HashMap<>();
        priorityQueue = new PriorityQueue<>(maxSize, new Comparator<Map.Entry<K, T>>() {
            @Override
            public int compare(Map.Entry<K, T> entry1, Map.Entry<K, T> entry2) {
                if (entry1.getValue().getRank() == entry2.getValue().getRank()) {
                    return 0;
                }
                return entry1.getValue().getRank() < entry2.getValue().getRank() ? -1 : 1;
            }
        });
    }

    /* Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,
     * retrieves it from the data source. If the cache is full, attempts to cache the returned data,
     * evicting the T with lowest rank among the ones that it has available
     * If there is a tie, the cache may choose any T with lowest rank to evict.
     */
    public T get(K key) {
        // Implementation here
        T val = cache.get(key);
        if (val != null) {
            return val;
        }
        val = ds.get(key);
        if (size + 1 > maxSize) {
            //kick the one with lowest rank
            Map.Entry<K, T> entry = priorityQueue.peek();
            if (entry.getValue().getRank() < val.getRank()) {

            }
        }
        //put into cache
        return null;
    }


    public int getSize() {
        return size;
    }
}




