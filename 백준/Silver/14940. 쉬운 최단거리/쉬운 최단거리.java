import java.util.*;

public class Main{
    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();


        Queue<int[]> q = new LinkedList<>();
    

        int[][] map = new int[N][M];
        int[][] dist = new int[N][M];

        // (가장 먼저 할 것) 거리 배열을 모두 -1로 초기화, 좌표 개수와 동일
        for(int i=0; i<N; i++){
            Arrays.fill(dist[i], -1);
        }

        // 입력값으로 맵 채우기 맵의 값이 2인 것을 찾아서 시작점으로 설정
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();

                if(map[i][j] == 2){
                    // 큐에 넣으려면 좌표가 필요
                    int sx = i;
                    int sy = j;

                    q.offer(new int[]{sx,sy});
                    dist[sx][sy]= 0;
                }
            }
        }



        while(!q.isEmpty()){

            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            int[] dx = {-1,1,0,0};
            int[] dy = {0,0,-1,1};

            for(int i=0; i<4; i++){

                int nx = x+ dx[i];
                int ny = y+ dy[i];

                // 범위 체크
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 맵의 값이 0
                if(map[nx][ny] == 0) continue;

                // 방문 체크: dist[][] 에 값이 들어가 있으면 이미 방문한 것
                if(dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[x][y] +1; // 상하좌우니까 거리 +1
                q.offer(new int[]{nx,ny});

            }

        }

        // 출력
        for(int i=0; i<N; i++){
            for (int j=0; j<M; j++){


                if(map[i][j] == 0 ) System.out.print(0 + " ");

                else if(dist[i][j] == -1 ) System.out.print(-1+ " ");

                else
                    System.out.print(dist[i][j] +" ");
            }
            // 줄바꿈
            System.out.println();

        }
    }
}