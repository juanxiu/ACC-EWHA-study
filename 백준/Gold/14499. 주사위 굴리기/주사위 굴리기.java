import java.util.*;

public class Main{
    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);

        int N=sc.nextInt();
        int M=sc.nextInt();


        int[][] map = new int[N][M];
        int[] dice = new int[7];

        int x=sc.nextInt();
        int y=sc.nextInt();
        int k=sc.nextInt();



        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j] = sc.nextInt();
            }
        }


      

        // 인덱스로 이동 명령 방향
        int[] dx={0,0,0,-1,1};
        int[] dy={0,1,-1,0,0};


        // 이동 명령
        for(int i=0; i<k;i++){
            int cmd = sc.nextInt();

            int nx = x + dx[cmd];
            int ny = y + dy[cmd];

            int temp;

            // nx,ny 경계 체크, 넘으면 건너뜀
            if(nx<0 || nx>=N || ny<0 || ny>=M) continue;

            // 동,서,남,북 이동은 "또는" 실행이므로 if, else if 문으로 구성
            if(cmd==1){
                temp=dice[1]; // 위 값을 temp에 넣기.
                dice[1]=dice[4]; // 위의 dice[1] 에 새로운 값 넣기
                dice[4]=dice[6]; // 마찬가지
                dice[6]=dice[3];
                dice[3]=temp; // 위 -> 동, temp 값 넣는 것으로 끝나야 함.

            }
            // 또는
            else if(cmd==2){
                temp=dice[1];
                dice[1]=dice[3];
                dice[3]=dice[6];
                dice[6]=dice[4];
                dice[4]=temp;

            }
            else if(cmd==3){
                temp=dice[1];
                dice[1]=dice[5];
                dice[5]=dice[6];
                dice[6]=dice[2];
                dice[2]=temp;
            }
            else if(cmd==4){
                temp=dice[1];
                dice[1]=dice[2];
                dice[2]=dice[6];
                dice[6]=dice[5];
                dice[5]=temp;

            }


            // cmd=1,2,3,4 모두 각각 끝난 이후 이 코드 실행되어야 함. -> if문으로 분리함.
            if(map[nx][ny]==0){
                map[nx][ny]=dice[6]; // 바닥
            }
            else{
                dice[6]=map[nx][ny];
                map[nx][ny]=0;
            }



            x=nx;
            y=ny;

            // 상단 값들
            System.out.println(dice[1]);


        }




    }
}