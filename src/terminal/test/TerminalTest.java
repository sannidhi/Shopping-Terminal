package terminal.test;

import static org.junit.Assert.*;
import im.scanning.API.Terminal;

import org.junit.Test;

public class TerminalTest {

	@Test
	public void testCalculate1() {
		Terminal terminal = new Terminal();
		terminal.setPrice('A',2,4,1);
		terminal.setPrice('B',12,0,0);
		terminal.setPrice('C', 1.25, 6, 1.50);
		terminal.setPrice('D', 0.15, 0, 0.0);

		terminal.scan('A');
		terminal.scan('B');
		terminal.scan('C');
		terminal.scan('D');
		terminal.scan('A');
		terminal.scan('B');
		terminal.scan('A');
		terminal.scan('A');

		assertEquals("testCalculate1 failed", 32.40, terminal.total(), 0.0);
	}

	@Test
	public void testCalculate2(){
		Terminal terminal = new Terminal();
		terminal.setPrice('C', 1.25, 6, 1.50);

		terminal.scan('C');
		terminal.scan('C');
		terminal.scan('C');
		terminal.scan('C');
		terminal.scan('C');
		terminal.scan('C');
		terminal.scan('C');

		assertEquals("testCalculate3 failed", 7.25, terminal.total(), 0.0);


	}
	@Test
	public void testCalculate3() {
		Terminal terminal = new Terminal();

		terminal.setPrice('A', 2.0, 4, 1.0);
		terminal.setPrice('B', 12.0, 0, 0.0);
		terminal.setPrice('C', 1.25, 6, 1.50);
		terminal.setPrice('D', 0.15, 0, 0.0);

		terminal.scan('A');
		terminal.scan('B');
		terminal.scan('C');
		terminal.scan('D');

		assertEquals("testCalculate3 failed", 15.40, terminal.total(), 0.0);


	}
}