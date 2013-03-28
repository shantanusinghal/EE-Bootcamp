package com.ee.dd;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

public class SyntaxHighlighterSpecs {
	
	@Test
	public void highlightsASWithBlue() {
		//Given
		List<String> keyword = Arrays.asList(new String [] {"as"});;
		Highlighter highlighter = new Highlighter(keyword);
		
		//When
		
		String text = "This is just as good";
		String highlightedText = highlighter.highlight(text);
		//Then
		assertThat(highlightedText , is("This is just [blue]as[blue] good"));
	} 

	@Test
	public void highlightsMultipleASWithBlue() {
		//Given
		List<String> keyword = Arrays.asList(new String [] {"as"});;
		Highlighter highlighter = new Highlighter(keyword);
		
		//When
		
		String text = "as good as it gets";
		String highlightedText = highlighter.highlight(text);
		//Then
		assertThat(highlightedText , is("[blue]as[blue] good [blue]as[blue] it gets"));
	} 

	@Test
	public void highlightsIFWithBlue() {
		List<String> keyword = Arrays.asList(new String [] {"if"});;
		//Given
		Highlighter highlighter = new Highlighter(keyword);
		
		//When
		
		String text = "I will do  if I can";
		String highlightedText = highlighter.highlight(text);
		//Then
		assertThat(highlightedText , is("I will do  [blue]if[blue] I can"));
	} 
	
	@Test
	public void highlightsIFAndASWithBlue() {
		List<String> keywords = Arrays.asList(new String [] {"if", "as" });
		//Given
		Highlighter highlighter = new Highlighter(keywords);
		
		//When
		
		String text = "as if i care";
		String highlightedText = highlighter.highlight(text);
		
		//Then
		assertThat(highlightedText , is("[blue]as[blue] [blue]if[blue] i care"));
	} 
	
	@Test
	public void doesNotHighlightNonKeywords() {
		List<String> keywords = Arrays.asList(new String [] {"if", "as" });
		//Given
		Highlighter highlighter = new Highlighter(keywords);
		
		//When
		
		String text = "caring helps";
		String highlightedText = highlighter.highlight(text);
		
		//Then
		assertThat(highlightedText , is(text));
	} 
	
	  
	@Test
	public void highlightsThenKeywordWhBlue(){
		List<String> keywords = Arrays.asList(new String [] {"then"});
		//Given
		Highlighter highlighter = new Highlighter(keywords);
		
		//When
		
		String text = "then caring helps";
		String highlightedText = highlighter.highlight(text);
		
		//Then
		assertThat(highlightedText , is("[blue]then[blue] caring helps"));
	}
	
	@Test
	public void highlightWhenKeywordWithBlueColor(){
		List<String> keywords = Arrays.asList(new String [] {"when"});
		//Given
		Highlighter highlighter = new Highlighter(keywords);
		
		//When
		
		String text = "when does caring helps";
		String highlightedText = highlighter.highlight(text);
		
		//Then
		assertThat(highlightedText , is("[blue]when[blue] does caring helps"));
	}
	
	@Test
	public void highlightAndKeywordWithColorBlue(){
		List<String> keywords = Arrays.asList(new String [] {"and"});
		//Given
		Highlighter highlighter = new Highlighter(keywords);
		
		//When
		
		String text = "and  helped";
		String highlightedText = highlighter.highlight(text);
		
		//Then
		assertThat(highlightedText , is("[blue]and[blue]  helped"));
	}
	
	@Test
	public void highlightsIFWithRedColor() {
		List<String> keyword = Arrays.asList(new String [] {"if:red"});;
		//Given
		Highlighter highlighter = new Highlighter(keyword);
		
		//When
		
		String text = "I will do  if I can";
		String highlightedText = highlighter.highlight(text);
		//Then
		assertThat(highlightedText , is("I will do  [red]if[red] I can"));
	} 
	@Test
	public void highlightsANDWithRed() {
		List<String> keyword = Arrays.asList(new String [] {"and:red"});;
		//Given
		Highlighter highlighter = new Highlighter(keyword);
		
		//When
		
		String text = "He and she will";
		String highlightedText = highlighter.highlight(text);
		//Then
		assertThat(highlightedText , is("He [red]and[red] she will"));
	} 
	
	@Test
	public void highlightsTHENKeywordWithGreen() {
		List<String> keyword = Arrays.asList(new String [] {"then:green"});;
		//Given
		Highlighter highlighter = new Highlighter(keyword);
		
		//When
		
		String text = "then I will win";
		String highlightedText = highlighter.highlight(text);
		//Then
		assertThat(highlightedText , is("[green]then[green] I will win"));
	} 
	
	@Test
	public void highlightsInputWithRespectiveColors(){
		List<String> keyword = Arrays.asList(new String [] {"then:green","as:blue","when","if:red","and:red"});;
		//Given
		Highlighter highlighter = new Highlighter(keyword);
		
		//When
		
		String text = "If we wre a program and compile , then as we run the program, we will get output";
		String expectedHighLightedText = "[red]If[red] we wre a program [red]and[red] compile , [green]then[green] [blue]as[blue] we run the program, we will get output";
		String highlightedText = highlighter.highlight(text);
		//Then
		assertThat(highlightedText , is(expectedHighLightedText));
	}
	
	@Test
	public void colorsAndCapalizesASKeyword() throws Exception {
		List<String> keyword = Arrays.asList(new String [] {"as:blue:capital"});;
		//Given
		Highlighter highlighter = new Highlighter(keyword);
		
		//When
		
		String text = "This is just as good";
		String highlightedText = highlighter.highlight(text);
		//Then
		assertThat(highlightedText , is("This is just [blue]AS[blue] good"));
	}
	
	@Test
	public void colorsAndDowncasesTHENKeyword() throws Exception {
		//Given
		List<String> keywords = Arrays.asList(new String [] {"then:green:lower"});
		Highlighter highlighter = new Highlighter(keywords);
		
		//When
		String text = "Then caring helps";
		String highlightedText = highlighter.highlight(text);
		
		//Then
		assertThat(highlightedText , is("[green]then[green] caring helps"));
	}
	
	@Test
	public void colorsByDowncasingWithBoldWeightForAndKeyword() throws Exception {
		//Given
		List<String> keywords = Arrays.asList(new String [] {"and:red:capital:bold"});
		Highlighter highlighter = new Highlighter(keywords);
		
		//When
		String text = "and caring helps";
		String highlightedText = highlighter.highlight(text);
		
		//Then
		assertThat(highlightedText , is("[red][bold]AND[bold][red] caring helps"));
	}
}
