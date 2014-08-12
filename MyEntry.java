import java.util.Map;

// Class used for TreeSet Map.Entry. - to override the compareTo method.

final class MyEntry<K, V> implements Map.Entry<K, V>, Comparable<MyEntry<K, V>> {
	private final K key;
	private V value;

	public MyEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		return key;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public V setValue(V value) {
		V old = this.value;
		this.value = value;
		return old;
	}

	@Override
	public int compareTo(MyEntry<K, V> object) {
		if ((Long)this.value < (Long)object.value)
			return -1;
		if (this.value.equals(object.value))
			return 0;

		return 1;
	}
}