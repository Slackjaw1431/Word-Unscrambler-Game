package scramblerwithdifficultyoptions;

import java.util.ArrayList;
import java.util.Scanner;

public class easy {

    public static ArrayList<String> getWordsEasy(ArrayList<String> words) {

        ArrayList<String> wordsEasy = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() <= 5) {
                wordsEasy.add(words.get(i));
            }
        }
        return wordsEasy;
    }

    public static void scrambleWordsEasy(ArrayList<String> wordsEasy) {

        char[] wordArray = null;
        int x = wordsEasy.size();
        int Score = 0;
        int lives = 3;

        while (!wordsEasy.isEmpty()) {
            for (int i = 0; i < wordsEasy.size(); i++) {
                String input = wordsEasy.get((int) (Math.random() * wordsEasy.size()));
                wordsEasy.remove(input);
                wordArray = input.toCharArray();
            }

            ArrayList<Character> unscrambledWord = new ArrayList<>();//unscrambled
            ArrayList<Character> scrambledWord = new ArrayList<>();//scrambled

            for (int i = 0; i < wordArray.length; i++) {
                unscrambledWord.add(wordArray[i]);
            }

            int wordSize = unscrambledWord.size();

            for (int k = 0; k < wordSize; k++) {
                int r = (int) (Math.random() * unscrambledWord.size());
                scrambledWord.add(unscrambledWord.get(r));
                unscrambledWord.remove(r);
            }

            System.out.println("***************");
            scrambledWord.forEach((i) -> {
                System.out.print(i + " ");
            });

            String Original = new String(wordArray);
            int len = Original.length();

            String guess = "";
            System.out.println("\n***************");
            System.out.println("Enter a guess or Enter \"Hint\" to see the last letter: ");
            Scanner scan3 = new Scanner(System.in);

            boolean unfinished = true;
            while (unfinished || lives == 0) {
                guess = scan3.nextLine();
                if (guess.equals(Original)) {
                    Score++;
                    System.out.println("You solved the word! Your Score is " + Score + " out of " + x);
                    unfinished = false;
                } else if (guess.equals("Hint")) {
                    System.out.println("The last letter is " + Original.charAt(len - 1));
                    System.out.println("***************");
                    scrambledWord.forEach((i) -> {
                        System.out.print(i + " ");
                    });
                    System.out.println("\n***************");
                } else {
                    lives--;
                    System.out.println("Try again! " + lives + " lives left.");
                }
                if (lives == 0) {
                    System.out.println("Game Over");
                    System.exit(0);
                } else if (wordsEasy.isEmpty()) {
                    System.out.println("Congratulations! You solved all the words!");
                    System.exit(0);//maybe find some way to go back to the main menu some way to reset the app
                }
            }

        }
    }
}


