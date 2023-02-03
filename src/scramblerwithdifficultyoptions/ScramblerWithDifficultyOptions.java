package scramblerwithdifficultyoptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import static scramblerwithdifficultyoptions.hard.getWordsHard;
import static scramblerwithdifficultyoptions.hard.scrambleWordsHard;

/*  @author Talha Memon */
public class ScramblerWithDifficultyOptions extends easy {

    public static void main(String[] args) {

        Scanner select = new Scanner(System.in);

        Scanner scan2 = new Scanner(System.in);

        ArrayList<String> words = new ArrayList<>();

        try {
            File wordFile = new File("C:\\Users\\TM\\Desktop\\Projects\\ScramblerWithDifficultyOptions\\src\\scramblerwithdifficultyoptions\\words.txt");
            Scanner list = new Scanner(wordFile);
            while (list.hasNextLine()) {
                words.add(list.nextLine());
            }
            System.out.println("File found and words added to the playlist.\n");

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.out.println("Create a new file and add words to it.\n");

        } finally {
            System.out.println("Select: \n1. Enter a new word to the list \n2. Play an Easy game \n3. Play a Hard game \n4. Exit");
        }

        int choice = select.nextInt();

        switch (choice) {
            case 1: {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\TM\\Desktop\\Projects\\ScramblerWithDifficultyOptions\\src\\scramblerwithdifficultyoptions\\words.txt", true));
                    System.out.println("Enter a word for the dictionary: ");
                    String newWord = scan2.nextLine();

                    boolean hasDigit = false;
                    for (int i = 0; i < newWord.length(); i++) {
                        if (Character.isDigit(newWord.charAt(i))) {
                            hasDigit = true;
                            System.out.println("Please only enter words with letters: ");
                            newWord = scan2.nextLine();
                        } else if (newWord.length() < 3) {
                            System.out.println("Please enter a word with at least 3 letters: ");
                            newWord = scan2.nextLine();
                        }
                    }

                    String newWordLower = newWord.toLowerCase();
                    String newWordSeparate = newWord.substring(0, 1);
                    String newWordFirstCap = newWordSeparate.toUpperCase();
                    String remainingString = newWordLower.substring(1);
                    String newWordFinal = newWordFirstCap + remainingString;

                    if (words.contains(newWordFinal) == true) {
                        System.out.println("Word already exists in the dictionary.");
                        System.exit(0);
                    } else {
                        writer.write(newWordFinal);
                        writer.newLine();
                        writer.close();

                        System.out.println("Word has been added to the dictionary.");
                        System.exit(0);
                    }
                } catch (IOException ex) {
                    System.out.println("Could not save the file or word.");
                    System.exit(0);
                }
            }
            case 2: {
                scrambleWordsEasy(getWordsEasy(words));
            }
            case 3: {
                scrambleWordsHard(getWordsHard(words));
            }
            case 4: {
                System.exit(0);
            }

        }
    }

}
