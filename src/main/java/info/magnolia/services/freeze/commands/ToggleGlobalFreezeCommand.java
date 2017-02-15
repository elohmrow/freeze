package info.magnolia.services.freeze.commands;

import info.magnolia.commands.MgnlCommand;
import info.magnolia.context.Context;

import info.magnolia.services.Freeze;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class ToggleGlobalFreezeCommand extends MgnlCommand {

    private static final Logger logger = LoggerFactory.getLogger(ToggleGlobalFreezeCommand.class);

    private Freeze freeze;

    @Inject
    public ToggleGlobalFreezeCommand(Freeze freeze) {
        this.freeze = freeze;
    }

    @Override
    public boolean execute(Context context) {
        logger.debug("execute({}) called", context);

        logger.debug("before: globalFreeze = {}", freeze.isGlobalFreeze());

        freeze.toggleGlobalFreeze();

        logger.debug("after: globalFreeze = {}", freeze.isGlobalFreeze());

        return true;
    }

}
