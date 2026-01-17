import java.util.*;

public class Main{
    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        // 입력 배열 1부터 받기
        int[] array = new int[N+1];

        for(int i=1; i<N+1; i++){
            array[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        for(int i=0; i<M; i++){
            int sex=sc.nextInt();
            int num=sc.nextInt();


            // 여
            if(sex==2){

                int left = num-1;
                int right = num+1;

                // 반복문 조건
                while(left >=1 && right<=N){

                    // 예) 2,6 검사했는데 불일치함 -> break 로 빠져나옴 하지만 이미 한 칸씩 늘어난 상태
                    // cf) break는 그것을 감싸는 가장 가까운 반복문 빠져나온다
                    if(array[left] !=array[right]){
                        break;
                    }

                    left--;
                    right++;

                }

                // 뒤집기
                // 범위 주의: if문에서 한 칸씩 늘리고 나온 상태임.
                for(int j=left+1; j<=right-1; j++){

                    array[j] = 1 - array[j]; // 0,1 뒤집기
            }
        }
            // 남
            else{

                // **배수 처리, i+=num 기억하자
                for(int k= num; k<N+1; k+=num){
                    array[k] = 1 - array[k]; // 0,1 뒤집기

                }


            }

        }
        for(int i=1; i<N+1; i++){
            System.out.print(array[i] + " ");
            // 한 줄에 20개씩 출력
            if(i%20==0) System.out.println();
        }
    }
}