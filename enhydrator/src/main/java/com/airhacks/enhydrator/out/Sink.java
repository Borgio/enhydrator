package com.airhacks.enhydrator.out;

/*
 * #%L
 * enhydrator
 * %%
 * Copyright (C) 2014 Adam Bien
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import com.airhacks.enhydrator.flexpipe.JAXBInterfaceAdapter;
import com.airhacks.enhydrator.in.Entry;
import java.util.List;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author airhacks.com
 */
@XmlJavaTypeAdapter(JAXBInterfaceAdapter.class)
@FunctionalInterface
public interface Sink extends AutoCloseable {

    default void init() {
    }

    default String getName() {
        String simpleName = this.getClass().getSimpleName();
        return Character.toString(simpleName.charAt(0)).toLowerCase() + simpleName.substring(1);
    }

    void processRow(List<Entry> entries);

    @Override
    default void close() {
    }
}
