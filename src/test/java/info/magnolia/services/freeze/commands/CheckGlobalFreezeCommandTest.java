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

import info.magnolia.context.Context;
import info.magnolia.context.MgnlContext;
import info.magnolia.services.Freeze;
import info.magnolia.test.MgnlTestCase;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

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

    @Test
    public void testSimpleFreeze() {
        logger.debug("testSimpleFreeze called");

        assertFalse("expected no freeze", freeze.isGlobalFreeze());

        Context context = MgnlContext.getInstance();
        assertNotNull("Expected a Context instance", context);

        freeze.setGlobalFreeze(true);
        boolean result = command.execute(context);

        // remember condition is inverted
        assertFalse("expected a freeze", result);
    }

    @Test
    public void testMultiFreeze() {
        logger.debug("testMultiFreeze called");

        assertFalse("expected no freeze", freeze.isGlobalFreeze());

        Context context = MgnlContext.getInstance();
        assertNotNull("Expected a Context instance", context);

        boolean result;

        freeze.setGlobalFreeze(true);
        assertFalse("expected a freeze", command.execute(context));

        freeze.setGlobalFreeze(true);
        assertFalse("expected a freeze", command.execute(context));

        freeze.setGlobalFreeze(true);
        assertFalse("expected a freeze", command.execute(context));

        freeze.setGlobalFreeze(false);
        assertFalse("still expected a freeze", command.execute(context));

        freeze.setGlobalFreeze(false);
        assertFalse("still expected a freeze", command.execute(context));

        freeze.setGlobalFreeze(false);
        assertTrue("did not expect a freeze", command.execute(context));
    }
}