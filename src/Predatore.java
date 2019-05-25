import java.util.ArrayList;
import java.util.Random;

public class Predatore {

    public int energy;
    public int breed_energy;
    private Coordinates actual_Coordinates;
    private int has_moved;
    private Random r = new Random();

    public Predatore(int energy, int breed_energy, Coordinates actual_Coordinates) {
        //Crea un nuovo predatore

        this.energy = energy;
        this.breed_energy = breed_energy;
        this.has_moved = 0;
        this.actual_Coordinates = actual_Coordinates;

    }


    public Coordinates move(fish_free_pair tuple) {
        //Muove il predatore in uno spazio adiacente a caso, dando priorita` agli spazi con delle prede da mangiare.

        if (this.has_moved == 1 || (fish.size() == 0 && freeCell.size() == 0)) return new Coordinates(-1, -1);

        //Coordinate nella quali il parametro has_moved deve venire settato a 1.
        Coordinates six = new Coordinates(this.actual_Coordinates.x + 1, this.actual_Coordinates.y);
        Coordinates seven = new Coordinates(this.actual_Coordinates.x - 1, actual_Coordinates.y + 1);
        Coordinates eight = new Coordinates(this.actual_Coordinates.x, this.actual_Coordinates.y + 1);
        Coordinates nine = new Coordinates(this.actual_Coordinates.x + 1, this.actual_Coordinates.y + 1);

        /***************************************************************************************************************
        * i nomi delle Coordinates definita qui sopra sono questi perche` la griglia delle mosse e` pensata come segue.*
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
            if (tuple.fish.size() != 0) ArrayList<Coordinates> moves = tuple.fish;
            else {
                ArrayList<Coordinates> moves = tuple.freeCell;
            }
        }

        //Selezione pseudo-randomica della coordinata dove muoversi ed eventuale settaggio a 1 di has_moved.
        int where_to_move = r.nextInt(moves.size());
        Coordinates new_pos = moves.get(where_to_move);
        this.actual_Coordinates = new_pos;
        if ( new_pos == six || new_pos == seven || new_pos == eight || new_pos == nine) this.has_moved = 1;
        return new_pos;
        
    }
    

    public Coordinates breed(ArrayList<Coordinates> freeCell) {
        //Ritorna le coordinate dove riprodursi se il predatore puo` riprodursi. Se non puo` ritorna le coordinate -1,-1.

        if(freeCell.size() == 0 || this.energy < this.breed_energy) return new Coordinates(-1,-1);
        Coordinates new_pos = freeCell.get(r.nextInt(freeCell.size()));
        return new_pos;
    }


    public Boolean dead() {
        //ritorna 1 se il predatore ha 0 di energia e deve morire, 0 altrimenti.

        if (this.energy == 0) return true;
        return false;
    }

}