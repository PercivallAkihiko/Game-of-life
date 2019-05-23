import java.util.ArrayList;

public class Griglia {

    private Object[][] matrix;
    private int width;
    private int height;

    public  Griglia(int width, int height){
        this.width = width;
        this.height = height;
        matrix = new Object[width][height];

        for(int i = 0; i <= width - 1 ; i++) matrix[0][i] = new wall();           //Create upper WALL
        for(int i = 0; i <= width - 1 ; i++) matrix[height - 1][i] = new wall();    //Create bottom WALL
        for(int i = 0; i <= height - 1 ; i++) matrix[i][0] = new wall();            //Create left WALL
        for(int i = 0; i <= height ; i++) matrix[i][width - 1] = new wall();        //Create right WALL

    }

    public fish_free_pair check_around(int row, int column){

        ArrayList<coordinates> fish = new ArrayList<coordinates>(); // Create an ArrayList FISH
        ArrayList<coordinates> free_cell = new ArrayList<coordinates>(); // Create an ArrayList SHARK

        for(int check_row = row -1; check_row <= row + 1 ; check_row++){  //Check Neigh
            for(int check_col = column - 1 ; check_col <= column + 1 ; check_col ++){
                if(check_row != row && check_col != column){

                    Object obj = matrix[check_row][check_col];
                    String class_name = obj.getClass().getName(); //Get class name

                    if(class_name == "Preda"){
                        //Check if it's a FISH
                        coordinates fish_coordinates = new coordinates(check_col, check_row); //Add FISH coordinates
                        fish.add(fish_coordinates);
                    }
                    else if(class_name != "Predatore" && class_name != "wall"){              //Add SHARK coordinates
                        //Check if there's nothing
                        coordinates free_space_coor = new coordinates(check_col, check_row);
                        free_cell.add(free_space_coor);
                    }

                }
            }
        }

        fish_free_pair tuple = new fish_free_pair(fish, free_cell);
        return tuple;
    }

    public void update_round(){
        int row = height;
        int column = width;


        //Checking Cells
        for(int check_row = 1; check_row <= row - 2 ; check_row++){
            for(int check_col = 1 ; check_col <= column - 2 ; check_col ++){

                Object obj = matrix[check_row][check_col];
                String class_name = obj.getClass().getName();  //Get class name

                fish_free_pair tuple = check_around(check_row, check_col);
                ArrayList<coordinates> fish = tuple.fish;   //Get FISH around
                ArrayList<coordinates> free_cell = tuple.free_cell;  //Get FREE_CELL around

                if(class_name == "Preda"){
                    /* //////////////////////////////////////////////////////////
                    DA IMPLEMENTARE

                    if(breed(free_cell){
                        coordinates removed = fish.remove( random.nextInt(fish.size()));
                        Preda new_fish = new Preda(breed_time);
                        matrix[removed.y][removed.x] = new_fish;
                    }

                    coordinates new_coor = obj.move(free_cell);
                    //ELIMINARE POSIZIONE PRECEDENTE
                    matrix[new_coor.y][new_coord.x] = obj;

                    */ //////////////////////////////////////////////////////////
                }
                else if(class_name == "Predatore"){
                    /* //////////////////////////////////////////////////////////
                    DA IMPLEMENTARE

                    if(obj.dead) //ELIMINO LA PREDA
                    else{
                        if(obj.breed(free_cel)){
                            coordinates removed = free_cell.remove( random.nextInt(free_cell.size()));
                            Predatore new_shark = new Predatore(obg.energy * 2 , breed_energy);
                            matrix[removed.y][removed.x] = new_shark;
                        }

                        coordinates new_coor = obj.move(free_cell, fish);
                        //ELIMINARE POSIZIONE PRECEDENTE
                        matrix[new_coor.y][new_coord.x] = obj;
                        }
                    }
                    */ //////////////////////////////////////////////////////////
                }

            }
        }
    }
}

