package info.magnolia.services;

import info.magnolia.module.ModuleLifecycle;
import info.magnolia.module.ModuleLifecycleContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Freeze implements ModuleLifecycle {

    private static final Logger logger = LoggerFactory.getLogger(Freeze.class);

    private boolean globalFreeze = false;
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
            return globalFreeze;
        }
    }

    public void setGlobalFreeze(boolean globalFreeze) {
        logger.info("Setting global freeze to {}", globalFreeze);

        if (this.globalFreeze == globalFreeze) {
            logger.info("Global freeze will not be changed, currently {}", globalFreeze);
        }

        synchronized (freezeSemaphore) {
            this.globalFreeze = globalFreeze;
        }
    }

    public boolean toggleGlobalFreeze() {
        logger.info("Toggling global freeze, current globa freeze = {}", globalFreeze);

        synchronized (freezeSemaphore) {

            globalFreeze = !globalFreeze;

            logger.debug("after toggle, global freeze = {}", globalFreeze);

            return globalFreeze;
        }
    }

}
