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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeSpec.Builder;

public class Generate
{

	private static List<Config> configs = new ArrayList<>();

	static {
		configs.add(new Config(TypeName.BYTE));
		configs.add(new Config(TypeName.SHORT));
		configs.add(new Config(TypeName.INT));
		configs.add(new Config(TypeName.LONG));
		configs.add(new Config(TypeName.FLOAT));
		configs.add(new Config(TypeName.DOUBLE));
		configs.add(new Config(TypeName.BOOLEAN));
		configs.add(new Config(TypeName.OBJECT));
	}

	public static void main(String[] args) throws IOException
	{
		Builder builder = TypeSpec.classBuilder("Reflection").addModifiers(
				Modifier.PUBLIC, Modifier.FINAL);

		for (Config config : configs) {
			MethodSpec method = create(config);
			builder.addMethod(method);
		}

		TypeSpec helloWorld = builder.build();

		JavaFile javaFile = JavaFile.builder("de.topobyte.melon.reflection",
				helloWorld).build();

		javaFile.writeTo(System.out);
	}

	private static MethodSpec create(Config config)
	{
		String typeName;
		String upperTypeName;
		if (config.getTypeName() instanceof ClassName) {
			ClassName className = (ClassName) config.getTypeName();
			typeName = className.simpleName();
			upperTypeName = typeName;
		} else {
			typeName = config.getTypeName().toString();
			upperTypeName = typeName.substring(0, 1).toUpperCase()
					+ typeName.substring(1);
		}

		MethodSpec.Builder method = MethodSpec.methodBuilder("get"
				+ upperTypeName);
		method.addModifiers(Modifier.PUBLIC, Modifier.STATIC);
		method.returns(config.getTypeName());
		method.addException(SecurityException.class);
		method.addException(NoSuchFieldException.class);
		method.addException(IllegalArgumentException.class);
		method.addException(IllegalAccessException.class);

		method.addParameter(TypeName.OBJECT, "o");
		method.addParameter(TypeName.INT, "k");
		method.addParameter(ClassName.get("java.lang", "String"), "name");

		TypeName type = config.getTypeName();
		if (type.isPrimitive()) {
			type = type.box();
		}

		method.addStatement("Field field = getField(o, k, name)");
		method.addStatement("$T value = ($T) field.get(o)", type, type);
		method.addStatement("return value");

		method.addJavadoc(String.format("Get a %s field of an instance.",
				typeName));
		method.addJavadoc("\n\n");
		method.addJavadoc("@param o the instance to get the field from");
		method.addJavadoc("\n");
		method.addJavadoc("@param k the number of times to dereference the superclass before getting the field");
		method.addJavadoc("\n");
		method.addJavadoc("@param name the name of the field");
		method.addJavadoc("\n");
		method.addJavadoc("@return the value of that object's field");
		method.addJavadoc("\n");
		method.addJavadoc("@throws SecurityException");
		method.addJavadoc("\n");
		method.addJavadoc("@throws NoSuchFieldException");
		method.addJavadoc("\n");
		method.addJavadoc("@throws IllegalArgumentException");
		method.addJavadoc("\n");
		method.addJavadoc("@throws IllegalAccessException");
		method.addJavadoc("\n");

		return method.build();
	}

}