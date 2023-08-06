import java.util.Scanner;
public class Lab2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.nextLine();
        String string[] = new String[a];
        String result[] = new String[a];

        for (int i = 0; i < a; i++) {
            string[i] = sc.nextLine();
            if (checkEmail(string[i])) {
                result[i] = "Email";
            } else if (CheckWeb(string[i])) {
                result[i] = "Web";
            } else
                result[i] = "Invalid";
        }

        for (int i = 0; i < a; i++) {
            System.out.println(result[i] + ", " + (i + 1));
        }

    }

    public static boolean checkEmail(String text) {
        int state = 0;
        String validsigns = "!#$%^&*()-/~[]";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            switch (state) {
                case 0:
                    if (Character.isLetter(ch)) {
                        state = 1;
                    } else
                        state = 2;
                    break;
                case 1:
                    if (Character.isLetter(ch) || Character.isDigit(ch)
                            || validsigns.contains((Character.toString(ch)))) {
                        state = 1;
                    } else if (ch == '@') {
                        state = 3;
                    } else
                        state = 2;
                    break;
                case 2:
                    break;
                case 3:
                    if (Character.isLetter(ch)) {
                        state = 4;
                    } else {
                        state = 2;
                    }
                    break;
                case 4:
                    if (ch == '.') {
                        state = 5;
                    } else if (Character.isLetter(ch) || validsigns.contains((Character.toString(ch)))) {
                        state = 4;
                    } else
                        state = 2;
                    break;
                case 5:
                    if (Character.isLetter(ch)) {
                        state = 6;
                    } else
                        state = 2;
                    break;
                case 6:
                    if (ch == '.') {
                        state = 5;
                    } else if (Character.isLetter(ch) || validsigns.contains((Character.toString(ch)))) {
                        state = 6;
                    } else
                        state = 2;
                    break;
                default:
                    break;
            }
        }

        if (state == 6)
            return true;
        ;

        return false;
    }

    static boolean CheckWeb(String text) {
        int state = 0;
        String validsigns = "#$*{}[].-_";

        if (text.isEmpty()) {
            return false;
        }


        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            switch (state) {

                case 0:
                    if (ch == 'w') {
                        state = 1;
                    } else
                        state = 4;
                    break;
                case 1:
                    if (ch == 'w') {
                        state = 2;
                    } else
                        state = 4;
                    break;
                case 2:
                    if (ch == 'w') {
                        state = 3;
                    } else
                        state = 4;
                    break;
                case 3:
                    if (ch == '.') {
                        state = 5;
                    } else
                        state = 4;
                    break;
                case 4:
                    break;
                case 5:
                    if (Character.isLetter(ch) || Character.isDigit(ch)||validsigns.contains((Character.toString(ch)))) {
                        state = 6;
                    } else
                        state = 4;
                    break;
                case 6:
                    if (ch == '.') {
                        state = 7;

                    } else
                        state = 4;
                    break;
                case 7:
                    if (Character.isLetter(ch)) {
                        state = 8;
                    }
                    else
                        state = 4;
                    break;
                case 8:
                    if (ch == '.') {
                        state = 7;
                    } else if (Character.isLetter(ch)) {
                        state = 8;
                    } else
                        state = 4;
                    break;
                default:
                    break;
            }
        }

        if (state == 8)
            return true;

        return false;
    }
}
