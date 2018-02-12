package rpgcharactercreation;

import ihm.RPGCharacterCreationIHM;

/**
 *
 * @author Nicolas Brax
 */
public class RPGCharacterCreation {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }catch(Exception ex){}
    new RPGCharacterCreationIHM().setVisible(true);
  }
  
  /*
  Pour chaque type de jeu, on veut une interface qui permet de saisir les caracteristiques
  tout en prenant en compte les restrictions, les obligations et tout ce qui peut
  etre utilisé selon les regles du jeu.
  
  Il faut aussi pouvoir sauvegarder les personnage créé dans un format qui pourra etre réutilisé
  dans un autre plugin ou logiciel.
  
   - 1 classe specifique pour chaque type de personnage ?
   - des fichiers de data ? => organisation ?

  Ajouter les PNJ
  
  ADD
  
  
  SR
  
  
  AC
  
  
  FS
  
  
  P13
  
  
  Generic?!
  
  
  */
  
}
