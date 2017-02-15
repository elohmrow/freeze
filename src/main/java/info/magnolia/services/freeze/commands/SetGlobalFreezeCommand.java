package info.magnolia.services.freeze.commands;

import info.magnolia.commands.MgnlCommand;
import info.magnolia.context.Context;

import info.magnolia.services.Freeze;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class SetGlobalFreezeCommand extends MgnlCommand {

    private static final Logger logger = LoggerFactory.getLogger(SetGlobalFreezeCommand.class);

    private Freeze freeze;
    private boolean freezeValue;

    @Inject
    public SetGlobalFreezeCommand(Freeze freeze) {
        this.freeze = freeze;
    }

    @Override
    public boolean execute(Context context) {
        logger.debug("execute({}) called", context);

        logger.debug("before: globalFreeze = {}", freeze.isGlobalFreeze());

        freeze.setGlobalFreeze(freezeValue);

        logger.debug("after: globalFreeze = {}", freeze.isGlobalFreeze());

        return true;
    }

    public void setFreezeValue(boolean freezeValue) {
        this.freezeValue = freezeValue;
    }

}
