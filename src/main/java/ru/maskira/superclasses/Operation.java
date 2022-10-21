package ru.maskira.superclasses;

import ru.maskira.operations.*;

import java.util.Collections;
import java.util.HashMap;

public abstract class Operation {
    public abstract Number execute(Number operand1, Number operand2);

    public static char doubleNumDelimiter = '.';
    private static HashMap<Character, Integer> binaryOperationPriority = new HashMap<>();
    static {
        binaryOperationPriority.put('+', 1);
        binaryOperationPriority.put('-', 1);
        binaryOperationPriority.put('*', 2);
        binaryOperationPriority.put('/', 2);
        binaryOperationPriority.put('\\', 2);
    }

    public static Operation getOperation(char operation){
        switch (operation){
            case '+':
                return new AddOperation();
            case '-':
                return new SubOperation();
            case '*':
                return new MulOperation();
            case '/':
            case '\\':
                return new DivOperation();
        }
        return null;
    }

    public static Integer getBinaryPriority(Character operation){
        return binaryOperationPriority.get(operation);
    }

    public static int getMaxBinaryPriority(){
        return Collections.max(binaryOperationPriority.values());
    }
}
