package de.fhro.inf.prg3.classesInterfaces.tests;

import de.fhro.inf.prg3.classesInterfaces.SimpleFilter;
import de.fhro.inf.prg3.classesInterfaces.SimpleList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListTest {

	private SimpleList testList;

	@BeforeEach
	void setup(){
		testList = new SimpleList();

		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
	}

	@Test
	void testAddElements(){
		int counter = 0;
		for(Object o : testList){
			counter++;
		}
		assertEquals(5, counter);
	}

	@Test
	void testGetSize(){
		assertEquals(5, testList.getSize());
	}

	@Test
	void testFilterAnonymousClass(){
		SimpleList result = testList.filter(new SimpleFilter() {
			@Override
			public boolean include(Object item) {
				int current = (int)item;
				return current > 2;
			}
		});

		for(Object o : result){
			int i = (int)o;
			assertTrue(i > 2);
		}
	}

	@Test
	void testFilterLambda(){
		SimpleList result = testList.filter(o -> ((int)o) % 2 == 0);
		for(Object o : result){
			int i = (int)o;
			assertTrue(i % 2 == 0);
		}
	}
}
