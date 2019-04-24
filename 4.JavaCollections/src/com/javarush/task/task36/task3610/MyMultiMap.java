package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
	static final long serialVersionUID = 123456789L;
	private HashMap<K, List<V>> map;
	private int repeatCount;

	public MyMultiMap(int repeatCount) {
		this.repeatCount = repeatCount;
		map = new HashMap<>();
	}

	@Override
	public int size() {
		//напишите тут ваш код
		if (map.size() == 0) return 0;
		int sum = 0;
		for (List<V> vs : map.values()) {
			sum += vs.size();
		}
		return sum;
	}

	@Override
	public V put(K key, V value) {
		//напишите тут ваш код
		List<V> vs = map.get(key);
		V oldValue = null;

		if (vs == null) {
			vs = new ArrayList<>();

		} else {
			oldValue = vs.get(vs.size()-1);
			if (vs.size() == repeatCount)
				vs.remove(0);
		}

		vs.add(value);
		map.put(key, vs);
		return oldValue;
	}

	@Override
	public V remove(Object key) {
		//напишите тут ваш код
		List<V> vs = map.get(key);
		if (vs == null)
			return null;

		V storedValue = vs.get(0);
		vs.remove(0);

		if (vs.size() == 0)
			map.remove(key);

		return storedValue;
	}

	@Override
	public Set<K> keySet() {
		//напишите тут ваш код
		return map.keySet();
	}

	@Override
	public ArrayList<V> values() {
		//напишите тут ваш код
		ArrayList<V> values = new ArrayList<>();
		for (List<V> v : map.values()) {
			values.addAll(v);
		}
		return values;
	}

	@Override
	public boolean containsKey(Object key) {
		//напишите тут ваш код
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		//напишите тут ваш код
		for (List<V> vs : map.values())
			if (vs.contains(value)) return true;
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		for (Map.Entry<K, List<V>> entry : map.entrySet()) {
			sb.append(entry.getKey());
			sb.append("=");
			for (V v : entry.getValue()) {
				sb.append(v);
				sb.append(", ");
			}
		}
		String substring = sb.substring(0, sb.length() - 2);
		return substring + "}";
	}
}