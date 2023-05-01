package JUnitTestCase;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Test;

public class CharacterStackTest {
	private static final int MAX_SIZE = 20;

	@Test
	public void constructorTest() {
		String normal_str = "it is test string.";
		String null_str = null;
		String empty_str = "";
		char c = 'a';
		CharacterStack characterStack0 = new CharacterStack();
		CharacterStack characterStack1 = new CharacterStack(normal_str);
		CharacterStack characterStack2 = new CharacterStack(null_str);
		CharacterStack characterStack3 = new CharacterStack(empty_str);
		CharacterStack characterStack4 = new CharacterStack(c);
		
		assertEquals(characterStack0.getSize(), 0);
		assertEquals(characterStack1.getSize(), normal_str.length());
		assertEquals(characterStack2.getSize(), 0);
		assertEquals(characterStack3.getSize(), 0);
		assertEquals(characterStack4.getSize(), 1);
	}
	
	@Test
	public void PushCharTest() {
		char c = 'a';
		
		CharacterStack characterStack = new CharacterStack();
		characterStack.push(c);
		
		assertNotNull(characterStack.pop());
	}
	
	@Test
	public void PushStringTest() {
		String normal_str = "push string.";
		String null_str = null;
		String empty_str = "";
		CharacterStack characterStack0 = new CharacterStack();
		CharacterStack characterStack1 = new CharacterStack();
		CharacterStack characterStack2 = new CharacterStack();
		characterStack0.push(normal_str);
		characterStack1.push(null_str);
		characterStack2.push(empty_str);
		
		assertEquals(characterStack0.getSize(), normal_str.length());
		assertEquals(characterStack1.getSize(), 0);
		assertEquals(characterStack2.getSize(), 0);
	}
	
	
	@Test
	public void popTest() {
		char c = 'a';
		
		CharacterStack characterStack = new CharacterStack(c);
		assertEquals(c, characterStack.pop());
	}
	
	@Test
	public void getMaxSizeTest() {
		CharacterStack characterStack = new CharacterStack();
		assertEquals(characterStack.getMaxSize(), MAX_SIZE);
	}
	
	@Test(expected = StackOverflowError.class)
	public void constructorOverflowTest() {
		String test_str = "it is string for testing overflow!!!!!!!!!!!";
		CharacterStack characterStack = new CharacterStack(test_str);
	}
	
	@Test(expected = StackOverflowError.class)
	public void pushCharOverflowTest() {
		char c = 'a';
		CharacterStack characterStack = new CharacterStack();
		for(int i=0; i<MAX_SIZE+1; i++) {
			characterStack.push(c);
		}
	}
	
	@Test(expected = StackOverflowError.class)
	public void pushStringOverflowTest() {
		String test_str = "it is string for testing overflow!!!!!!!!!!!";
		CharacterStack characterStack = new CharacterStack();
		characterStack.push(test_str);
	}
	
	@Test(expected = EmptyStackException.class)
	public void popEmptyStackExceptionTest() {
		CharacterStack characterStack = new CharacterStack();
		characterStack.pop();
	}

}
