/*
 * Copyright 2015 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.dispatch.rest.processors.serialization.jackson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.gwtplatform.dispatch.rest.processors.definitions.HasImports;
import com.gwtplatform.dispatch.rest.processors.definitions.TypeDefinition;

public class MapperDefinition implements HasImports {
    private final TypeDefinition mapped;
    private final TypeDefinition impl;

    public MapperDefinition(
            TypeDefinition mapped,
            TypeDefinition impl) {
        this.mapped = mapped;
        this.impl = impl;
    }

    public TypeDefinition getMapped() {
        return mapped;
    }

    public TypeDefinition getImpl() {
        return impl;
    }

    @Override
    public Collection<String> getImports() {
        List<String> imports = new ArrayList<>(mapped.getImports());
        imports.addAll(impl.getImports());

        return imports;
    }
}