import java.util.*;

public class Main{

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int R = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        q.offer(R);


        // 노드 들어가는 리스트
        ArrayList<Integer>[] graph = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        // 간선 넣기
        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        // 간선 넣은 이후, 오름차순 정렬
        for(int i=1; i<=N; i++){
            Collections.sort(graph[i]);
        }




        int[] order = new int[N+1];
        int cnt = 1;
        order[R] = cnt++;

        boolean[] visited = new boolean[N+1];
        visited[R] = true;

        while(!q.isEmpty()){

            int cur = q.poll();

            // 인접 리스트니까 방향 이동 아니고 연결 노드들 for문으로
            for(int next : graph[cur]){

                if(visited[next]) continue;

                visited[next] = true;
                order[next] = cnt++; // cnt는 2이고, 대입 후 3으로 올라감.
                q.offer(next);
            }

        }

        for(int i=1; i<=N; i++){
            System.out.println(order[i]);
        }
    }
}