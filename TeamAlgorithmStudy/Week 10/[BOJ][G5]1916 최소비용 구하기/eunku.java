import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] cost;
    static ArrayList<ArrayList<Node>> graph;
    static class Node {
        int idx, cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Node>());
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Node(end, cost));
        }
        int[] dist = new int[N+1];
        boolean[] check = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        PriorityQueue<Node> que = new PriorityQueue<>((o1,o2) -> Integer.compare(o1.cost, o2.cost));
        dist[start] = 0;
        que.add(new Node(start, 0));
        while(!que.isEmpty()){
                Node node= que.poll();
                int to = node.idx;

                if(check[to]) continue;
                else check[to] =true;

                for(Node nd : graph.get(to)){
                    if(dist[nd.idx] >= dist[to] + nd.cost){
                        dist[nd.idx] = dist[to] + nd.cost;
                        que.add(new Node(nd.idx, dist[nd.idx]));
                    }
                }
        }
        System.out.println(dist[end]);
    }

}
