import java.util.*;
class Solution {
    static String[] res;
    static int[] check;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        Arrays.sort(tickets, (o1,o2) ->
                    o1[0].equals("ICN") && o2[0].equals("ICN")? //둘 다 인천 출발이면 도착지 알파벳 순
                    (o1[1].compareTo(o2[1])) : 
                    o1[0].equals("ICN") && !o2[0].equals("ICN") ?
                    -1 :
                    o2[0].equals("ICN") && !o1[0].equals("ICN") ?
                    1 :
                    o1[0].equals(o2[0]) ?
                    (o1[1].compareTo(o2[1])):
                    (o1[0].compareTo(o2[0]))
                   );
        for(int i =0; i< tickets.length; i++){
            check = new int[tickets.length];
            res = new String[tickets.length + 1];
            check[i] = 1;
            res[0] = "ICN";
            res = dfs(tickets, tickets[i][1], 1);
            if(res[tickets.length] != null) break;
        }

        return res;
    }
    public static String[] dfs(String[][] tickets, String city, int idx){
        for(int i =0; i< tickets.length; i++){
            if(check[i] == 0 && tickets[i][0].equals(city)){
                check[i] = 1;
                res[idx] = tickets[i][0];
                if(idx == tickets.length - 1) res[idx + 1] = tickets[i][1];                    
                if(res[tickets.length] != null) break;
                dfs(tickets, tickets[i][1], idx + 1);
                check[i] = 0;
            } 
        }        
        return res;
    }
}