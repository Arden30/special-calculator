package org.itmo.calculator;

import Commands.*;
import Exceptions.Error0;
import Exceptions.Error2;
import Exceptions.Error3;


public final class SpecialCalculator {
    private final CommandManager commandManager;
    private final long[] memory;
    private long res;
    public SpecialCalculator(int memoryCellsSize) {
        commandManager = new CommandManager(new AddCommand("+"),
                new MinusCommand("-"), new MultiplyCommand("*"),
                new DivisionCommand("/"), new ModCommand("%"),
                new PowCommand("^"), new DoublePlusCommand("++"),
                new DoubleMinusCommand("--"), new MultiplyDivCommand("*/"));
        if (memoryCellsSize >= 0 && memoryCellsSize < 101) memory = new long[memoryCellsSize];
        else memory = new long[0];
    }

    public String calculate(String expression) {
        long[] args = new long[6];
        String[] operations = new String[5];
        String[] str = expression.split(" ");
        for (int i = 0, j = 0, k = 0; i < str.length; i++) {
            if (i % 2 == 0) {
                try {
                    args[j] = Integer.parseInt(str[i]);
                } catch (NumberFormatException e) {
                    args[j] = memory[Integer.parseInt(str[i].substring(1))];
                }
                j++;
            }
            else {
                operations[k] = str[i];
                k++;
            }
        }
        for (int i = 0; i < operations.length && operations[i] != null; i++) {
            Command command = commandManager.getCommands().get(operations[i]);
            try {
                res = command.execute(args[i], args[i + 1]);
            } catch (Error0 | Error2 | Error3 e) {
                return e.getMessage();
            }
            args[i + 1] = res;
        }
        return Long.toString(res);
    }

    public String putLastResultInMemory(int memoryCellIndex) {
        if (memoryCellIndex < 0 || memoryCellIndex > memory.length - 1) {
            return "ERROR_1";
        } else {
            memory[memoryCellIndex] = res;
            return Long.toString(res);
        }
    }

    public String resetMemory(int memoryCellIndex) {
        if (memoryCellIndex < 0 || memoryCellIndex > memory.length - 1) {
            return "ERROR_1";
        } else {
            memory[memoryCellIndex] = 0;
            return "0";
        }
    }
}
