package org.ff4j.aop;

/*
 * #%L
 * ff4j-aop
 * %%
 * Copyright (C) 2013 Ff4J
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

import junit.framework.Assert;

import org.ff4j.FF4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-ff4j-aop-test.xml")
public class FeatureFlipperTest {

    @Autowired
    private FF4j ff4j;

    @Autowired
    @Qualifier("greeting.english")
    private GreetingService greeting;

    @Autowired
    @Qualifier("goodbye.french")
    private GoodbyeService goodbye;

    @Before
    public void createFeatures() {
        if (!ff4j.existFeature("language-english")) {
            ff4j.createFeature("language-english");
        }
        if (!ff4j.existFeature("language-french")) {
            ff4j.createFeature("language-french");
        }
    }

    @After
    public void disableFeatures() {
        ff4j.disableFeature("language-french");
        ff4j.disableFeature("language-english");
    }

    @Test
    public void testAnnotatedFlipping_with_alterBean() {
        Assert.assertTrue(greeting.sayHello("CLU").startsWith("Hello"));

        ff4j.enableFeature("language-french");
        Assert.assertTrue("Service did not flipped", greeting.sayHello("CLU").startsWith("Bonjour"));
    }

    @Test
    @Ignore
    public void testAnnotatedFlipping_with_alterClazz() {
        Assert.assertTrue(greeting.sayHelloWithClass("CLU").startsWith("Hi"));
        ff4j.enableFeature("language-french");
        Assert.assertTrue("Service did not flipped", greeting.sayHelloWithClass("CLU").startsWith("Salut"));
    }

    @Test
    public void testAnnotatedFlipping_if_qualified_implementation_is_not_the_first_class_qualified_name_in_natural_ordering() {
        Assert.assertTrue(goodbye.sayGoodbye("CLU").startsWith("Au revoir"));

        ff4j.enableFeature("language-english");
        Assert.assertTrue("Service did not flipped", goodbye.sayGoodbye("CLU").startsWith("Goodbye"));
    }

    @Test
    @Ignore
    public void testAnnotatedFlipping_with_alterClazz_if_qualified_implementation_is_not_the_first_class_qualified_name_in_natural_ordering() {
        Assert.assertTrue(goodbye.sayGoodbyeWithClass("CLU").startsWith("A plus"));

        ff4j.enableFeature("language-english");
        Assert.assertTrue("Service did not flipped", goodbye.sayGoodbyeWithClass("CLU").startsWith("See you"));
    }
}