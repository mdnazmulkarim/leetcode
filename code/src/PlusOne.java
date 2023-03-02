import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public static void main(String[] args) {

       // int[] arr = new int[]{9,9,9};
        int[] arr = new int[]{9,8,7,6,5,4,3,2,1,0};
        System.out.println(new PlusOne().plusOne(arr));
    }
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            if ((digits[i] + carry) == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = digits[i] + carry;
                carry = 0;
            }


        }
        if (carry == 0) {
            return digits;
        } else {
            digits = new int[n + 1];
            digits[0] = 1;
            return digits;
        }

//        int i = digits.length-1;
//        long num = 0;
//        int k=0;
//        while(i>=0) {
//            num = num + digits[i] * (long)Math.pow(10,k);
//            System.out.println(num);
//            k++;
//            i--;
//        }
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(num);
//        num++;
//
//
//        ArrayList<Long> list = new ArrayList<>();
//       while(num>0) {
//           long d = num%10;
//           num = num -d;
//           num = num/10;
//           list.add(0,d);
//       }
//        System.out.println(list);
//
//       int[] arr = new int[list.size()];
//
//       for(int j=0; j< list.size(); j++) {
//           arr[j] = list.get(j).intValue();
//       }
//
//       return arr;

    }
}
