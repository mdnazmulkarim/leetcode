package designanexpressiontreewithevaluatefunction;

public class ExpTree extends Node {

    public ExpTree() {

    }
    public ExpTree(int v) {
        value = v;
    }

    @Override
    public int evaluate() {
        if(right == null && left == null) {
            return getValue();
        }
        if(operator.equals("+")) {
            return left.evaluate() + right.evaluate();
        }
        if(operator.equals("-")) {
            return left.evaluate() - right.evaluate();
        }
        if(operator.equals("*")) {
            return left.evaluate() * right.evaluate();
        }
        if(operator.equals("/")) {
            return left.evaluate() / right.evaluate();
        }
        return 0;
    }
};
