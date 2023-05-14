package designanexpressiontreewithevaluatefunction;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
            int numRows = 5;
            new PascalTriangle().generate(numRows);
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i< numRows; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                if(i==0 && j==0) {
                    l.add(1);
                } else if(i>=1) {
                    l.add(getValue(list.get(i - 1),j - 1) + getValue(list.get(i - 1), j));
                }
            }
            list.add(l);
        }
        return list;
    }

    private int getValue(List<Integer> list, int pos) {
        if(pos <0 || pos>= list.size()) {
            return 0;
        } else {
            return list.get(pos);
        }
    }
}
