package oop;
public class Word {
String word = "apple";
Word(String word)
{
this.word=word;
}
}

package oop;
public abstract class Player {
String name;
Player(String name)
{
this.name=name;
}
public abstract int checkGuess(Word word);
}

package oop;
import java.util.Scanner;
public class Player1 extends Player {
String name;
Player1(String name)
{
super(name);
this.name=name;

}
public int checkGuess(Word word) {
Scanner scanner = new Scanner(System.in);
char[] guessWord = new char[word.word.length()];
for (int i = 0; i < guessWord.length; i++) {
guessWord[i] = '_';
}
System.out.println(this.name + ", please enter your guess: ");
int numGuesses = 0;
while (true) {
String guess = scanner.nextLine();
int numMatches = 0;
for (int i = 0; i < word.word.length(); i++) {
if (word.word.charAt(i) == guess.charAt(0)) {
guessWord[i] = guess.charAt(0);
numMatches++;
}
}
System.out.println(guessWord);
if (numMatches == 0) {
System.out.println("Incorrect!");
} else {
System.out.println("Correct!");
}
numGuesses++;
if (word.word.equals(new String(guessWord))) {
System.out.println("Congratulations, you guessed the word in " + numGuesses +

" guesses!");
break;
} else {
System.out.println("Please enter your next guess: ");
}
}
return numGuesses;
}
}

package oop;
import java.util.Scanner;
public class Player2 extends Player {
String name;

Player2(String name)
{
super(name);
this.name=name;
}
public int checkGuess(Word word) {
Scanner scanner = new Scanner(System.in);
char[] guessWord = new char[word.word.length()];
for (int i = 0; i < guessWord.length; i++) {
guessWord[i] = '_';
}
System.out.println(this.name + ", please enter your guess: ");
int numGuesses = 0;
while (true) {
String guess = scanner.nextLine();
int numMatches = 0;
for (int i = 0; i < word.word.length(); i++) {
if (word.word.charAt(i) == guess.charAt(0)) {
guessWord[i] = guess.charAt(0);
numMatches++;
}
}
System.out.println(guessWord);
if (numMatches == 0) {
System.out.println("Incorrect!");
} else {
System.out.println("Correct!");
}
numGuesses++;
if (word.word.equals(new String(guessWord))) {
System.out.println("Congratulations, you guessed the word in " + numGuesses +

" guesses!");
break;
} else {
System.out.println("Please enter your next guess: ");
}
}
return numGuesses;
}
}

package oop;
public class Main {
public static void main(String[] args) {
System.out.println("Welcome, try to guess the word! HINT: It's a fruit of 5 letters");

Word word = new Word("apple");
Player1 player1 = new Player1("Munia");
Player2 player2 = new Player2("Nihal");
int guessesPlayer1 = player1.checkGuess(word);
int guessesPlayer2 = player2.checkGuess(word);
if (guessesPlayer1 < guessesPlayer2) {
System.out.println(player1.name + " wins with " + guessesPlayer1 + " guesses!");
} else if (guessesPlayer2 < guessesPlayer1) {
System.out.println(player2.name + " wins with " + guessesPlayer2 + " guesses!");
} else {
System.out.println("It's a tie!");
}
}
}