package TestPackage;

//import static org.junit.Assert.assertEquals; //junit 4
import static org.junit.jupiter.api.Assertions.assertEquals; //junit 5

//import org.junit.Before; //junit 4
//import org.junit.Test; //junit 4
import org.junit.jupiter.api.BeforeEach; //junit 5
import org.junit.jupiter.api.Test; //junit 5

//public class calcTest { //junit 4
class calcTest { //junit 5
	
	calcolatrice calc;
	
	//@Before //junit 4
	@BeforeEach //junit 5
	//public void setUp() { //junit 4
	void setUp() { //junit 5
		calc = new calcolatrice();
	}
	
	@Test
	//public void testAdd() { //junit 4
	void testAdd() { //junit 5
		//assertEquals("moltiplicazione funziona", 10, calc.add(5,5)); //junit 4
		assertEquals(10, calc.add(5,5), "moltiplicazione funziona"); //junit 5
	}
	
	@Test
	//public void testMult() { //junit 4
	void testMult() { //junit 5
		//assertEquals("moltiplicazione funziona", 20, calc.multiply(4,5)); //junit 4
		assertEquals(20, calc.multiply(4,5), "moltiplicazione funziona"); //junit 5
	}
	
}
