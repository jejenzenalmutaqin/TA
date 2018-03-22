/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.controller;

import java.util.List;
import jipi.dto.JenisPengajuanDto;
import jipi.dto.JurusanDto;
import jipi.dto.MahasiswaDto;
import jipi.dto.ProposalDto;
import jipi.dto.ViewAlumniDto;
import jipi.dto.ViewKelulusanDto;
import jipi.dto.ViewPengajuanSidangDosenDto;
import jipi.dto.viewPengajuanProposalDto;
import jipi.service.AlumniService;
import jipi.service.JenisPengajuanService;
import jipi.service.JurusanService;
import jipi.service.KelulusanService;
import jipi.service.MahasiswaService;
import jipi.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Barne's
 * 
 */
@Controller
public class DsnController {
    
    @Autowired
    AlumniService alumniService;
    
    @Autowired
    ProposalService proposalService;
    
    @Autowired
    JenisPengajuanService jenisPengajuanService;
    
    @Autowired
    KelulusanService kelulusanService;
    
    @Autowired
    JurusanService jurusanService;
    
    @Autowired
    MahasiswaService mahasiswaService;
    
    @RequestMapping(value = "/dsn_index",method = RequestMethod.GET)
    public String viewDosenIndexPage(){
        return "dsn_index";
    }
    
    @RequestMapping(value = "/dsn_DknViewSidang", method = RequestMethod.GET)
    public String tampilanViewSidang(ModelMap model){               
        List<JenisPengajuanDto> listJenisPengajuan = null;
        try {
            ViewPengajuanSidangDosenDto dto = new ViewPengajuanSidangDosenDto();
            model.addAttribute("dto", dto);
            listJenisPengajuan = jenisPengajuanService.getListDataJenisPengajuan();
            model.addAttribute("listJurusanDto", listJenisPengajuan);
       } catch (Exception e) {
            e.printStackTrace();
        }     
        return "dsn_DknViewSidang";
    }
    
    @RequestMapping(value = "/viewSidang", method = RequestMethod.POST)
    public String tampilanSidangDsn(ViewPengajuanSidangDosenDto param,ModelMap model){
        try {
            List<ViewPengajuanSidangDosenDto> listDto = jenisPengajuanService.getListPengajuanSidang(param);
            model.addAttribute("listDto", listDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "dsn_ViewDataPengajuanSidang";
    }
    
    @RequestMapping(value = "/dsn_DknViewKelulusan", method = RequestMethod.GET)
    public String tampilanViewKellulusan(ModelMap model){               
        List<JenisPengajuanDto> listJenisPengajuan = null;
        try {
            listJenisPengajuan = jenisPengajuanService.getListDataJenisPengajuan();
            model.addAttribute("listJurusanDto", listJenisPengajuan);
            ViewKelulusanDto dto = new ViewKelulusanDto();
            model.addAttribute("dto", dto);
       } catch (Exception e) {
            e.printStackTrace();
        }     
        return "dsn_DknViewKelulusan";
    }
    
    @RequestMapping(value = "/viewKelulusan", method = RequestMethod.POST)
    public String tampilanKelulusan(ViewKelulusanDto param,ModelMap model){
        try { 
            List<ViewKelulusanDto> listDto = kelulusanService.getListKelulusan(param);
            model.addAttribute("listDto", listDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "dsn_ViewDataKelulusan";
    }
    
    @RequestMapping(value = "/dsn_DknViewAlumni", method = RequestMethod.GET)
    public String tampilanViewAlumni(ModelMap model){               
        List<JurusanDto> listJenisPengajuan = null;
        List<MahasiswaDto> listAngkatan=null;
        try {
            
            ViewAlumniDto dto = new ViewAlumniDto();
            model.addAttribute("dto", dto);
            
           listJenisPengajuan = jurusanService.getListDataJurusan();
            model.addAttribute("listJurusanDto", listJenisPengajuan);
            
            listAngkatan=mahasiswaService.getListAngkatan();
            model.addAttribute("listAngkatanDto", listAngkatan);
            
       } catch (Exception e) {
            e.printStackTrace();
        }
        return "dsn_DknViewAlumni";
    }
    
     @RequestMapping(value = "/viewAlumni", method = RequestMethod.POST)
    public String tampilanAlumni(ViewAlumniDto alumni,ModelMap model){
        try {
            List<ViewAlumniDto> listDto = alumniService.getListPengajuanSidang(alumni);
             model.addAttribute("listDto", listDto);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "viewDataPengajuanProposalDsn";
    }
    
    /////////////////////Proposal///////////////////////////////////////
    
    @RequestMapping(value = "/viewProposal", method = RequestMethod.POST)
    public String tampilanProposalDsn(viewPengajuanProposalDto pengajuanDto,ModelMap model){
        try {
            List<viewPengajuanProposalDto> listDto = proposalService.getDataForViewProposal(pengajuanDto);
             model.addAttribute("listDto", listDto);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "viewDataPengajuanProposalDsn";
    }
    
    
    @RequestMapping(value = "/dsn_DknViewProposal", method = RequestMethod.GET)
    public String tampilanProposal(ModelMap model)throws Exception{ 
       List<JurusanDto> listJenisPengajuan = null;
        List<MahasiswaDto> listAngkatan=null;
        try {
            viewPengajuanProposalDto dto = new viewPengajuanProposalDto();
            model.addAttribute("dto", dto);
            
            listJenisPengajuan = jurusanService.getListDataJurusan();
            model.addAttribute("listJurusanDto", listJenisPengajuan);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
                    + "+++++++++++++++++++++++++ ini pengajuan ++++++++++++++++++++++++++++++++++++++++++++++++++++"
                    + "++++++++++++++++++"+listJenisPengajuan.size());
            listAngkatan=mahasiswaService.getListAngkatan();
            model.addAttribute("listAngkatanDto", listAngkatan);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
                    + "+++++++++++++++++++++++++ ini Angkatan ++++++++++++++++++++++++++++++++++++++++++++++++++++"
                    + "++++++++++++++++++"+listAngkatan.size());
          
       } catch (Exception e) {
            e.printStackTrace();
       }     
        return "dsn_DknViewProposal";
    }
    
}
