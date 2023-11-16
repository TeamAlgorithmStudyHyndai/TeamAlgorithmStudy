package src.secondWeek.Eunsol;
import java.util.Arrays;
public class 단어변환 {

	private boolean[] visited;

    public int solution(String begin, String target, String[] words) {
         // target이 words 안에 없으면 변환 불가능
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        visited = new boolean[words.length];
        return transform(begin, target, words);
    }

    private int transform(String current, String target, String[] words) {
        if (current.equals(target)) {
             // 변환 필요 없음
            return 0;
        }

        int minSteps = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && canTransform(current, words[i])) {
                visited[i] = true;
                int steps = transform(words[i], target, words);
                if (steps != -1) {
                    minSteps = Math.min(minSteps, steps + 1);
                }
                 // 백트래킹
                visited[i] = false;
            }
        }

        return (minSteps == Integer.MAX_VALUE) ? -1 : minSteps;
    }

    private boolean canTransform(String word1, String word2) {
        // 한 번에 한 개의 알파벳만 바꿀 수 있으므로 한 글자만 다른지 확인
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        return diffCount == 1;
    }
}
