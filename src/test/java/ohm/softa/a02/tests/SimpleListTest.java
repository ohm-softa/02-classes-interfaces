package ohm.softa.a02.tests;

import ohm.softa.a02.SimpleFilter;
import ohm.softa.a02.SimpleListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListTest {

	private SimpleListImpl testList;

	@BeforeEach
	void setup(){
		testList = new SimpleListImpl();

		testList.add(1);
		testList.add(2);
		testList.add(3);
		testList.add(4);
		testList.add(5);
	}

	@Test
	void testAddElements(){
		int counter = 0;
		for(Object obj : testList){
			counter++;
		}
		assertEquals(5, counter);
	}

	@Test
	void testSize(){
		assertEquals(5, testList.size());
	}

	@Test
	void testFilterAnonymousClass(){
		SimpleListImpl result = (SimpleListImpl) testList.filter(new SimpleFilter() {
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
		SimpleListImpl result = (SimpleListImpl) testList.filter(o -> ((int)o) % 2 == 0);
		for(Object o : result){
			int i = (int)o;
			assertEquals(i % 2, 0);
		}
	}
}
