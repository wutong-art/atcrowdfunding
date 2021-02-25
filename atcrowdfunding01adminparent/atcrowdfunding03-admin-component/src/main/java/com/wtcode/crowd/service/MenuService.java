package com.wtcode.crowd.service;

import com.wtcode.crowd.entity.Menu;

import java.util.List;

/**
 * @author wtcode
 * @date 2021/2/14 - 19:11
 */
public interface MenuService {


    List<Menu> getAll();

    void saveMenu(Menu menu);

    void updateMenu(Menu menu);

    void removeMenu(Integer id);
}
