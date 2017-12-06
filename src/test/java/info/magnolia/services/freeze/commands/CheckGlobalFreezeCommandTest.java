/**
 * This file Copyright (c) 2017 Magnolia International
 * Ltd.  (http://www.magnolia-cms.com). All rights reserved.
 *
 *
 * This program and the accompanying materials are made
 * available under the terms of the Magnolia Network Agreement
 * which accompanies this distribution, and is available at
 * http://www.magnolia-cms.com/mna.html
 *
 * Any modifications to this file must keep this entire header
 * intact.
 *
 */
package info.magnolia.services.freeze.commands;

import info.magnolia.services.Freeze;
import info.magnolia.test.MgnlTestCase;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;

/**
 * TBD.
 */
public class CheckGlobalFreezeCommandTest extends MgnlTestCase {

    private static final Logger logger = LoggerFactory.getLogger(CheckGlobalFreezeCommandTest.class);


    Freeze freeze;
    CheckGlobalFreezeCommand command;

    @Before
    public void setUp() throws Exception {
        logger.debug("setUp() called");

        super.setUp();

        // do some set up here
        freeze = new Freeze();
        command = new CheckGlobalFreezeCommand(freeze);
    }

    @After
    public void tearDown() throws Exception {
        logger.debug("tearDown called");

        super.tearDown();

        // do some tear down here
    }

    @Test
    public void testSmoke() {
        logger.debug("testSmoke called");

        // do some testing here
        assertNotNull("Expected a CheckGlobalFreezeCommand instance", command);
        assertNotNull("Expected a Freeze instance", freeze);
    }
}