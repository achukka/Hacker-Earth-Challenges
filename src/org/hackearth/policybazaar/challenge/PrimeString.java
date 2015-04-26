package org.hackearth.policybazaar.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeString {

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			System.out.println(isPrimString(line));
		}

	}

	private static String isPrimString(String line) {
		int[] array = new int[26];
		for (int i = 0; i < 26; i++) {
			array[i] = 0;
		}
		char ch;
		for (int i = 0; i < line.length(); i++) {
			ch = line.charAt(i);
			array[ch - 'a']++;
		}
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (array[i] != 0) {
				if (!isprime(array[i])) {
					return "NO";
				}
				count++;
			}
		}
		if (!isprime(count))
			return "NO";
		return "YES";
	}

	private static boolean isprime(int n) {
		if (n == 1)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
