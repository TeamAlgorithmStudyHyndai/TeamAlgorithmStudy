import java.util.*;
public class Solution {
    List<String> result;
    boolean[] visited;

    public String[] solution(String[][] tickets) {
        result = new ArrayList<>();
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

        // 출발지 "ICN"에서 시작하여 여행경로 찾기
        findRoute("ICN", tickets, 0);

        // List를 배열로 변환하여 반환
        return result.toArray(new String[result.size()]);
    }

    public boolean findRoute(String departure, String[][] tickets, int depth) {
        // 현재까지의 경로를 결과에 추가
        result.add(departure);

        // 모든 항공권을 사용한 경우 종료
        if (depth == tickets.length) {
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            // 출발지가 같고, 사용하지 않은 티켓인 경우
            if (!visited[i] && departure.equals(tickets[i][0])) {
                visited[i] = true;
                // 도착지를 다시 출발지로 설정하고 재귀적으로 경로 찾기
                if (findRoute(tickets[i][1], tickets, depth + 1)) {
                    return true;
                }
                // 백트래킹: 사용한 티켓을 다시 미사용 상태로 변경
                visited[i] = false;
                result.remove(result.size() - 1);
            }
        }

        return false;
    }
}
