
package questao6;

public class Questao6 {

    public static void main(String[] args) {
        System.out.println(funcao(-4, -3));
    }
    
    private static int funcao(int a, int b){
        if (b == 0){
            return 0;
        } else if (b == 1){
            return a;
        } else if (b>1){
            return a + funcao(a,b -1);
        } else {
            return -a + funcao(a,b+1);
        }
    }
    
}
