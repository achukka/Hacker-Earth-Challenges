package org.hackearth.policybazaar.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThirdSmallestAndLargest {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);

		for (int i = 0; i < N; i++) {
			line = br.readLine();
			print3rdSmallest(line);
			print3rdLargest(line);
		}

	}

	private static void print3rdSmallest(String input) {
		int[] digits = new int[10];
		String lowest = "";
		for (int i = 0; i < 10; i++) {
			digits[i] = 0;
		}
		for (int i = 0; i < input.length(); i++) {
			digits[input.charAt(i) - '0']++;
		}

		for (int i = 1; i < 10; i++) {
			if (digits[i] != 0) {
				for (int k = 0; k < digits[i]; k++) {
					lowest += String.valueOf(i);
				}
			}
		}
		String next = "";
		for (int i = 0; i < 2; i++) {
			next = NextValue(lowest);
			if (lowest == next) {
				System.out.println("Not Possible");
				return;
			}
			lowest = next;
		}
		System.out.println(next);
	}

	private static String NextValue(String lowest) {
		
		int len = lowest.length();
		int pivot = -1;
		int swapPos = -1;
		for(int i=0;i<len-1;i++)
		{
			if(lowest.charAt(i) < lowest.charAt(i+1))
				pivot = i;
		}
		
		if(pivot==-1)
			return lowest;
					
		for(int j=len-1;j>=pivot;j--)
		{
			if(lowest.charAt(j) > lowest.charAt(pivot))
			{
				swapPos = j;
				break;
			}
		}
		if(swapPos==-1 || swapPos==pivot)
			return lowest;
		
		char[] charArray = lowest.toCharArray();
		char swapChar=lowest.charAt(pivot);
		charArray[pivot]=charArray[swapPos];
		charArray[swapPos]=swapChar;
		int tempLen = swapPos-pivot;
		char[] tempArray = new char[tempLen];
		for(int i=0;i<(tempLen);i++)
		{
			tempArray[i] = charArray[pivot+1+i]; 
		}
		
		for(int i=tempLen-1;i>=0;i--)
		{
			charArray[tempLen-i+pivot]=tempArray[i];
		}
		
		return  new String(charArray) ;
	}

	private static void print3rdLargest(String input) {
		int[] digits = new int[10];
		String highest = "";
		for (int i = 0; i < 10; i++) {
			digits[i] = 0;
		}
		for (int i = 0; i < input.length(); i++) {
			digits[input.charAt(i) - '0']++;
		}

		for (int i = 9; i > 0; i--) {
			if (digits[i] != 0) {
				for (int k = 0; k < digits[i]; k++) {
					highest += String.valueOf(i);
				}
			}
		}
		String next = highest;
		for (int i = 0; i < 2; i++) {
			next = PreviousValue(highest);
			if (highest == next) {
				System.out.println("Not Possible");
				return;
			}
			highest = next;
		}
		System.out.println(next);
	}

	private static String PreviousValue(String highest) {

		int len = highest.length();
		int pivot = -1;
		int swapPos = -1;
		for(int i=0;i<len-1;i++)
		{
			if(highest.charAt(i) > highest.charAt(i+1))
				pivot = i;
		}
		
		if(pivot==-1)
			return highest;
					
		for(int j=len-1;j>=pivot;j--)
		{
			if(highest.charAt(j) < highest.charAt(pivot))
			{
				swapPos = j;
				break;
			}
		}
		if (swapPos == -1 || swapPos == pivot)
			return highest;

		char[] charArray = highest.toCharArray();
		char swapChar = highest.charAt(pivot);
		charArray[pivot] = charArray[swapPos];
		charArray[swapPos] = swapChar;
		int tempLen = swapPos - pivot;
		char[] tempArray = new char[tempLen];
		for (int i = 0; i < (tempLen); i++) {
			tempArray[i] = charArray[pivot + 1 + i];
		}

		for (int i = tempLen - 1; i >= 0; i--) {
			charArray[tempLen - i + pivot] = tempArray[i];
		}

		
		return new String(charArray);	}
}
