package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

/**
 * Class description goes here.
 *
 * @author Dmitry
 * @version 1.10 22.04.2019 Апр. 2019
 */
public class MaleFactory implements AbstractFactory {
	@Override
	public Human getPerson(int age) {
		if (age < 13) return new KidBoy();
		else if (age > 12 && age < 20) return new TeenBoy();
		else return new Man();
	}
}
