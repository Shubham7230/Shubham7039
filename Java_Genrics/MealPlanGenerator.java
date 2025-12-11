import java.util.*;

interface MealPlan {
    String getType();
}

class VegetarianMeal implements MealPlan {
    public String getType() { return "Vegetarian"; }
}

class VeganMeal implements MealPlan {
    public String getType() { return "Vegan"; }
}

class KetoMeal implements MealPlan {
    public String getType() { return "Keto"; }
}

class HighProteinMeal implements MealPlan {
    public String getType() { return "High-Protein"; }
}

class Meal<T extends MealPlan> {
    private List<T> meals = new ArrayList<>();
    public void addMeal(T meal) { meals.add(meal); }
    public List<T> getMeals() { return meals; }
}

class MealGenerator {
    public static <T extends MealPlan> T generatePlan(T meal) { return meal; }
}

public class MealPlanGenerator{
    public static void main(String[] args) {
        Meal<VegetarianMeal> vegMeals = new Meal<>();
        Meal<VeganMeal> veganMeals = new Meal<>();
        Meal<KetoMeal> ketoMeals = new Meal<>();
        Meal<HighProteinMeal> hpMeals = new Meal<>();

        VegetarianMeal veg = MealGenerator.generatePlan(new VegetarianMeal());
        VeganMeal vegan = MealGenerator.generatePlan(new VeganMeal());
        KetoMeal keto = MealGenerator.generatePlan(new KetoMeal());
        HighProteinMeal highProtein = MealGenerator.generatePlan(new HighProteinMeal());

        vegMeals.addMeal(veg);
        veganMeals.addMeal(vegan);
        ketoMeals.addMeal(keto);
        hpMeals.addMeal(highProtein);

        for (MealPlan m : vegMeals.getMeals()) System.out.println(m.getType());
        for (MealPlan m : veganMeals.getMeals()) System.out.println(m.getType());
        for (MealPlan m : ketoMeals.getMeals()) System.out.println(m.getType());
        for (MealPlan m : hpMeals.getMeals()) System.out.println(m.getType());
    }
}
