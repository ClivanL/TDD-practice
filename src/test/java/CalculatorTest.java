import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CalculatorTest {
    @Test
    public void emptyInput(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(0,calculator.add(""));
    }
    @Test
    public void singleInput(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(8, calculator.add("8"));
    }
    @Test
    public void doubleInput(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(19,calculator.add("9, 10"));
    }
    @Test
    public void multipleInputs(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(65, calculator.add("10,3,50,2"));
    }
    @Test
    public void inputsWithNewLines(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(6, calculator.add("3\n3"));
    }
    @Test
    public void inputsWithOptionalDelimiter(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(8,calculator.add("//;\n2;2;2;2"));
    }

    @Test
    public void rejectNegatives(){
        Calculator calculator = new Calculator();
        String errorMsg = "";
        try{
            calculator.add("-5");
        }
        catch (IllegalArgumentException e){
            errorMsg = e.getMessage();
        }
        Assert.assertEquals("negatives not allowed", errorMsg);
    }

    @Test
    public void rejectMoreThanOneNegatives(){
        Calculator calculator = new Calculator();
        String errorMsg = "";
        try{
            calculator.add("-5,-8,5");
        }
        catch (IllegalArgumentException e){
            errorMsg = e.getMessage();
        }
        Assert.assertEquals("negatives not allowed,-5,-8", errorMsg);
    }

    @Test
    public void singleNumberMoreThan1000(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(0,calculator.add("1001"));
    }

    @Test
    public void multipleNumbersMoreThan1000(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(35,calculator.add("1001,30,5"));
    }

    @Test
    public void delimiterWithMultipleLength(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(12,calculator.add("//;;;\n3;;;4;;;4;;;1"));
    }

    @Test
    public void varyingDelimiters(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(15,calculator.add("//[;][%]\n3;4%3%5"));
    }

    @Test
    public void varyingDelimitersWithDifferentLengths(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(15,calculator.add("//[;;][%%%]\n3;;4%%%3%%%5"));
    }

    @Test
    public void varyingDelimitersWithDifferentLengthsWithInputMoreThan1000(){
        Calculator calculator = new Calculator();
        Assert.assertEquals(408,calculator.add("//[;;][%%%]\n3000;;400%%%3%%%5"));
    }
}
