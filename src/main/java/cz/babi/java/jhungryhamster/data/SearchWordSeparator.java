/*
 * Copyright 2017 Martin Misiarz
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cz.babi.java.jhungryhamster.data;

import static cz.babi.java.jhungryhamster.utils.Common.RESOURCE_BUNDLE;

/**
 * @author Martin Misiarz
 * @author dev.misiarz@gmail.com
 */
public enum SearchWordSeparator {

    Space(" " + RESOURCE_BUNDLE.getString("Splitter.space")),
    Dot(" ."),
    Comma(" ,"),
    Custom(" " + RESOURCE_BUNDLE.getString("Splitter.own"));

    private String key;

    /**
     * Constructor
     * @param key The key.
     */
    SearchWordSeparator(String key) {
        this.key = key;
    }

    /**
     * Reruns key.
     * @return The key.
     */
    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return key;
    }
}
