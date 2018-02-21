/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import ihm.p13.P13NPCPanel;
import ihm.p13.PC13Panel;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author nicolas
 */
public class RPGCharacterCreationIHM extends javax.swing.JFrame {

  /**
   * The game that is played of for which the dice launcher is needed.
   */
  private String game;
  
  /**
   * 
   */
  private CreationInterface creation;
  
  /**
   * Creates new form RPGCharacterCreationIHM
   */
  public RPGCharacterCreationIHM() {
    initComponents();
    
    this.setTitle("RPG Character Creation v.0.0.3");                            // title of the frame and software
    URL iconURL = getClass().getResource("favicon.png");                        // icon for the frame
    ImageIcon icon = new ImageIcon(iconURL);
    this.setIconImage(icon.getImage());
    
  }
  
  /**
   * Load the right game mechanisms according to what has been choosen. It is 
   * dedicated to be set by the plugin RPGGameChooser. To be set by another
   * component, whatever it is, it MUST consider the game as follows:
   * - ADD for Advanced Dungeons and Dragons;
   * - SR for Shadowrun;
   * - Ac for Call of Cthulhu;
   * - P13 for Patient 13;
   * - FS for Feng Shui;
   * - Generic for Generic game (default choice is none is recognized).
   * 
   * @param game The game choosen.
   */
  public void setGame(String game){
    this.game = game;
    switch(this.game){
      case "ADD":
        break;
      case "SR":
        break;
      case "AC":
        break;
      case "P13":
        creation = new PC13Panel();
        jtbCreationPanels.add("Player Characters", (PC13Panel)creation);
        jtbCreationPanels.add("Non Player Characters", new P13NPCPanel());
        revalidate();
        repaint();
        break;
      case "FS":
        break;
      default:
        break;
    }
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jtbCreationPanels = new javax.swing.JTabbedPane();
    jbtnQuit = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setTitle("RPG Character Creation v.0.0.0");
    setMaximumSize(new java.awt.Dimension(1024, 700));
    setMinimumSize(new java.awt.Dimension(1024, 700));
    setResizable(false);

    jbtnQuit.setText("Quit");
    jbtnQuit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtnQuitActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jtbCreationPanels)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 943, Short.MAX_VALUE)
            .addComponent(jbtnQuit)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jtbCreationPanels, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jbtnQuit)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jbtnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnQuitActionPerformed
    if(creation.isSaveNeeded()){                                                // if a save is needed while closing
      int dialogButton = JOptionPane.YES_NO_OPTION;                             // proposes to do so
      int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to save before quit?","Warning",dialogButton);
      if(dialogResult == JOptionPane.YES_OPTION){
        creation.saveCharacter();
      }
    }
    System.exit(0);
  }//GEN-LAST:event_jbtnQuitActionPerformed

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(RPGCharacterCreationIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(RPGCharacterCreationIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(RPGCharacterCreationIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(RPGCharacterCreationIHM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new RPGCharacterCreationIHM().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jbtnQuit;
  private javax.swing.JTabbedPane jtbCreationPanels;
  // End of variables declaration//GEN-END:variables
}
