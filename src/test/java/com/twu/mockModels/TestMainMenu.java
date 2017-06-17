package com.twu.mockModels;

import com.twu.biblioteca.MainMenu;
import com.twu.biblioteca.MenuItem;
import com.twu.inputOutput.InputReader;
import com.twu.inputOutput.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pujag on 6/17/17.
 */
public class TestMainMenu extends MainMenu {
    private  Map<String, MenuItem> testMenuMapper;

    public TestMainMenu(InputReader inputReader, OutputWriter outputWriter) {
        super(inputReader,outputWriter);
        testMenuMapper =new HashMap<>();
    }

    public void addMenuItems(MenuItem menuItem) {
        int index = testMenuMapper.size();
        testMenuMapper.put(index + 1 +"", menuItem);
    }

    public List<MenuItem> getMenuItems() {
        List<MenuItem> menuList = new ArrayList<>(testMenuMapper.values());
        return menuList;
    }



}
