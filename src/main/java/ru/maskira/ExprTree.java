package ru.maskira;

import ru.maskira.superclasses.ExprPreparation;
import ru.maskira.superclasses.Operation;

import java.util.regex.Pattern;

public class ExprTree<T extends Number> {
    private Node root;

    public ExprTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void createTree(String expression) {
        root = createTree(expression, null);
    }

    // recursion
    // expression without spaces
    private Node createTree(String expression, Node parent) {
        System.out.println(" [] " + expression);
        if (expression == null) return null;

        Node newNode = new Node(parent);
        String clearExpression = ExprPreparation.removeBrackets(expression);
        if (ExprPreparation.isNum(clearExpression)) {
            newNode.setValue(Double.valueOf(clearExpression));
        } else {
            int idx = getMinPriorityIdx(expression);
            newNode.setOperation(Operation.getOperation(expression.charAt(idx)));
            newNode.setLeft(createTree(expression.substring(0, idx), newNode));
            newNode.setRight(createTree(expression.substring(++idx), newNode));
        }

        return newNode;
    }
    private int getMinPriorityIdx(String str) {
        int idx = -1;
        int minPriority = 10;
        int minPriorityIdx = 0;
        int curPriority = 0;
        int shift = Operation.getMaxBinaryPriority();

        for (char c : str.toCharArray()) {
            idx++;
            if (c == '(') {
                curPriority += shift;
                continue;
            }
            if (c == ')') {
                curPriority -= shift;
                continue;
            }
            Integer prior = Operation.getBinaryPriority(c);
            if (prior != null) {
                int cur = prior + curPriority;
                if (cur <= minPriority) {
                    minPriority = cur;
                    minPriorityIdx = idx;
                }
                continue;
            }
        }

        return minPriorityIdx;
    }
}
