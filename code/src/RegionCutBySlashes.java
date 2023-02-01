import java.util.*;

public class RegionCutBySlashes {
    public static void main(String []args){
        double a=0.1;
        double b=0.2;
        double c=a+b;
        System.out.println(c);
    }
    public int regionsBySlashes(String[] grid) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        map.put(1, new HashSet<>(List.of(2,6)));
        map.put(2, new HashSet<>(List.of(1,3)));
        map.put(3, new HashSet<>(List.of(2,8)));
        map.put(4, new HashSet<>());
        map.put(5, new HashSet<>());
        map.put(6, new HashSet<>(List.of(1,11)));
        map.put(7, new HashSet<>());
        map.put(8, new HashSet<>(List.of(3,13)));
        map.put(9, new HashSet<>());
        map.put(10, new HashSet<>());
        map.put(11, new HashSet<>(List.of(6,12)));
        map.put(12, new HashSet<>(List.of(11,13)));
        map.put(13, new HashSet<>(List.of(8,12)));

        for (String line : grid) {
            if(line.equals(" /")) {
                map.get(3).add(5);
                map.get(5).add(3);
                map.get(5).add(7);
                map.get(7).add(5);
            }
            if(line.equals("/")) {
                map.get(2).add(4);
                map.get(4).add(2);
                map.get(6).add(4);
                map.get(4).add(6);
            }
            if(line.equals("\\")) {
                map.get(1).add(4);
                map.get(4).add(1);
                map.get(4).add(7);
                map.get(7).add(4);
            }
            if(line.equals(" \\")) {
                map.get(2).add(5);
                map.get(5).add(2);
                map.get(5).add(8);
                map.get(8).add(5);
            }
        }

        return 0;
    }
}
