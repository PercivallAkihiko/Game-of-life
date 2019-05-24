import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Preda {

    public int breed_time;
    private boolean has_moved;
    private int tempo_di_riproduzione;
    private coordinates coor;
    private Random rand;

    public Preda(int breed_time, coordinates coor){
        this.breed_time = breed_time;
        this.has_moved = false;
        this.coor = coor;
        this.rand = new Random();
    }

    public coordinates move(ArrayList<coordinates> free_cell, coordinates actual_coordinates){

        coordinates six = new coordinates(this.coor.x + 1, this.coor.y);
        coordinates seven = new coordinates(this.coor.x - 1, this.coor.y + 1);
        coordinates eight = new coordinates(this.coor.x, this.coor.y + 1);
        coordinates nine = new coordinates(this.coor.x + 1, this.coor.y + 1);

        if (this.has_moved || free_cell.size() == 0) return new coordinates(-1, -1); // se mi sono già mosso o non ho spazio intorno
        coordinates new_pos = free_cell.remove( rand.nextInt(free_cell.size())); // altrimenti genero una coordinata casuale
        this.tempo_di_riproduzione += 1;
        if (new_pos.compares(six)|| new_pos.compares(seven) || new_pos.compares(eight) || new_pos.compares(nine)) this.has_moved = true;
        this.coor.x = new_pos.x;
        this.coor.y = new_pos.y;
        return new_pos;
    }

    public coordinates breed(ArrayList<coordinates> free_cell){
        if(free_cell.size() == 0 || this.tempo_di_riproduzione != this.breed_time) return new coordinates(-1,-1);
        coordinates new_pos = free_cell.remove( rand.nextInt(free_cell.size()));
        return new_pos;
    }

}