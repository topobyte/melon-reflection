// Copyright 2016 Sebastian Kuerten
//
// This file is part of melon-reflection.
//
// melon-reflection is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// melon-reflection is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with melon-reflection. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.melon.reflection;

import java.lang.reflect.Field;

/**
 * Some convenience methods for retrieving non-public fields
 * 
 * @author Sebastian Kuerten (sebastian@topobyte.de)
 */
public class Reflection
{

	/**
	 * Get a byte field of an instance.
	 *
	 * @param o
	 *            the instance to get the field from
	 * @param k
	 *            the number of times to dereference the superclass before
	 *            getting the field
	 * @param name
	 *            the name of the field
	 * @return the value of that object's field
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static byte getByte(Object o, int k, String name)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException
	{
		Field field = getField(o, k, name);
		Byte value = (Byte) field.get(o);
		return value;
	}

	/**
	 * Get a short field of an instance.
	 *
	 * @param o
	 *            the instance to get the field from
	 * @param k
	 *            the number of times to dereference the superclass before
	 *            getting the field
	 * @param name
	 *            the name of the field
	 * @return the value of that object's field
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static short getShort(Object o, int k, String name)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException
	{
		Field field = getField(o, k, name);
		Short value = (Short) field.get(o);
		return value;
	}

	/**
	 * Get a int field of an instance.
	 *
	 * @param o
	 *            the instance to get the field from
	 * @param k
	 *            the number of times to dereference the superclass before
	 *            getting the field
	 * @param name
	 *            the name of the field
	 * @return the value of that object's field
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static int getInt(Object o, int k, String name)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException
	{
		Field field = getField(o, k, name);
		Integer value = (Integer) field.get(o);
		return value;
	}

	/**
	 * Get a long field of an instance.
	 *
	 * @param o
	 *            the instance to get the field from
	 * @param k
	 *            the number of times to dereference the superclass before
	 *            getting the field
	 * @param name
	 *            the name of the field
	 * @return the value of that object's field
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static long getLong(Object o, int k, String name)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException
	{
		Field field = getField(o, k, name);
		Long value = (Long) field.get(o);
		return value;
	}

	/**
	 * Get a float field of an instance.
	 *
	 * @param o
	 *            the instance to get the field from
	 * @param k
	 *            the number of times to dereference the superclass before
	 *            getting the field
	 * @param name
	 *            the name of the field
	 * @return the value of that object's field
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static float getFloat(Object o, int k, String name)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException
	{
		Field field = getField(o, k, name);
		Float value = (Float) field.get(o);
		return value;
	}

	/**
	 * Get a double field of an instance.
	 *
	 * @param o
	 *            the instance to get the field from
	 * @param k
	 *            the number of times to dereference the superclass before
	 *            getting the field
	 * @param name
	 *            the name of the field
	 * @return the value of that object's field
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static double getDouble(Object o, int k, String name)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException
	{
		Field field = getField(o, k, name);
		Double value = (Double) field.get(o);
		return value;
	}

	/**
	 * Get a boolean field of an instance.
	 *
	 * @param o
	 *            the instance to get the field from
	 * @param k
	 *            the number of times to dereference the superclass before
	 *            getting the field
	 * @param name
	 *            the name of the field
	 * @return the value of that object's field
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static boolean getBoolean(Object o, int k, String name)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException
	{
		Field field = getField(o, k, name);
		Boolean value = (Boolean) field.get(o);
		return value;
	}

	/**
	 * Get a Object field of an instance.
	 *
	 * @param o
	 *            the instance to get the field from
	 * @param k
	 *            the number of times to dereference the superclass before
	 *            getting the field
	 * @param name
	 *            the name of the field
	 * @return the value of that object's field
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static Object getObject(Object o, int k, String name)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException
	{
		Field field = getField(o, k, name);
		Object value = (Object) field.get(o);
		return value;
	}

	private static Field getField(Object o, int k, String name)
			throws NoSuchFieldException, SecurityException
	{
		Field field = getClass(o, k).getDeclaredField(name);
		field.setAccessible(true);
		return field;
	}

	private static Class<?> getClass(Object o, int k)
	{
		Class<?> c = o.getClass();
		for (int i = 0; i < k; i++) {
			c = c.getSuperclass();
		}
		return c;
	}

}
