package im.scanning.API;

/**
 * This class is used to simulate the terminal by supplying the products scanned via the main class
 * @author Sannidhi
 *
 */

public class TerminalSimulator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Terminal terminal = new Terminal();
		
		terminal.setPrice('A', 2.0, 4, 1.0);
		terminal.setPrice('B', 12.0, 0, 0.0);
		terminal.setPrice('C', 1.25, 6, 1.50);
		terminal.setPrice('D', 0.15, 0, 0.0);
		
		terminal.scan('A');
		terminal.scan('A');
		terminal.scan('A');
		terminal.scan('A');
		terminal.scan('B');
		
		double result = terminal.total();
		System.out.println("$"+result);
	}

}
