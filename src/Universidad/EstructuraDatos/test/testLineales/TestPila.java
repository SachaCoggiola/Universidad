package Universidad.EstructuraDatos.test.testLineales;

import Universidad.EstructuraDatos.lineal.estatico.Pila;
import static org.junit.Assert.*;
import org.junit.*;

public class TestPila {
    @Test
    public void testCrearPilaVacia(){
        Pila pila = new Pila();
        boolean ev = pila.esVacia();
        Object t = pila.obtenerTope();
        //String s = pila.toString();
        //String rx = "\[\]";
        //boolean findSubstring = isSubstring(s, rx);
        assertEquals(ev, true);
        assertEquals(t, null);

    }

}
