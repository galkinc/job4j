package ru.job4j.calculate;

public class CalculateTest {

	public void whenSetStopInEchoThenReturnThreeStops() {
	
		//assign
		Calculate calc = new Calculate();
		
		//action
		String result = calc.echo("stop");
		
		Assert.assertThat(result, is("stop stop stop")); 
	
	}

}

