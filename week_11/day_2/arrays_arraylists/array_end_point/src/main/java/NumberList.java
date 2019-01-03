import java.util.ArrayList;
import java.util.Collections;

public class NumberList {

    private ArrayList<Integer> numbers;

    public NumberList(ArrayList<Integer> numbers){

        this.numbers = numbers;
    }

    public int getNumberCount() {

        return this.numbers.size();
    }

    public ArrayList<Integer> getNumbers(){
        ArrayList<Integer> copyOfNumbers = new ArrayList<>(this.numbers);
        return copyOfNumbers;
    }

    public void addNumber(int number){
        this.numbers.add(number);
    }

    public int getNumberAtIndex(int index){
        return this.numbers.get(index);
    }

    public int getTotal(){
        int total = 0;
        for (int number :this.numbers){
            total += number;
        }
        return total;
    }

    public int getRandomNumber(){
        Collections.shuffle(this.numbers);
        return getNumberAtIndex(0);
    }
}
