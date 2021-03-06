/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.zTakeover.view;

import byui.cit260.zTakeover.control.*;
import byui.cit260.zTakeover.exception.MapControlException;
import byui.cit260.zTakeover.model.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import zombietakeover.ZombieTakeover;

public class GameMenuView extends View {
        public GameMenuView(){
            super("\n"
            +"\n------------------------"
            +"\n|      Game Menu       |"
            +"\n------------------------"
            +"\nD - Display Inventory"
            +"\nF - Footstep Counter"
            +"\nA - Ability list"
            +"\nM - Move Character"
            +"\nK - Kick down the door"
            +"\nT - Display Stats"
            +"\nV - View Map"
            +"\nH - Help Menu"
            +"\nS - Save Game"
            +"\nP - Print Map"
            +"\nE - Exit Game"
            +"\n------------------------");
        }
    @Override
    public boolean doAction(Object obj) {
        String value=(String)obj;
        value=value.toLowerCase();
        char selection=value.charAt(0);
        switch (selection){
            case 'd':
                this.displayInventory();
                break;
            case 'f':
                this.displayFootstepCounter();
                break;
            case 'a':
                this.displayAbilities();
                break;
            case 'm':
                this.moveCharacter();
                break;
            case 'v':
                this.viewMap();
                break;
            case 'h':
                this.displayHelpMenu();
                break;
            case 'k':
                this.kickDoor();
                break;
            case 's':
                this.saveGame();
                break;
            case 't':
                this.displayStats();
                break;
            case 'p':
                this.printMap();
                break;
            case 'e':
                return true;
            default:
                this.console.println("***Invalid entry, try again.***");
                break;
        }
        return false;
    }

    private void displayInventory() {
        Items[] inventory = GameControl.getSortedInventoryList();
        
        this.console.println("\nList of Inventory Items");
        this.console.println("Description" + "\t"
                         + "In Stock");
        
        // for each inventory item
        for (Items inventoryItem : inventory) {
            // DISPLAY the description, the required amount and amount in stock
            this.console.println(inventoryItem.getDescription() + "\t   "
                             + inventoryItem.getAmount());
        }
        
        // display other sub menus
        InventoryView invView = new InventoryView();
        invView.display();
        
    }

    private void displayFootstepCounter() {
        FootstepCounter footsteps = new FootstepCounter();
        int currentSteps = footsteps.getCounter();
        
        this.console.println("\nYou have walked " + currentSteps + " steps.");
    }

    private void displayAbilities() {
        AbilitiesView aView = new AbilitiesView();
        aView.display();
        
    }

    private void moveCharacter() {
        Map map1 = ZombieTakeover.getCurrentGame().getMap();
        CharacterControl character = new CharacterControl();
            try {
                character.moveCharacter();
            } catch (MapControlException ex) {
                ErrorView.display("GameMenuView", ex.getMessage());
            }
    }

    private void viewMap() {
        Location[][] locations = ZombieTakeover.getCurrentGame().getMap().getLocations();

        System.out.println("\n***** Urban Crawl ******");
        System.out.println("   | 0  | 1  | 2  | 3  | 4  | 5  | 6  | 7  | 8  | 9  | ");

        for (int i = 0; i < locations[0].length; i++) {
            System.out.println("\n------------------------------------------------------");
            System.out.format("%2d", i);
            for (int j = 0; j < locations[0].length; j++) {
                System.out.print(" | ");
                System.out.print(locations[i][j].getScene().getSymbol());

            }
            System.out.print(" | ");
        }
        System.out.println("\n------------------------------------------------------");
    
    }

    private void displayHelpMenu() {
         //Display help menu
        HelpMenuView helpMenu = new HelpMenuView();
        helpMenu.display();
    }

    private void saveGame() {
        this.console.println("\n\nEnter the filename for where to save the game:");
        String fileName = this.getInput() + ".txt";
        
        try{
            GameControl.saveGame(ZombieTakeover.getCurrentGame(),fileName);
        }catch(Exception ex){
            ErrorView.display("MainMenuView", ex.getMessage());
        }
    }

    private void printMap() {
        try{
        MapControl.printMap();
        }catch(Exception ex){
            ErrorView.display("GameMenuView", ex.getMessage());
        }
    }

    private void kickDoor() {
        SceneControl.checkScene();
    }

    private void displayStats() {
        this.console.println("\n Health: " + ZombieTakeover.getCurrentGame().getPlayer().getHealth());
        this.console.println("\n Speed : " + ZombieTakeover.getCurrentGame().getPlayer().getSpeed());
    }
}
