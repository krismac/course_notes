import java.util.ArrayList;

public class BinarySearch {
    public static Boolean searchArrayList(int search_number, ArrayList<Integer> array){
        if (array.size() == 0){
            return false;
        }

        int middle_index = 0;
        if (array.size() >1) {
            middle_index = (int) Math.ceil((double) array.size() / 2);
        }

        int midpoint = array.get(middle_index);

        if (search_number == midpoint){
            return true;
        }

        ArrayList<Integer> new_search_area = search_number < midpoint ? new ArrayList<Integer>(array.subList(0, middle_index-1)) : new ArrayList<Integer>(array.subList(middle_index + 1, array.size()));

        return searchArrayList(search_number, new_search_area);
    }
}
