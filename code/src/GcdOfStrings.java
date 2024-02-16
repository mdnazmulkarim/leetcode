public class GcdOfStrings {
    public static void main(String[] args) {
        System.out.println(new GcdOfStrings().gcdOfStrings("ABABAB","ABAB"));
        System.out.println(new GcdOfStrings().gcdOfStringsAnotherApproach("ABABABAB","ABAB"));
    }

    public String gcdOfStrings(String str1, String str2) {

        if((str1+str2).equals(str2+str1)) {
            return str1.substring(0,gcd(str1.length(), str2.length()));
        }

        return "";
    }

    public String gcdOfStringsAnotherApproach(String str1, String str2) {

       int min  = Math.min(str1.length(), str2.length());


        while (min > 0) {
            String str = str1.substring(0, min);
            if (str1.replace(str, "").isEmpty() &&
                    str2.replace(str, "").isEmpty()) {
                return str1.substring(0, min);
            }
            min--;
        }

        return "";
    }

    public int gcd(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return gcd(y, x % y);
        }
    }
}
