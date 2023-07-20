package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class main_misc {
	
	
	public static final int MAX = 1_000_000;
	
	public static void main(String[] args) {
		
	
	List<Character> b0 = new ArrayList<>(Arrays.asList('0','0','0'));
	List<Character> b1 = new ArrayList<>(Arrays.asList('0','0','1'));
	List<Character> b2 = new ArrayList<>(Arrays.asList('0','1','0'));
	List<Character> b4 = new ArrayList<>(Arrays.asList('1','0','0'));
	List<List<Character>> bits = new ArrayList<>(Arrays.asList(b0,b1,b2,b4));
	
	System.out.println(missing_number(bits));
		
	}
	
	private static char fetch_jth(List<Character> bits,int j){
		
		return bits.get(j);
		
	}
	
	private static int missing_number(List<List<Character>> numbers){
		
		/*when we deal with binary numbers the number of digits must be all equal so i assume that in this
		 * array all binary numbers have an equal number of digits,if the largest is 4 --> 100
		 * 1 is represented as 001.Because i now that there is only one number missing i can say that somewhere
		 * it will increase 10(2) instead of 1.
		 */
		
		int LSB_ndx = numbers.get(numbers.size()-1).size() - 1;
		
		//expected sequence of LSBs : 0,1,0,1,0,...
		int expected = '0';
		for(int i = 0;i < numbers.size();i++) {
			
			char curr = fetch_jth((numbers.get(i)),LSB_ndx);
			
			if(curr == expected) {
				
				if(curr == '0'){
					expected = '1';
				}
				else {
					expected = '0';
				}
				continue;
			}
			if(curr != expected) {
				return i;
			}
		}
		
		return -1;
		
	}
	
	

}
