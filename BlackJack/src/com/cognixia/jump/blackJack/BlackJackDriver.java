package com.cognixia.jump.blackJack;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BlackJackDriver {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		try {

			GameImpl.getGame();

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (UnsupportedOperationException e) {
			System.out.println("Illegal bet, make sure your " + 
					"bet doesn't exceed the amount of money you have");
			e.printStackTrace();
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			input.close();
			System.exit(0);
		}
	}


}
