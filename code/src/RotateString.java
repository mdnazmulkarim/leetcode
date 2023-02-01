public class RotateString {
    public static void main(String[] args) {
        System.out.println(new RotateString().rotateString("abcde","bcdea"));
        System.out.println(new RotateString().rotateString("abcde","abced"));
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int i=0;
        while(i< goal.length()) {
            int j = i;
            int k=0;
            while(goal.charAt(k) == s.charAt(j) && k < goal.length()) {

                j++;
                k++;
                if(j == s.length()) {
                    j = 0;
                }
                if(k == goal.length()) {
                    return true;
                }
            }
            i++;
        }

        return false;
    }
}
