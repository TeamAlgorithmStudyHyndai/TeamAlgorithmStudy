import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    static boolean usedTickets[]; // 티켓 사용 여부

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        usedTickets = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(list); // 알파벳 순 정렬
        answer = list.get(0).split(" ");
        return answer;
    }
    
    static void dfs(int depth, String now, String path, String[][] tickets)
    {
        if (depth == tickets.length) 
        {
            list.add(path);
            return;
        }

        for (int i = 0; i < usedTickets.length; i++) 
        {
            if (!usedTickets[i] && now.equals(tickets[i][0])) 
            {
                usedTickets[i] = true;
                dfs(depth + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                usedTickets[i] = false;
            }
        }
    
    }
}
