import java.util.Scanner;

public class Main{

    // main 밖에서 선언
    static int[][] visited = new int[5][5];



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] map = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int num=0;
        for (int x=0;x<5;x++) {
            for (int y=0;y<5;y++) {
                int k = sc.nextInt();
                num++;

                // k를 전체 빙고판에서 찾기 위해서 포문을 또 돌리는 것
                for (int i=0;i<5;i++){
                    for(int j=0;j<5;j++){

                        if (map[i][j] == k) {
                            visited[i][j] = 1;

                        }
                    }
                }
                // 체크 함수, 숫자 하나 표시 직후에 빙고 체크
                if(check() >=3){
                    System.out.println(num);
                    return; // 출력 후 프로그램 종료

                }

            }
        }

    }
    public static int check () {
        int bingo = 0;

        for (int i = 0; i < 5; i++) { // 행 고정, 동일 행 빙고
            int count = 0;
            for (int j = 0; j < 5; j++) {

                if (visited[i][j] == 1) {

                    count++;
                }

            }
            // 하나의 열 검사 끝나고
            if (count == 5) bingo++;


        }
        for (int j = 0; j < 5; j++) { // 열 고정, 동일 열 빙고(j를 바깥에서 돌리기)
            int count = 0;
            for (int i=0; i<5;i++) {

                if (visited[i][j] == 1) {
                    count++;
                }

            }
            if (count == 5) bingo++;


        }

        // 왼 상단 대각선
        int flag = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j && visited[i][j] == 1) {
                    flag++;
                }
            }
        }
        if (flag == 5) bingo++;

        // 오 상단 대각선
        int flag2 = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i + j == 4 && visited[i][j] == 1) {
                    flag2++;
                }
            }
        }
        if (flag2 == 5) bingo++;

        return bingo;

    }
}