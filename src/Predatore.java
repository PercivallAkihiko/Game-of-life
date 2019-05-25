import java.util.ArrayList;
import java.util.Random;

public class Predatore {

    public int energy;
    public int breed_energy;
    public coordinates actual_coordinates;
    private int has_moved;
    private Random r = new Random();

    public Predatore(int energy, int breed_energy, coordinates actual_coordinates) {
        //Crea un nuovo predatore

        this.energy = energy;
        this.breed_energy = breed_energy;
        this.has_moved = 0;
        this.actual_coordinates = actual_coordinates;

    }


    public coordinates move(fish_free_pair tuple) {
        //Muove il predatore in uno spazio adiacente a caso, dando priorita` agli spazi con delle prede da mangiare.

        if (this.has_moved == 1 || (fish.size() == 0 && free_cell.size() == 0)) return new coordinates(-1, -1);

        //Coordinate nella quali il parametro has_moved deve venire settato a 1.
        coordinates six = new coordinates(this.actual_coordinates.x + 1, this.actual_coordinates.y);
        coordinates seven = new coordinates(this.actual_coordinates.x - 1, actual_coordinates.y + 1);
        coordinates eight = new coordinates(this.actual_coordinates.x, this.actual_coordinates.y + 1);
        coordinates nine = new coordinates(this.actual_coordinates.x + 1, this.actual_coordinates.y + 1);

        /***************************************************************************************************************
        * i nomi delle coordinates definita qui sopra sono questi perche` la griglia delle mosse e` pensata come segue.*
        *                                                                                                              *
        * 1   2   3                                                                                                    *
        * 4   0   6                                                                                                    *
        * 7   8   9                                                                                                    *
        *                                                                                                              *
        * La posizione 0 e` la posizione attuale. Se si muove nelle caselle 6,7,8 o 9. quando quelle celle verranno    *
        * controllate, il predatore con has_moved settato a 1 non dovra` muoversi di nuovo.                            *
        ****************************************************************************************************************/

        else {
            //Selezione di quale delle due arraylist utilizzare per decidere la mossa successiva.
            if (tuple.fish.size() != 0) ArrayList<coordinates> moves = tuple.fish;
            else {
                ArrayList<coordinates> moves = tuple.free_cell;
            }
        }

        //Selezione pseudo-randomica della coordinata dove muoversi ed eventuale settaggio a 1 di has_moved.
        int where_to_move = r.nextInt(moves.size());
        coordinates new_pos = moves.get(where_to_move);
        this.actual_coordinates = new_pos;
        if ( new_pos == six || new_pos == seven || new_pos == eight || new_pos == nine) this.has_moved = 1;
        return new_pos;
        
    }
    

    public coordinates breed(ArrayList<coordinates> free_cell) {
        //Ritorna le coordinate dove riprodursi se il predatore puo` riprodursi. Se non puo` ritorna le coordinate -1,-1.

        if(free_cell.size() == 0 || this.energy < this.breed_energy) return new coordinates(-1,-1);
        coordinates new_pos = free_cell.get(r.nextInt(free_cell.size()));
        return new_pos;
    }


    public Boolean dead() {
        //ritorna 1 se il predatore ha 0 di energia e deve morire, 0 altrimenti.

        if (this.energy == 0) return true;
        return false;
    }

}