package com.hyxogen.reporter.commands;

import org.bukkit.command.CommandSender;

interface ICommand {

    String getCommand();

    default String[] getAliases() {
        return new String[0];
    }

    default String[] getPermissions() {
        return new String[0];
    }

    default short getMinArgs() {
        return 0;
    }

    default short getMaxArgs() {
        return Short.MAX_VALUE;
    }

    default Class<? extends CommandSender> getAllowedSenders() {
        return CommandSender.class;
    }

    void execute(CommandSender sender, String[] args);
}