public class Disappeardle {


    //4/21/22 9pm

    public static void main (String[] args) { new Disappeardle().run();}
    private WordleModel model;

        public void run() {
            model = new WordleModel();
            String correct = model.getCorrect();
            String finalScore = "";

            String[] guesses = new String[6];
            int attempts = 0;
            title(); // title screen, prints directions
            guesses[attempts] = StdIn.readLine();
            String acc = model.checkWord(guesses[attempts]); // stores the accuracy of guess
            while (attempts < 5 && acc != "22222") {
                if (acc != "-1") {
                    attempts++;
                }
                else {
                    StdOut.println("That is not a valid guess. Please enter a valid five letter word:");
                    guesses[attempts] = StdIn.readLine();
                    acc = model.checkWord(guesses[attempts]); // stores the accuracy of guess
                    continue;
                }
                for (int i = 0; i < 20; i++){
                    StdOut.println("*");} // prints the 'space' to make history disappear
                StdOut.println(guesses[attempts - 1]);
                StdOut.println(model.checkWord(guesses[attempts - 1]));
                StdOut.println("Guesses: " + attempts + "/6"); // keeps count of number of guesses
                StdOut.println("Guess Again:");
                guesses[attempts] = StdIn.readLine();
                StdOut.println(guesses[attempts]);
                acc = model.checkWord(guesses[attempts]); // stores the accuracy of guess
                finalScore += acc + "   ";
            }
            StdOut.println("Guesses: " + (attempts + 1) + "/6");
            StdOut.println("You have ran out of guesses. The answer was:");
            StdOut.println(correct);
            StdOut.println("Your final score: " + finalScore);
        }

        public void title() {
            StdOut.println("Welcome to Disappeardle!");
            StdOut.println("Type in a guess and press 'enter'");
            StdOut.println("If a letter in your guess is **present** in the word but wrong place, a '1' will be displayed in that place.");
            StdOut.println("If a letter in your guess is in the **right place**, a '2' will be displayed in that place.");
            StdOut.println("If a letter in your guess is **not present** in the word, a '0' will be displayed in that place.");
            StdOut.println("Once you guess, only your most recent guess will be displayed, so remember what you enter!");
            StdOut.println("Make your first guess: ");
    }
    }
