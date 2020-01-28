package com.company;

public class WordPuzzle {
    private char[][] coordinates;
    private String[] words;

    public WordPuzzle() {
        coordinates = new char[4][4];
        char[] chars = {'t', 'h', 'i', 's', 'w', 'a', 't', 's', 'o', 'a', 'h', 'g', 'f', 'g', 'd', 't'};
        int x = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                coordinates[i][j] = chars[x];
                x++;
            }
        }
        words = new String[4];
        words[0] = "this";
        words[1] = "two";
        words[2] = "fat";
        words[3] = "that";
    }

    public void search() {
        int startingColumn, startingRow;
        for (String word : words) {
            for (int row = 0; row < coordinates.length; row++) {
                for (int column = 0; column < coordinates.length; column++) {
                    if (coordinates[row][column] == word.charAt(0)) {
                        startingColumn = column;
                        startingRow = row;

                        try {
                            if (coordinates[row - 1][column - 1] == word.charAt(1)) {
                                if (upLeft(row, column, word).equals(word)) {
                                    System.out.println("Found " + word + " from ("
                                            + (startingRow + 1) + "," + (startingColumn + 1) + ") to (" + (startingRow - word.length() + 2)
                                            + "," + (startingColumn - word.length() + 2) + ")");
                                }
                            }
                        } catch (IndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (coordinates[row - 1][column] == word.charAt(1)) {
                                if (up(row, column, word).equals(word)) {
                                    System.out.println("Found " + word + " from ("
                                            + (startingRow + 1) + "," + (startingColumn + 1) + ") to (" + (startingRow - word.length() + 2)
                                            + "," + (startingColumn + 1) + ")");
                                }
                            }
                        } catch (IndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (coordinates[row - 1][column + 1] == word.charAt(1)) {
                                if (upRight(row, column, word).equals(word)) {
                                    System.out.println("Found " + word + " from ("
                                            + (startingRow + 1) + "," + (startingColumn + 1) + ") to (" + (startingRow - word.length() + 2)
                                            + "," + (startingColumn + word.length()) + ")");
                                }
                            }
                        } catch (IndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (coordinates[row][column - 1] == word.charAt(1)) {
                                if (left(row, column, word).equals(word)) {
                                    System.out.println("Found " + word + " from ("
                                            + (startingRow + 1) + "," + (startingColumn + 1) + ") to (" + (startingRow + 1)
                                            + "," + (startingColumn - word.length() + 1) + ")");
                                }
                            }
                        } catch (IndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (coordinates[row][column + 1] == word.charAt(1)) {
                                if (right(row, column, word).equals(word)) {
                                    System.out.println("Found " + word + " from ("
                                            + (startingRow + 1) + "," + (startingColumn + 1) + ") to (" + (startingRow + 1)
                                            + "," + (startingColumn + word.length()) + ")");
                                }
                            }
                        } catch (IndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (coordinates[row + 1][column - 1] == word.charAt(1)) {
                                if (downLeft(row, column, word).equals(word)) {
                                    System.out.println("Found " + word + " from ("
                                            + (startingRow + 1) + "," + (startingColumn + 1) + ") to (" + (startingRow + word.length() + 1)
                                            + "," + (startingColumn - word.length() + 1) + ")");
                                }
                            }
                        } catch (IndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (coordinates[row + 1][column] == word.charAt(1)) {
                                if (down(row, column, word).equals(word)) {
                                    System.out.println("Found " + word + " from ("
                                            + (startingRow + 1) + "," + (startingColumn + 1) + ") to (" + (startingRow + word.length())
                                            + "," + (startingColumn + 1) + ")");
                                }
                            }
                        } catch (IndexOutOfBoundsException ignore) {
                        }
                        try {
                            if (coordinates[row + 1][column + 1] == word.charAt(1)) {
                                if (downRight(row, column, word).equals(word)) {
                                    System.out.println("Found " + word + " from ("
                                            + (startingRow + 1) + "," + (startingColumn + 1) + ") to (" + (startingRow + word.length() + 1)
                                            + "," + (startingColumn + word.length() + 1) + ")");
                                }
                            }
                        } catch (IndexOutOfBoundsException ignore) {
                        }
                    }
                }
            }
        }
    }

    private String up(int row, int column, String word) {
        String progress = "" + word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (coordinates[row - i][column] == word.charAt(i)) {
                progress = progress + word.charAt(i);
            }
        }
        return progress;
    }

    private String down(int row, int column, String word) {
        String progress = "" + word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (coordinates[row + i][column] == word.charAt(i)) {
                progress = progress + word.charAt(i);
            }
        }
        return progress;
    }

    private String left(int row, int column, String word) {
        String progress = "" + word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (coordinates[row][column - i] == word.charAt(i)) {
                progress = progress + word.charAt(i);
            }
        }
        return progress;
    }

    private String right(int row, int column, String word) {
        String progress = "" + word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (coordinates[row][column + i] == word.charAt(i)) {
                progress = progress + word.charAt(i);
            }
        }
        return progress;
    }

    private String upLeft(int row, int column, String word) {
        String progress = "" + word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (coordinates[row - i][column - i] == word.charAt(i)) {
                progress = progress + word.charAt(i);
            }
        }
        return progress;
    }

    private String upRight(int row, int column, String word) {
        String progress = "" + word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (coordinates[row - i][column + i] == word.charAt(i)) {
                progress = progress + word.charAt(i);
            }
        }
        return progress;
    }

    private String downLeft(int row, int column, String word) {
        String progress = "" + word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (coordinates[row + i][column - i] == word.charAt(i)) {
                progress = progress + word.charAt(i);
            }
        }
        return progress;
    }

    private String downRight(int row, int column, String word) {
        String progress = "" + word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (coordinates[row + i][column + i] == word.charAt(i)) {
                progress = progress + word.charAt(i);
            }
        }
        return progress;
    }

    public void print() {
        System.out.print("# ");
        for (int n = 1; n < coordinates.length + 1; n++) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int i = 0; i < coordinates.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < coordinates[i].length; j++) {
                System.out.print(coordinates[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
