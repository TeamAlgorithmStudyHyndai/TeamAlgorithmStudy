import java.util.*;

class Solution {
    static boolean[] check;
    static String[] ans;
    static int n;

    public String[] solution(String[][] tickets) {
        n = tickets.length;
        ans = new String[n + 1];
        check = new boolean[n];

        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].toString().contentEquals(o2[0].toString()))
                    return o1[1].toString().compareTo(o2[1].toString());
                else
                    return o1[0].toString().compareTo(o2[0].toString());
            }
        });

        for (int i = 0; i < n; i++) {
            if (tickets[i][0].equals("ICN")) {
                ans[0] = tickets[i][0];
                ans[1] = tickets[i][1];
                check[i] = true;
                dfs(1, tickets);
                if (ans[n] != null) {
                    return ans; // 수정: 함수에서 정상적으로 반환
                }
                check[i] = false;
            }
        }

        return ans;
    }

    public static void dfs(int depth, String[][] tickets) {
        if (depth == n) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!check[i] && ans[depth].equals(tickets[i][0])) {
                check[i] = true;
                ans[depth + 1] = tickets[i][1];
                dfs(depth + 1, tickets);
                if (ans[n] != null) {
                    return;
                }
                check[i] = false;
            }
        }
    }
}