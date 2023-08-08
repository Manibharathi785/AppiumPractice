package Calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Reusables.SuperClass;

public class CalcTask extends SuperClass {

	@Test
	public void bodmasRule() {

		WebElement brackets = driver.findElement(By.id("com.google.android.calculator:id/parens"));
		brackets.click();
		WebElement one = driver.findElement(By.id("com.google.android.calculator:id/digit_1"));
		one.click();
		WebElement zero = driver.findElement(By.id("com.google.android.calculator:id/digit_0"));
		zero.click();
		WebElement divide = driver.findElement(By.id("com.google.android.calculator:id/op_div"));
		divide.click();
		WebElement two = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
		two.click();
		WebElement multiply = driver.findElement(By.id("com.google.android.calculator:id/op_mul"));
		multiply.click();
		WebElement three = driver.findElement(By.id("com.google.android.calculator:id/digit_3"));
		three.click();
		zero.click();
		WebElement add = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
		add.click();
		WebElement five = driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
		five.click();
		WebElement minus = driver.findElement(By.id("com.google.android.calculator:id/op_sub"));
		minus.click();
		WebElement six = driver.findElement(By.id("com.google.android.calculator:id/digit_6"));
		six.click();
		brackets.click();
		WebElement power = driver.findElement(By.id("com.google.android.calculator:id/op_pow"));
		power.click();
		two.click();
		WebElement equalsTo = driver.findElement(By.id("com.google.android.calculator:id/eq"));
		equalsTo.click();
		
//		WebElement firstAnswer = driver.findElement(By.id(""));
//		firstAnswer.click();
//
//		WebElement clear = driver.findElement(By.id("com.google.android.calculator:id/clr"));
//		clear.click();
//
//		brackets.click();
//		one.click();
//		zero.click();
//		zero.click();
//		divide.click();
//		five.click();
//		zero.click();
//		multiply.click();
//		two.click();
//		add.click();
//		WebElement seven = driver.findElement(By.id("com.google.android.calculator:id/digit_7"));
//		seven.click();
//		minus.click();
//		WebElement eight = driver.findElement(By.id("com.google.android.calculator:id/digit_8"));
//		eight.click();
//		brackets.click();
//		power.click();
//		WebElement four = driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
//		four.click();
//		equalsTo.click();
//		
//		WebElement secondAnswer = driver.findElement(By.id(""));
//		secondAnswer.click();
//		
//		assertEquals(firstAnswer, secondAnswer);

	}

}
