package arrays;

public class LastIndexOf1 {

	public static void main(String[] args) {
		String s="0100100";
		int n= s.length();
		int flag=0;
		//Iterate from last and check every character, if equals 1 print.
		for(int i=n-1;i>=0;i--) {
			if(s.charAt(i)=='1') {
				flag=1;
				System.out.println("The index of 1 is: "+i);
				break;
			}
		}
		if(flag==0) {
			System.out.println("Since, 1 is not present, so output is -1.");
		}

	}

}
