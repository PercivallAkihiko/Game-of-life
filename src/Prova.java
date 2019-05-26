import java.util.Random;

public class Prova {
    private int r,c;
    public static int[][] multi;

    public Prova(int riga, int colonna)
    {
        multi = new int[riga][colonna];
        r = riga;
        c = colonna;
    }

    public void inserisci_randoms()
    {
        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                Random value = new Random();
                int valore = value.nextInt(3) + 0;
                multi[i][j] = valore;
            }
        }
    }
}