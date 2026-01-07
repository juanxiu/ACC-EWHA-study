import java.util.*;

public class Main{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 트리 구조니까 그래프가 필요
        ArrayList<Integer>[] graph = new ArrayList[N+1];

        // 인접 그래프 생성, 인덱스 1부터 N개 노드
        for(int i=1; i <=N; i++){
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 N-1개
        for (int i=0; i<N-1; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        // 방문 배열
        boolean[]visited = new boolean[N+1];

        // 시작 노드는 1
        visited[1] = true;

        //큐에는 노드가 들어가 있다.
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        int[]parent = new int[N+1];

        while(!q.isEmpty()){
            // 이웃 노드를 하나씩 꺼내려면 for문 돌려서 graph[] 에서 꺼내야 한다.
            int cur = q.poll();

            for(int next : graph[cur]){

                if(visited[next]) continue;
                // 부모 노드를 출력해야 함. 호출한 노드가 부모가 됨.
                parent[next] = cur;
                visited[next] = true;

                // 그 다음 노드를 큐에 넣어야지
                q.offer(next);

            }

        }
        for (int i=2; i<=N; i++){ // N+1크기 
            // 부모노드 번호를 2번 노드부터 출력
            System.out.println(parent[i]);
        }

    }
}