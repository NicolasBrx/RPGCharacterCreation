package ihm.games;

import ihm.CreationInterface;
import ihm.PCGenericPanel;
import player_creator.games.SrCreator;
import player_creator.games.shadowrun.builder.Prioritizer;
import player_creator.games.shadowrun.builder.RunnerTypes;
import player_creator.games.shadowrun.builder.SpecialSkills;
import player_creator.games.shadowrun.builder.LifeStyles;

/**
 *
 * @author Nicolas Brax
 */
public class SrPanel extends javax.swing.JPanel implements CreationInterface{

  private SrCreator creator;
  private boolean saveNeeded;
  private Prioritizer priorities;
  
  /**
   * Creates new form AcPCPanel
   */
  public SrPanel() {
    initComponents();
    
    jlblAvailableMetatypes.setText(" ");
    jlblSpecialAttributesPoints.setText(" ");
    jlblAttributesPoints.setText(" ");
    jlblCredits.setText(" ");
    jlblMRPoints.setText(" ");
    jlblMROther.setText(" ");
    jlblSkillPoints.setText(" ");
    jlblSkillGroupPoints.setText(" ");
    
    for(RunnerTypes runnerType : RunnerTypes.values()){
      jcbbRunnerType.addItem(runnerType.toString());
    }
    
    for(SpecialSkills specialSkill : SpecialSkills.values()){
      jcbbSpecial.addItem(specialSkill.toString());
    }
  }

  @Override
  public boolean isSaveNeeded(){
    return this.saveNeeded;
  }
  
  @Override
  public void saveCharacter(){
    //modifySaveState(false);
  }
  
  /**
   * 
   * @param playerName 
   */
  @Override
  public void create(String playerName){
    creator = new SrCreator(playerName,25);
    
    //enableFields(true);
    
    setInformation("You can now create a new ...");
    
    // + init des champs a saisir...
  }
  
  /**
   * 
   * @param message 
   */
  private void setInformation(String message){
    ((PCGenericPanel)this.getParent()).setInformation(message);
  }
  
  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jcbMetatype = new javax.swing.JComboBox<>();
    jcbAttributes = new javax.swing.JComboBox<>();
    jcbMR = new javax.swing.JComboBox<>();
    jcbSkills = new javax.swing.JComboBox<>();
    jcbRessources = new javax.swing.JComboBox<>();
    jcbGodMode = new javax.swing.JCheckBox();
    jbValidatePriorities = new javax.swing.JButton();
    jbPreviousSubPanel = new javax.swing.JButton();
    jbNextSubPanel = new javax.swing.JButton();
    jbValidate = new javax.swing.JButton();
    jbSave = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jlblAvailableMetatypes = new javax.swing.JLabel();
    jlblSpecialAttributesPoints = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jlblAttributesPoints = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jlblCredits = new javax.swing.JLabel();
    jLabel10 = new javax.swing.JLabel();
    jlblMRPoints = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jlblMROther = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    jlblSkillPoints = new javax.swing.JLabel();
    jLabel13 = new javax.swing.JLabel();
    jlblSkillGroupPoints = new javax.swing.JLabel();
    jcbbRunnerType = new javax.swing.JComboBox<>();
    jcbbSpecial = new javax.swing.JComboBox<>();

    setBorder(javax.swing.BorderFactory.createEtchedBorder());
    setMaximumSize(new java.awt.Dimension(975, 520));
    setMinimumSize(new java.awt.Dimension(975, 520));
    setPreferredSize(new java.awt.Dimension(975, 520));

    jLabel1.setText("Metatype");

    jLabel2.setText("Attributs");

    jLabel3.setText("Magie / Resonance");

    jLabel4.setText("Compétences");

    jLabel5.setText("Ressources");

    jcbMetatype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
    jcbMetatype.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbMetatypeActionPerformed(evt);
      }
    });

    jcbAttributes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
    jcbAttributes.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbAttributesActionPerformed(evt);
      }
    });

    jcbMR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
    jcbMR.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbMRActionPerformed(evt);
      }
    });

    jcbSkills.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
    jcbSkills.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbSkillsActionPerformed(evt);
      }
    });

    jcbRessources.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
    jcbRessources.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbRessourcesActionPerformed(evt);
      }
    });

    jcbGodMode.setText("God Mode");

    jbValidatePriorities.setText("Valider");

    jbPreviousSubPanel.setText("<<");

    jbNextSubPanel.setText(">>");

    jbValidate.setText("Validate");
    jbValidate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbValidateActionPerformed(evt);
      }
    });

    jbSave.setText("Save");

    jLabel6.setText("Points attributs spéciaux :");

    jLabel7.setText("Metatypes disponibles :");

    jlblAvailableMetatypes.setText("jLabel8");

    jlblSpecialAttributesPoints.setText("jLabel8");
    jlblSpecialAttributesPoints.setMaximumSize(new java.awt.Dimension(50, 14));
    jlblSpecialAttributesPoints.setMinimumSize(new java.awt.Dimension(50, 14));
    jlblSpecialAttributesPoints.setPreferredSize(new java.awt.Dimension(50, 14));

    jLabel8.setText("Points attributs :");

    jlblAttributesPoints.setText("jLabel9");

    jLabel9.setText("Crédits :");

    jlblCredits.setText("jLabel10");

    jLabel10.setText("M / R automatique :");

    jlblMRPoints.setText("jLabel11");

    jLabel11.setText("Autre :");

    jlblMROther.setText("jLabel12");

    jLabel12.setText("Points de compétences :");

    jlblSkillPoints.setText("jLabel13");

    jLabel13.setText("Points de groupes :");

    jlblSkillGroupPoints.setText("jLabel14");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(113, 113, 113)
        .addComponent(jbPreviousSubPanel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jbNextSubPanel)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel6)
              .addComponent(jlblSpecialAttributesPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel7)
              .addComponent(jlblAvailableMetatypes))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel8)
              .addComponent(jlblAttributesPoints)))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jcbMetatype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(75, 75, 75)
            .addComponent(jLabel2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jcbAttributes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(31, 31, 31)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbMR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jLabel10)
              .addComponent(jlblMRPoints))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(jlblSkillGroupPoints)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbValidatePriorities))
                  .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbSkills, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addComponent(jLabel12)
                      .addComponent(jlblSkillPoints))
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbRessources, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(jcbGodMode))
                      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                          .addComponent(jLabel9)
                          .addComponent(jlblCredits))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                          .addComponent(jcbbRunnerType, 0, 136, Short.MAX_VALUE)
                          .addComponent(jcbbSpecial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel13)
                    .addGap(0, 0, Short.MAX_VALUE))))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbValidate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSave, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)))
            .addGap(30, 30, 30))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel11)
              .addComponent(jlblMROther))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel1)
              .addComponent(jLabel2)
              .addComponent(jLabel3)
              .addComponent(jLabel4)
              .addComponent(jLabel5)
              .addComponent(jcbMetatype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jcbMR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jcbSkills, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jcbRessources, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jcbAttributes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jcbGodMode))
            .addGap(4, 4, 4)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel7)
              .addComponent(jLabel8)
              .addComponent(jLabel9)
              .addComponent(jLabel10)
              .addComponent(jLabel12)
              .addComponent(jcbbRunnerType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jlblAvailableMetatypes, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jlblCredits)
              .addComponent(jlblMRPoints)
              .addComponent(jlblSkillPoints)
              .addComponent(jlblAttributesPoints))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel6)
              .addComponent(jLabel11)
              .addComponent(jLabel13))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jcbbSpecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(13, 13, 13)))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jlblSpecialAttributesPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jlblMROther)
            .addComponent(jlblSkillGroupPoints))
          .addComponent(jbValidatePriorities))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jbPreviousSubPanel)
          .addComponent(jbNextSubPanel)
          .addComponent(jbValidate)
          .addComponent(jbSave))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jbValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbValidateActionPerformed
    // Once validate button is clicked
    
    // Check all numbers are good and allow to pursue character creation by instanciation of the subpanels 
    // (attributes, skills, gears, qualities, ... repartition to see according to place and what's to be done)
    
  }//GEN-LAST:event_jbValidateActionPerformed

  private void jcbMetatypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMetatypeActionPerformed
    // inform about available metatyptes and special points according to the priority choosen
  }//GEN-LAST:event_jcbMetatypeActionPerformed

  private void jcbAttributesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAttributesActionPerformed
    // inform about available attribute points according to the priority choosen
  }//GEN-LAST:event_jcbAttributesActionPerformed

  private void jcbMRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMRActionPerformed
    // inform about magic resistance and other magic/techno bonuses according to the priority choosen
  }//GEN-LAST:event_jcbMRActionPerformed

  private void jcbSkillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSkillsActionPerformed
    // inform about available skill points according to the priority choosen
  }//GEN-LAST:event_jcbSkillsActionPerformed

  private void jcbRessourcesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbRessourcesActionPerformed
    // inform about available credit resources according to the priority choosen
  }//GEN-LAST:event_jcbRessourcesActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JButton jbNextSubPanel;
  private javax.swing.JButton jbPreviousSubPanel;
  private javax.swing.JButton jbSave;
  private javax.swing.JButton jbValidate;
  private javax.swing.JButton jbValidatePriorities;
  private javax.swing.JComboBox<String> jcbAttributes;
  private javax.swing.JCheckBox jcbGodMode;
  private javax.swing.JComboBox<String> jcbMR;
  private javax.swing.JComboBox<String> jcbMetatype;
  private javax.swing.JComboBox<String> jcbRessources;
  private javax.swing.JComboBox<String> jcbSkills;
  private javax.swing.JComboBox<String> jcbbRunnerType;
  private javax.swing.JComboBox<String> jcbbSpecial;
  private javax.swing.JLabel jlblAttributesPoints;
  private javax.swing.JLabel jlblAvailableMetatypes;
  private javax.swing.JLabel jlblCredits;
  private javax.swing.JLabel jlblMROther;
  private javax.swing.JLabel jlblMRPoints;
  private javax.swing.JLabel jlblSkillGroupPoints;
  private javax.swing.JLabel jlblSkillPoints;
  private javax.swing.JLabel jlblSpecialAttributesPoints;
  // End of variables declaration//GEN-END:variables
}
