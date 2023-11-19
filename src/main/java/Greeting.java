import java.util.LinkedList;

public class Greeting {

    public String greet(String name){
        if (name.equals(name.toUpperCase())){
            return this.greetInUppercase(name);
        }
        return "Hello, " + name +".";
    }
    public String greet(){
        return "Hello, my friend.";
    }
    public String greetInUppercase(String name){
        return "HELLO, " + name + "!";
    }
    public String greet(String[] names){
        LinkedList<String> normalNames = new LinkedList<>();
        String shoutName = "";
        for (int i=0; i<names.length;i++){
            if (names[i].contains("\"")){
                normalNames.add(names[i].substring(1,names[i].length()-1));
            }
            else if(names[i].contains(",")){
                String[] joinedNames=names[i].split(",");
                for (int j=0; j<joinedNames.length; j++){
                    normalNames.add(joinedNames[j].trim());
                }
            }
            else if (!names[i].toUpperCase().equals(names[i])){
                normalNames.add(names[i]);
            }
            else{
                shoutName=names[i];
            }
        }
        String finalGreeting="";
        String[]normalNamesArr= normalNames.toArray(new String[0]);
        if (normalNamesArr.length>2){
            finalGreeting = this.greetMoreThanTwo(normalNamesArr);
        }
        else{
            finalGreeting="Hello, " + normalNamesArr[0] + " and " + normalNamesArr[1] + ".";
        }

        if (!shoutName.equals("")){
            finalGreeting+=" AND HELLO "+shoutName+"!";
        }

        return finalGreeting;
    }
    public String greetMoreThanTwo(String[] names){
        String greeting = "Hello,";
        for (int i=0; i<names.length-1; i++){
            greeting+=" "+names[i]+",";
        }
        greeting+=" and "+names[names.length-1]+".";
        return greeting;
    }
}
