import org.junit.jupiter.api.Test;
import ro.uvt.p3.testv1.Plant;
import ro.uvt.p3.testv1.RoboBotanicalKeeper;
import ro.uvt.p3.testv1.Tree;
import ro.uvt.p3.testv1.Nutrient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoboKeeperTest {

    @Test
    public void testConstructorAndGetters(){
        RoboBotanicalKeeper keeper = new RoboBotanicalKeeper("Timisoara");

        for(Nutrient i : Nutrient.values()){
            assertEquals(5000, keeper.getStock(i), "stock not initialized");
        }

        List<Nutrient> ingredients = new ArrayList<>();
        ingredients.add(Nutrient.WATER);
        ingredients.add(Nutrient.POTASSIUM);

        Plant a1 = new Tree("Maxy", ingredients, 120);
        a1.setHourlyAmount(Nutrient.WATER, 100);
        a1.setHourlyAmount(Nutrient.POTASSIUM, 60);

        keeper.addPlant(a1);

        Plant a2 = new Plant("Hexy", ingredients);
        keeper.addPlant(a2);

        assertEquals(a1, keeper.getPlants().get(0));
        assertEquals(a2, keeper.getPlants().get(1));
    }
}
