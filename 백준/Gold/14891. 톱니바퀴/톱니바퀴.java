import java.util.Scanner;

public class Main{

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);



      // 톱니 바퀴와 톱니 2차원 배열, 1~4, 0~7
      int[][] arr=new int[5][8];

      

        for(int i=1;i<=4;i++){
            String st = sc.next();
            for(int j=0;j<8;j++){
                arr[i][j]=st.charAt(j)-'0';
            }

        }
        int cmd = sc.nextInt();


      for(int i=0;i<cmd;i++){

          // 방향 배열, 1: 시계, -1: 반시계
          int[] dirArr = new int[5];

          int num=sc.nextInt();
          int dir=sc.nextInt();


          // 명령 방향
          dirArr[num] =dir;

          // 오른쪽 바퀴로 전파, 4는 오른쪽이 없으니까 j<4 조건을 사용
          for (int j = num; j < 4; j++){

              if(arr[j][2]==arr[j+1][6]) {
                  break; // 반복문 탈출(전파 안하고 멈추기)
              }

              // 반대 방향이므로 - 붙인다
              dirArr[j+1]=-dirArr[j];
          }

          // 왼쪽 바퀴로 전파
          for (int j = num; j > 1; j--){

              //j-1 인덱스를 사용하기 위해서 for문에서 j>1 조건을 씀, 어차피 1은 왼쪽 바퀴가 없기에
              if(arr[j-1][2]==arr[j][6]){
                  break;
              }
              // 반대 방향이므로 - 붙인다
              dirArr[j-1]=-dirArr[j];

          }

          // 전파 완료, 실제 회전
          // 4개 바퀴가 회전해야 함
          for(int j=1;j<=4;j++){
              if(dirArr[j]==1){ // 시계 방향 1->2, 2->3

                  // 톱니 회전
                  int temp= arr[j][7];
                  for(int k=7;k>0;k--){ // 뒤에서부터 밀어야 하므로 k--

                      arr[j][k]=arr[j][k-1];

                  }
                  arr[j][0]=temp;

              }
              if(dirArr[j]==-1){ // 반시계

                  // 톱니 회전
                  int temp= arr[j][0];
                  for(int k=0;k<7;k++){

                      arr[j][k]=arr[j][k+1];

                  }
                  arr[j][7]=temp;

              }
          }



      }
      int totalScore = 0;
        if (arr[1][0] == 1) totalScore += 1;
        if (arr[2][0] == 1) totalScore += 2;
        if (arr[3][0] == 1) totalScore += 4;
        if (arr[4][0] == 1) totalScore += 8;
        System.out.println(totalScore);


    }
}