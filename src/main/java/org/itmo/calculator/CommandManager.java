package org.itmo.calculator;

import Commands.Command;

import java.util.HashMap;

public class CommandManager {
    public static HashMap<String, Command> commandManager = new HashMap<>();
    public CommandManager(Command ...commands) {
        for (Command command: commands) {
            commandManager.put(command.getName(), command);
        }
    }
    public HashMap<String, Command> getCommands() {
        return commandManager;
    }
}
