import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_11060_점프점프 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] line = new int[n];
		
		for(int i = 0; i < n; i++) {
			line[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		dp[0] = 0;
		
		for(int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(dp));
			if(dp[i] != Integer.MAX_VALUE) {
				int jump = line[i];
				
				for(int j = 1; j <= jump; j++) {
					if(i+j >= n) continue;
					dp[i+j] = Math.min(dp[i]+1, dp[i+j]);
				}
			}
		}
        if(dp[n-1] == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(dp[n-1]);
	}

}
