package cn.xxx.rpms.web.controller;

import cn.xxx.basic.query.BaseQuery;
import cn.xxx.basic.utils.JsonResult;
import cn.xxx.basic.utils.PageList;
import cn.xxx.basic.utils.SystemControllerLog;
import cn.xxx.rpms.domain.Menu;
import cn.xxx.rpms.domain.Menu;
import cn.xxx.rpms.service.IMenuService;
import cn.xxx.rpms.service.IMenuService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RequestMapping("/menu")
@Controller
public class MenuController {
    @Autowired
    private IMenuService menuService;
    @RequestMapping("/index")
    private String getPartList(){
        return "/system/menu";
    }
    @RequestMapping("/page")
    @ResponseBody
    @SystemControllerLog(description = "查询菜单")
    public PageList<Menu> maintenancePageList(BaseQuery menuQuery){
        return menuService.queryPage(menuQuery);
    }

    @RequestMapping("/save")
    @ResponseBody
    @SystemControllerLog(description = "保存菜单")
    public JsonResult save(Menu menu){
        JsonResult jsonResult = new JsonResult();
        try {
            if(menu.getId()==null||"".equals(menu.getId())){
                System.out.println(menu);
                menuService.add(menu);
            }else{
                menuService.update(menu);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping("/delete")
    @ResponseBody
    @SystemControllerLog(description = "删除菜单")
    public JsonResult delete(Long[] ids,HttpServletRequest req){
        JsonResult jsonResult = new JsonResult();
        String realPath = req.getSession().getServletContext().getRealPath("/upload");
        try {
            for(Long id:ids){
                Menu menu = menuService.get(id);
                String icon = menu.getIcon();
                System.out.println("这是啥"+realPath);
                String substring = icon.substring(7, 16);
                File file = new File(realPath, substring);
                System.out.println("文件名++++"+file.getName());
                System.gc();
                if(file.isFile()&&file.exists()) {
                    System.out.println("===============");
                    file.delete();
                }
                menuService.delete(id);
            }
            return jsonResult;
        } catch (Exception e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }
    }
    @RequestMapping(value="upload",method= RequestMethod.POST)
    @ResponseBody
    @SystemControllerLog(description = "上传")
    public  JsonResult uploadPic( MultipartFile multipartFile,HttpServletRequest req) {
        System.out.println("拿到了没有呀"+multipartFile);
        String realPath = req.getSession().getServletContext().getRealPath("/upload");
        //FilenameUtils.getExtension(multipartFile.getOriginalFilename())
        String newName= UUID.randomUUID().toString().substring(0, 4)+"."+ FilenameUtils.getExtension(multipartFile.getOriginalFilename());
        //将地址传入对象
        File file = new File(realPath, newName);
        InputStream input = null;
        try {
            input = multipartFile.getInputStream();
            FileOutputStream output = new FileOutputStream(file);
            IOUtils.copy(input, output);
            System.gc();
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
            return new JsonResult(false,e.getMessage());
        }

        return new JsonResult(true,"/upload/"+newName);
    }

}
