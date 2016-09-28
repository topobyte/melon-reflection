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

import com.squareup.javapoet.TypeName;

public class Config
{

	private TypeName typeName;

	public Config(TypeName typeName)
	{
		this.typeName = typeName;
	}

	public TypeName getTypeName()
	{
		return typeName;
	}

}
