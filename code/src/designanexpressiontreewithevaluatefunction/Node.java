package designanexpressiontreewithevaluatefunction;

abstract class Node {
    public abstract int evaluate();
    // define your fields here
    int value;
    Node left;
    Node right;
    String operator;

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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getValue() {
        return value;
    }
}
