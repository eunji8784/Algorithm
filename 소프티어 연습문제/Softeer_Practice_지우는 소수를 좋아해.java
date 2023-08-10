import java.util.*;
import java.io.*;

// 다익스트라 알고리즘 
public class Main
{
    private static final int INF = 1000000000;

    private static int N, M;
    private static ArrayList<Edge>[] adjLst;
    private static TreeSet<Integer> levels = new TreeSet<>();

    private static class Edge implements Comparable<Edge> {
        int node, cost;

        public Edge (int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String args[]) throws IOException
    {
        getInput();
        solution();
    }

    private static void solution() {
        for (int level : levels) {
            if (dijkstra(level)) {
                level++; // 'X레벨 이하 지원자는 오지 마시오.'
                while (!isPrime(level)) {
                    level++;
                }
                System.out.println(level);
                System.exit(0);
            }
        }
    }

    private static boolean isPrime(int level) {
        if (level <= 1) {
            return false;
        }
        for (int i = 2; i * i <= level; i++) {
            if (level % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean dijkstra(int levelLimit) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[1] = 0;

        PriorityQueue<Edge> que = new PriorityQueue<>();
        que.offer(new Edge(1, 0));

        while (!que.isEmpty()) {
            Edge current = que.poll();

            if (current.node == N) {
                return true;
            }

            if (distance[current.node] < current.cost) {
                continue;
            }

            for (Edge edge : adjLst[current.node]) {
                if (edge.cost <= levelLimit && current.cost + edge.cost < distance[edge.node]) {
                    distance[edge.node] = current.cost + edge.cost;
                    que.offer(new Edge(edge.node, distance[edge.node]));
                }
            }
        }

        return false;
    }

    private static void getInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
      
        adjLst = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjLst[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            
            adjLst[from].add(new Edge(to, level));
            adjLst[to].add(new Edge(from, level));
            levels.add(level);
        }
        
        br.close();
    }
}
