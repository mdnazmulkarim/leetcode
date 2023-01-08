

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfaPhoneNumber {



    public List<String> letterCombinations(String digits) {
        Map<Character, List<String>> map = new HashMap<>();

        map.put('2', List.of("a", "b", "c"));
        map.put('3', List.of("d", "e", "f"));
        map.put('4', List.of("g", "h", "i"));
        map.put('5', List.of("j", "k", "l"));
        map.put('6', List.of("m", "n", "o"));
        map.put('7', List.of("p", "q", "r", "s"));
        map.put('8', List.of("t", "u", "v"));
        map.put('9', List.of( "w", "x", "y", "z" ));

        List<String> list = new ArrayList<>();

        if (digits.length() > 0) {
            
            if(digits.length() == 1) {
                list.addAll(map.get(digits.charAt(0)));
            } else {
                List<List<String>> lists = new ArrayList<>();
                List<Integer> indexList = new ArrayList<>();

                int total = 1;
                int currentTotal = 1;

                for(int i=0; i< digits.length(); i++) {
                    lists.add(map.get(digits.charAt(i)));
                    indexList.add(1);
                    total = total * map.get(digits.charAt(i)).size();
                }


                while (currentTotal < total) {
                    StringBuffer stringBuffer = new StringBuffer();

                    for(int index = 0; index < indexList.size(); index++) {
                        stringBuffer.append(lists.get(index).get(indexList.get(index)));
                        indexList.set(index, (indexList.get(index)+1)% lists.get(index).size());
                    }

                    currentTotal = calculateTotal(indexList);
                }
            }
        }
        return list;

    }

    private int calculateTotal(List<Integer> indexList) {

        int currentTotal = indexList.stream().mapToInt(i -> i).reduce(1, (a, b) -> a * b);
        return currentTotal;
    }

//    private String getString(List<List<String>> lists,  List<Integer> indexList) {
//
//
//    }

}
