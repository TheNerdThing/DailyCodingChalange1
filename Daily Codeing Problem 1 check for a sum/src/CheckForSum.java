import java.util.Arrays;
import java.util.concurrent.SynchronousQueue;

/**
 * 
 * @author Gregory Evevsky
 *
 * Daily coding problem # 1. 
 * 
 * Given a list of numbers and an integer k, 
 * return true iff 2 numbers from the list can be used to add to k
 */
public class CheckForSum {

	public static void main(String[] args) {
		int[] list = {-5 ,5 ,10 ,25,3}; 
		int k =  28;		
		System.out.println(onePass( list, k));
	}
	
	/**
	 * first solution that came into my mind
	 * @param list
	 * @param k
	 * @return
	 */
	public static boolean soultion(int[] list, int k) {
		for(int i = 0; i < list.length -1; i ++) {
			for( int x = i +1; x < list.length; x ++) {
				if(list[i] + list[x] == k) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * in order for this to work list must be sorted
	 * 
	 * @param list
	 * @param k
	 * @return
	 */
	public static boolean onePass(int[] list, int k) {
		Arrays.sort(list);
		int lowerCount = 0; 			
		int higherCount = list.length -1;  
		
		while(lowerCount < higherCount) {
			int check = list[lowerCount] + list[higherCount]; 
			// check needs to be lower so decrease the higher count
			if(check > k) {
				higherCount --;
			// check needs to be higher, so increase higher count
			}else if( check < k) {
				lowerCount ++;
			}
			else { // they are equal
				return true;
			}
		}
		
		return false;
	}
}
