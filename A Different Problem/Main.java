import java.util.Scanner;
public class Main{
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        
        while(s.hasNextLong()){
            long a = s.nextLong();
            long b = s.nextLong();
            System.out.println(Math.abs(a-b));
        }
    }
}