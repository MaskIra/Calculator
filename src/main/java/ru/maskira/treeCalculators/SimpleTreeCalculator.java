package ru.maskira.treeCalculators;

import ru.maskira.Node;
import ru.maskira.ExprTree;
import ru.maskira.superclasses.Operation;
import ru.maskira.superclasses.TreeCalculator;

public class SimpleTreeCalculator implements TreeCalculator {
    @Override
    public Number getResult(ExprTree exprTree) {

        Node curNode = exprTree.getRoot();
        while (!curNode.isLeaf()) {
            calcTree(curNode);
        }
        return curNode.getValue();
    }

    // recursion
    private void calcTree(Node root) {
        if (root.isWithChildsLeafs()) {
            Operation operation = root.getOperation();
            root.setValue(operation.execute(root.getLeft().getValue(), root.getRight().getValue()));
            root.setLeft(null);
            root.setRight(null);
            root.setOperation(null);
        }
        if (!root.isLeaf()) {
            calcTree(root.getLeft());
            calcTree(root.getRight());
        }
    }
}
