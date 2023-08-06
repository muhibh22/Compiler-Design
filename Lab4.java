import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Stack;


public class Lab4 {
public static void main(String []args) throws IOException {
	File file =new File("input.txt");
	Scanner sc= new Scanner(file);
	FileInputStream fis = new FileInputStream(file);
	byte[] byteArray = new byte[(int)file.length()];
    fis.read(byteArray);
    String data = new String(byteArray);
    String[] stringArray = data.split("\r\n");
    //System.out.println("Number of lines in the file are ::"+stringArray.length);
	String[]s=new String[stringArray.length];
	int i=0;
	while(sc.hasNextLine()) {
		s[i]=sc.nextLine();
		i++;
	}
	sc.close();
	fis.close();
	System.out.println("Methods:");
	method2(s);
	method1(s);
	method3(s);
	
}
public static void method1(String[]s) {
	Stack<Character> stack= new Stack<Character>();
	String pattern="(public|private)\\ (void)\\ +[a-zA-Z1-9]+\\(\\)";
	Pattern r= Pattern.compile(pattern);
	for(int i=0;i<s.length;i++) {
		Matcher m= r.matcher(s[i]);
		if(m.find()) {
			char[] c= s[i].toCharArray();
			int countpop=0;
			for(int j=0;j<c.length;j++) {
				stack.push(c[j]);
				if(stack.peek()=='(') {
					stack.pop();
					while(stack.peek()!=null) {
						stack.pop();
						countpop++;
						if(stack.peek()==' ') {
							for(int k=j-countpop;k<c.length;k++) {
								stack.push(c[k]);
	    						System.out.print(stack.peek());
	    						if(stack.peek()==')') {
	    							break;
	    						}
							}
							break;
						}
					}
				}
			}
			stack.clear();
			countpop =0;
			int count=0;
			System.out.print(", return type: ");
			try {
				for(int j=0;j<c.length;j++) {
					stack.push(c[j]);
					if(stack.peek()=='(') {
						while(stack.peek()!=null) {
							stack.pop();
							countpop++;
							if(stack.peek()==' ') {
							while(stack.peek()!=null) {
								stack.pop();
								count++;
								if(stack.peek()==' ') {
									for(int k=j-(countpop+count);k<(j-countpop);k++) {
										stack.push(c[k]);
										System.out.print(stack.peek());
									}
									break;
								}
							}
							break;
							}
						}
					}
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {}
			System.out.println();
		}
	}
	
}
public static void method2(String[]s) {
	Stack<Character> stack= new Stack<Character>();
	String pattern="(public|private)\\ +[a-zA-Z]+\\ +[a-zA-Z1-9]+\\(+[a-zA-Z ,]+\\)";
	Pattern r= Pattern.compile(pattern);
	for(int i=0;i<s.length;i++) {
		Matcher m= r.matcher(s[i]);
		if(m.find()) {
			char[] c= s[i].toCharArray();
			int countpop=0;
			for(int j=0;j<c.length;j++) {
				stack.push(c[j]);
				if(stack.peek()=='(') {
					stack.pop();
					while(stack.peek()!=null) {
						stack.pop();
						countpop++;
						if(stack.peek()==' ') {
							for(int k=j-countpop;k<c.length;k++) {
								stack.push(c[k]);
	    						System.out.print(stack.peek());
	    						if(stack.peek()==')') {
	    							break;
	    						}
							}
							break;
						}
					}
				}
			}
			stack.clear();
			countpop =0;
			int count=0;
			System.out.print(", return type: ");
			try {
				for(int j=0;j<c.length;j++) {
					stack.push(c[j]);
					if(stack.peek()=='(') {
						while(stack.peek()!=null) {
							stack.pop();
							countpop++;
							if(stack.peek()==' ') {
							while(stack.peek()!=null) {
								stack.pop();
								count++;
								if(stack.peek()==' ') {
									for(int k=j-(countpop+count);k<(j-countpop);k++) {
										stack.push(c[k]);
										System.out.print(stack.peek());
									}
									break;
								}
							}
							break;
							}
						}
					}
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {}
			System.out.println();
		}
	}
}
public static void method3(String[]s) {
	Stack<Character> stack= new Stack<Character>();
	String pattern="(public|private)\\ (static)\\ +[a-zA-Z]+\\ +[a-zA-Z1-9]+\\(+[a-zA-Z ,]+\\)";
	Pattern r= Pattern.compile(pattern);
	for(int i=0;i<s.length;i++) {
		Matcher m= r.matcher(s[i]);
		if(m.find()) {
			char[] c= s[i].toCharArray();
			int countpop=0;
			for(int j=0;j<c.length;j++) {
				stack.push(c[j]);
				if(stack.peek()=='(') {
					stack.pop();
					while(stack.peek()!=null) {
						stack.pop();
						countpop++;
						if(stack.peek()==' ') {
							for(int k=j-countpop;k<c.length;k++) {
								stack.push(c[k]);
	    						System.out.print(stack.peek());
	    						if(stack.peek()==')') {
	    							break;
	    						}
							}
							break;
						}
					}
				}
			}
			stack.clear();
			countpop =0;
			int count=0;
			System.out.print(", return type: ");
			try {
				for(int j=0;j<c.length;j++) {
					stack.push(c[j]);
					if(stack.peek()=='(') {
						while(stack.peek()!=null) {
							stack.pop();
							countpop++;
							if(stack.peek()==' ') {
							while(stack.peek()!=null) {
								stack.pop();
								count++;
								if(stack.peek()==' ') {
									for(int k=j-(countpop+count);k<(j-countpop);k++) {
										stack.push(c[k]);
										System.out.print(stack.peek());
									}
									break;
								}
							}
							break;
							}
						}
					}
				}
			}
			catch(ArrayIndexOutOfBoundsException e) {}
			System.out.println();
		}
	}
}
}