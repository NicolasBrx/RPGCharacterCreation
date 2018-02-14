/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.p13;

import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author nicolas
 */
public class P13PCPanel extends javax.swing.JPanel {

  /**
   * Creates new form AcPCPanel
   */
  public P13PCPanel() {
    initComponents();
    
    this.setMinimumSize(new Dimension(1000,600));
    this.setMaximumSize(new Dimension(1000,600));
    this.setPreferredSize(new Dimension(1000,600));
    
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel3 = new javax.swing.JLabel();
    jtfPlayerName = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jtfPatientName = new javax.swing.JTextField();
    jLabel5 = new javax.swing.JLabel();
    jtfPatientAge = new javax.swing.JTextField();
    jlblInformation = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jlblLucidity = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jlblColdblood = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jlblVitality = new javax.swing.JLabel();
    jbtnLucidityPlus = new javax.swing.JButton();
    jbtnLucidityMinus = new javax.swing.JButton();
    jbtnColdbloodPlus = new javax.swing.JButton();
    jbtnColdbloodMinus = new javax.swing.JButton();
    jbtnVitalityPlus = new javax.swing.JButton();
    jbtnVitalityMinus = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();

    setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
    setMaximumSize(new java.awt.Dimension(1000, 600));
    setMinimumSize(new java.awt.Dimension(1000, 600));
    setPreferredSize(new java.awt.Dimension(1000, 600));

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    jLabel3.setText("Player Name:");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jtfPlayerName, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(jtfPlayerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    jLabel1.setText("Patient Name:");

    jLabel5.setText("Patient Age:");

    jlblInformation.setMaximumSize(new java.awt.Dimension(646, 64));
    jlblInformation.setMinimumSize(new java.awt.Dimension(646, 64));
    jlblInformation.setPreferredSize(new java.awt.Dimension(646, 64));

    jLabel2.setText("Health Indicators:");

    jLabel4.setText("Lucidity:");

    jlblLucidity.setText("5");

    jLabel7.setText("Cold Blood:");

    jlblColdblood.setText("5");

    jLabel9.setText("Vitality:");

    jlblVitality.setText("5");

    jbtnLucidityPlus.setText("-");
    jbtnLucidityPlus.setName("lMinus"); // NOI18N
    jbtnLucidityPlus.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        attributeActionPerformed(evt);
      }
    });

    jbtnLucidityMinus.setText("+");
    jbtnLucidityMinus.setMaximumSize(new java.awt.Dimension(43, 24));
    jbtnLucidityMinus.setMinimumSize(new java.awt.Dimension(43, 24));
    jbtnLucidityMinus.setName("lPlus"); // NOI18N
    jbtnLucidityMinus.setPreferredSize(new java.awt.Dimension(43, 24));
    jbtnLucidityMinus.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        attributeActionPerformed(evt);
      }
    });

    jbtnColdbloodPlus.setText("-");
    jbtnColdbloodPlus.setName("cMinus"); // NOI18N
    jbtnColdbloodPlus.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        attributeActionPerformed(evt);
      }
    });

    jbtnColdbloodMinus.setText("+");
    jbtnColdbloodMinus.setName("cPlus"); // NOI18N
    jbtnColdbloodMinus.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        attributeActionPerformed(evt);
      }
    });

    jbtnVitalityPlus.setText("-");
    jbtnVitalityPlus.setName("vMinus"); // NOI18N
    jbtnVitalityPlus.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        attributeActionPerformed(evt);
      }
    });

    jbtnVitalityMinus.setText("+");
    jbtnVitalityMinus.setName("vPlus"); // NOI18N
    jbtnVitalityMinus.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        attributeActionPerformed(evt);
      }
    });

    jButton1.setText("Save Character");

    jButton2.setText("Reset Fields");

    jButton3.setText("Help");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfPatientName)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfPatientAge, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
              .addGroup(layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblInformation, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                .addContainerGap())))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2)
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel7)
                  .addComponent(jLabel4)
                  .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                  .addComponent(jlblColdblood, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                  .addComponent(jlblLucidity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jlblVitality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(jbtnLucidityPlus)
                      .addComponent(jbtnColdbloodPlus))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(jbtnLucidityMinus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(jbtnColdbloodMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(jbtnVitalityPlus)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jbtnVitalityMinus)))
                .addGap(0, 0, Short.MAX_VALUE))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jlblInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel1)
              .addComponent(jtfPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel5)
              .addComponent(jtfPatientAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel4)
              .addComponent(jlblLucidity)
              .addComponent(jbtnLucidityPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jbtnLucidityMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel7)
              .addComponent(jlblColdblood)
              .addComponent(jbtnColdbloodPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jbtnColdbloodMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel9)
              .addComponent(jlblVitality)
              .addComponent(jbtnVitalityPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jbtnVitalityMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 381, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jButton2)
              .addComponent(jButton1)
              .addComponent(jButton3))
            .addContainerGap())))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void attributeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attributeActionPerformed
    
    System.out.println(((JButton)evt.getSource()).getName()); // do not work, display null... ?!
    
  }//GEN-LAST:event_attributeActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JButton jbtnColdbloodMinus;
  private javax.swing.JButton jbtnColdbloodPlus;
  private javax.swing.JButton jbtnLucidityMinus;
  private javax.swing.JButton jbtnLucidityPlus;
  private javax.swing.JButton jbtnVitalityMinus;
  private javax.swing.JButton jbtnVitalityPlus;
  private javax.swing.JLabel jlblColdblood;
  private javax.swing.JLabel jlblInformation;
  private javax.swing.JLabel jlblLucidity;
  private javax.swing.JLabel jlblVitality;
  private javax.swing.JTextField jtfPatientAge;
  private javax.swing.JTextField jtfPatientName;
  private javax.swing.JTextField jtfPlayerName;
  // End of variables declaration//GEN-END:variables
}
