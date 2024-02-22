package com.zs25.programs;

public class BobAliceGame {
    public static void main(String[] args) {
        BobAliceGame game = new BobAliceGame();
        game.formSubset(new int[]{1, 1, 2, 3, 12, 34, 12}, new int[]{1,2, 12});

    }
    public void formSubset(int[] distinctElements, int[] array){
        for(int i=0; i<array.length; i++){
            for(int j=0; j<distinctElements.length; j++) {
                if (array[i] != distinctElements[j]) {
                    array[i] = 0;
                }
            }
        }
    }
}

