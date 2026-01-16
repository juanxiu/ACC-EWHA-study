import java.util.*;

public class Main{
    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // char 선언 주의
        char [][] board = new char[N][M];

        for (int i=0; i<N; i++) {
            // 한 줄 입력
            String line = sc.next();
            for(int j=0; j<M; j++){
                // 해당 줄의 한 글자씩
                board[i][j] = line.charAt(j);
            }
        }

        int minValue = Integer.MAX_VALUE; // 큰 값

        // 시작점 포문(오른쪽으로 이동하는거지)
        for(int i=0; i<=N-8; i++){
            for(int j=0; j<=M-8; j++){

                // 시작점 마다 새로 계산해야
                int cntW = 0; // 다시 칠한 개수, 시작점이 W라고 가정
                int cntB = 0;

                // 시작점부터 시작점+8까지 색칠하기
                for(int x=i; x<i+8; x++){
                    for(int y=j; y<j+8; y++){



                        // 포문 변수 사용할 것
                        if((x+y)%2 ==0){ // 짝수 칸
                            if(board[x][y] != 'W') cntW++;
                            if(board[x][y] != 'B') cntB++;
                        } else{ // 홀수 칸
                            if(board[x][y] !='B') cntW++;
                            if(board[x][y] !='W') cntB++;
                        }
                    }
                }

                // 최소값을 계속 갱신하는 게 핵심
                minValue = Math.min(minValue, Math.min(cntW, cntB));
            }


        }
        System.out.println(minValue);

    }
}