

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

    static class Node {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 도시의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 버스의 개수 M
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, c));
        }

        // 출발점과 도착점
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 다익스트라 알고리즘을 통해 최소 비용 계산
        int[] dist = dijkstra(start, N);

        // 도착지점 출력
        System.out.println(dist[end]);
    }

    private static int[] dijkstra(int start, int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));

        // 시작 노드에서 시작 노드로 가는 가장 짧은 비용은 0
        q.offer(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            if (dist[curNode.idx] < curNode.cost) {
                continue;
            }

            for (Node nextNode : graph.get(curNode.idx)) {
                if (dist[curNode.idx] != Integer.MAX_VALUE && dist[curNode.idx] + nextNode.cost < dist[nextNode.idx]) {
                    dist[nextNode.idx] = dist[curNode.idx] + nextNode.cost;
                    q.offer(new Node(nextNode.idx, dist[nextNode.idx]));
                }
            }
        }

        return dist;
    }
}
