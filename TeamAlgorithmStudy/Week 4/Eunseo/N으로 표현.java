import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;
        HashMap<Integer, HashSet<Integer>> dp = new HashMap<>();
        for (int i = 1; i <= 8; i++) 
            dp.put(i, new HashSet<>());
        for (int i = 1; i <= 8; i++) {
            int repeatedN = Integer.parseInt(String.valueOf(N).repeat(i));
            if (repeatedN == number) return i;
            dp.get(i).add(repeatedN);
        }

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(i - j)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);
                        }
                    }
                }
            }
            if (dp.get(i).contains(number)) return i;
        }

        return -1;
    }
}
