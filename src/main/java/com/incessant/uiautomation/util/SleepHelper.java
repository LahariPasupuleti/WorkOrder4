package com.incessant.uiautomation.util;

public class SleepHelper {
	
	public static String aSite = null;
	public static void main(String args[]) {
		int cnt = 0;
		while (aSite == null && cnt < 50) {
			aSite = SleepHelper.getSiteName(cnt);
			System.out.println(cnt + "------------> " + aSite);
			cnt++;
			SleepHelper.sleep( 2/*seconds*/);
		}
	}

	public static void sleep(int numSecs) {
		        long remainder = numSecs * 1000;
		        long targetTime =  System.currentTimeMillis() + (numSecs * 1000);
		        while (remainder > 0) {
		            try {
		                Thread.sleep(remainder);
		            }
		            catch (Exception e) {
		                System.out.println("Thread.sleep() interrupted by exception:");
		                e.printStackTrace(System.out);
		            }
		            finally {
		                remainder = targetTime - System.currentTimeMillis();
		            }
		        }
	}
	
	
	public static String getSiteName(int count) {
		if(count == 25) {
			return "www.incessanttechnologies.com";		
		} else {
			return null;
		}
	}

}
