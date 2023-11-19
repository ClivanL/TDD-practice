import java.util.LinkedList;
import java.util.regex.Pattern;

public class Calculator {
    public int add(String numbers){
        if (numbers.contains("-")){
            String[]numberArr=numbers.split(",");
            String errorNumbers="";
            if (numberArr.length>1){
                for (int i=0;i<numberArr.length;i++){
                    if (Integer.parseInt(numberArr[i].trim())<0){
                        errorNumbers+=","+numberArr[i];
                    }
                }
            }
            throw new IllegalArgumentException("negatives not allowed"+errorNumbers);
        }
        else if (numbers.length()==0){
            return 0;
        }
        else if (numbers.startsWith("//")){
            LinkedList<String> delimiters= new LinkedList<>();
            int endIndex=0;
            if (numbers.contains("[")){
                String[]numbersArr=numbers.split("");
                for (int i=0; i<numbersArr.length;i++){
                    if (numbersArr[i].equals("[")){
                        int j = i+1;
                        String delimiter="";
                        while (!numbersArr[j].equals("]")){
                            delimiter+=numbersArr[j];
                            j++;
                        }
                        i=j;
                        delimiters.add(delimiter);
                    }
                    else if (numbersArr[i].equals("\n")){
                        endIndex=i;
                        break;
                    }
                }
                //System.out.println("substring"+numbers.substring(endIndex+1));
                return this.calculateMultipleInputsWithMultipleDelimiters(numbers.substring(endIndex+1),delimiters);

            }
            int delimiterEndIndex = 2;
            String delimiter = numbers.substring(2,3);
            while (!delimiter.equals("\n")){
                delimiterEndIndex+=1;
                delimiter=numbers.substring(delimiterEndIndex,delimiterEndIndex+1);
            }
            String finalDelimiter = numbers.substring(2,delimiterEndIndex);
            return this.calculateMultipleInputs(numbers.substring(delimiterEndIndex+1),finalDelimiter);
        }
        else if (!numbers.contains(",") && !numbers.contains("\n")){
            int result=Integer.parseInt(numbers);
            if (result>1000){
                return 0;
            }
            return result;
        }
        else{
            if (numbers.contains(",")){
                return this.calculateMultipleInputs(numbers,",");
            }
            else{
                return this.calculateMultipleInputs(numbers,"\n");
            }
        }
    }
    public int calculateMultipleInputs(String numbers, String delimiter){
        int result=0;
        String[] numberArr = numbers.split(delimiter);
        for (int i=0;i<numberArr.length;i++){
            int num=Integer.parseInt(numberArr[i].trim());
            if (num<=1000){
                result+=num;
            }
        }
        //System.out.println(result);
        return result;
    }

    public int calculateMultipleInputsWithMultipleDelimiters(String numbers, LinkedList<String> delimiters){
        String delimitersString="";
        for (String delimiter: delimiters){
            delimitersString+=delimiter+"|";
        }
        delimitersString=delimitersString.substring(0,delimitersString.length()-1);
        //System.out.println("delimiters"+delimitersString);
        Pattern pattern = Pattern.compile(delimitersString);
        String[] numbersArr = pattern.split(numbers);
        int result = 0;
        for (int i=0;i<numbersArr.length;i++){
            int num=Integer.parseInt(numbersArr[i].trim());
            if (num<=1000){
                result+=num;
            }
        }
        return result;
    }

}
