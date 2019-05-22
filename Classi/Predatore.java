import java.util.LinkedList;
import java.util.Random;

public class Predatore {

	public int energy;
	public int breed_energy;
	public int has_moved;
	
	public Predatore(int energy, int breed_energy) {
		//Crea un nuovo predatore
		this.energy = energy;
		this.breed_energy = breed_energy;
		this.has_moved = 0;
		
	}
	
	public Object move(LinkedList free_spaces, LinkedList feast_spaces) {
		//Muove il predatore in uno spazio adiacente a caso, dando priorita` agli spazi con delle prede da mangiare.
		Random r = new Random();
		
		if (this.has_moved == 1 || (free_spaces.size() == 0 && feast_spaces.size() == 0)) return 0; //0 nella griglia e` lo spazio dove il predatore si trova attualmente. 
		
		if (feast_spaces.size() != 0) {
			
			int where_to_move = r.nextInt(free_spaces.size() - 1);
			if ( (int) feast_spaces.get(where_to_move) == 6 || (int) feast_spaces.get(where_to_move) == 7 || (int) feast_spaces.get(where_to_move) == 8 || (int) feast_spaces.get(where_to_move) == 9) {
				this.has_moved = 1;
			}
			
			return (int) feast_spaces.get(where_to_move);
				
		}
		
		else {
		
			int where_to_move = r.nextInt(free_spaces.size() - 1);
			if ( (int) free_spaces.get(where_to_move) == 6 || (int) free_spaces.get(where_to_move) == 7 || (int) free_spaces.get(where_to_move) == 8 || (int) free_spaces.get(where_to_move) == 9) {
				this.has_moved = 1;
			}
			
			return (int) free_spaces.get(where_to_move);
		
		}
	}
	
	public int breed(LinkedList free_spaces) {
		//ritorna 1 se il predatore puo` riprodursi (se ci sono spazi liberi adiacenti intorno a lui, 0 altrimenti.
		if (free_spaces.size() == 0) return 0;
		
		return 1;
		
	}
	
	public int dead() {
		//ritorna 1 se il predatore ha 0 di energia e deve morire, 0 altrimenti.
		if (this.energy == 0) return 1;
		return 0;
		
	}
	
}
