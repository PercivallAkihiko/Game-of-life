import java.util.LinkedList;
import java.util.Random;

public class Preda {

    public int breed_time;
    public int has_moved;
    public int tempo_di_riproduzione;

    public Preda(int breed_time){
        this.breed_time = breed_time;
        this.has_moved = 0;
    }


    public Object move(LinkedList free_spaces){
        Random r = new Random();

        if (this.has_moved == 0){

            int where_to_move = r.nextInt(free_spaces.size() - 1);
            if ( (int) free_spaces.get(where_to_move) == 6 || (int) free_spaces.get(where_to_move) == 7 || (int) free_spaces.get(where_to_move) == 8 || (int) free_spaces.get(where_to_move) == 9) {
                this.has_moved = 1;
                tempo_di_riproduzione +=1;
            }

            return (int) free_spaces.get(where_to_move);
        }

        else{ // se has_moved non è a zero lo resetto senza fare nessun movimento

            this.has_moved = 0;
            return 0;
        }

    }

    public int breed(LinkedList free_spaces) {
        Random r = new Random();
        int where_to_move = r.nextInt(free_spaces.size() - 1);

        if (tempo_di_riproduzione == breed_time){
            tempo_di_riproduzione = 0;
            return 1;
        }

        return 0;
    }

}
