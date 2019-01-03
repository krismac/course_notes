import java.util.ArrayList;

public class BusStop {

    private String name;
    private ArrayList<Person> queue;

    public BusStop(String name){
        this.name = name;
        this.queue = new ArrayList<>();
    }

    public int getQueueCount(){
        return this.queue.size();
    }

    public void addPerson(Person person){
        this.queue.add(person);
    }


    public Person removePerson(){
        return this.queue.remove(0);
    }
}
