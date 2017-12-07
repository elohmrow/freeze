# freeze

The Freeze module provides commands for managing a global freeze flag. You can set the global flag and unset it as well.

The CheckGlobalFreezeCommand command (info.magnolia.services.freeze.commands.CheckGlobalFreezeCommand) can be added to a command chain to interrupt the execution of the commands if a global freeze in place.

The Freeze module is useful in implementing a global publication freeze on a Magnolia author instance if you add CheckGlobalFreeCommand to command chains doing activation.

A freeze can be cumulative: successive calls to freeze-startGlobalFreeze (see below) must be followed by the same number of calls to the freeze-stopGlobalFreeze (see below) before the freeze is lifted.

For example:

1. freeze-startGlobalFreeze called (freeze starts, freeze-checkGlobalFreeze returns false)
2. freeze-startGlobalFreeze called (freeze continues, freeze-checkGlobalFreeze returns false)
3. freeze-startGlobalFreeze called (freeze continues, freeze-checkGlobalFreeze returns false)
4. freeze-stopGlobalFreeze called (freeze continues, freeze-checkGlobalFreeze still returns false)
5. freeze-stopGlobalFreeze called (freeze continues, freeze-checkGlobalFreeze still returns false)
6. freeze-stopGlobalFreeze called (freeze ended! freeze-checkGlobalFreeze returns true)

You can override and end an on-going freeze by calling freeze-stopGlobalFreeze with the "force" parameter set to true no matter how many times freeze-startGlobalFreeze has been called.

This interaction between freeze-startGlobalFreeze and freeze-stopGlobalFreeze can be useful when a freeze is started by different sources and can prevent a premature end to a freeze until all sources are done.

## Installation

Add a dependency for the freeze module to your web app Maven pom file:

```
<dependency>
  <groupId>info.magnolia.services</groupId>
  <artifactId>freeze</artifactId>
  <version>(current freeze module version)</version>
</dependency>
```

## Usage

The following commands are defined by the freeze module:

**freeze-startGlobalFreeze**
**freeze-stopGlobalFreeze**
**freeze-toggleGlobalFreeze**
**freeze-checkGlobalFreeze**

**freeze-startGlobalFreeze** start a global freeze, or continue a global freeze. If called multiple times without a corresponding calls to freeze-stopGlobalFreeze or freeze-toggleGlobalFreeze, the freeze will in place until the same number of calls to freeze-stopGlobalFreeze are executed or a single call to freeze-toggleGlobalFreeze is made.

**freeze-stopGlobalFreeze** attempts to stop a global freeze. The following attributes in the command context will be used:

  * *force* (optional) - forces the global freeze to end no matter how many times freeze-startGlobalFreeze.

**freeze-toggleGlobalFreeze** will start a global freeze if a freeze is not active or end a global freeze is one is currently active. Note that toggleGlobalFreeze will always start or stop a freeze, even if a freeze has been invoked by multiple sources.

**freeze-checkGlobalFreeze** will return **false** if a global freeze is active and **true** if not. You can use this command in command chains to check if a global freeze is in place.

## Information on Magnolia CMS


## License


## Contributors

Andrew Warinner
Senior Solution Architect
Magnolia
