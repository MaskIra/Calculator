package ru.maskira;

import ru.maskira.superclasses.Operation;

public class Node<T extends Number> {
    private Node parent;
    private Node left;
    private Node right;
    private T value;
    private Operation operation;

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Node() {
        this.parent = null;
        this.left = null;
        this.right = null;
        this.value = null;
        this.operation = null;
    }

    public Node(Node parent) {
        this();
        this.parent = parent;
    }

    public Node(Node parent, T value) {
        this();
        this.parent = parent;
        this.value = value;
    }

    public Node(Node parent, Node left, Node right, T value) {
        this.parent = parent;
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public boolean isWithChildsLeafs() {
        return !isLeaf() && left.isLeaf() && right.isLeaf();
    }
}