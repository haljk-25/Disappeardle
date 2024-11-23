 class WordleModel {

    private String correct;

    private String[] dictionary;

    private String[] allowed;

    // reads file and generates random word
    public WordleModel() {
        dictionary = new In("wordle-answers-alphabetical.txt").readAllLines();
        allowed = new In("wordle-allowed-guesses.txt").readAllLines();
        correct = dictionary[StdRandom.uniform(dictionary.length)];

    }

    // returns random word
    public String getCorrect () {
        return correct;
    }

    // returns true if guess is in allowed
     public static boolean contains(String guess, String[] allowed) {
         for (int i = 0; i < allowed.length; i++) {
             if (guess.equals(allowed[i])) {
                 return true;
             }
         }
         return false;
     }

    // returns true is guess equals to correct
    public boolean getCheck(String guess, String correct) {
        for (int i = 0; i < guess.length(); i++) {
            if (guess.equals(allowed[i])) {
                return true;
            }
        }
        return false;
    }

    // present, present wrong place, wrong place
    public String checkWord(String guess, String correct) {
        String[] word = guess.split("");
        String[] targetWord = correct.split("");
        String results = String.valueOf(new String[6]);
        boolean isPresent = false;
        for (int i = 0; i < guess.length(); i++) {
            isPresent = false;
            if (word[i] == targetWord[i]) {
                results += "correct";
            }
            continue;
        }
        for (int j = 0; j < guess.length(); j++) {
            if (word[j] == targetWord[j]) {
                results += "present";
                isPresent = true;
                break;
            }
        }
        if (isPresent == false) {
            results += "absent";
        }
        return results;
    }

     // returns true if guess length is 5
     public boolean wordLength(String guess) {
         if (guess.length() == 5) {
             return true;
         }
         return false;
    }

}





