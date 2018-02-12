package org.ff4j.v1.utils;

/*
 * #%L
 * ff4j-core
 * %%
 * Copyright (C) 2013 - 2016 FF4J
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

import java.util.Optional;
import java.util.function.Consumer;

public class OptionalEx {
    
    private boolean isPresent;

    private OptionalEx(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public void orElse(Runnable runner) {
        if (!isPresent) {
            runner.run();
        }
    }

    public static <T> OptionalEx ifPresent(Optional<T> opt, Consumer<? super T> consumer) {
        if (opt.isPresent()) {
            consumer.accept(opt.get());
            return new OptionalEx(true);
        }
        return new OptionalEx(false);
    }
}