package disjointset;

public class NoOfProvinces {
    public static void main(String[] args) {
     int[][] arr = new int[][]{

             {1,0,0}, {0,1,0}, {0,0,1}
             /*
             {1,0,0,1},
             {0,1,1,0},
             {0,1,1,1},
             {1,0,1,1}
             */

     };
        System.out.println(new NoOfProvinces().findCircleNum(arr));
    }

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        UnionFind dsu = new UnionFind(n);
        int numberOfComponents = n;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1 && dsu.findParent(i) != dsu.findParent(j)) {
                    numberOfComponents--;
                    dsu.union(i, j);
                }
            }
        }

        return numberOfComponents;
    }

        /*
        UnionFind uf = new UnionFind(isConnected.length);
        // 1-2-5-6-7 3-8-9 4

        for(int i =0; i< isConnected.length; i++) {
            for (int j=i ; j< isConnected.length; j++) {
                if(isConnected[i][j] ==1 && i != j) {
                    uf.union(i, j);
                }
            }
        }

        */

    }

//    public int findCircleNum(int[][] isConnected) {
//
//        Map<Integer, Set<Integer>> map = new HashMap<>();
//
//        for(int i=0; i < isConnected.length; i++) {
//            for(int j =0; j < isConnected[i].length; j++) {
//                if(isConnected[i][j] == 1){
//                if(map.containsKey(i) || map.containsKey(j))  {
//                    Set<Integer> set = map.get(i) != null? map.get(i) : map.get(j) ;
//
//                    if( i==j ) {
//                        if (map.get(i) != null) {
//                            set.addAll(map.get(i));
//                        }
//                        map.put(i,set);
//                    } else {
//                        if (map.get(i) != null) {
//                            set.addAll(map.get(i));
//                        }
//                        if (map.get(j) != null) {
//                            set.addAll(map.get(j));
//                        }
//                        if(!map.containsKey(j)) {
//                            map.put(j, set);
//                        }
//                        map.put(i, set);
//                    }
//                    }
//                  else {
//                    Set<Integer> set = new HashSet<>();
//                    if (map.get(i) != null) {
//                        set.addAll(map.get(i));
//                    }
//                    if (map.get(j) != null) {
//                        set.addAll(map.get(j));
//                    }
//                    map.put(i, set);
//                    map.put(j, set);
//                }
//                }
//            }
//        }
//
//        Set<Integer> set = new HashSet<>();
//
//        map.values().stream().forEach(s -> {
//            System.out.println(s.size()+"|"+ s.hashCode()+ Arrays.toString(s.toArray()));
//            set.add(s.hashCode());
//        });
//
//        return set.size();
//    }



