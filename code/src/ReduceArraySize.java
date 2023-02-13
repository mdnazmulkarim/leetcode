import java.util.*;

//https://programming.com/problems/reduce-array-size-to-the-half/description/

class ReduceArraySize {

    public static void main(String[] args) {

        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        System.out.println(new ReduceArraySize().minSetSize(arr));
    }
    public int minSetSize(int[] arr) {

        Map<Integer, ArrayItem> map = new HashMap<Integer, ArrayItem>();

        for(int i : arr) {
            if(map.containsKey(i)) {
                ArrayItem item = map.get(i);
                item.setFrequency(item.getFrequency() + 1);
                map.put(i, item);
            } else {
                map.put(i, new ArrayItem(i, 1));
            }
        }

        List<ArrayItem> list = new ArrayList<ArrayItem> (map.values());

        Collections.sort(list, new SortByFrequency());

        int count = 0;
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            sum = sum + list.get(i).getFrequency();
            count++;
            if(sum >= (arr.length)/2) {
                break;
            }
        }

        return count;
    }

    class ArrayItem {

        int value;
        int frequency;

        public ArrayItem(int val, int freq) {
            this.value = val;
            this.frequency = freq;
        }

        public int getValue() { return this.value; }
        public void setValue( int val) { this.value = val; }

        public int getFrequency() { return this.frequency; }
        public void setFrequency( int freq) { this.frequency = freq; }
    }

    class SortByFrequency implements Comparator<ArrayItem> {

        public int compare(ArrayItem a, ArrayItem b) {
            return b.frequency - a.frequency;
        }
    }
}


