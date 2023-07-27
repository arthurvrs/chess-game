package util;

public class Character {

    /*static String NEWLINE = "\n";
    public boolean isWhitespace(char character) {
        if(character == '\n' || character == '\t' || character == '\b') {
            return true;
        }
        return false;
    }

    public String getNEWLINE() {
        return NEWLINE;
    }*/

    public static int[] getLocation(String location) {
        int[] aux = new int[2];
        int auxRank = 0;
        int auxFile = 0;
        String rank = location.substring(1,2);
        String files = location.substring(0,1);
        switch(rank) {
            case "1": auxRank = 7; break;
            case "2": auxRank = 6; break;
            case "3": auxRank = 5; break;
            case "4": auxRank = 4; break;
            case "5": auxRank = 3; break;
            case "6": auxRank = 2; break;
            case "7": auxRank = 1; break;
            case "8": auxRank = 0; break;
        }
        switch(files) {
            case "a": auxFile = 0; break;
            case "b": auxFile = 1; break;
            case "c": auxFile = 2; break;
            case "d": auxFile = 3; break;
            case "e": auxFile = 4; break;
            case "f": auxFile = 5; break;
            case "g": auxFile = 6; break;
            case "h": auxFile = 7; break;
        }
        aux[0] = auxRank;
        aux[1] = auxFile;
        return aux;
    }
}
