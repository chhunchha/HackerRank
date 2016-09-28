import java.util.HashMap;
import java.util.Map;

/**
 * Created by chhunchha on 9/28/16.
 */
public class MakingAnagram {

    //doesn't work
//    public static int numberNeeded(String first, String second) {
//        StringBuilder first_sb = new StringBuilder(first);
//        StringBuilder second_sb = new StringBuilder(second);
//        int delete_count = 0;
//        for(int i = 0 ; i < first_sb.length(); i++) {
//            if (second_sb.indexOf(first_sb.charAt(i) + "") == -1) {
//                first_sb.deleteCharAt(i);
//                i--;
//                delete_count++;
//            }
//        }
//        for(int i = 0 ; i < second_sb.length(); i++) {
//            if(first_sb.indexOf(second_sb.charAt(i)+"") == -1) {
//                second_sb.deleteCharAt(i);
//                i--;
//                delete_count++;
//            }
//        }
//        return delete_count++;
//    }

    // trying map
    public static int numberNeeded(String first, String second) {
        Map<Character, Integer> first_map = new HashMap<>();
        Map<Character, Integer> second_map = new HashMap<>();

        //creating character count maps for both strigs
        for(int i = 0 ; i < first.length(); i++) {
            char c = first.charAt(i);
            int number_of_chars = first_map.containsKey(c) ? first_map.get(c) + 1 : 1;
            first_map.put(first.charAt(i), number_of_chars);
        }

        for(int i = 0 ; i < second.length(); i++) {
            char c = second.charAt(i);
            int number_of_chars = second_map.containsKey(c) ? second_map.get(c) + 1 : 1;
            second_map.put(second.charAt(i), number_of_chars);
        }

        // going through chars from first string
        // if second string doesn't contain then all need to be deleted
        // if second string has character but count is different that absolute difference need to be deleted
        // if equal number of character count then no need to delete anything.
        int delete_count = 0;
        for( Character key : first_map.keySet()) {
            if(!second_map.containsKey(key)) {
                delete_count += first_map.get(key);
            } else if(second_map.get(key) != first_map.get(key)) {
                delete_count += Math.abs(second_map.get(key) - first_map.get(key));
            }
        }

        // for second map - only need to look for characters which are not present in first string
        // character with different number of count has already been considered in first run.
        for(Character key : second_map.keySet()) {
            if(!first_map.containsKey(key)) {
                delete_count += second_map.get(key);
            }
        }
        return delete_count;
    }

    public static void main(String args[]){
        String first;
        String second;

        first = "fcrxzwscanmligyxyvym";
        second = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        System.out.println(numberNeeded(first, second));
    }
}
