import java.util.ArrayList;
import java.util.Random;

public class test {

	public static void main(String[] args) {



	    Object[] matrix = new Object[2];
	    matrix[1] = new Preda(3);

	    Object obj = matrix[1];
	    String class_name = obj.getClass().getName();
	    if(class_name == "Preda"){
	        Preda fish = (Preda)obj;
	        //System.out.println(fish.bree);
        }

	    /*oordinates prova = new coordinates(1,2);
	    coordinates prova2 = new coordinates(1,2);

	    if(prova.compares(prova2)) System.out.println("UGUALI");
	    else System.out.println("NON UGUALI"); */

        /*Random random = new Random();
        ArrayList<coordinates> fish = new ArrayList<coordinates>();

        fish.add(new coordinates(1,3));
        fish.add(new coordinates(0,2));
        fish.add(new coordinates(1,6));
        fish.add(new coordinates(2,6));

        for(int i = 0 ; i < fish.size(); i ++){
            coordinates obj = fish.get(i);
            System.out.println("x: " + obj.x + "      y: " + obj.y);
        }
        System.out.println( fish.size() );
		int rand = random.nextInt(fish.size());
        System.out.println("Sto levando il rand: " + rand);
        coordinates removed = fish.remove(rand);
        System.out.println("E stato eliminato "+ removed.x + " " + removed.y);

        for(int i = 0 ; i < fish.size(); i ++){
            coordinates obj = fish.get(i);
            System.out.println("x: " + obj.x + "      y: " + obj.y);
        }*/

/*
        int[] prova = new int[2];
        prova[1] = 2;
        prova[1] =null;*/

		//TEST

	}

}
