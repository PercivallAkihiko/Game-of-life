import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Preda {

    public int breed_time;
    private boolean has_moved;
    private int tempo_di_riproduzione;
    private Random rand;

    public Preda(int breed_time){
        this.breed_time = breed_time;
        this.has_moved = false;
        this.rand = new Random();
    }

    public coordinates move(ArrayList<coordinates> free_cell, coordinates actual_coordinates){
    
        coordinates six = new coordinates(actual_coordinates.x + 1, actual_coordinates.y);
        coordinates seven = new coordinates(actual_coordinates.x - 1, actual_coordinates.y + 1);
        coordinates eight = new coordinates(actual_coordinates.x, actual_coordinates.y + 1);
        coordinates nine = new coordinates(actual_coordinates.x + 1, actual_coordinates.y + 1);

        if (this.has_moved || free_cell.size() == 0) return new coordinates(-1, -1);
        coordinates new_pos = free_cell.remove( rand.nextInt(free_cell.size()));
        this.tempo_di_riproduzione += 1;
        if (new_pos == six || new_pos == seven || new_pos == eight || new_pos == nine) this.has_moved = true;
        return new_pos;
    }

    public coordinates breed(ArrayList<coordinates> free_cell){
        if(free_cell.size() == 0 || this.tempo_di_riproduzione != this.breed_time) return new coordinates(-1,-1);
        coordinates new_pos = free_cell.remove( rand.nextInt(free_cell.size()));
        return new_pos;
    }

}