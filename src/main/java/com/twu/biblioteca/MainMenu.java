package com.twu.biblioteca;

import java.util.ArrayList;

/**
 * Menu that appears on start up.
 */
public class MainMenu {
   private ArrayList<MenuItem> menuItems;

   MainMenu(ListAvailableBooks listAvailableBooks) {
       menuItems=new ArrayList<>();
       menuItems.add(listAvailableBooks);
   }



    public ArrayList<MenuItem> getMenuItems() {
       return menuItems;
    }

}
