package com.hyxogen.reporter.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CommandRegister extends HashMap<Integer, ICommand> {

    public CommandRegister() {

    }

    public void registerCommand(ICommand command) {
        List<Integer> aliasHashes = new ArrayList<>();

        aliasHashes.add(command.getCommand().toLowerCase().hashCode());
        Arrays.asList(command.getAliases()).forEach(alias -> aliasHashes.add(alias.toLowerCase().hashCode()));

        for (int i = 0; i < aliasHashes.size(); i++)
            put(aliasHashes.get(i), command);
    }
}