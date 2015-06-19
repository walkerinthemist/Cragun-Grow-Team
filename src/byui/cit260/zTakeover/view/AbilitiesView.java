/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.zTakeover.view;

public class AbilitiesView extends View{
    public AbilitiesView(){
        super("\n---------------------------"
             +"\n      Abilites List       "
             +"\n---------------------------"
             +"\nSelect an Ability for Desc:"
             +"\nM-Magic"
             +"\nI-Ingition Proof"
             +"\nP-Physical Damage Proof"
             +"\nN-Night Vision"
             +"\nF-Fast"
             +"\nA-Always First"
             +"\nB-Bear Vitality"
             +"\nC-Cuteness"
             +"\nS-Sane"
             +"\nK-Knowledge on"
             +"\nQ-Quit List"
             +"\n---------------------------");
    }
    
    @Override
    public boolean doAction(Object obj) {
        String value=(String)obj;
        value=value.toUpperCase();
        char selection=value.charAt(0);
        switch (selection){
            case 'M':
                this.magicDes();
                break;
            case 'I':
                this.ignitionDes();
                break;
            case 'P':
                this.physicalDes();
                break;
            case 'N':
                this.nightDes();
                break;
            case 'F':
                this.fastDes();
                break;
            case 'A':
                this.alwaysDes();
                break;
            case 'B':
                this.bearDes();
                break;  
            case 'C':
                this.cutenessDes();
                break;
            case 'S':
                this.saneDes();
                break;
            case 'K':
                this.knowledgeDes();
                break;
            case 'Q':
                return false;
            default:
                System.out.println("***Invalid entry, try again.***");
                break;
        }
        return true;
    }

    private void magicDes() {
        System.out.println("Allows you to cast a variety of spells in combat.");
    }

    private void ignitionDes() {
        System.out.println("You're fireproof. Negates additional fire damage.");
    }

    private void physicalDes() {
        System.out.println("You're unhurtable from physical attacks. Negates physical damage.");
   }

    private void nightDes() {
        System.out.println("You can see in the dark like it's noon in the desert.");
    }

    private void fastDes() {
        System.out.println("You're a blur. Gives you +35 speed.");
    }

    private void alwaysDes() {
        System.out.println("You always get to attack first in combat.");
    }

    private void bearDes() {
        System.out.println("Vitality of a bear. Gives you +50 hp.");
    }

    private void cutenessDes() {
        System.out.println("You're so cute it's almost sickening.");
    }

    private void saneDes() {
        System.out.println("You're all there.");
    }

    private void knowledgeDes() {
        System.out.println("You have knowledge on a particular specified subject.");
    }
}
