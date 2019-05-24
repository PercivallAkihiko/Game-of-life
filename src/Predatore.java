import java.util.ArrayList;
import java.util.Random;

public class Predatore {

    public int energy;
    public int breed_energy;
    public int has_moved;
    private Random r = new Random();

    public Predatore(int energy, int breed_energy) {
        //Crea un nuovo predatore
        this.energy = energy;
        this.breed_energy = breed_energy;
        this.has_moved = 0;

    }

    public coordinates move(fish_free_pair tuple) {
        //Muove il predatore in uno spazio adiacente a caso, dando priorita` agli spazi con delle prede da mangiare.


        if (this.has_moved == 1 || (tuple.fish.size() == 0 && tuple.free_cell.size() == 0)) {

            coordinates output = new coordinates(-1,-1);
            return output;

        }


    }; //0 nella griglia e` lo spazio dove il predatore si trova attualmente.

    if (tuple.fish.size() != 0) {

        int where_to_move = r.nextInt(tuple.fish.size() - 1);
        if ( (int) tuple.fish.get(where_to_move) == 6 || (int) tuple.fish.get(where_to_move) == 7 || (int) tuple.fish.get(where_to_move) == 8 || (int) tuple.fish.get(where_to_move) == 9) {
            this.has_moved = 1;
        }

        coordinates output = tuple.fish.get(where_to_move);
        return output;

    }

    else {

        int where_to_move = r.nextInt(tuple.free_cell.size() - 1);
        if ( (int) tuple.free_cell.get(where_to_move) == 6 || (int) tuple.free_cell.get(where_to_move) == 7 || (int) tuple.free_cell.get(where_to_move) == 8 || (int) tuple.free_cell.get(where_to_move) == 9) {
            this.has_moved = 1;
        }

        coordinates output = tuple.free_cell.get(where_to_move);
        return output;
    }
}


    public coordinates breed(fish_free_pair tuple) {
        //ritorna 1 se il predatore puo` riprodursi (se ci sono spazi liberi adiacenti intorno a lui, 0 altrimenti.
        if (tuple.free_cell.size() == 0) {

            coordinates output = new coordinates(-1,-1);
            return output;

        }

        int where_to_breed = r.nextInt(tuple.free_cell.size() - 1);
        coordinates output = tuple.free_cell.get(where_to_breed);
        return output;
    }

    public int dead() {
        //ritorna 1 se il predatore ha 0 di energia e deve morire, 0 altrimenti.
        if (this.energy == 0) return 1;
        return 0;

    }

}