package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

/**
 * Class description goes here.
 *
 * @author Dmitry
 * @version 1.10 22.04.2019 Апр. 2019
 */
public class FactoryProducer {
	public static enum HumanFactoryType{
		MALE,
		FEMALE
	}

	public static AbstractFactory getFactory(HumanFactoryType type){
		switch (type){
			case MALE: return new MaleFactory();
			case FEMALE: return new FemaleFactory();
			default: throw new IllegalArgumentException();
		}
	}
}
