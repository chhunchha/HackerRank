import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class RansomNote {

    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public RansomNote(String magazine, String note) {
        magazineMap = new HashMap<>();
        StringTokenizer stk = new StringTokenizer(magazine, " ");
        while(stk.hasMoreElements()) {
            String word = stk.nextToken();

            int wordCount = magazineMap.containsKey(word) ? magazineMap.get(word) + 1 : 1;
            magazineMap.put(word, wordCount);
        }

        noteMap = new HashMap<>();
        stk = new StringTokenizer(note, " ");
        while(stk.hasMoreElements()) {
            String word = stk.nextToken();

            int wordCount = noteMap.containsKey(word) ? noteMap.get(word) + 1 : 1;
            noteMap.put(word, wordCount);
        }
    }

    public boolean solve() {

        for(String noteWord : noteMap.keySet()) {
            if(!magazineMap.containsKey(noteWord) || magazineMap.get(noteWord) < noteMap.get(noteWord)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String magazine = "give me one grand today night";
        String note = "give one grand today";

        RansomNote r = new RansomNote(magazine, note);
        System.out.println(r.solve());

        magazine = "apgo clm w lxkvg mwz elo bg elo lxkvg elo apgo apgo w elo bg";
        note = "elo lxkvg bg mwz clm w";

        r = new RansomNote(magazine, note);
        System.out.println(r.solve());

    }
}