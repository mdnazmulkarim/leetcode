public class IndexOfFirstOccurance {
    public static void main(String[] args) {
        System.out.println(new IndexOfFirstOccurance().strStr("mississippi", "issip"));
       // System.out.println(new IndexOfFirstOccurance().strStr("sadstorysad", "sad"));
       // System.out.println(new IndexOfFirstOccurance().strStr("programming", "leeto"));
    }

    public int strStr(String haystack, String needle) {
        int i=0;
        while(i<haystack.length()) {
            int j=i;
            int k = 0;
            while(j < haystack.length() && haystack.charAt(j) == needle.charAt(k) && k < needle.length()) {
                j++;
                k++;
                if(k == needle.length()){
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
}
