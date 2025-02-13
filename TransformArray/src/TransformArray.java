import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class TransformArray {

    public static Object[] Transform(Object[] arreglo, ArrayList<Object>  arregloNuevo){
        for (int i=0; i<arreglo.length; i++) {
            if (arreglo[i].getClass().isArray()) {
                System.out.println(arreglo[i]);
                System.out.println(arreglo[i].getClass().isArray());
                Transform((Object[]) arreglo[i], arregloNuevo);
            } else {
                System.out.println(arreglo[i].getClass().isArray());
                System.out.println(arreglo[i]);
                arregloNuevo.add(arreglo[i]);
            }
        }
        return arregloNuevo.toArray();
    }
}
