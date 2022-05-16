import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        System.out.println("Wilkommen zu Hangman");


        File dictionary = new File("C:/Users/Friedrich/IdeaProjects/HangmanDe/src/deutsch.txt"); //put your path in here from the english3.txt file

        Scanner scanner = new Scanner(dictionary);
        Scanner input = new Scanner(System.in);

        int lives = 6;

        ArrayList<String> words = new ArrayList<>();

        while (scanner.hasNext()) {
            words.add(scanner.nextLine() );
        }

        String guess = words.get((int)(Math.random() * words.size()));
        char[] textArray = guess.toCharArray();

        char[] myAnswer = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            myAnswer[i] = '?';
        }

        boolean finish = false;

        while (finish == false) {
            System.out.println("**************************");
            System.out.println("Bitte gib ein Buchstaben ein");

            String letter = input.next();

            while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
                System.out.println("Keine Valide Eingabe || Versuche es nochmal"); // f string and putt l31 in
                letter = input.next();
            }

            boolean found = false;
            for (int i = 0; i < textArray.length; i++) {
                if (letter.charAt(0) == textArray[i]) {
                    myAnswer[i] = textArray[i];
                    found = true;
                }
            }

            if (!found) {
                lives--;

                System.out.println("Dieser Buchstabe ist nicht im Wort");
            }

            boolean done = true;
            for (int i = 0; i < myAnswer.length; i++) {
                if (myAnswer[i] == '?') {
                    System.out.print(" _");
                    done = false;
                } else {
                    System.out.print(" " + myAnswer[i]);
                }
            }

            System.out.println("\n" + "Leben übrig " + lives);
            drawHangman(lives);

            if (done) {
                System.out.println("Du hast gewonnen :D");
                finish = true;
            }

            if (lives <= 0) {
                System.out.println("Du hast verloren D:");
                System.out.printf("Das Wort war: %s", guess);
                finish = true;
            }
        }
    }
    public static void drawHangman(int l) {
        if(l == 6) {
            System.out.println("|----------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 5) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 4) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|    |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 3) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 2) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else if(l == 1) {
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
        else{
            System.out.println("|----------");
            System.out.println("|    O");
            System.out.println("|   -|-");
            System.out.println("|   /|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
        }
    }
}
