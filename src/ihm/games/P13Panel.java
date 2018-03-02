package ihm.games;

import player_creator.games.P13Creator;
import javax.swing.JButton;
import ihm.CreationInterface;
import ihm.PCGenericPanel;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Nicolas Brax
 */
public class P13Panel extends javax.swing.JPanel implements CreationInterface {
  
  private P13Creator creator;
  private boolean saveNeeded;
  
  /**
   * Creates new form PC13Panel
   */
  public P13Panel() {
    initComponents();
    jpCivil.enable(false);
    saveNeeded = false;
  }
  
  @Override
  public boolean isSaveNeeded(){
    return this.saveNeeded;
  }
  
  @Override
  public void saveCharacter(){
    modifySaveState(false);
  }
  
  /**
   * 
   * @param playerName 
   */
  @Override
  public void create(String playerName){
    creator = new P13Creator(playerName,true);
    
    setInformation("You can now create a new Patient. Please note that the "
            + "form is initialised for a new sane patient. (Un)Check boxes "
            + "if you want another type of patient. It impacts the number of "
            + "points to allocate as well as the number of lineaments.");
    
    enableFields(true);
    
    jlblLucidity.setText(String.valueOf(creator.getLucidity()));
    jlblColdblood.setText(String.valueOf(creator.getColdblood()));
    jlblVitality.setText(String.valueOf(creator.getVitality()));
    jlblRemaining.setText(String.valueOf(creator.remainingPoints()));
    
    resetLineamentFields();
  }
  
  /**
   * 
   * @param save 
   */
  private void modifySaveState(boolean save){
    if(!saveNeeded && (save != saveNeeded)){
      saveNeeded = true;
      ((PCGenericPanel)getParent()).changeTitle("*");
    }
    else if(saveNeeded && (save != saveNeeded)){
      saveNeeded = false;
      ((PCGenericPanel)getParent()).changeTitle("");
    }
  }
  
  /**
   * 
   */
  private void resetAttributeFields(){
    creator.setLucidity(5);        // dangerous?
    creator.setColdblood(5);
    creator.setVitality(5);
    jlblLucidity.setText(String.valueOf(creator.getLucidity()));
    jlblColdblood.setText(String.valueOf(creator.getColdblood()));
    jlblVitality.setText(String.valueOf(creator.getVitality()));
    jlblRemaining.setText(String.valueOf(creator.remainingPoints()));
  }
  
  private void resetLineamentFields(){
    DefaultTableModel model = (DefaultTableModel)jtLineaments.getModel();
    int rowCount = model.getRowCount();
    for(int i = rowCount - 1 ; i >= 0 ; --i){
      model.removeRow(i);
    }
    if(!creator.isSane()){
      model.addRow(new Object[]{"",3});
      model.addRow(new Object[]{"",2});
    }
    model.addRow(new Object[]{"",2});
    model.addRow(new Object[]{"",1});
    model.addRow(new Object[]{"",-1});
    model.addRow(new Object[]{"",-2});
  }
  
  /**  
   * 
   */
  private void storeCharacter(){
    creator.setFemale(jpCivil.isWoman());
    if(!jpCivil.getCharacterName().equalsIgnoreCase(""))
      creator.setFamilyname(jpCivil.getCharacterName());
    if(!jpCivil.getCharacterFirstname().equalsIgnoreCase(""))
      creator.setFirstname(jpCivil.getCharacterFirstname());
    if(!jpCivil.getCharacterSurname().equalsIgnoreCase(""))
      creator.setSurname(jpCivil.getCharacterSurname());
    if(!jpCivil.getCharacterAge().equalsIgnoreCase(""))
      creator.setAge(Integer.parseInt(jpCivil.getCharacterAge()));
    if(!jpCivil.getCharacterWeight().equalsIgnoreCase(""))
      creator.setWeigth(Double.parseDouble(jpCivil.getCharacterWeight()));
    if(!jpCivil.getCharacterSize().equalsIgnoreCase(""))
      creator.setSize(Double.parseDouble(jpCivil.getCharacterSize()));
    if(!jpCivil.getCharacterEyeColor().equalsIgnoreCase(""))
      creator.setEyecolor(jpCivil.getCharacterEyeColor());
    for(int i = 0 ; i < jtLineaments.getRowCount() ; ++i){
      creator.addLineament((String)jtLineaments.getValueAt(i,0),(Integer)jtLineaments.getValueAt(i,1));
    }
    creator.setStored(true);
  }
  
  /**
   * 
   */
  private boolean validateCharacter(){
    jpCivil.colorSurname(Color.BLACK);
    jpCivil.colorName(Color.BLACK);
    jpCivil.colorFirstname(Color.BLACK);
    jpCivil.colorAge(Color.BLACK);
    jlblAttL.setForeground(Color.BLACK);
    jlblAttC.setForeground(Color.BLACK);
    jlblAttV.setForeground(Color.BLACK);
    jlblRemain.setForeground(Color.BLACK);
    jtLineaments.setForeground(Color.BLACK);
    if(creator.isStored()){
      String validated = creator.validateCharacter();
      if(validated.equalsIgnoreCase("ok")){
        setInformation("The character is validated as a correct Patient "
                + "13 patient.");
        return true;
      }
      else{
        setInformation("The character is not validated as a correct "
                + "Patient 13 patient. See the red colored fields.");
        String[] results = validated.split("-");
        for(int i = 0 ; i < results.length ; ++i){
          if(results[i].equalsIgnoreCase("surname")){
            jpCivil.colorSurname(Color.RED);
          }
          else if(results[i].equalsIgnoreCase("name")){
            jpCivil.colorFirstname(Color.RED);
            jpCivil.colorName(Color.RED);
          }
          else if(results[i].equalsIgnoreCase("age")){
            jpCivil.colorAge(Color.RED);
          }
          else if(results[i].equalsIgnoreCase("attribute")){
            jlblAttL.setForeground(Color.RED);
            jlblAttC.setForeground(Color.RED);
            jlblAttV.setForeground(Color.RED);
          }
          else if(results[i].equalsIgnoreCase("remaining")){
            jlblRemain.setForeground(Color.RED);
          }
          else if(results[i].equalsIgnoreCase("lineaments")){
            jtLineaments.setForeground(Color.RED);
          }
        }
        return false;
      }
    }
    else{
      setInformation("No character is stored into the creator. Maybe "
              + "check the code or sequence called.");
      return false;
    }
  }
  
  /**
   * 
   * @param yes 
   */
  private void enableFields(boolean yes){
    jpCivil.enable(yes);
    jcbSane.setEnabled(yes);
    jcbSane.setSelected(yes);
    jcbGod.setEnabled(yes);
    jbtnPL.setEnabled(yes);
    jbtnML.setEnabled(yes);
    jbtnPC.setEnabled(yes);
    jbtnMC.setEnabled(yes);
    jbtnPV.setEnabled(yes);
    jbtnMV.setEnabled(yes);
    jbtnHelp.setEnabled(yes);
    jbtnValidate.setEnabled(yes);
    jbtnSave.setEnabled(yes);
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

    jcbSane = new javax.swing.JCheckBox();
    jcbGod = new javax.swing.JCheckBox();
    jlblAttL = new javax.swing.JLabel();
    jlblAttC = new javax.swing.JLabel();
    jlblAttV = new javax.swing.JLabel();
    jlblLucidity = new javax.swing.JLabel();
    jlblColdblood = new javax.swing.JLabel();
    jlblVitality = new javax.swing.JLabel();
    jbtnPL = new javax.swing.JButton();
    jbtnML = new javax.swing.JButton();
    jbtnMC = new javax.swing.JButton();
    jbtnPC = new javax.swing.JButton();
    jbtnPV = new javax.swing.JButton();
    jbtnMV = new javax.swing.JButton();
    jlblRemain = new javax.swing.JLabel();
    jlblRemaining = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jtLineaments = new javax.swing.JTable();
    jbtnAdd = new javax.swing.JButton();
    jbtnRemove = new javax.swing.JButton();
    jbtnValidate = new javax.swing.JButton();
    jbtnSave = new javax.swing.JButton();
    jbtnHelp = new javax.swing.JButton();
    jpCivil = new ihm.JpCivilianStatus();
    jbtnReset = new javax.swing.JButton();

    setBorder(javax.swing.BorderFactory.createEtchedBorder());
    setMaximumSize(new java.awt.Dimension(974, 520));
    setMinimumSize(new java.awt.Dimension(974, 520));
    setPreferredSize(new java.awt.Dimension(974, 520));

    jcbSane.setText("Patient is Sane?");
    jcbSane.setEnabled(false);
    jcbSane.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbSaneActionPerformed(evt);
      }
    });

    jcbGod.setText("Patient is God?");
    jcbGod.setEnabled(false);
    jcbGod.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbGodActionPerformed(evt);
      }
    });

    jlblAttL.setText("Lucidity:");

    jlblAttC.setText("Cold Blood:");

    jlblAttV.setText("Vitality: ");

    jlblLucidity.setMaximumSize(new java.awt.Dimension(50, 14));
    jlblLucidity.setMinimumSize(new java.awt.Dimension(50, 14));
    jlblLucidity.setPreferredSize(new java.awt.Dimension(50, 14));

    jlblColdblood.setMaximumSize(new java.awt.Dimension(50, 14));
    jlblColdblood.setMinimumSize(new java.awt.Dimension(50, 14));
    jlblColdblood.setPreferredSize(new java.awt.Dimension(50, 14));

    jlblVitality.setMaximumSize(new java.awt.Dimension(50, 14));
    jlblVitality.setMinimumSize(new java.awt.Dimension(50, 14));
    jlblVitality.setPreferredSize(new java.awt.Dimension(50, 14));

    jbtnPL.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
    jbtnPL.setText("+");
    jbtnPL.setEnabled(false);
    jbtnPL.setMaximumSize(new java.awt.Dimension(40, 18));
    jbtnPL.setMinimumSize(new java.awt.Dimension(40, 18));
    jbtnPL.setName("btnPlusL"); // NOI18N
    jbtnPL.setPreferredSize(new java.awt.Dimension(40, 18));
    jbtnPL.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        changeAttribute(evt);
      }
    });

    jbtnML.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
    jbtnML.setText("-");
    jbtnML.setEnabled(false);
    jbtnML.setMaximumSize(new java.awt.Dimension(40, 18));
    jbtnML.setMinimumSize(new java.awt.Dimension(40, 18));
    jbtnML.setName("btnMinusL"); // NOI18N
    jbtnML.setPreferredSize(new java.awt.Dimension(40, 18));
    jbtnML.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        changeAttribute(evt);
      }
    });

    jbtnMC.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
    jbtnMC.setText("-");
    jbtnMC.setEnabled(false);
    jbtnMC.setMaximumSize(new java.awt.Dimension(40, 18));
    jbtnMC.setMinimumSize(new java.awt.Dimension(40, 18));
    jbtnMC.setName("btnMinusC"); // NOI18N
    jbtnMC.setPreferredSize(new java.awt.Dimension(40, 18));
    jbtnMC.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        changeAttribute(evt);
      }
    });

    jbtnPC.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
    jbtnPC.setText("+");
    jbtnPC.setEnabled(false);
    jbtnPC.setMaximumSize(new java.awt.Dimension(40, 18));
    jbtnPC.setMinimumSize(new java.awt.Dimension(40, 18));
    jbtnPC.setName("btnPlusC"); // NOI18N
    jbtnPC.setPreferredSize(new java.awt.Dimension(40, 18));
    jbtnPC.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        changeAttribute(evt);
      }
    });

    jbtnPV.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
    jbtnPV.setText("+");
    jbtnPV.setEnabled(false);
    jbtnPV.setMaximumSize(new java.awt.Dimension(40, 18));
    jbtnPV.setMinimumSize(new java.awt.Dimension(40, 18));
    jbtnPV.setName("btnPlusV"); // NOI18N
    jbtnPV.setPreferredSize(new java.awt.Dimension(40, 18));
    jbtnPV.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        changeAttribute(evt);
      }
    });

    jbtnMV.setFont(new java.awt.Font("Dialog", 0, 8)); // NOI18N
    jbtnMV.setText("-");
    jbtnMV.setEnabled(false);
    jbtnMV.setMaximumSize(new java.awt.Dimension(40, 18));
    jbtnMV.setMinimumSize(new java.awt.Dimension(40, 18));
    jbtnMV.setName("btnMinusV"); // NOI18N
    jbtnMV.setPreferredSize(new java.awt.Dimension(40, 18));
    jbtnMV.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        changeAttribute(evt);
      }
    });

    jlblRemain.setText("Remaining points to allocate:");

    jlblRemaining.setMaximumSize(new java.awt.Dimension(30, 14));
    jlblRemaining.setMinimumSize(new java.awt.Dimension(30, 14));
    jlblRemaining.setPreferredSize(new java.awt.Dimension(30, 14));

    jtLineaments.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Lineament", "Score"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.Integer.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    jScrollPane1.setViewportView(jtLineaments);
    if (jtLineaments.getColumnModel().getColumnCount() > 0) {
      jtLineaments.getColumnModel().getColumn(0).setPreferredWidth(350);
      jtLineaments.getColumnModel().getColumn(1).setPreferredWidth(100);
    }

    jbtnAdd.setText("Add");
    jbtnAdd.setEnabled(false);
    jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtnAddActionPerformed(evt);
      }
    });

    jbtnRemove.setText("Remove");
    jbtnRemove.setEnabled(false);
    jbtnRemove.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtnRemoveActionPerformed(evt);
      }
    });

    jbtnValidate.setText("Validate");
    jbtnValidate.setEnabled(false);
    jbtnValidate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtnValidateActionPerformed(evt);
      }
    });

    jbtnSave.setText("Save");
    jbtnSave.setEnabled(false);
    jbtnSave.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtnSaveActionPerformed(evt);
      }
    });

    jbtnHelp.setText("Help?");
    jbtnHelp.setEnabled(false);
    jbtnHelp.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtnHelpActionPerformed(evt);
      }
    });

    jbtnReset.setText("Reset");
    jbtnReset.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbtnResetActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jlblAttC)
                  .addComponent(jlblAttV)
                  .addComponent(jlblAttL))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(jlblVitality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jlblColdblood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jlblLucidity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(jbtnPC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jbtnMC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(jbtnPL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jbtnML, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(layout.createSequentialGroup()
                    .addComponent(jbtnPV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jbtnMV, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jlblRemain)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlblRemaining, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(layout.createSequentialGroup()
                .addComponent(jcbSane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbGod)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 528, Short.MAX_VALUE)
            .addComponent(jpCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jbtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtnRemove))
              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, Short.MAX_VALUE)))
        .addContainerGap())
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jbtnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jbtnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jbtnValidate)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jbtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(30, 30, 30))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jcbSane)
              .addComponent(jcbGod))
            .addGap(35, 35, 35)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jlblAttL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jlblLucidity, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbtnPL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jbtnML, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jlblAttC)
              .addComponent(jlblColdblood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jbtnPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jbtnMC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jlblAttV)
              .addComponent(jlblVitality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jbtnPV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jbtnMV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jlblRemain)
              .addComponent(jlblRemaining, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jbtnRemove)
              .addComponent(jbtnAdd)))
          .addComponent(jpCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 24, Short.MAX_VALUE)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jbtnHelp)
          .addComponent(jbtnValidate)
          .addComponent(jbtnSave)
          .addComponent(jbtnReset))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jcbSaneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSaneActionPerformed
    boolean goOn = true;
    if(!creator.isSane() && (creator.remainingPoints() < 3)){
      int dialogButton = JOptionPane.YES_NO_OPTION;                             // proposes to do so
      int dialogResult = JOptionPane.showConfirmDialog (null, "Too much attribute "
              + "points have been spent for a sane patient. Would you reset the "
              + "attribute points?","Warning",dialogButton);
      if(dialogResult == JOptionPane.YES_OPTION){
        resetAttributeFields();
      }
      else{
        goOn = false;
      }
    }
    if(goOn){
      if(!creator.isSane() 
      && (!(((String)jtLineaments.getValueAt(0,0)).equalsIgnoreCase(""))
         || !(((String)jtLineaments.getValueAt(1,0)).equalsIgnoreCase(""))
      )){
        int dialogButton = JOptionPane.YES_NO_OPTION;                           // proposes to do so
        int dialogResult = JOptionPane.showConfirmDialog (null, "Some lineaments "
                + "have been set and are not compatible with a conversion from an "
                + "affected to a sane patient. Would you reset?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
          resetLineamentFields();
        }
      }
      else{
        DefaultTableModel model = (DefaultTableModel)jtLineaments.getModel();
        if(creator.isSane()){
          model.insertRow(0,new Object[]{"",3});
          model.insertRow(1,new Object[]{"",2});
        }
        else{
          model.removeRow(0);
          model.removeRow(0);
        }
      }

      creator.setSane(jcbSane.isSelected());

      setInformation("Your character is now a"
              + (jcbSane.isSelected() ? "" : "n")
              + " " 
              + (jcbSane.isSelected() ? "sane" : "affected") 
              + " patient. It impacts the number of points to allocate and the "
              + "number of lineaments to add.");
      jlblRemaining.setText(String.valueOf(creator.remainingPoints()));
    }
    else{
      setInformation("Conversion has been aborted.");
      jcbSane.setSelected(!jcbSane.isSelected());
    }
  }//GEN-LAST:event_jcbSaneActionPerformed

  private void jcbGodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGodActionPerformed
    if(creator.isGodMode()){
      int dialogButton = JOptionPane.YES_NO_OPTION;                             // proposes to do so
      int dialogResult = JOptionPane.showConfirmDialog (null, "God Mode Creation "
                + "was not compatible with another creation mode so every field "
                + "will be reseted. Would you continue?","Warning",dialogButton);
      if(dialogResult == JOptionPane.YES_OPTION){
        resetAttributeFields();
        resetLineamentFields();
      }
    }
    else{
      setInformation("God Mode allows you to create a character without any "
              + "limitation. Hope you know what you do.");
      creator.setGodMode(jcbGod.isSelected());
      jbtnAdd.setEnabled(jcbGod.isSelected());
      jbtnRemove.setEnabled(jcbGod.isSelected());
    }
  }//GEN-LAST:event_jcbGodActionPerformed

  private void changeAttribute(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeAttribute
    switch(((JButton)evt.getSource()).getName()){
      case "btnPlusL":
        if(!creator.modifyLucidity(1))
          setInformation(creator.lastError());
        else
          jlblLucidity.setText(String.valueOf(creator.getLucidity()));
        break;
      case "btnMinusL":
        if(!creator.modifyLucidity(-1))
          setInformation(creator.lastError());
        else
          jlblLucidity.setText(String.valueOf(creator.getLucidity()));
        break;
      case "btnPlusC":
        if(!creator.modifyColdblood(1))
          setInformation(creator.lastError());
        else
          jlblColdblood.setText(String.valueOf(creator.getColdblood()));
        break;
      case "btnMinusC":
        if(!creator.modifyColdblood(-1))
          setInformation(creator.lastError());
        else
          jlblColdblood.setText(String.valueOf(creator.getColdblood()));
        break;
      case "btnPlusV":
        if(!creator.modifyVitality(1))
          setInformation(creator.lastError());
        else
          jlblVitality.setText(String.valueOf(creator.getVitality()));
        break;
      case "btnMinusV":
        if(!creator.modifyVitality(-1))
          setInformation(creator.lastError());
        else
          jlblVitality.setText(String.valueOf(creator.getVitality()));
        break;
      default:
        // TODO: error should not be able to be reached!
    }//switch
    jlblRemaining.setText(String.valueOf(creator.remainingPoints()));
    modifySaveState(true);
  }//GEN-LAST:event_changeAttribute

  private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
    if(creator.isGodMode()){
      DefaultTableModel model = (DefaultTableModel)jtLineaments.getModel();
      model.addRow(new Object[]{"",0});
    }
    else{
      setInformation("You can only add new lineaments while creating "
              + "a character in God Mode.");
    }
  }//GEN-LAST:event_jbtnAddActionPerformed

  private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
    storeCharacter();
    int dialogButton = JOptionPane.YES_NO_OPTION;                           // proposes to do so
    int dialogResult = JOptionPane.showConfirmDialog (null, "Please note that "
            + "this will validate and close your character. Be sure that it is  "
            + "completed. Would you go on?","Warning",dialogButton);
    if(dialogResult == JOptionPane.YES_OPTION){
      if(validateCharacter()){
        creator.saveCharacter();
        modifySaveState(false);
        enableFields(false);
        setInformation("Save is done.");
      }
      else{
        setInformation("Save is not done, some validation problems appeared. See the red fields.");
      }
    }
  }//GEN-LAST:event_jbtnSaveActionPerformed

  private void jbtnValidateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnValidateActionPerformed
    storeCharacter();
    validateCharacter();
  }//GEN-LAST:event_jbtnValidateActionPerformed

  private void jbtnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHelpActionPerformed
    //
  }//GEN-LAST:event_jbtnHelpActionPerformed

  private void jbtnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRemoveActionPerformed
    if(creator.isGodMode()){
      DefaultTableModel model = (DefaultTableModel)jtLineaments.getModel();
      int[] rows = jtLineaments.getSelectedRows();
      for(int i = 0 ; i < rows.length ; ++i){
        model.removeRow(rows[i]-i);
      }
    }
    else{
      setInformation("You can only remove a lineament while creating "
              + "a character in God Mode.");
    }
  }//GEN-LAST:event_jbtnRemoveActionPerformed

  private void jbtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetActionPerformed
    storeCharacter();
    if(isSaveNeeded()){                                                // if a save is needed while closing
      int dialogButton = JOptionPane.YES_NO_OPTION;                             // proposes to do so
      int dialogResult = JOptionPane.showConfirmDialog (null, "Would you like to save before reseting all fields?","Warning",dialogButton);
      if(dialogResult == JOptionPane.YES_OPTION){
        if(validateCharacter()){
          creator.saveCharacter();
          enableFields(false);
          ((PCGenericPanel)this.getParent()).reset();
        }
        else{
          // TODO: say something...
        }
      }
    }
    enableFields(false);
    ((PCGenericPanel)this.getParent()).reset();
    DefaultTableModel model = (DefaultTableModel)jtLineaments.getModel();
    int rowCount = model.getRowCount();
    for(int i = rowCount - 1 ; i >= 0 ; --i){
      model.removeRow(i);
    }
  }//GEN-LAST:event_jbtnResetActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JButton jbtnAdd;
  private javax.swing.JButton jbtnHelp;
  private javax.swing.JButton jbtnMC;
  private javax.swing.JButton jbtnML;
  private javax.swing.JButton jbtnMV;
  private javax.swing.JButton jbtnPC;
  private javax.swing.JButton jbtnPL;
  private javax.swing.JButton jbtnPV;
  private javax.swing.JButton jbtnRemove;
  private javax.swing.JButton jbtnReset;
  private javax.swing.JButton jbtnSave;
  private javax.swing.JButton jbtnValidate;
  private javax.swing.JCheckBox jcbGod;
  private javax.swing.JCheckBox jcbSane;
  private javax.swing.JLabel jlblAttC;
  private javax.swing.JLabel jlblAttL;
  private javax.swing.JLabel jlblAttV;
  private javax.swing.JLabel jlblColdblood;
  private javax.swing.JLabel jlblLucidity;
  private javax.swing.JLabel jlblRemain;
  private javax.swing.JLabel jlblRemaining;
  private javax.swing.JLabel jlblVitality;
  private ihm.JpCivilianStatus jpCivil;
  private javax.swing.JTable jtLineaments;
  // End of variables declaration//GEN-END:variables
}


