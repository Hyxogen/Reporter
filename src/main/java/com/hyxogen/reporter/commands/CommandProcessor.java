package com.hyxogen.reporter.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandProcessor implements CommandExecutor {

    private CommandRegister register;

    public CommandProcessor(CommandRegister register) {
        this.register = register;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        ICommand iCommand = register.get(command.getName().toLowerCase().hashCode());

        if (iCommand != null)
            iCommand.execute(sender, args);
        return true;
    }
}
