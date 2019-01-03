import java.util.ArrayList;

public class LinearSearch {
    public Boolean linearSearchSortedArray(int search_number, ArrayList<Integer> sorted_array) {
        for (int number : sorted_array)
            if (number == search_number){
                return true;
            }
        return false;
    }
}
