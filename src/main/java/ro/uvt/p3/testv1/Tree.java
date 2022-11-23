package ro.uvt.p3.testv1;

import java.util.List;

public class Tree extends Plant {


    public Tree(String name, List<Nutrient> ingredients, int numFruits) {
        super(name, ingredients);

    }

    public int getNumFruits() {
        return 0;
    }
}
