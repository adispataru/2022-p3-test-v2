import org.junit.jupiter.api.Test;
import ro.uvt.p3.testv1.Plant;
import ro.uvt.p3.testv1.RoboBotanicalKeeper;
import ro.uvt.p3.testv1.Tree;
import ro.uvt.p3.testv1.Nutrient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FeedTest {

    @Test
    public void testFeedMachine(){
        RoboBotanicalKeeper robo = new RoboBotanicalKeeper("RoZoo5520");

        List<Nutrient> ingredients = new ArrayList<>();
        ingredients.add(Nutrient.WATER);
        ingredients.add(Nutrient.NITROGEN);

        Plant a1 = new Plant("Rose", ingredients);
        a1.setHourlyAmount(Nutrient.WATER, 100);
        a1.setHourlyAmount(Nutrient.NITROGEN, 60);

        robo.addPlant(a1);


        boolean result = robo.feed(0);
        assertTrue(result, "robot should be able to feed");
        assertEquals(5000 - 100, robo.getStock(Nutrient.WATER), "water should be subtracted");
        assertEquals(5000 - 60, robo.getStock(Nutrient.NITROGEN), "fish should be subtracted");
        assertEquals(1600, robo.getUsedElectricity(), "electricity must be added");


        List<Nutrient> ingredients2 = new ArrayList<>();
        ingredients2.add(Nutrient.NITROGEN);
        ingredients2.add(Nutrient.WATER);
        ingredients2.add(Nutrient.POTASSIUM);

        Tree a2 = new Tree("PlumTree", ingredients2, 100);
        a2.setHourlyAmount(Nutrient.NITROGEN, 60);
        a2.setHourlyAmount(Nutrient.WATER, 200);
        a2.setHourlyAmount(Nutrient.POTASSIUM, 80);

        robo.addPlant(a2);

        Tree a3 = new Tree("MangoTree", ingredients2, 1000);
        a3.setHourlyAmount(Nutrient.NITROGEN, 600);
        a3.setHourlyAmount(Nutrient.WATER, 2000);
        a3.setHourlyAmount(Nutrient.POTASSIUM, 800);

        robo.addPlant(a3);

        result = robo.feed(1);
        assertTrue(result, "robo should be able to feed");
        assertEquals(8400,robo.getUsedElectricity(), "wrong electricity");


        result = robo.feed(2);
        assertFalse(result, "robo shouldn't be able to feed due stock issues");
        

    }
}
