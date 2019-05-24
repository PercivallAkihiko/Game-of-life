import java.util.ArrayList;

public class coordinates{

    public int x;
    public int y;

    public coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean compares(coordinates coor){
        if(this.x == coor.x || this.y == coor.y) return true;
        return false;
    }

}