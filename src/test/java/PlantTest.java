import org.junit.jupiter.api.Test;
import ro.uvt.p3.testv1.Plant;
import ro.uvt.p3.testv1.Nutrient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlantTest {

    @Test
    public void testConstructorandGetters(){
        List<Nutrient> ingredients = new ArrayList<>();
        ingredients.add(Nutrient.WATER);
        ingredients.add(Nutrient.NITROGEN);
        ingredients.add(Nutrient.POTASSIUM);

        Plant a = new Plant("Rose", ingredients);
        a.setHourlyAmount(Nutrient.WATER, 50);
        a.setHourlyAmount(Nutrient.NITROGEN, 20);
        a.setHourlyAmount(Nutrient.POTASSIUM, 20);

        assertEquals("Rose", a.getName(), "wrong name");
        assertEquals(Nutrient.WATER, a.getNutrients().get(0), "wrong ingredient 0");
        assertEquals(Nutrient.NITROGEN, a.getNutrients().get(1), "wrong ingredient 1");
        assertEquals(Nutrient.POTASSIUM, a.getNutrients().get(2), "wrong ingredient 2");
        assertEquals(50, a.getHourlyAmount(Nutrient.WATER), "wrong amount for ingredient");
        assertEquals(20, a.getHourlyAmount(Nutrient.NITROGEN), "wrong amount for ingredient");
        assertEquals(20, a.getHourlyAmount(Nutrient.POTASSIUM), "wrong amount for ingredient");

    }
}
