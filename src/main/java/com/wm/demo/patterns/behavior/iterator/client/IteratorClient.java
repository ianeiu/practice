package com.wm.demo.patterns.behavior.iterator.client;

import com.wm.demo.patterns.behavior.iterator.impl.BreakfastMenu;
import com.wm.demo.patterns.behavior.iterator.impl.LunchMenu;
import com.wm.demo.patterns.behavior.iterator.impl.Waitress;
import com.wm.demo.patterns.behavior.iterator.interf.Menu;
import com.wm.demo.patterns.behavior.iterator.utils.Utils;

public class IteratorClient {

    private Menu menu = null;
    private Waitress waitress = null;
    
    public static void main(String[] args) {
        IteratorClient client = new IteratorClient();
        client.initEvent();
        client.operate();
    }
    
    private void initEvent() {
        menu = new BreakfastMenu();
        Utils.initMenuItem((BreakfastMenu)menu);
        
        menu = new LunchMenu();
        
        waitress = new Waitress(menu);
    }
    
    private void operate() {
        waitress.printMenu();
    }
}
