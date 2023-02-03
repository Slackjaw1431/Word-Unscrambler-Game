package scramblerwithdifficultyoptions;

import java.util.ArrayList;
import java.util.Scanner;

public class hard {

    public static ArrayList<String> getWordsHard(ArrayList<String> words) {

        ArrayList<String> wordsHard = new ArrayList<>();
        int x = words.size();
        int Score = 0;

            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).length() > 5) {
                    wordsHard.add(words.get(i));
                }
            }
        return wordsHard;
    }

    public static void scrambleWordsHard(ArrayList<String> wordsHard) {

          char[] wordArray = null;
        int x = wordsHard.size();
        int Score = 0;

        while(!wordsHard.isEmpty()){
        for (int i = 0; i < wordsHard.size(); i++) {
            String input = wordsHard.get((int) (Math.random() * wordsHard.size()));
            wordsHard.remove(input);
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

        scrambledWord.forEach((i) -> {
            System.out.print(i + " ");
        });

        String Original = new String(wordArray);

        String guess = "";

        System.out.println("\nEnter a guess: ");
        Scanner scan3 = new Scanner(System.in);

        boolean unfinished = true;
        while (unfinished) {
            guess = scan3.nextLine();
            if (guess.equals(Original)) {
                Score++;
                System.out.println("You solved the word! Your Score is " + Score + " out of " + x);
                unfinished = false;
            } else {
                System.out.println("Try again!");
            }
        }
    }
    }
}





