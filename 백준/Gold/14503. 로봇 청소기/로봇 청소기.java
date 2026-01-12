import java.util.*;

public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

      

        int[][] map = new int[N][M];

        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }


        int cleanCount =0;

        // 주변 4칸 탐색 위해 시계방향 순서로 정렬한 것
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        // 계속 돌리기, break 를 넣기
        while (true) {

            // 현재 칸 청소
            if(map[r][c]==0){
                map[r][c] = 2;
                cleanCount++;
            }

            //for 문 안에 상태를 저장해서 for 문 밖 whie 문에서 사용하기 위한 변수.
            boolean moved = false;


            for (int i = 0; i < 4; i++) {

                // 반시계 회전, 주변 탐색
                d = (d + 3) % 4;

                int nr = r + dr[d];
                int nc = c + dc[d];

                // 주변 4칸 중 청소 X 칸 있는 경우
                if (map[nr][nc] == 0) {
                    // 전진
                    r = nr;
                    c = nc;
                    moved = true;
                    break; // for 문 탈출

                }
                // 주변 4칸 탐색 전부 완료(for 문 끝) 했지만, 청소 X 칸 없음.
            }
                // 만약 전진했다면, 아래 후진 코드가 실행되지 않도록 하고 다시 while 처음으로 돌아간다
                if(moved) continue;

                // 후진
                int backDir = (d + 2) % 4;
                int br = r + dr[backDir];
                int bc = c + dc[backDir];


                // 후진 불가
                if(map[br][bc] ==1){
                    break; // > while 문 종료
                }

                r = br;
                c = bc;


        }
        System.out.println(cleanCount);


    }

}