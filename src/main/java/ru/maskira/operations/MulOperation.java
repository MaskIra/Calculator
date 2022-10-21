package ru.maskira.operations;

import ru.maskira.superclasses.Operation;

public class MulOperation extends Operation {
    @Override
    public Number execute(Number operand1, Number operand2) {
        return operand1.doubleValue() * operand2.doubleValue();
    }
}