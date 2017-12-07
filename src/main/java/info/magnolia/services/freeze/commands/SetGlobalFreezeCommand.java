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

import info.magnolia.commands.MgnlCommand;
import info.magnolia.context.Context;

import info.magnolia.services.Freeze;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * TBD.
 */
public class SetGlobalFreezeCommand extends MgnlCommand {

    private static final Logger logger = LoggerFactory.getLogger(SetGlobalFreezeCommand.class);

    private Freeze freeze;
    private boolean freezeValue;
    private boolean force = false;

    @Inject
    public SetGlobalFreezeCommand(Freeze freeze) {
        this.freeze = freeze;
    }

    @Override
    public boolean execute(Context context) {
        logger.debug("execute({}) called", context);

        logger.debug("before: globalFreeze = {}", freeze.isGlobalFreeze());

        freeze.setGlobalFreeze(freezeValue, force);

        logger.debug("after: globalFreeze = {}", freeze.isGlobalFreeze());

        return true;
    }

    public void setFreezeValue(boolean freezeValue) {
        this.freezeValue = freezeValue;
    }

    public void setForce(boolean force) {
        this.force = force;
    }
}
