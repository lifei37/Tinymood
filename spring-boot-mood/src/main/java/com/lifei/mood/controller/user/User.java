package com.lifei.mood.controller.user;

import com.lifei.mood.common.Constant;
import com.lifei.mood.common.MD5Util;
import com.lifei.mood.entity.Response;
import com.lifei.mood.entity.UserInfo;
import com.lifei.mood.services.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

@RestController
public class User {

    @Autowired
    UserInfoService userInfoService;
    @GetMapping("/user/info")
    public Response userDesc(@RequestParam("userId") int userId){
        UserInfo user = userInfoService.userDesc(userId);

        return Response.ok("成功", user);
    }

    // 头像上传部分
    @PostMapping("/avatar")
    public Response UploadAvatar(@RequestParam(required = true) MultipartFile file, HttpSession session) throws IOException {
        String OsName = System.getProperty("os.name");
        String path = OsName.toLowerCase().startsWith("win") ? Constant.WINDOWS_PATH:Constant.LINUX_PATH;
        System.out.println(path);
        if(!file.isEmpty()){
            UserInfo currentUser = (UserInfo) session.getAttribute("user");

            System.out.println(currentUser.getId());
            String filePathOld = userInfoService.selectUser(currentUser).getAvatar();
            String newPathName = path + filePathOld;
            if(newPathName.equals("picture/moren.jpg") || "".equals(filePathOld)){
            newPathName = path +"picture/"+ System.currentTimeMillis() + file.getOriginalFilename();
            String newPath = "picture/" + System.currentTimeMillis() + file.getOriginalFilename();
            currentUser.setAvatar(newPath);
            int u = userInfoService.updateAvatar(currentUser);
            }
            // 磁盘保存
            BufferedOutputStream out = null;
            try{
                File folder = new File(path);
                if(!folder.exists()){
                    folder.mkdir();
                }
                System.out.println(newPathName);
                out = new BufferedOutputStream(new FileOutputStream(newPathName));
                out.write(file.getBytes());
            }catch (Exception e){
                e.printStackTrace();
                return Response.ok("失败");
            }finally {
                try{
                    out.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return Response.ok("成功");
    }

    @GetMapping("/user/infoAll")
    public Response getUserInfo(HttpSession session){
        UserInfo currentUser = (UserInfo) session.getAttribute("user");
        UserInfo user = userInfoService.selectUser(currentUser);
        return Response.ok("成功", user);
    }

    @PutMapping("/user/infoAll")
    public Response updateInfo(@RequestBody Map infoMap) throws ParseException {
        System.out.println(infoMap);
        String vueDate = (String) infoMap.get("date1");
        String d = vueDate.substring(0,10);
        infoMap.put("date1", d);
        int u = userInfoService.updateInfo(infoMap);
        return Response.ok("成功");
    }

    @PostMapping("/user/pwd")
    public Response checkPwd(@RequestBody UserInfo user){
        String password = (String) user.getPassword();
        user.setPassword(MD5Util.string2MD5(password));
        try{
            UserInfo us= userInfoService.loginUser(user);
            System.out.println(us);
            System.out.println(us.getId());
        }catch (Exception e){
            return Response.error("失败");
        }
        return Response.ok("成功");
    }

    @PutMapping("/user/pwd")
    public Response updatePwd(@RequestBody UserInfo user){
        String password = (String) user.getPassword();
        user.setPassword(MD5Util.string2MD5(password));
        int u =userInfoService.updatePwd(user);
        return Response.ok("成功");
    }

}
