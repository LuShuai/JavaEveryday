package hashmap;

public interface myMap<K,V>
{
	void put(K key, V value);
	V get(K key);
	void remove(K key);
	boolean isEmpty();
	boolean contains(K key);
	void resize(int size);
}
