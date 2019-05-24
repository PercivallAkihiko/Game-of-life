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

        for(int check_row = row -1 ; check_row <= row + 1 ; check_row++){  //Check Neigh
            for(int check_col = column - 1 ; check_col <= column + 1 ; check_col ++){
                if(check_row != row && check_col != column){

                    Object obj = matrix[check_row][check_col];
                    String class_name = obj.getClass().getName(); //Get class name

                    if(class_name == "Preda"){
                        //Check if it's a FISH
                        coordinates fish_coordinates = new coordinates(check_col, check_row);
                        fish.add(fish_coordinates);
                    }
                    else if(class_name != "Predatore" && class_name != "wall"){
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
        coordinates null_coordinates = new coordinates(-1,-1);

        for(int check_row = 1; check_row <= row - 2 ; check_row++){
            for(int check_col = 1 ; check_col <= column - 2 ; check_col ++){

                Object obj = matrix[check_row][check_col];
                String class_name = obj.getClass().getName();

                fish_free_pair tuple = check_around(check_row, check_col);
                ArrayList<coordinates> fish = tuple.fish;
                ArrayList<coordinates> free_cell = tuple.free_cell;

                /*if(class_name == "Preda"){
                    Preda fish_obj = (Preda)obj;
                    coordinates coor_fish_son = fish_obj.breed(free_cell);
                    if(!coor_fish_son.compares(null_coordinates)){
                        Preda fish_son = new Preda(fish_obj.breed_time, coor_fish_son);
                        matrix[coor_fish_son.y][coor_fish_son.x] = fish_son;
                    }

                    coordinates new_pos = fish_obj.move(free_cell);
                    if(!new_pos.compares(null_coordinates)){
                        //LO ELIMINO DALLA MATRICE
                        matrix[new_pos.y][new_pos.x] = fish;
                    }
                }
                else if(class_name == "Predatore"){
                    Predatore shark_obj = (Predatore)obj;
                    if(!shark_obj.dead()){
                        coordinates coor_shark_son = shark_obj.breed(free_cell);
                        if(!coor_shark_son.compares(null_coordinates)){
                            Predatore shark_son = new Predatore(shark_obj.energy, shark_obj.breed_energy , coor_shark_son);
                            matrix[coor_shark_son.y][coor_shark_son.x] = shark_son;
                        }
                        coordinates new_pos = shark_obj.move(free_cell, fish);
                        if(!new_pos.compares(null_coordinates)){
                            //ELIMINO DALLA MATRICE
                            matrix[new_pos.y][new_pos.x] = shark_obj;
                        }
                    }
                    else //ELIMINARE DALLA GRIGLIA
                    */
                }

            }
        }
    }
}

