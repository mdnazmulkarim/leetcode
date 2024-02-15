public class MergeAlternately {
    public static void main(String[] args) {

        System.out.println(new MergeAlternately().mergeAlternately("abcd", "pq"));
    }
    public String mergeAlternately(String word1, String word2) {

        int count = Math.max(word1.length(), word2.length());
        char[] arr = new char[word1.length() + word2.length()];

        int i=0;
        int j=0;
        while(i<count) {
            if(i < word1.length()) {
                arr[j++] = word1.charAt(i);
            }
            if(i < word2.length()) {
                arr[j++] = word2.charAt(i);
            }
            i++;
        }
        return String.valueOf(arr);
    }
}
