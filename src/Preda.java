import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Preda {

    public int breed_time;
    public boolean has_moved;
    public int tempo_di_riproduzione;
    private Random r = new Random();

    public Preda(int breed_time){
        this.breed_time = breed_time;
        this.has_moved = false;

    }

    public Object move(LinkedList free_spaces){

        Random r= new Random();

        if(!this.has_moved){
            int where_to_move = r.nextInt(free_spaces.size() - 1);
            if( (int) free_spaces.get(where_to_move) == 6 || (int) free_spaces.get(where_to_move) == 7 || (int) free_spaces.get(where_to_move) == 8 || (int) free_spaces.get(where_to_move) ==9 ){
                this.has_moved = true;
                tempo_di_riproduzione += 1;
            }

            return (int) free_spaces.get(where_to_move);
        }
        else{
            this.has_moved = false;
            return 0;
        }
    }

    public coordinates breed(ArrayList<coordinates> free_spaces){
        if(free_spaces.size() == 0 || this.tempo_di_riproduzione != this.breed_time) return new coordinates(-1,-1);
        coordinates new_coord = free_spaces.remove( r.nextInt(free_spaces.size()));
        return new_coord;
    }

}
