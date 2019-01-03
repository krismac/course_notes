package ThemePark;

import ThemePark.Interfaces.IReviewed;
import ThemePark.Interfaces.ISecurity;
import ThemePark.Interfaces.ITicketed;
import ThemePark.Visitors.Visitor;

import java.util.ArrayList;

public class ThemePark {
    ArrayList<IReviewed> iRevieweds;

    public ThemePark(ArrayList<IReviewed> iRevieweds) {
        this.iRevieweds = iRevieweds;
    }

    public ArrayList<IReviewed> getAllRevieweds() {
        return iRevieweds;
    }

    public String reportReviewed(){
        String report = "";
        for (IReviewed e: iRevieweds) {
            report += e.getName() + " : " + e.getRating() + ", ";

        }
        return report;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> result = new ArrayList<IReviewed>();
        for ( IReviewed reviewed : this.iRevieweds) {
            if (reviewed instanceof ISecurity && (((ISecurity) reviewed).isAllowedTo(visitor))) { // notes: this is called 'Casting'
                result.add(reviewed);
            }
        }
        return result;
    }
}