package ru.maskira;

import ru.maskira.exprCheckers.BracketsChecker;
import ru.maskira.superclasses.TreeCalculator;
import ru.maskira.treeCalculators.SimpleTreeCalculator;

public class Calculator {
    private Tree tree = new Tree();
    private String expression;
    private TreeCalculator calcTree;

    public Calculator(String expression) {
        this.expression = expression;
        tree.createTree(expression);
        calcTree = new SimpleTreeCalculator();
    }

    public Number getResult() {
        if (!checkExpr())
            return null;
        return calcTree.getResult(tree);
    }

    public boolean checkExpr() {
        if(!new BracketsChecker().check(expression))
            return false;
        return true;
    }
}
