package guessinggame;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
	
	static Scanner scanner = new Scanner(System.in);
	static Random random = new Random();
	
	static int EASY_LEVEL_GUESSES = 8;
	static int MEDIUM_LEVEL_GUESSES = 5;
	static int HARD_LEVEL_GUESSES = 3;
	static int turns = 0;

	public static void main(String[] args) {
		System.out.println("  ________                            .__                 ________                       \r\n"
				+ " /  _____/ __ __   ____   ______ _____|__| ____    ____  /  _____/_____    _____   ____  \r\n"
				+ "/   \\  ___|  |  \\_/ __ \\ /  ___//  ___/  |/    \\  / ___\\/   \\  ___\\__  \\  /     \\_/ __ \\ \r\n"
				+ "\\    \\_\\  \\  |  /\\  ___/ \\___ \\ \\___ \\|  |   |  \\/ /_/  >    \\_\\  \\/ __ \\|  Y Y  \\  ___/ \r\n"
				+ " \\______  /____/  \\___  >____  >____  >__|___|  /\\___  / \\______  (____  /__|_|  /\\___  >\r\n"
				+ "        \\/            \\/     \\/     \\/        \\//_____/         \\/     \\/      \\/     \\/ ");
		game();
	}
	
	static void game()
	{
		System.out.println("Welcome to the Number Guessing Game!");
		System.out.print("Would you like to play? Type 'yes' or 'no': ");
		String response = scanner.nextLine();
		yesOrNo(response);
		scanner.close();
	}
	
	static void startGame()
	{
		System.out.println("Great! The mechanics of the game is very easy.");
		System.out.println("----------------------------------------------");
		System.out.println("First, you have to choose a difficulty: easy or hard.");
		System.out.println("For the easy difficulty, you have 8 guesses.");
		System.out.println("For the medium difficulty, you have 5 guesses.");
		System.out.println("For the hard difficulty, you have 3 guesses.");
		System.out.println("Once you have chosen a difficulty, the game will start.");
		System.out.print("Would you like to proceed? ");
		String proceed = scanner.nextLine();
		if (proceed.equals("yes")) {
			System.out.println("The game will start now.");
			System.out.println("----------------------------------------------");
			System.out.println("I'm thinking of a number between 1 and 100");
			int answer = random.nextInt(100);
			turns = setDifficulty();
			int guess = 0;
			while (guess != answer) {
				System.out.println("You have " + turns + " attempts to guess the number.");
				System.out.print("Make a guess: ");
				guess = scanner.nextInt();
				turns = checkAnswer(guess, answer, turns);
				if (turns == 0) {
					System.out.println("You've run out of guesses, you lose.");
					return;
				} else if (guess != answer) {
					System.out.println("Guess again.");
				}
			}
		} else if (proceed.equals("no")) {
			System.out.print("Are you sure you want to quit? Type 'yes' or 'no': ");
			String quit = scanner.nextLine();
			if (quit.equals("yes")) {
				System.out.println("Goodbye.");
				return;
			} else if (quit.equals("no")) {
				game();
			} else {
				System.out.println("Error: Invalid syntax!");
			}
		} else {
			System.out.println("Error: Invalid syntax!");
		}
	}
	
	static int checkAnswer(int guess, int answer, int turns) {
		if (guess > answer) {
			System.out.println("Too high.");
			return turns - 1;
		} else if (guess < answer) {
			System.out.println("Too low.");
			return turns - 1;
		} else {
			System.out.println("You got it! The answer was " + answer + ".");
		}
		return answer;
	}
	
	static int setDifficulty() {
		System.out.print("Choose a difficulty: Type 'easy', 'medium' or 'hard': ");
		String level = scanner.nextLine();
		if (level.equals("easy")) {
			return EASY_LEVEL_GUESSES;
		} else if (level.equals("medium")) {
			return MEDIUM_LEVEL_GUESSES;
		} else if (level.equals("hard")) {
			return HARD_LEVEL_GUESSES;
		} else {
			return setDifficulty();
		}
	}
	
	static void yesOrNo(String response) {
		if (response.equals("yes")) {
			startGame();
		} else if (response.equals("no")) {
			System.out.print("Are you sure you want to quit? Type 'yes' or 'no': ");
			String quit = scanner.nextLine();
			if (quit.equals("yes")) {
				System.out.println("Goodbye.");
				return;
			} else if (quit.equals("no")) {
				game();
			} else {
				System.out.println("Error: Invalid syntax!");
			}
		} else {
			System.out.println("Error: Invalid syntax!");
		}
	}
	
	static void mainGame() {
		System.out.println("The game will start now.");
		System.out.println("----------------------------------------------");
		System.out.println("I'm thinking of a number between 1 and 100");
		int answer = random.nextInt(100);
		turns = setDifficulty();
		int guess = 0;
		while (guess != answer) {
			System.out.println("You have " + turns + " attempts to guess the number.");
			System.out.print("Make a guess: ");
			guess = scanner.nextInt();
			turns = checkAnswer(guess, answer, turns);
			if (turns == 0) {
				System.out.println("You've run out of guesses, you lose.");
				return;
			} else if (guess != answer) {
				System.out.println("Guess again.");
			}
		}
	}
}
