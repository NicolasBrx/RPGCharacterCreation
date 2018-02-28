/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.Color;

/**
 *
 * @author nicolas
 */
public class PCCreationCivilianPanel extends javax.swing.JPanel {

  /**
   * Creates new form PCCreationCivilianPanel
   */
  public PCCreationCivilianPanel() {
    initComponents();
    jtfName.setText("");
    jtfSurname.setText("");
    jtfFirstname.setText("");
    jtfAge.setText("");
    jtfSize.setText("");
    jtfWeight.setText("");
    jtfEyeColour.setText("");
  }
  
  /**
   * 
   * @param enable 
   */
  @Override
  public void enable(boolean enable){
    jtfName.setEnabled(enable);
    jtfSurname.setEnabled(enable);
    jtfFirstname.setEnabled(enable);
    jtfAge.setEnabled(enable);
    jtfSize.setEnabled(enable);
    jtfWeight.setEnabled(enable);
    jtfEyeColour.setEnabled(enable);
    jcbWoman.setEnabled(enable);
  }
  
  /**
   * 
   * @return 
   */
  public boolean isWoman(){
    return jcbWoman.isSelected();
  }
  
  /**
   * 
   * @return 
   */
  public String getCharacterName(){
    return jtfName.getText();
  }
  
  /**
   * 
   * @return 
   */
  public String getCharacterFirstname(){
    return jtfFirstname.getText();
  }
  
  /**
   * 
   * @return 
   */
  public String getCharacterSurname(){
    return jtfSurname.getText();
  }
  
  /**
   * 
   * @return 
   */
  public String getCharacterAge(){
    return jtfAge.getText();
  }
  
  /**
   * 
   * @return 
   */
  public String getCharacterSize(){
    return jtfSize.getText();
  }
  
  /**
   * 
   * @return 
   */
  public String getCharacterWeight(){
    return jtfWeight.getText();
  }
  
  /**
   * 
   * @param color 
   */
  public void colorSurname(Color color){
    jlblSurname.setForeground(color);
  }
  
  /**
   * 
   * @param color 
   */
  public void colorName(Color color){
    jlblName.setForeground(color);
  }
  
  /**
   * 
   * @param color 
   */
  public void colorFirstname(Color color){
    jlblFirstname.setForeground(color);
  }
  
  /**
   * 
   * @param color 
   */
  public void colorAge(Color color){
    jlblAge.setForeground(color);
  }
  

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jcbWoman = new javax.swing.JCheckBox();
    jlblAge = new javax.swing.JLabel();
    jtfAge = new javax.swing.JTextField();
    jlblSurname = new javax.swing.JLabel();
    jtfSurname = new javax.swing.JTextField();
    jlblName = new javax.swing.JLabel();
    jtfName = new javax.swing.JTextField();
    jlblFirstname = new javax.swing.JLabel();
    jtfFirstname = new javax.swing.JTextField();
    jlblSize = new javax.swing.JLabel();
    jlblWeight = new javax.swing.JLabel();
    jlblEyeColour = new javax.swing.JLabel();
    jtfSize = new javax.swing.JTextField();
    jtfWeight = new javax.swing.JTextField();
    jtfEyeColour = new javax.swing.JTextField();

    setBorder(javax.swing.BorderFactory.createEtchedBorder());
    setMaximumSize(new java.awt.Dimension(186, 232));
    setMinimumSize(new java.awt.Dimension(186, 232));

    jcbWoman.setText("Woman?");

    jlblAge.setText("Age:");

    jlblSurname.setText("Surname:");

    jlblName.setText("Name:");

    jlblFirstname.setText("First Name:");

    jlblSize.setText("Size:");

    jlblWeight.setText("Weight:");

    jlblEyeColour.setText("Eye Colour:");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jcbWoman)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jlblName)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jlblFirstname)
                .addComponent(jlblSize, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jlblWeight, javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jlblEyeColour, javax.swing.GroupLayout.Alignment.TRAILING))
              .addComponent(jlblAge)
              .addComponent(jlblSurname))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jtfFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jtfAge, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jtfSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jtfSize, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jtfWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jtfEyeColour, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jcbWoman)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jlblName)
          .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jlblFirstname)
          .addComponent(jtfFirstname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jtfAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jlblAge))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jtfSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jlblSurname))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jlblSize)
          .addComponent(jtfSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jlblWeight)
          .addComponent(jtfWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jlblEyeColour)
          .addComponent(jtfEyeColour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JCheckBox jcbWoman;
  private javax.swing.JLabel jlblAge;
  private javax.swing.JLabel jlblEyeColour;
  private javax.swing.JLabel jlblFirstname;
  private javax.swing.JLabel jlblName;
  private javax.swing.JLabel jlblSize;
  private javax.swing.JLabel jlblSurname;
  private javax.swing.JLabel jlblWeight;
  private javax.swing.JTextField jtfAge;
  private javax.swing.JTextField jtfEyeColour;
  private javax.swing.JTextField jtfFirstname;
  private javax.swing.JTextField jtfName;
  private javax.swing.JTextField jtfSize;
  private javax.swing.JTextField jtfSurname;
  private javax.swing.JTextField jtfWeight;
  // End of variables declaration//GEN-END:variables
}
