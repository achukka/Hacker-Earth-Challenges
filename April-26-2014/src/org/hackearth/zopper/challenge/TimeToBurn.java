package org.hackearth.zopper.challenge;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TimeToBurn {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int T = Integer.parseInt(line);
		int L = 0;
		String input[];
		Integer upper[];
		Integer lower[];
		for (int i = 0; i < T; i++) {
			line = br.readLine();
			L = Integer.parseInt(line);

			upper = new Integer[L - 1];
			lower = new Integer[L - 1];

			line = br.readLine();
			input = line.split(" ");
			for (int j = 0; j < L - 1; j++) {
				upper[j] = Integer.parseInt(input[j]);
			}

			line = br.readLine();
			input = line.split(" ");
			for (int j = 0; j < L - 1; j++) {
				lower[j] = Integer.parseInt(input[j]);
			}
			System.out.println(printTimeToBurn(L, upper,lower));
		}

	}

	private static int printTimeToBurn(int l, Integer[] upper,
			Integer[] lower) {
		int totalTime = l;
		int extraTime=0;
		int maxRopeAttached=0;
		int remainingTime=0;
		for(int i=0;i<l-1;i++)
		{
			maxRopeAttached=max(upper[i],lower[i]);
			remainingTime=totalTime-i-1;
			if(maxRopeAttached > remainingTime)
			{
				extraTime = maxRopeAttached - remainingTime;
				totalTime +=extraTime;
			}
		}
		return totalTime;
	}

	private static int max(Integer a, Integer b) {
		return a>b?a:b;
	}

	
}
