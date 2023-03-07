import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Permutations {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        new Permutations().permute(arr);
    }

    public List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> list = new ArrayList<>();

        Queue<Item> queue = new LinkedList<>();

        Item item = new Item();
        for(int i=0; i<nums.length; i++) {
            item.addOptions(nums[i]);
        }
        queue.add(item);

        while(!queue.isEmpty()) {
            Item actingItem = queue.remove();
            //System.out.println(actingItem.list);
            if(actingItem.options.size() == 0) {
                list.add(actingItem.list);
            } else {
                AtomicInteger index = new AtomicInteger();
                actingItem.options.forEach(i ->{
                    Item newItem = new Item();
                    newItem.addList(actingItem.list);
                    newItem.add(i);
                    newItem.addOptions(actingItem.options);
                    newItem.remove(index.get());
                    queue.add(newItem);
                    index.getAndIncrement();
                });
            }
        }
        System.out.println(list);
      return list;
    }


    class Item {
        List<Integer> list;
        List<Integer> options;

        Item() {
            list = new ArrayList<>();
            options = new ArrayList<>();
        }

        Item add(int i) {
            if(list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            return this;
        }

        Item addList(List<Integer> l) {
            if(list == null) {
                list = new ArrayList<>();
            }
            list.addAll(l);
            return this;
        }

        Item addOptions(int i) {
            if(options == null) {
                options = new ArrayList<>();
            }
            options.add(i);
            return this;
        }

        Item addOptions(List<Integer> l) {
            if(options == null) {
                options = new ArrayList<>();
            }
            options.addAll(l);
            return this;
        }

        void remove(int i) {
            if (options != null && options.size() > 0) {
                options.remove(i);
            }
        }
    }
}
