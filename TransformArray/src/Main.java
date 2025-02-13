import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        prueba1();
    }


    public static void prueba1( ){
        Object[] arregloPrueba=TransformArray.Transform(new Object[]{'a','e','i',new Object[]{'o','u'}}, new ArrayList<>());
        Object[] arregloCorrecto= new Object[]{'a','e','i','o','u'};
        System.out.println(listar(arregloPrueba)+"  "+listar(arregloCorrecto));
        if(listar(arregloPrueba).equals(listar(arregloCorrecto))){
            System.out.println("Correcto");
        }else{
            System.out.println("Incorrecto");
        }
    }

    public static  String  listar(Object[] arreglo){
        String palabra="";
        for (int i=0; i<arreglo.length; i++){
            palabra= palabra + arreglo[i].toString();
        }
        return palabra;
    }
}