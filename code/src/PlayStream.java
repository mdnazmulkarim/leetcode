import java.util.Arrays;
import java.util.List;

public class PlayStream {
    public static void main(String[] args) {
        testStream();
    }

    private static void testStream() {
        List<Integer> list = Arrays.asList(new Integer[] {1,5,25, 15});

        System.out.println(list.stream().max((i1,i2) -> i1.compareTo(i2)).get());
       Object[] arr =  list.stream().toArray();
       list.stream().map(i ->i*i).filter( i -> i%5 ==0).sorted().forEach(System.out::println);
    }
}
