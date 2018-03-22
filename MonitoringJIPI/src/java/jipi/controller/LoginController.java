/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.controller;

import java.util.HashMap;
import java.util.List;
import jipi.dto.UserDto;
import jipi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author HP
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String tampilanIndexLogin(ModelMap model) {
        try {
            UserDto dto = new UserDto();
            model.addAttribute("dto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public String simpanData(UserDto userDto, ModelMap model) throws Exception {
        String panggil="";
        try {
            System.out.println("user : " + userDto.getUsername());
//            int cekUsername = userService.getCountUsernameService(userDto.getUsername().toString());
            List<Object[]> username = userService.getCountUsernameService(userDto.getUsername().toString());
            String test = username.toString();
            String sub = test.substring(1, 2);
            int cekUsername = Integer.parseInt(sub);
            
            List<Object[]> password = userService.getCountUsernameAndPasswordService(userDto.getUsername().toString(), userDto.getPassword().toString());
            test = password.toString();
            sub = test.substring(1, 2);
            int cekPassword = Integer.parseInt(sub);
            
            List<Object[]> akses = userService.getCountUsernameAndPasswordAndAksesService(userDto.getUsername().toString(), userDto.getPassword().toString(), userDto.getAkses().toString());
            test = akses.toString();
            sub = test.substring(1, 2);
            int cekAkses = Integer.parseInt(sub);
            
            System.out.println("bawah panggil fungsi");
            if(cekUsername>=1 && cekPassword>=1 && cekAkses>=1){
                System.out.println("masuk if");
                if(userDto.getAkses().toString().equals("1")){
                    panggil= "akd_index";
                }else if(userDto.getAkses().toString().equals("5")){
                    List<UserDto> listUserDto = userService.getListDataUserByLogin(userDto.getUsername().toString(), userDto.getPassword().toString(), userDto.getAkses().toString());
                    System.out.println("di atas if baru");
                    if(listUserDto.get(0).getAkses().toString().equals("5")){
                        System.out.println("masuk if akses mahasiswa");
//                        model.addAttribute("nim", listUserDto);
                        HashMap map = new HashMap();
                        model.addAttribute("dto", listUserDto);
                        System.out.println("di bawah model attribut");
                        System.out.println(listUserDto);
                        panggil= "mhs_index_awal";
                    }else{
                        //sementara, harusnya panggil alm_index
                        System.out.println("masuk if akses alumni");
                        model.addAttribute("dto", listUserDto);
                        panggil= "mhs_profil";
                    }
                    
                }else if(userDto.getAkses().toString().equals("4")){
                    //sementara, harusnya masuk dsn_index
                    panggil= "akd_index";
                }
            }else{
                System.out.println("masuk else");
                if(cekUsername<1){
                    userDto.setKeterangan("Username tidak sesuai");
                    model.addAttribute("dto", userDto);
                    panggil = "login_gagal";
                }else if(cekPassword<1){
                    userDto.setKeterangan("Password tidak sesuai");
                    model.addAttribute("dto", userDto);
                    panggil = "login_gagal";
                }else if(cekAkses<1){
                    userDto.setKeterangan("Akses login tidak Sesuai");
                    model.addAttribute("dto", userDto);
                    panggil = "login_gagal";
                }
            }
        } catch (Exception e) {
        }
        
        return panggil;
    }

}
