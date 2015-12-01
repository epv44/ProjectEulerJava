
public class Problem5 {
    public static void smallestMultiple(){
        int result = 1;
        for(int i = 10; i<20; i++){
            result = LCM(result, i);
        }
        
        System.out.println("The answer is: " + result);
    }

    private static int GCD(int a, int b){
        while(b>0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private static int LCM(int a, int b){
        return ((a * b)/GCD(a, b));
    }
}
