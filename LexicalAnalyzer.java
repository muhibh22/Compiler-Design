import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LexicalAnalyzer {
    public static ArrayList<String> Key_Words = new ArrayList<String>();
    public static ArrayList<String> Identifiers = new ArrayList<String>();
    public static ArrayList<String> Math_Operators = new ArrayList<String>();
    public static ArrayList<String> Logical_Operators = new ArrayList<String>();
    public static ArrayList<String> Numbers = new ArrayList<String>();
    public static ArrayList<String> Others = new ArrayList<String>();
    public void analyze() throws FileNotFoundException {

        try {

            File file = new File("input.txt");

            Scanner sc = new Scanner(file);

            LexicalAnalyzer la = new LexicalAnalyzer();

            while (sc.hasNext()) {
                String currentline = sc.nextLine();
                la.tokenDetector(currentline);
            }
            sc.close();

            System.out.print("Keywords: ");
            printArrayList(Key_Words);
            System.out.print("Identifiers: ");
            printArrayList(Identifiers);
            System.out.print("Math Operators: ");
            printArrayList(Math_Operators);
            System.out.print("Logical Operators: ");
            printArrayList(Logical_Operators);
            System.out.print("Numeric Values: ");
            printArrayList(Numbers);
            System.out.print("Others: ");
            for (String x : Others) {
                System.out.print(x);
            }

        }

        catch (Exception e) {
            System.out.println(e);
        }

    }

    public void tokenDetector(String e) {

        StringTokenizer st = new StringTokenizer(e);

        String X;

        while (st.hasMoreTokens()) {
            X = st.nextToken();
            if (RightKeywords(X)) {
                if (!Key_Words.contains(X)) {
                    Key_Words.add(X);
                }
            } else if (RightMathOperator(X)) {
                if (!Math_Operators.contains(X)) {
                    Math_Operators.add(X);
                }
            } else if (RightLogicalOperator(X)) {
                if (!Logical_Operators.contains(X)) {
                    Logical_Operators.add(X);
                }
            } else if (RightIdentifier(X)) {
                if (!Identifiers.contains(X)) {
                    Identifiers.add(X);
                }
            } else if (RightNumbers(X)) {
                if (!Numbers.contains(X)) {
                    Numbers.add(X);
                }
            } else {
                if (!Others.contains(X)) {
                    Others.add(X);
                }
            }
        }
    }

    public boolean RightKeywords(String f) {
        String[] keywordsInC = { "auto", "double", "int", "struct", "break", "else", "long", "switch", "case", "enum",
                "register", "typedef", "const", "extern", "return", "union", "char", "float", "short", "unsigned",
                "continue", "for", "signed", "volatile", "default", "goto", "sizeof", "void", "do", "if", "static",
                "while" };

        ArrayList<String> keys = new ArrayList<String>(Arrays.asList(keywordsInC));

        if (keys.contains(f)) {
            return true;
        }
        return false;
    }

    public boolean RightMathOperator(String f) {
        String[] mathOperatorsInC = { "+", "-", "*", "/", "=","%", "++", "--" };

        ArrayList<String> ops = new ArrayList<String>(Arrays.asList(mathOperatorsInC));

        if (ops.contains(f)) {
            return true;
        }
        return false;
    }

    public boolean RightLogicalOperator(String f) {
        String[] logicalOperatorsInC = { "<", ">","==", "!", "!=" ,"||" , "&&"};

        ArrayList<String> ops = new ArrayList<String>(Arrays.asList(logicalOperatorsInC));

        if (ops.contains(f)) {
            return true;
        }
        return false;
    }

    public boolean RightIdentifier(String f) {

        String regex = "^([a-zA-Z_$][a-zA-Z\\d_$]*)$";

        Pattern p = Pattern.compile(regex);

        if (f == null) {
            return false;
        }

        Matcher m = p.matcher(f);

        return m.matches();

    }

    public boolean RightNumbers(String f) {

        String regex = "^(?:-(?:[1-9](?:\\d{0,2}(?:,\\d{3})+|\\d*))|(?:0|(?:[1-9](?:\\d{0,2}(?:,\\d{3})+|\\d*))))(?:.\\d+|)$";

        Pattern p = Pattern.compile(regex);

        if (f == null) {
            return false;
        }

        Matcher m = p.matcher(f);

        return m.matches();

    }

    public void printArrayList(ArrayList l) {
        for (int i = 0; i < l.size(); i++) {
            if (i == l.size() - 1) {
                System.out.println(l.get(i));
            } else {
                System.out.print(l.get(i) + ", ");
            }
        }
    }
}