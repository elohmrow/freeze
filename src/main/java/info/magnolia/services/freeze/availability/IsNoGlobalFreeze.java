package info.magnolia.services.freeze.availability;

import info.magnolia.services.Freeze;
import info.magnolia.ui.api.availability.AbstractAvailabilityRule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class IsNoGlobalFreeze extends AbstractAvailabilityRule {
    private static final Logger log = LoggerFactory.getLogger(IsNoGlobalFreeze.class);

    protected Freeze freeze;

    @Inject
    public IsNoGlobalFreeze(Freeze freeze) {
        this.freeze = freeze;
    }

    protected boolean isAvailableForItem(Object itemId) {
        log.debug("checking for global freeze");
        return !freeze.isGlobalFreeze();
    }

}
