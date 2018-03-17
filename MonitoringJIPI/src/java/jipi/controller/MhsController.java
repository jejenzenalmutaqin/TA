/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.controller;

import java.util.List;
import jipi.dto.AlumniDto;
import jipi.dto.JenisPengajuanDto;
import jipi.dto.MahasiswaDto;
import jipi.dto.ProposalDto;
import jipi.dto.UserDto;
import jipi.service.AlumniService;
import jipi.service.JenisPengajuanService;
import jipi.service.MahasiswaService;
import jipi.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author HP
 */
@Controller
public class MhsController {
    
    @Autowired
    MahasiswaService mahasiswaService;
    
    @Autowired
    AlumniService alumniService;
    
    @RequestMapping(value = "/mhs_index", method = RequestMethod.GET)
    public String tampilanIndexMhs(ModelMap model){               
        return "mhs_index";
    }
    @RequestMapping(value = "/mhs_profil", method = RequestMethod.GET)
    public String tampilanProfil(String nim, ModelMap model) throws Exception{
        nim = "0204151016";
        try {
            MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(nim);
            model.addAttribute("dto", mahasiswaDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mhs_profil";
    }
    @RequestMapping(value = "/mhs_notifikasi", method = RequestMethod.GET)
    public String tampilanNotifikasi(ModelMap model){               
        return "mhs_notifikasi";
    }
    @RequestMapping(value = "/mhs_ubahakun", method = RequestMethod.GET)
    public String ubahAkun(ModelMap model){     
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "mhs_ubahakun";
    }
    @RequestMapping(value = "/berandaalumni", method = RequestMethod.GET)
    public String tampilanAlumni(ModelMap model){
        List<AlumniDto> listDto = alumniService.getListDataAlumni();
        model.addAttribute("listDto", listDto);
        return "mhs_berandaalumni";
    }
    @RequestMapping(value = "/caridataalumni", method = RequestMethod.POST)
    public String cariAlumni(String cariBerdasarkan, String cariKey, ModelMap model) throws Exception{
        List<AlumniDto> listDto = alumniService.searchAlumni(cariBerdasarkan, cariKey);
        model.addAttribute("listDto",listDto);
//        return "redirect:akd_datauser.htm";
        return "mhs_berandaalumni";
    }
    
    @RequestMapping(value = "/editMhsAlumni", method = RequestMethod.GET)
    public String editAlumni(String kdalumni, ModelMap model) throws Exception{ 
        try {
            AlumniDto alumniDto = alumniService.updateDataForm(kdalumni);
            model.addAttribute("dto", alumniDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mhs_editdataalumni";
    }
    
    @RequestMapping(value = "/editAlumniMhs", method = RequestMethod.POST)
    public String editDataAlumni(AlumniDto alumniDto, ModelMap model) throws Exception{                
        ModelAndView mdl = new ModelAndView();
        alumniService.doUpdateDataForm(alumniDto);       
        return "redirect:berandaalumni.htm";
    }
}
