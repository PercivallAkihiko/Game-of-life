import java.util.ArrayList;
import java.util.Random;

public class Predatore {

    public int energy;
    public int breed_energy;
    private int has_moved;
    private Random rand;

    public Predatore(int energy, int breed_energy) {
        //Crea un nuovo predatore
        this.energy = energy;
        this.breed_energy = breed_energy;
        this.has_moved = 0;
        this.rand = new Random();
    }

    public coordinates move(fish_free_pair tuple, coordinates actual_coordinates) {
        //Muove il predatore in uno spazio adiacente a caso, dando priorita` agli spazi con delle prede da mangiare.

        coordinates six = new coordinates(actual_coordinates.x + 1, actual_coordinates.y);
        coordinates seven = new coordinates(actual_coordinates.x - 1, actual_coordinates.y + 1);
        coordinates eight = new coordinates(actual_coordinates.x, actual_coordinates.y + 1);
        coordinates nine = new coordinates(actual_coordinates.x + 1, actual_coordinates.y + 1);

        ArrayList<coordinates> fish = tuple.fish;
        ArrayList<coordinates> free_cell = tuple.free_cell;

        if (this.has_moved == 1 || (fish.size() == 0 && free_cell.size() == 0)) return  new coordinates(-1,-1);

        if (fish.size() != 0){
            int where_to_move = rand.nextInt(fish.size());
            coordinates new_pos = fish.get(where_to_move);
            if ( new_pos == six || new_pos == seven || new_pos == eight || new_pos == nine) this.has_moved = 1;
            return new_pos;
        }

        else {
            int where_to_move = rand.nextInt(free_cell.size());
            coordinates new_pos = free_cell.get(where_to_move);

            if (new_pos == six || new_pos == seven || new_pos == eight || new_pos == nine) this.has_moved = 1;
            return new_pos;

        }
    }


    public coordinates breed(ArrayList<coordinates> free_cell) {
        if(free_cell.size() == 0 || this.energy < this.breed_energy) return new coordinates(-1,-1);
        coordinates new_pos = free_cell.remove( rand.nextInt(free_cell.size()));
        return new_pos;
    }

    public int dead() {
        //ritorna 1 se il predatore ha 0 di energia e deve morire, 0 altrimenti.
        if (this.energy == 0) return 1;
        return 0;
    }

}