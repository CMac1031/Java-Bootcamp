public class LoopsPractice{
    public static void main(String[] args){
        nestedForLoop();
        whileLoop();
        doWhileLoop();
    }
    public static void nestedForLoop(){
        System.out.print("Nested For Loop: ");
        for(int i = 1; i<5; i ++){
            for(int j = 1; j < 5; j ++){
                System.out.print(i*j+ " ");
            }
        }
        System.out.print("\n");
    }
    public static void whileLoop(){
        int i = 0;
        System.out.print("While Loop: ");
        while(i <= 5){
            System.out.print(i+" ");
            i++;
        }
        System.out.print("\n");
    }
    public static void doWhileLoop(){
        int n = 5, sum = 0, i = 1;
        while (i <= n) {
            sum += i;
            i++;
            System.out.print(sum+" ");
        }
    }
}