import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        int[] valores = {4 ,3 ,5 ,-5 ,0 ,1 ,8 ,10 ,-21};
        boolean[] subc = subcSuma0MaxElem(valores);
        int sum = 0;
        System.out.print("[");
        for (int i = 0; i < valores.length; i++) {
            if(subc[i]){
                System.out.print(" " + valores[i] + " ");
            }
        }
        System.out.println("]");
    }

    public static boolean[] subcSuma0MaxElem(int[] v){
        //Suponemos que el array no está vacío
        boolean[] subc = new boolean[v.length];
        boolean[] subcAux = new boolean[v.length];
        setAllFalse(subc);
        setAllFalse(subcAux);
        subcSuma0MaxElemAux(v,subc,subcAux,0,0);
        return subc;
    }

    public static void subcSuma0MaxElemAux(int[] v, boolean[] mejor,boolean[] actual, int suma, int index){
        if(suma == 0 && getBooleanLength(actual) > 0 && getBooleanLength(mejor) < getBooleanLength(actual)){
            for (int i = 0; i < mejor.length; i++) {
                mejor[i] = actual[i];
            }
        }else {
            for (int i = index+1; i < v.length; i++) {
                suma += v[i];
                actual[i] = true;
                subcSuma0MaxElemAux(v, mejor, actual, suma, i);
                actual[i] = false;
                suma -= v[i];
            }
        }
    }

    public static void setAllFalse(boolean[] v){
        for (int i = 0; i < v.length; i++) {
            v[i]=false;
        }
    }

    public static int getBooleanLength(boolean[]v){
        int s = 0;
        for (int i = 0; i < v.length; i++) {
            if(v[i])
                s++;
        }
        return s;
    }



}