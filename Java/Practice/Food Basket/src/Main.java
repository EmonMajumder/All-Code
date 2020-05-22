public class Main {

    public static void main(String[] args) {

        //Create a Food
        Food a  = new Food("Banana", "Fruit");
        Food b = new Food("Carrot", "Vegetable");
        Food c = new Food("Beef", "Meat");
        Food d = new Food("Yogurt", "Dairy");
        Food e = new Food("Burger", "Fastfood");

        Food[] picnicBasket = new Food[5];

        picnicBasket[0] = a;
        picnicBasket[1] = b;
        picnicBasket[2] = c;
        picnicBasket[3] = d;
        picnicBasket[4] = e;

        //Show all food in the list and a response to the food.
        String message;
        for(int i = 0; i < picnicBasket.length; i++) {
            Food items = picnicBasket[i];
            String itemInBasket= picnicBasket[i].name;
            System.out.println(itemInBasket);
            if (picnicBasket[i].name == "Beef")
                message = items.denyit();
            else
                message = items.eatit();
            System.out.println(message);
        }
    }
}
