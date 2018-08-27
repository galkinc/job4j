package ru.job4j.calculate;

/**
* Calculate
*
* @author Kirill Galkin (galkinc@gmail.com)
*/

public class Calculate {
	/**
	* Method echo - shows the inserted param three times.
	*
	* @param value – string for string concatenation.
	* @return - result of string concatenation.  
	*/
	public String echo(String value) {
		return String.format("%s %s %s", value, value, value);
	}
	
	/**
   * Method echo.
   * @param name Your name.
   * @return Echo plus your name.
   */
   public String echolot(String name) {
       return "Echo, echo, echo : " + name;
    }
	
	/**
	* Main
	*
	* @param args - args.
	*/
	public static void main(String[] args) {
		Calculate calc = new Calculate();
		System.out.println(calc.echo("aah")); 
	}
}