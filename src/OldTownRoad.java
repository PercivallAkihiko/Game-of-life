import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.SwingUtilities;
import java.util.Timer;
import java.util.TimerTask;

public class OldTownRoad extends javax.swing.JFrame
{

    int alt = 50;
    int larg = 100;
    int[][] Griglia = new int[alt][larg];
    boolean Gioca;
    Image Immagine;
    Graphics Grafica;

    public OldTownRoad()
    {
        initComponents();
        Timer tempo = new Timer();
        TimerTask lavoro = new TimerTask()
        {
            public void run()
            {
                if (Gioca)
                {
                    Prova randomed = new Prova(alt, larg);
                    randomed.inserisci_randoms();
                    Griglia = randomed.multi;
                    Colora();
                }
            }
        };
        tempo.scheduleAtFixedRate(lavoro, 0, 16);
    }

    private void Colora()
    {
        Grafica.setColor(jPanel1.getBackground());
        Grafica.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());
        for(int i = 0 ; i < alt ; i++){
            for(int j = 0 ; j < larg; j++)
            {
                if(Griglia[i][j]==1){
                    Grafica.setColor(Color.ORANGE);
                    int x = j * jPanel1.getWidth()/larg;
                    int y = i * jPanel1.getHeight()/alt;
                    Grafica.fillRect(x, y, jPanel1.getWidth()/larg, jPanel1.getHeight()/alt);
                }
                if(Griglia[i][j]==2)
                {
                    Grafica.setColor(Color.RED);
                    int x = j * jPanel1.getWidth()/larg;
                    int y = i * jPanel1.getHeight()/alt;
                    Grafica.fillRect(x, y, jPanel1.getWidth()/larg, jPanel1.getHeight()/alt);
                }
            }
        }
        Grafica.setColor(Color.WHITE);
        for(int i = 1; i < alt;i++){
            int y = i * jPanel1.getHeight()/alt;
            Grafica.drawLine(0, y, jPanel1.getWidth(), y);
        }
        for(int j = 1; j < larg;j++)
        {
            int x = j * jPanel1.getWidth()/larg;
            Grafica.drawLine(x, 0, x, jPanel1.getHeight());
        }
        jPanel1.getGraphics().drawImage(Immagine, 0, 0, jPanel1);
    }

    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OldTownRoad Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx Cx");

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter()
        {
            public void componentResized(java.awt.event.ComponentEvent evt)
            {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 337, Short.MAX_VALUE)
        );

        jButton1.setText("Avvia");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Resetta");
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Per disegnare i pesci trascina il PulsanteDestro del mouse, per disegnare gli squali trascina il PulsanteSinistro.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton1)
                                                        .addComponent(jButton2)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel1)))
                                .addContainerGap())
        );

        pack();
    }

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt)
    {
        Immagine = createImage(jPanel1.getWidth(), jPanel1.getHeight());
        Grafica = Immagine.getGraphics();
        Colora();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {
        Gioca = !Gioca;
        if(Gioca) jButton1.setText("Pausa");
        else jButton1.setText("Avvia");
        Colora();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
    {
        Griglia = new int[alt][larg];
        Colora();
    }

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt)
    {
        int X = larg * evt.getX() / jPanel1.getWidth();
        int Y = alt * evt.getY() / jPanel1.getHeight();
        int x = X * jPanel1.getWidth()/larg;
        int y = Y * jPanel1.getHeight()/alt;
        if(SwingUtilities.isLeftMouseButton(evt))
        {
            Grafica.setColor(Color.RED);
            Griglia[Y][X]=2;
        }
        else
        {
            Grafica.setColor(Color.ORANGE);
            Griglia[Y][X]=1;
        }
        Grafica.fillRect(x, y, jPanel1.getWidth()/larg, jPanel1.getHeight()/alt);
        Colora();
        jPanel1.getGraphics().drawImage(Immagine, 0, 0, jPanel1);
    }

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt)
    {
        int X = larg * evt.getX() / jPanel1.getWidth();
        int Y = alt * evt.getY() / jPanel1.getHeight();
        int x = X * jPanel1.getWidth()/larg;
        int y = Y * jPanel1.getHeight()/alt;
        if(SwingUtilities.isLeftMouseButton(evt))
        {
            Grafica.setColor(Color.RED);
            Griglia[Y][X]=2;
        }
        else
        {
            Grafica.setColor(Color.ORANGE);
            Griglia[Y][X]=1;
        }
        Grafica.fillRect(x, y, jPanel1.getWidth()/larg, jPanel1.getHeight()/alt);
        Colora();
        jPanel1.getGraphics().drawImage(Immagine, 0, 0, jPanel1);
    }

    public static void main(String args[])
    {
        OldTownRoad game = new OldTownRoad();
        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
}