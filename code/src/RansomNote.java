public class RansomNote {
    public static void main(String[] args) {

        System.out.println(new RansomNote().canConstruct("aa","aab"));
        System.out.println(new RansomNote().canConstruct("aa","ab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {

        for(char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c);
            if( index == -1) {
                return false;
            }

            magazine = magazine.substring(0, index)+ magazine.substring(index + 1);
        }

        return true;

    }
}
