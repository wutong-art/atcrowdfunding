package com.wtcode.crowd.mvc.handler;

import com.wtcode.crowd.entity.Menu;
import com.wtcode.crowd.service.MenuService;
import com.wtcode.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author wtcode
 * @date 2021/2/14 - 19:11
 */
// @Controller
// @ResponseBody
@RestController
public class MenuHandler {

    @Autowired
    private MenuService menuService;

    // @ResponseBody
    @RequestMapping("/menu/remove.json")
    public ResultEntity<String> removeMenu(@RequestParam("id") Integer id){

        menuService.removeMenu(id);

        return ResultEntity.successWithoutData();
    }


    // @ResponseBody
    @RequestMapping("/menu/update.json")
    public ResultEntity<String> updateMenu(Menu menu){

        menuService.updateMenu(menu);

        return ResultEntity.successWithoutData();
    }


    // @ResponseBody
    @RequestMapping("/menu/save.json")
    public ResultEntity<String> saveMenu(Menu menu){

        menuService.saveMenu(menu);


        return ResultEntity.successWithoutData();


    }



    // @ResponseBody
    @RequestMapping("/menu/get/whole/tree.json")
    public ResultEntity<Menu> getWholeTree() {

        // 1.查询全部menu对象
        List<Menu> menuList = menuService.getAll();
        // 2.声明一个变量用来存储找到的根节点
        Menu root = null;
        // 3.创建Map对象用来存储id和Menu对象的对应关系便于查找父节点
        Map<Integer,Menu> menuMap = new HashMap<>();
        // 4.遍历menuList去填充menuMap
        for (Menu menu : menuList) {
            Integer id = menu.getId();
            menuMap.put(id,menu);
        }
        // 5.再次遍历menuList查找根节点，组装父子节点
        for (Menu menu : menuList) {
            // 6.获取当前menu对象的pid属性值
            Integer pid = menu.getPid();
            // 7.如果pid为null，就判定为根节点
            if(pid == null){
                // 8.如果当前节点是根节点，那么肯定没有父节点，不必继续执行
                root = menu;
                continue;
            }
            // 9.如果当前pid不为null,那么当前节点有父节点，那么可以根据pid查找到对应的Menu对象
            Menu menuParent = menuMap.get(pid);

            // 10.将当前节点存入父节点的children集合
            menuParent.getChildren().add(menu);
        }
        // 11.经过上面的运算，根节点就包含了整个树形结构
        return ResultEntity.successWithData(root);
    }


    /*public ResultEntity<Menu> getWholeTreeOld(){
        // 1.查询全部menu对象
        List<Menu> menuList = menuService.getAll();
        // 2.声明一个变量用来存储找到的根节点
        Menu root = null;
        // 3.遍历menuList
        for (Menu menu : menuList) {
            // 4.获取当前menu对象的pid属性
            Integer pid = menu.getPid();
            // 5.检查pid是否为null
            if(pid == null){
                // 6.把当前正在遍历的这个menu对象赋值给root
                root = menu;
                // 7.停止本次循环继续执行下一次循环
                continue;
            }
            // 8.如果pid不为null,说明当前节点有父节点，找到父节点就可以进行组装，建立父子关系
            for (Menu menuMaybeParent : menuList) {
                // 9.获取MayBeParent的ID属性
                Integer id = menuMaybeParent.getId();
                // 10.将子节点的pid和疑似父节点的id进行比较
                if(Objects.equals(pid,id)){
                    // 11.将子节点存入父节点的children集合
                    menuMaybeParent.getChildren().add(menu);
                    // 12.找到即可停止运行循环
                    break;
                }

            }
        }
    return ResultEntity.successWithData(root);
    }*/
}
