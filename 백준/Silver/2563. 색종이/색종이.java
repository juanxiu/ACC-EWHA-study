import java.util.*; 
public class Main{

    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);

        int[][] paper = new int[100][100];

        int N = sc.nextInt();

        for(int i=0;i<N; i++){

            int y = sc.nextInt(); // 행
            int x = sc.nextInt(); // 열

            // 넓이 만큼 1로 칠해야 함.
            for(int j=y;j<y+10;j++){
                for(int k=x;k<x+10;k++){
                    paper[j][k] = 1;
                }
            }
        }

        int area = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(paper[i][j]==1)
                area++;
            }
        }
        System.out.println(area);
    }
}