/*
 * Link : https://www.geeksforgeeks.org/puzzle-30-last-palindrome-data/
 * Question:In year 2001 on October 2, 2001, the date in MMDDYYYY format was a palindrome (same forwards as backwards),
   10/02/2001 -> “10022001”.When was the last palindrome date before 10/02/2001? 
  
  *Answer:
	One year can have only one palindrome as the year fixes the month and date too, so
	the year has to be less than 2001 since we already have the palindrome for 10/02. 
	It can’t be any year in 1900 because that would result in a day of 91, same for 1800 down to 1400. 
	It could be a year in 1300 because that would be the 31st day.
	
	So what’s the latest year in 1300 that would make a month?
	When you first look at it, 12th month comes to mind as we have to find the latest date, 
	so it seems it would be 1321. But we have to keep in mind that we want 
	the maximum year in 1300 century with a valid date, so lets think about 1390 that will give the date as 09/31, is this a valid date…? 
	No, because September has only 30 days, so last will be the 31st August. Which means the correct date would be 08/31/1380.
   
 */
package arrays;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PalindromeBefore2001 {
		static String year;
	    static String mr="",dr="";
	    void m1()
	    {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter a date:");
	        String input=sc.nextLine();
	        year=input.substring(6);
	        System.out.println("Year:"+year);
	    }
	    
	    void m2()//This 2nd method is created to call this again in main method and to reduce complexity
	    {
	        char ch;
	        System.out.println("M2 Year:"+year);
	        String date =year.substring(0,2);
	        System.out.println("Month:"+date);
	        String month =year.substring(2);
	        System.out.println("Date:"+month);
	    
	      String a = String.valueOf(month.charAt(0));//Converting char at month to string to concat them	                                                  
	      String b = String.valueOf(month.charAt(1));//them instead of using reverse for two characters
	      mr=b.concat(a); //concating
	      System.out.println("Month Reverse:"+mr);//reversing
	      
	      String c =  String.valueOf(date.charAt(0));
	      String dd =  String.valueOf(date.charAt(1));
	      dr=dd.concat(c);
	      System.out.println("Date Reverse:"+dr);
	      System.out.println("*****Loop Ended*****");
	      System.out.println();
	    }
		public static void main(String[] args) 
		{
			System.out.println("*****Palindrome Check*****");
			PalindromeBefore2001 Pal=new PalindromeBefore2001();
			Pal.m1();
			Pal.m2();
			while (true)
			{
			   Integer y= Integer.parseInt(year);// As year is string converting it to Integer
			   Integer d= Integer.parseInt(dr);//similarly for d and m
			   Integer m= Integer.parseInt(mr);
			   
	    		if(d>31)
	    		{
	    		    y=y-100; //Reverse of 31 is 13.So, if year is>1300 then subtract it by 100.
	    		  //again giving the same y value to year to make it to decre or incre, 
	    		  //bcz y value is not there in method 2. So again we are assigning y value to year
	    		    year = String.valueOf(y);
	    		    Pal.m2();//method calling
	    		}
	    		else
	    		{
	    		    if(m>12 || m<=0)
	    		    {
	        		    y=y-1;
	        		    year = String.valueOf(y);
	        		    Pal.m2();
	    		    } 
	    		    else if (d<=31 && m<=12 &&m>0)//because,if we take 1900,1800 then month value will be in Zeroes(0).
	    		    {
	    		        List<Integer> list = Arrays.asList(1,3,5,7,8,10,12);
	    		        if (d==31 && list.contains(m))//31 will be there in these months
	    		        {// reason for taking these is before 2000 we had 1300 year in which palindrome is present.
	        		        System.out.println("Palindrome before 2001:");      
	                        System.out.println(m+"/"+d+"/"+y);
	                        break;
	    		        }
	    		        else{
	    		        	// Here we get 9/31/1390,instead 1380 to get that we subtract by -1.
	    		            y=y-1;
	            		    year = String.valueOf(y);
	            		    Pal.m2();
	    		        }      
	    		    }
	    		}
		    }
	}
}
