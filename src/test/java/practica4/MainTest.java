/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4;
import practica4.CCuenta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 *
 * @author Enrique Iranzo Martínez
 * Todos los tests están comentados, para probar uno en específico hay que descomentarlo, lo he hecho así para poder tener todos los tests en un solo archivo .java 
 */
public class MainTest {
        CCuenta cuenta=new CCuenta("Enrique","1234-1234-56-87654321",500,0);
    public MainTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    /**
     * Test of main method, of class TestActividaENDES.
     */
   @org.junit.jupiter.api.Test
    public void testMain(){
        CCuenta cuenta=new CCuenta("Enrique","1234-1234-56-87654321",3000,0);
        double expected,numero=-60;
        expected=cuenta.estado()+numero;
        try{
        cuenta.ingresar(numero);
        } catch (Exception E){
            expected = cuenta.estado();
            System.out.println("No se pueden ingresar cantidades negativas");
        }
        assertEquals(expected,cuenta.estado());
    //Va a salir mal y saltará la excepción de que no se pueden introducir números negativos
    }
    
    @Test
    public void testMain2(){
        CCuenta cuenta2=new CCuenta("Enrique","1234-1234-56-87654321",3000,0);
        double expected,numero=300;
        expected=cuenta2.estado()+numero;
        try{
        cuenta2.ingresar(numero);
        } catch (Exception E){
            System.out.println("No se pueden ingresar cantidades negativas");
        }
        assertEquals(expected,cuenta2.estado());
    //Va a salir bien la prueba ya que se ingresa una cantidad positiva
    }

    @ParameterizedTest
    @ValueSource (doubles = {200, -60, 800})
    public void testMainP3 (double numero){
        double expected = cuenta.estado() -numero;
        try{
            cuenta.retirar (numero);
        }
        catch (Exception Ex){
            expected = cuenta.estado();
            System.out.println ("No se puede retirar una cantidad negativa");
        }
        assertEquals(expected, cuenta.estado());
    //El primer argumento que le pasamos pasará el test, ya que es una cantidad positiva y menor al saldo de la cuenta
    //El segundo y tercer argumento darán error, el segundo es menor a 0 y saltará la excepción y el tercero retirarrá más dinero del que hay en la cuenta
    }
 
    @Test
     public void testMain3(){
        CCuenta cuenta=new CCuenta("Enrique","1234-1234-56-87654321",200,0);
        double expected,expectedretirar,expectedfinal,numero=300;
        expected=cuenta.estado()+numero;
        try{
        cuenta.ingresar(numero);
        } catch (Exception E){
            expected = cuenta.estado();
            System.out.println("No se pueden ingresar cantidades negativas");
        }
        assertEquals(expected,cuenta.estado());
        
        double numeroretirar = 200 ;
        expectedretirar=cuenta.estado()-numeroretirar;
        try{
        cuenta.retirar(numeroretirar);
        } catch (Exception E){
            expected = cuenta.estado();
            System.out.println("No se pueden retirar cantidades negativas");
        }
        assertEquals(expectedretirar,cuenta.estado());
        //El test será válido puesto que en ambos métodos se cumplen las condiciones de entrada

    }
     
     
    @Test
     public void testMain4(){
        CCuenta cuenta=new CCuenta("Enrique","1234-1234-56-87654321",200,0);
        double expected,expectedretirar,expectedfinal,numero=-60;
        expected=cuenta.estado()+numero;
        try{
        cuenta.ingresar(numero);
        } catch (Exception E){
            expected = cuenta.estado();
            System.out.println("No se pueden ingresar cantidades negativas");
        }
        assertEquals(expected,cuenta.estado());
        
        double numeroretirar = 200 ;
        expectedretirar=cuenta.estado()-numeroretirar;
        try{
        cuenta.retirar(numeroretirar);
        } catch (Exception E){
            expected = cuenta.estado();
            System.out.println("No se pueden retirar cantidades negativas");
        }
        assertEquals(expectedretirar,cuenta.estado());
        //El test no será válido puesto que estamos ingresando una cantidad negativa
    }
     
    @Test
     public void testMain5(){
        CCuenta cuenta=new CCuenta("Enrique","1234-1234-56-87654321",200,0);
        double expected,expectedretirar,expectedfinal,numero=300;
        expected=cuenta.estado()+numero;
        try{
        cuenta.ingresar(numero);
        } catch (Exception E){
            expected = cuenta.estado();
            System.out.println("No se pueden ingresar cantidades negativas");
        }
        assertEquals(expected,cuenta.estado());
        
        double numeroretirar = -60 ;
        expectedretirar=cuenta.estado()-numeroretirar;
        try{
        cuenta.retirar(numeroretirar);
        } catch (Exception E){
            expectedretirar = cuenta.estado();
            System.out.println("No se pueden retirar cantidades negativas");
        }
        assertEquals(expectedretirar,cuenta.estado());
        //El test no será válido puesto que vamos a retirar una cantidad negativa
    }
     
    @Test
     public void testMain6(){
        CCuenta cuenta=new CCuenta("Enrique","1234-1234-56-87654321",200,0);
        double expected,expectedretirar,expectedfinal,numero=300;
        expected=cuenta.estado()+numero;
        try{
        cuenta.ingresar(numero);
        } catch (Exception E){
            expected = cuenta.estado();
            System.out.println("No se pueden ingresar cantidades negativas");
        }
        assertEquals(expected,cuenta.estado());
        
        double numeroretirar = 800 ;
        expectedretirar=cuenta.estado()-numeroretirar;
        try{
        cuenta.retirar(numeroretirar);
        } catch (Exception E){
            expectedretirar = cuenta.estado();
            System.out.println("No se pueden retirar cantidades negativas");
        }
        assertEquals(expectedretirar,cuenta.estado());
        //Este test tampoco será válido puesto que vamos a retirar más cantidad de la que disponemos en la cuenta
    }
}

