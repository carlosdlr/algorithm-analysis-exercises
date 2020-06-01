package com.carlosdlr.algorithm.exercises;

/**
 * When you select a contiguous block of text in a PDF viewer, the selection is highlighted with a blue rectangle.
 * In this PDF viewer, each word is highlighted independently.
 * In this challenge, you will be given a list of letter heights in the alphabet and a string.
 * Using the letter heights given, determine the area of the rectangle highlight in mm power of 2 assuming all letters are 1mm wide.
 * For example, the highlighted word = torn.
 * Assume the heights of the letters are t = 2, o = 1, r = 1 and n = 1. The tallest letter is 2 high and there are 4 letters.
 * The highlighted area will be 2 * 4 =  8 mm power of 2  so the answer is 8.
 */
public class DesignerPDFViewer {

    public static void main(String args[]) {
       int [] h = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7};
       String word = "zaba";
        System.out.println(designerPdfViewer(h, word));

    }

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {
        if(h.length > 26)
            return 0;

        if(word.length() > 10)
            return 0;

        int highest = 0;
        int wordLength =  word.length();

        for(int i = 0; i < wordLength; i++) {
           int value = h[(int) word.charAt(i) -97];
           if(value > highest)
               highest = value;
        }

        return highest * wordLength;
    }
}
