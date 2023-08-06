import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
public class L3 {
    public static void main(String[]args){
        Scanner sc= new Scanner(System.in);
        int p,l;
        p=sc.nextInt();
        String[]regex=new String[p];
        for(int i=0; i<p;i++){
            regex[i]=sc.next();
        }
        l=sc.nextInt();
       String[]line=new String[l];
        for(int i=0; i<l;i++){
            line[i]=sc.next();
        }
        for(int i=0;i<line.length;i++){
            for(int j=0; j<regex.length;j++){
                Pattern r=Pattern.compile(regex[j]);
                Matcher m=r.matcher(line[i]);
                if(m.find()){
                    System.out.println("YES, "+(j+1));
                    break;
                }
                else if(j==(regex.length-1)){
                    System.out.println("NO, "+0);
                    break;
                }
            
                
                }
           

        }
        sc.close();

    }
    
}
