/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.controller;

import jipi.dto.UserDto;
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
        try {
            System.out.println("user : " + userDto.getUsername());
            if(userDto.getKduser().equals("1")){
                return "akd_index";
            }else if(userDto.getKduser().equals("2")){
                return "mhs_index";
            }
        } catch (Exception e) {
        }
        
        return "mhs_index";
    }

}
