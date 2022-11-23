import org.junit.jupiter.api.Test;
import ro.uvt.p3.testv1.Plant;
import ro.uvt.p3.testv1.Tree;
import ro.uvt.p3.testv1.Nutrient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TreeTest {

    @Test
    public void testConstructorandGetters(){
        List<Nutrient> ingredients = new ArrayList<>();
        ingredients.add(Nutrient.POTASSIUM);
        ingredients.add(Nutrient.WATER);

        Tree tree = new Tree("PearTree", ingredients, 66);
        tree.setHourlyAmount(Nutrient.POTASSIUM, 300);
        tree.setHourlyAmount(Nutrient.WATER, 180);

        assertEquals("PearTree", tree.getName(), "wrong name");
        assertEquals(Nutrient.POTASSIUM, tree.getNutrients().get(0), "wrong ingredient 0");
        assertEquals(Nutrient.WATER, tree.getNutrients().get(1), "wrong ingredient 1");
        assertEquals(300, tree.getHourlyAmount(Nutrient.POTASSIUM), "wrong amount for ingredient");
        assertEquals(180, tree.getHourlyAmount(Nutrient.WATER), "wrong amount for ingredient");

        assertEquals(66, tree.getNumFruits(), "wrong number of fruits");

        assertInstanceOf(Plant.class, tree);
    }
}
