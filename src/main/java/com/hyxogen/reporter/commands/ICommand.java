package com.hyxogen.reporter.commands;

import org.bukkit.command.CommandSender;

public interface ICommand {

    void execute(CommandSender sender, String[] args);

    String getCommand();

    String[] getAliases();
}