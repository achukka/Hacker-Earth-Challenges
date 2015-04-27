package org.hackearth.zopper.challenge;
// Test ID -  1750937
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PrintWobblyNumbers {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		int n = 0, k = 0;
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			String input[] = line.split(" ");
			n = Integer.parseInt(input[0]);
			k = Integer.parseInt(input[1]);
			String result = printNum(n, k);
			if (result != null)
				System.out.println(result);
			else
				System.out.println("-1");
		}

	}

	public static String printNum(int n, int k) {
		int len = 0;
		String str = "";
		for (int a = 1; a <= 9; a++) {
			for (int b = 0; b <= 9; b++) {
				str = "";
				if (a == b)
					continue;
				for (int i = 0; i < n; i++) {
					if (i % 2 == 0)
						str += String.valueOf(a);
					else
						str += String.valueOf(b);
				}
				len++;
				if (len == k) {
					return str;
				}
			}
		}
		return null;
	}
}
