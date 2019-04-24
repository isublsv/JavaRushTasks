package com.javarush.task.task36.task3610;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class MyMultiMapTest {

	private MyMultiMap<String, List<String>> map = new MyMultiMap<>(3);

	@Before
	public void setUp() throws Exception {
		ArrayList<String> strings = new ArrayList<>();
		strings.add("one");
		strings.add("two");
		ArrayList<String> strings2 = new ArrayList<>();
		strings.add("three");
		strings.add("four");
		map.put("1", strings);
		map.put("2", strings2);
	}

	@Test
	public void size() {
		int expected = map.size();
		int actual = 4;
		assertEquals(expected, actual);
	}

	@Test
	public void put() {
	}

	@Test
	public void remove() {
	}

	@Test
	public void keySet() {
	}

	@Test
	public void values() {
	}

	@Test
	public void containsKey() {
	}

	@Test
	public void containsValue() {
	}
}