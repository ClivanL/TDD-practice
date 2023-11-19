import org.junit.Assert;
import org.junit.Test;

public class GreetingTest {
    @Test
    public void correctGreetingWithName(){
        Greeting greeting= new Greeting();
        Assert.assertEquals("Hello, Bob.", greeting.greet("Bob"));
    }

    @Test
    public void correctGreetingWithoutName(){
        Greeting greeting = new Greeting();
        Assert.assertEquals("Hello, my friend.", greeting.greet());
    }

    @Test
    public void greetingsInUppercase(){
        Greeting greeting = new Greeting();
        Assert.assertEquals("HELLO, JASON!", greeting.greet("JASON"));
    }

    @Test
    public void greetTwo(){
        Greeting greeting = new Greeting();
        String[] names= {"Jill", "Jane"};
        Assert.assertEquals("Hello, Jill and Jane.",greeting.greet(names));
    }

    @Test
    public void greetMoreThanTwo(){
        Greeting greeting = new Greeting();
        String[] names = {"Amy", "Brian", "Charlotte"};
        Assert.assertEquals("Hello, Amy, Brian, and Charlotte.", greeting.greet(names));
    }

    @Test
    public void greetWithVaryingTones(){
        Greeting greeting = new Greeting();
        String[] names = {"Amy", "BRIAN", "Charlotte"};
        Assert.assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!", greeting.greet(names));
    }

    @Test
    public void greetWithCombinedNames(){
        Greeting greeting = new Greeting();
        String[] names = {"Bob", "Charlie, Dianne"};
        Assert.assertEquals("Hello, Bob, Charlie, and Dianne.", greeting.greet(names));
    }

    @Test
    public void greetWithIntentionalCombinedNames(){
        Greeting greeting = new Greeting();
        String[] names = {"Bob", "\"Charlie, Dianne\""};
        Assert.assertEquals("Hello, Bob and Charlie, Dianne.", greeting.greet(names));
    }
}
