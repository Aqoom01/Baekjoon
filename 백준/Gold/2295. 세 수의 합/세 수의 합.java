import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(br.readLine());
        Arrays.sort(nums);
        
        List<Integer> XPlusY = new ArrayList<>();
        for(int i = 0; i < N; i++) {
        	for(int j = i; j < N; j++) {
        		int temp = nums[i] + nums[j];
        		XPlusY.add(temp);
        	}
        }
        Collections.sort(XPlusY);
        
        for(int k = N - 1; k > 0; k--) {
        	for(int z = 0; z < k; z++) {
        		int target = nums[k] - nums[z];
        		
        		int l = 0;
        		int r = XPlusY.size() - 1;
        		while(l <= r) {
        			int mid = (l + r) / 2;
        			
        			int temp = XPlusY.get(mid);
        			if(temp == target) {
        				System.out.println(nums[k]);
        				return;
        			}
        			else if(temp > target) r = mid - 1;
        			else l = mid + 1;
        		}
        	}
        }
	}
}