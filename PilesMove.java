
import java.util.Arrays;
import java.util.Scanner;


public class PilesMove {
    
    static int dp[] = new int[1006]; 
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int totalPile = in.nextInt();
        int piles[] = new int[totalPile];
        
        for(int i = 0; i < totalPile; i++){
            piles[i] = in.nextInt();
        }
        Arrays.fill(dp, -1);
        int ans = 0;
        for(int i = 0; i < totalPile; i++){
            int stone = piles[i];
            if(dp[stone] != -1){
                ans ^= dp[stone];
            }
            else{
              ans ^= calculateGrandy(stone);
            }
        }
        System.out.println(ans);
        in.close();
    }

    private static boolean visited[] = new boolean[5];
    
    private static int calculateGrandy(int stone) {
        if(stone < 2){
            return dp[stone] = 0;
        }
        if(dp[stone] != -1){
            return dp[stone];
        }
        
       if(stone >= 2){
           visited[calculateGrandy(stone - 2)] = true; 
       }
       if(stone >= 3){
           visited[calculateGrandy(stone - 3)] = true; 
       }
       if(stone >= 2){
           visited[calculateGrandy(stone - 3)] = true; 
       }
        
       for(int i = 0; i < 5; i++){
           if(!visited[i]){
               return dp[stone] = i;
           }
       }
        
        
        return 0;
    }
}
