package designanexpressiontreewithevaluatefunction;


import java.util.Stack;

class TreeBuilder {
    Node buildTree(String[] postfix) {
        //["3","4","+","2","*","7","/"]
        //{"4","5","2","7","+","-","*"}

        Stack<Node> stack = new Stack<Node>();
        Node node = null;
        if(postfix.length == 1) {
            stack.push(new ExpTree(Integer.parseInt(postfix[0])));
        }

        int i = 0;

        while(i< postfix.length) {

            if(postfix[i].equals("+") || postfix[i].equals("-") || postfix[i].equals("*") || postfix[i].equals("/")) {
                Node temp = new ExpTree();
                temp.setOperator(postfix[i]);

                temp.right = stack.pop();
                temp.left = stack.pop();
                stack.push(temp);
            } else {
                stack.push(new ExpTree(Integer.parseInt(postfix[i])));

            }

            i++;

        }

        return stack.pop();
    }
}
