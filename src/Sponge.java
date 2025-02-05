public class Sponge {

  /*
   * Create a method "spongeCase" that takes a string consisting of one or more words 
   * separated by spaces. It should return a new string converted to "sponge 
   * case," where each word starts with a lowercase letter, and then alternates 
   * between upper and lower case for each following letter in the word.
   *
   * Examples:
   *
   * spongeCase("spongebob")  should return "sPoNgEbOb"
   * spongeCase("Who are YOU calling A Pinhead")  should return "wHo aRe yOu cAlLiNg a pInHeAd"
   * spongeCase("WHAT is UP my dude")  should return "wHaT iS uP mY dUdE"
   * spongeCase("debí tir  ar más fotos") should return dEbÍ tIrAr mÁs fOtOs" (note the accents)
   * spongeCase("E")  should return "e"
   * spongeCase("e")  should return "e"
   * 
   * Hints:
   * There exist the following methods in java:
   * Character.toUpperCase() (e.g. Character.toUpperCase('f'))
   * Character.toLowerCase() (e.g. Character.toLowerCase('Q'))
   * .toCharArray() String method (e.g. myString.toCharArray())
   */
  public static void main(String[] args) {
    // Test cases
    assertEqual(1, spongeCase("spongebob"), "sPoNgEbOb");
    assertEqual(2, spongeCase("Who are YOU calling A Pinhead"), "wHo aRe yOu cAlLiNg a pInHeAd");
    assertEqual(3, spongeCase("WHAT is UP my dude"), "wHaT iS uP mY dUdE");
    assertEqual(4, spongeCase("debí tirar más fotos"), "dEbÍ tIrAr mÁs fOtOs");
    assertEqual(5, spongeCase("E"), "e");
    assertEqual(6, spongeCase("e"), "e");
  }

  /*Implement your solution here!
  public static String spongeCase(String sentence) {
    return null;

  }*/

  public static String spongeCase(String sentence) {
    // Split the sentence into words
    String[] words = sentence.split(" ");
    StringBuilder result = new StringBuilder();

    // Loop through each word in the sentence
    for (int i = 0; i < words.length; i++) {
        result.append(spongeSingleWord(words[i]));
        if (i < words.length - 1) {
            result.append(" ");
        }
    }

    return result.toString();
}

// Helper method to convert a single word to sponge case
private static String spongeSingleWord(String word) {
    StringBuilder newWord = new StringBuilder();
    boolean toUpperCase = false;

    /*This loop iterates through each character in a word, checking if it is a letter. If it is a letter, it alternates 
    between uppercase and lowercase based on the  toUpperCase flag. The flag is then toggled to ensure the next letter follows the opposite case. If the character is not a 
letter, it is added to the new word without any modifications. This ensures that spaces and punctuation remain unchanged while only the letters alternate in case.
     The modified word is then returned after processing all its characters. */
    for (char letter : word.toCharArray()) {
        if (Character.isLetter(letter)) {
            newWord.append(toUpperCase ? Character.toUpperCase(letter) : Character.toLowerCase(letter));
            toUpperCase = !toUpperCase;
        } else {
            newWord.append(letter);
        }
    }

    return newWord.toString();
}

  
  // Method to help with testing, you do not need to read this.
  public static void assertEqual(int testNumber, String actual, String expected) {
    if (!expected.equals(actual)) {
      System.out.println("Test " + testNumber + " failed! Expected: '" + expected + "', but got: '" + actual + "'");
    } else {
      System.out.println("Test " + testNumber + " passed!");
    }
  }
}