package info.magnolia.services.freeze.commands;

import info.magnolia.commands.MgnlCommand;

import info.magnolia.context.Context;
import info.magnolia.services.Freeze;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class CheckGlobalFreezeCommand extends MgnlCommand {

    private static final Logger logger = LoggerFactory.getLogger(CheckGlobalFreezeCommand.class);

    private Freeze freeze;

    @Inject
    public CheckGlobalFreezeCommand(Freeze freeze) {
        this.freeze = freeze;
    }

    @Override
    public boolean execute(Context context) {
        logger.debug("execute({}) called", context);

        logger.debug("current: globalFreeze = {}", freeze.isGlobalFreeze());

        return !freeze.isGlobalFreeze();
    }

}
