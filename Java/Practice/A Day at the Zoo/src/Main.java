import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String animalendangered = "";
        Animal animalSelected = new Animal();
        /*
        animalSelected.Speciesgetter();
        animalSelected.habitatgetter();
        animalSelected.MaxWeightgetter();
        animalSelected.IsEndangeredgetter();
        */

        Animal animalSelected1 = new Animal("Rabbit", 4, "Jungle",false);
        Animal animalSelected2 = new Animal("Giant Panda", 120, "Mountain",false);
        Animal animalSelected3 = new Animal ("Penguin", 10, "Polar region",true);

        Animal[] Zoo = new Animal[4];
        Zoo[0] = animalSelected;
        Zoo[1] = animalSelected1;
        Zoo[2] = animalSelected2;
        Zoo[3] = animalSelected3;

        for (int i=0;i<Zoo.length;i++) {
            System.out.println(Zoo[i].report());
            Scanner sc = new Scanner(System.in);
            System.out.println("What do you want to feed me? : ");
            String feedtype = sc.nextLine();
            System.out.println("Do you know what type of sound I make? ");
            String sounditmakes = sc.nextLine();
            System.out.println(Zoo[i].feedme(feedtype));
            System.out.println(Zoo[i].Sound(sounditmakes));
        }
    }
}

