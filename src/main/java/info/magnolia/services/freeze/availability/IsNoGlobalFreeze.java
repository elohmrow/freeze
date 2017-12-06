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
package info.magnolia.services.freeze.availability;

import info.magnolia.services.Freeze;
import info.magnolia.ui.api.availability.AbstractAvailabilityRule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * TBD.
 */
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
