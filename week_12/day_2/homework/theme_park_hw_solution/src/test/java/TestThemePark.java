import ThemePark.Attractions.Dodgems;
import ThemePark.Attractions.Playground;
import ThemePark.Attractions.Rollercoaster;
import ThemePark.Interfaces.IReviewed;
import ThemePark.Stalls.TobaccoStall;
import ThemePark.ThemePark;
import ThemePark.Visitors.Visitor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestThemePark {

    Visitor youngVisitor;
    Visitor parentVisitor;
    Playground playground;
    Rollercoaster rollercoaster;
    Dodgems dodgems;
    ThemePark themePark;
    TobaccoStall tobaccoStall;

    @Before
    public void before() {
        youngVisitor = new Visitor(12, 133, 10.3);
        parentVisitor = new Visitor(37, 183, 40.3);
        playground = new Playground("Happy Tree Friends", 6);
        rollercoaster = new Rollercoaster("Death Stirr", 6);
        dodgems = new Dodgems("Mud Max", 6);
        tobaccoStall = new TobaccoStall("Smoke Screen", "Dodgy Bill", 3, 1);

        ArrayList<IReviewed> iRevieweds = new ArrayList<>();
        //Cast Playground and Rollercoaster to IReviewed (i.e. treat them as IReviewed for the purposes of this line)
        iRevieweds.add(playground);
        iRevieweds.add(rollercoaster);
        iRevieweds.add(dodgems);
        iRevieweds.add(tobaccoStall);

        themePark = new ThemePark(iRevieweds);

    }

    @Test
    public void testGetAllReviewed() {
        assertEquals(4, themePark.getAllRevieweds().size());
    }

    @Test
    public void testAgesPlaygroundYoung() {
        assertEquals(true, playground.isAllowedTo(youngVisitor));
    }

    @Test
    public void testAgesPlaygroundParent() {
        assertEquals(false, playground.isAllowedTo(parentVisitor));
    }

    @Test
    public void testAgesRollercoasterYoung() {
        assertEquals(false, rollercoaster.isAllowedTo(youngVisitor));
    }

    @Test
    public void testAgesRollercoasterParent() {
        assertEquals(true, rollercoaster.isAllowedTo(parentVisitor));
    }

    @Test
    public void testReport() {
        String expectedReport = "Happy Tree Friends : 6, Death Stirr : 6, Mud Max : 6, Smoke Screen : 1, ";
        assertEquals(expectedReport, themePark.reportReviewed());
    }


    @Test
    public void testGetAllAllowedForYoung(){
        assertEquals(1, themePark.getAllAllowedFor(youngVisitor).size());
    }

    @Test
    public void testGetAllAllowed(){
        assertEquals(2, themePark.getAllAllowedFor(parentVisitor).size());
    }

}
