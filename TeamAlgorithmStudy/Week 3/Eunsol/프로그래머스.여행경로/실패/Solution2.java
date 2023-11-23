import java.util.*;
public class Solution2 {
    boolean [] visited;
    List<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        
         // 2차원 배열(String) 오름차순 정렬
        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[0].equals(o2[0])) {
                    return o1[1].compareTo(o2[1]);
                } else {
                    return o1[0].compareTo(o2[0]);
                }
            }
        });
        
        //출발지 ICN list에 add
        list.add("ICN");
        //출발지를 기준으로 길찾기
        findRoute("ICN",0,tickets.length, tickets);
        
        answer = list.toArray(new String[list.size()]);
        return answer;
    }
    public void findRoute( String departure, int currentDepth, int totalDepth, String[][] tickets){
        if(currentDepth == totalDepth)
            return;
        
       for(int i = 0 ; i <tickets.length;i++ ){
           //출발지가 같고, 같은 행의 출발지를 방문하지 않은 경우
            if(! visited[i] && departure.equals(tickets[i][0])){
                visited[i]= true;
                list.add(tickets[i][1]);
                //도착지를 다시 출발지로 설정
                findRoute(tickets[i][1] ,currentDepth+1, totalDepth, tickets);
                break;
            }
        }
       
    }
}
