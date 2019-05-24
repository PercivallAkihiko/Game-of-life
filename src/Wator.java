package WATOR;

import java.awt.Color;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.SwingUtilities;

public class Wator extends javax.swing.JFrame {
    final int wid = 400, hei = 200;
    boolean[][] currentMove = new boolean[hei][wid];
    boolean play;
    Image offScrImg;
    Graphics offScrGraph;

    public Wator() {
        initComponents();
    }
    
    private void repain(){
        offScrGraph.setColor(jPanel1.getBackground());
        offScrGraph.fillRect(0, 0, jPanel1.getWidth(), jPanel1.getHeight());           
        offScrGraph.setColor(Color.BLUE);
        for(int i = 1; i < hei;i++){
            int y = i * jPanel1.getHeight()/hei;
            offScrGraph.drawLine(0, y, jPanel1.getWidth(), y);
        }
        for(int j = 1; j < wid;j++){
            int x = j * jPanel1.getWidth()/wid;
            offScrGraph.drawLine(x, 0, x, jPanel1.getHeight());
        }
        jPanel1.getGraphics().drawImage(offScrImg, 0, 0, jPanel1);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vacallo nel mare viola");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 423, Short.MAX_VALUE)
        );

        jButton1.setText("Avvia");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Resetta");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel1.setText("Trascinando nella griglia il PulsanteDestro del mouse si disegnano i pesci, con il sinistro gli squali.");

        jLabel2.setText("Per avviare il gioco premere avvia");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        offScrImg = createImage(jPanel1.getWidth(), jPanel1.getHeight());
        offScrGraph = offScrImg.getGraphics();
        repain();
    }//GEN-LAST:event_jPanel1ComponentResized

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int f = wid * evt.getX() / jPanel1.getWidth();
        int r = hei * evt.getY() / jPanel1.getHeight();
        if(SwingUtilities.isLeftMouseButton(evt)){
            currentMove[r][f] = true;

                if(currentMove[r][f]){
                    offScrGraph.setColor(Color.CYAN);
                    int x = f * jPanel1.getWidth()/wid;
                    int y = r * jPanel1.getHeight()/hei;
                    offScrGraph.fillRect(x, y, jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                    jPanel1.getGraphics().drawImage(offScrImg, 0, 0, jPanel1);                    
                }   
        }
        else
        {
                    offScrGraph.setColor(Color.GREEN);
                    int x = f * jPanel1.getWidth()/wid;
                    int y = r * jPanel1.getHeight()/hei;
                    offScrGraph.fillRect(x, y, jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                    jPanel1.getGraphics().drawImage(offScrImg, 0, 0, jPanel1);            
        }
        
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        currentMove = new boolean[hei][wid];
        repain();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        play = !play;
        if(play) jButton1.setText("In Pausa");
        else jButton1.setText("Avvia");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        int f = wid * evt.getX() / jPanel1.getWidth();
        int r = hei * evt.getY() / jPanel1.getHeight();
        currentMove[r][f] = true;
        if(SwingUtilities.isLeftMouseButton(evt)){
            currentMove[r][f] = true;

                if(currentMove[r][f]){
                    offScrGraph.setColor(Color.CYAN);
                    int x = f * jPanel1.getWidth()/wid;
                    int y = r * jPanel1.getHeight()/hei;
                    offScrGraph.fillRect(x, y, jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                    jPanel1.getGraphics().drawImage(offScrImg, 0, 0, jPanel1);            
                }   
        }
        else
        {
                    offScrGraph.setColor(Color.GREEN);
                    int x = f * jPanel1.getWidth()/wid;
                    int y = r * jPanel1.getHeight()/hei;
                    offScrGraph.fillRect(x, y, jPanel1.getWidth()/wid, jPanel1.getHeight()/hei);
                    jPanel1.getGraphics().drawImage(offScrImg, 0, 0, jPanel1);         
        }
    }//GEN-LAST:event_jPanel1MouseClicked

    public static void main(String args[]) {
        Wator life = new Wator();
        life.setLocationRelativeTo(null);
        life.show();        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
