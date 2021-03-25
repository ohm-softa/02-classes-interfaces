package ohm.softa.a02;

public interface SimpleList extends SimpleFilter {
	/**
	 * Add a given object to the back of the list.
	 */
	void add(Object o);

	/**
	 * @return current size of the list
	 */
	int size();

	/**
	 * Generate a new list using the given filter instance.
	 * @return a new, filtered list
	 */
	SimpleList filter(SimpleFilter filter);
}
