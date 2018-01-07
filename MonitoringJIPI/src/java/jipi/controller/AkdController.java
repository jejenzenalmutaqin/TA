/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.controller;

import java.util.List;
import jipi.dto.JenisPengajuanDto;
import jipi.dto.ProposalDto;
import jipi.service.JenisPengajuanService;
import jipi.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author hp
 */
@Controller
public class AkdController {
    @Autowired
    ProposalService proposalService;
    
    @Autowired
    JenisPengajuanService jenisPengajuanService;
    
    
    @RequestMapping(value = "/akd_index", method = RequestMethod.GET)
    public String tampilanIndexAkd(ModelMap model){               
        return "akd_index";
    }
    
    @RequestMapping(value = "/akd_pengajuanproposal", method = RequestMethod.GET)
    public String tampilanProposalAkd(ModelMap model){
        List<ProposalDto> listDto = proposalService.getListDataProposal();
        model.addAttribute("listDto", listDto);
        List<JenisPengajuanDto> listJns = jenisPengajuanService.getListDataJenisPengajuan();
        model.addAttribute("listJns", listJns);
        return "akd_pengajuanproposal";
    }
    
    @RequestMapping(value = "/hapusListProposal", method = RequestMethod.GET)
    public String hapusData(String kdproposal, ModelMap model) throws Exception{        
        proposalService.deleteDataProposal(kdproposal);
        return "redirect:akd_pengajuanproposal.htm";
    }
}
