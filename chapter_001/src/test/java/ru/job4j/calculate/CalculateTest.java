package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculateTest {

	/**
	* Test echo
	*/
	 
	@Test
	public void whenSetStopInEchoThenReturnThreeStops() {
		//assign
		Calculate calc = new Calculate();
		//action
		String result = calc.echo("stop");
		assertThat(result, is("stop stop stop")); 
	}

	@Test
	public void whenSetNullInEchoThenReturnThreeStops() {
		//assign
		Calculate calc = new Calculate();
		//action
		String result = calc.echo(null);
		assertThat(result, is("null null null")); 
	}
	
	/**
	* Test echolot
	*/
	@Test
	public void whenTakeNameThenTreeEchoPlusName() {
   		String input = "XXX";
    	String expect = "Echo, echo, echo : XXX"; 
    	Calculate calc = new Calculate();
    	String result = calc.echolot(input);
    	assertThat(result, is(expect));
	}
	
}