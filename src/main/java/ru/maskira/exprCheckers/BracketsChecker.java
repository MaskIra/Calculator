package ru.maskira.exprCheckers;

import ru.maskira.superclasses.ExprChecker;

public class BracketsChecker implements ExprChecker {
    @Override
    public boolean check(String expression) {
        int count = 0;

        for (char c : expression.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            if (count < 0) return false;
        }

        return count == 0;
    }
}
