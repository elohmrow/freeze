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
package info.magnolia.services;

import info.magnolia.module.ModuleLifecycle;
import info.magnolia.module.ModuleLifecycleContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * .
 */
public class Freeze implements ModuleLifecycle {

    private static final Logger logger = LoggerFactory.getLogger(Freeze.class);

    private int freezeCount = 0;
    private Object freezeSemaphore = new Object();

    @Override
    public void start(ModuleLifecycleContext moduleLifecycleContext) {
        logger.debug("****************************************");
        logger.debug("***  starting Freeze module!!!       ***");
        logger.debug("****************************************");
    }

    @Override
    public void stop(ModuleLifecycleContext moduleLifecycleContext) {
        logger.debug("****************************************");
        logger.debug("***  stopping Freeze module!!!       ***");
        logger.debug("****************************************");
    }

    public boolean isGlobalFreeze() {
        synchronized (freezeSemaphore) {
            return freezeCount > 0;
        }
    }

    public void setGlobalFreeze(boolean globalFreeze) {
        setGlobalFreeze(globalFreeze, false);
    }

    public void setGlobalFreeze(boolean globalFreeze, boolean force) {
        logger.info("Setting global freeze to {}", globalFreeze);

        synchronized (freezeSemaphore) {
            if (force) {
                if (globalFreeze) {
                    ++freezeCount;
                } else {
                    freezeCount = 0;
                }
            } else {
                freezeCount += (globalFreeze) ? 1 : -1;
            }

            if (freezeCount < 0) {
                logger.info("freezeCount is {}, this strange", freezeCount);
                freezeCount = 0;
            }
        }
    }

    public boolean toggleGlobalFreeze() {
        logger.info("Toggling global freeze, current globa freeze = {}", freezeCount);

        synchronized (freezeSemaphore) {
            freezeCount = (freezeCount > 0) ? 0 : 1;
            return freezeCount > 0;
        }
    }

}
