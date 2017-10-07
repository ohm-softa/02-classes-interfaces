package de.fhro.inf.prg3.classesInterfaces;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
@FunctionalInterface
public interface SimpleFilter {
	boolean include(Object item);
}
