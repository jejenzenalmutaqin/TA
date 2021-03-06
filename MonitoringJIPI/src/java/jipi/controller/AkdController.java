/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jipi.dto.AksesDto;
import jipi.dto.AlumniDto;
import jipi.dto.FakultasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
import jipi.dto.JenisPengajuanDto;
import jipi.dto.JurusanDto;
import jipi.dto.KelulusanDto;
import jipi.dto.MahasiswaDto;
import jipi.dto.NotifDto;
import jipi.dto.ProposalDto;
import jipi.dto.SidangDto;
import jipi.dto.UserDto;
import jipi.model.MahasiswaModel;
import jipi.model.ProposalModel;
import jipi.model.SidangModel;
import jipi.service.AksesService;
import jipi.service.AlumniService;
import jipi.service.FakultasService;
import jipi.service.JenisPengajuanService;
import jipi.service.JurusanService;
import jipi.service.KelulusanService;
import jipi.service.MahasiswaService;
import jipi.service.NotifService;
import jipi.service.ProposalService;
import jipi.service.SidangService;
import jipi.service.UserService;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    UserService userService;

    @Autowired
    AksesService aksesService;

    @Autowired
    SidangService sidangService;

    @Autowired
    KelulusanService kelulusanService;

    @Autowired
    AlumniService alumniService;

    @Autowired
    FakultasService fakultasService;

    @Autowired
    JurusanService jurusanService;

    @Autowired
    MahasiswaService mahasiswaService;

    @Autowired
    NotifService notifService;

    @Autowired
    private JavaMailSender mailSender;

    @RequestMapping(value = "/akd_index", method = RequestMethod.GET)
    public String tampilanIndexAkd(ModelMap model) {
        return "akd_index";
    }

    //================================================= PROPOSAL =======================================
    @RequestMapping(value = "/akd_pengajuanproposal", method = RequestMethod.GET)
    public String tampilanProposalAkd(ModelMap model) {
        List<ProposalDto> listDto = proposalService.getListDataProposal();
        model.addAttribute("listDto", listDto);
        return "akd_pengajuanproposal";
    }

//    @RequestMapping(value = "/hapusListProposal", method = RequestMethod.POST)
//    @ResponseBody
//    public String hapusData(String kdproposal, ModelMap model) throws Exception {
//        proposalService.deleteDataProposal(kdproposal);
//        return "redirect:akd_pengajuanproposal.htm";
//    }
    @RequestMapping(value = "/hapusListProposal", method = RequestMethod.GET)
    public String hapusData(String kdproposal, ModelMap model) throws Exception {
        proposalService.deleteDataProposal(kdproposal);
        return "redirect:akd_pengajuanproposal.htm";
    }

    @RequestMapping(value = "/tambahProposal", method = RequestMethod.GET)
    public String tampilanTambahProposal(ModelMap model) throws Exception {

        List<JenisPengajuanDto> listJenisPengajuan = null;
        try {
            listJenisPengajuan = jenisPengajuanService.getListDataJenisPengajuan();
//            System.out.println(listJenisPengajuan);
            model.addAttribute("listJns", listJenisPengajuan);
            ProposalDto dto = new ProposalDto();
            model.addAttribute("dto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "akd_tambahpengajuanproposal";
    }

    @RequestMapping(value = "/simpanDataPengajuanProposal", method = RequestMethod.POST)
    public String simpanDataProposal(ProposalDto proposalDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        proposalService.saveDataProposal(proposalDto);
        return "redirect:akd_pengajuanproposal.htm";
    }

    @RequestMapping(value = "/editProposal", method = RequestMethod.GET)
    public String editData(String kdproposal, ModelMap model) throws Exception {
        List<JenisPengajuanDto> listJenisPengajuan = null;
        try {
            listJenisPengajuan = jenisPengajuanService.getListDataJenisPengajuan();
//            System.out.println(listJenisPengajuan);
            model.addAttribute("listJns", listJenisPengajuan);
            ProposalDto proposalDto = proposalService.updateDataForm(kdproposal);
            model.addAttribute("dto", proposalDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "akd_editpengajuanproposal";
    }

    @RequestMapping(value = "/editDataPengajuanProposal", method = RequestMethod.POST)
    public String editDataBaru(ProposalDto proposalDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        proposalService.doUpdateDataForm(proposalDto);
        return "redirect:akd_pengajuanproposal.htm";
    }

    @RequestMapping(value = "/createAkun", method = RequestMethod.GET)
    public String buatAkunOtomatis(ProposalDto proposalDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        proposalService.createAkun(proposalDto);
        return "redirect:akd_pengajuanproposal.htm";
    }

    @RequestMapping(value = "/cariProposal", method = RequestMethod.POST)
    public String cariProposal(String cariBerdasarkan, String cariKey, ModelMap model) throws Exception {
        List<ProposalDto> listDto = proposalService.searchProposal(cariBerdasarkan, cariKey);
        model.addAttribute("listDto", listDto);
//        return "redirect:akd_datauser.htm";
        return "akd_pengajuanproposal";
    }

    @RequestMapping(value = "/shareProposal", method = RequestMethod.GET)
    public String shareDataProposal(String kdproposal, ModelMap model) throws Exception {
        return "EmailForm";
    }

    //========================================  USER  ================================================
    @RequestMapping(value = "/akd_datauser", method = RequestMethod.GET)
    public String tampilanUserAkd(ModelMap model) {
        List<UserDto> listDto = userService.getListDataUser();
//        List<JenisPengajuanDto> listJns  = jenisPengajuanService.getListDataJenisPengajuan();
        model.addAttribute("listDto", listDto);
//        model.addAttribute("listJns", listJns);
        return "akd_datauser";
    }

    @RequestMapping(value = "/hapusListUser", method = RequestMethod.GET)
    public String hapusDataUser(String kduser, ModelMap model) throws Exception {
        userService.deleteDataUser(kduser);
        return "redirect:akd_datauser.htm";
    }
//    

    @RequestMapping(value = "/tambahUser", method = RequestMethod.GET)
    public String tampilanTambahUser(ModelMap model) throws Exception {
        List<AksesDto> listAkses = null;
        try {
            listAkses = aksesService.getListDataAkses();
            model.addAttribute("listAkses", listAkses);
            UserDto dto = new UserDto();
            model.addAttribute("dto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "akd_tambahdatauser";
    }
//    

    @RequestMapping(value = "/simpanDataUser", method = RequestMethod.POST)
    public String simpanDataUser(UserDto userDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        userService.saveDataUser(userDto);
        return "redirect:akd_datauser.htm";
    }
//    

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String editDataUser(String kduser, ModelMap model) throws Exception {
        List<AksesDto> listAkses = null;
        try {
            listAkses = aksesService.getListDataAkses();
//            System.out.println(listJenisPengajuan);
            model.addAttribute("listAkses", listAkses);
            UserDto userDto = userService.updateDataForm(kduser);
            model.addAttribute("dto", userDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "akd_editdatauser";
    }
//    

    @RequestMapping(value = "/editDataUser", method = RequestMethod.POST)
    public String editDataUserBaru(UserDto userDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        userService.doUpdateDataForm(userDto);
        return "redirect:akd_datauser.htm";
    }

    @RequestMapping(value = "/cariUser", method = RequestMethod.POST)
    public String cariUser(String cariBerdasarkan, String cariKey, ModelMap model) throws Exception {
        List<UserDto> listDto = userService.searchUser(cariBerdasarkan, cariKey);
        model.addAttribute("listDto", listDto);
//        return "redirect:akd_datauser.htm";
        return "akd_datauser";
    }

    //////////////////////////////////////// SIDANG /////////////////////////////////////////////////
    @RequestMapping(value = "/akd_pengajuansidang", method = RequestMethod.GET)
    public String tampilanSidangAkd(ModelMap model) {
        List<SidangDto> listDto = sidangService.getListDataSidang();
//        List<JenisPengajuanDto> listJns  = jenisPengajuanService.getListDataJenisPengajuan();
        model.addAttribute("listDto", listDto);
//        model.addAttribute("listJns", listJns);
        return "akd_pengajuansidang";
    }

    @RequestMapping(value = "/hapusListSidang", method = RequestMethod.GET)
    public String hapusDataSidang(String kdsidang, ModelMap model) throws Exception {
        sidangService.deleteDataSidang(kdsidang);
        return "redirect:akd_pengajuansidang.htm";
    }
//    

    @RequestMapping(value = "/tambahSidang", method = RequestMethod.GET)
    public String tampilanTambahSidang(ModelMap model) throws Exception {

        List<JenisPengajuanDto> listJenisPengajuan = null;
        try {
            listJenisPengajuan = jenisPengajuanService.getListDataJenisPengajuan();
//            System.out.println(listJenisPengajuan);
            model.addAttribute("listJns", listJenisPengajuan);
            SidangDto dto = new SidangDto();
            model.addAttribute("dto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "akd_tambahpengajuansidang";
    }
//    

    @RequestMapping(value = "/simpanDataPengajuanSidang", method = RequestMethod.POST)
    public String simpanDataSidang(SidangDto sidangDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        sidangService.saveDataSidang(sidangDto);
        return "redirect:akd_pengajuansidang.htm";
    }
//    

    @RequestMapping(value = "/editSidang", method = RequestMethod.GET)
    public String editDataSidang(String kdsidang, ModelMap model) throws Exception {
        List<JenisPengajuanDto> listJenisPengajuan = null;
        try {
            listJenisPengajuan = jenisPengajuanService.getListDataJenisPengajuan();
//            System.out.println(listJenisPengajuan);
            model.addAttribute("listJns", listJenisPengajuan);
            SidangDto sidangDto = sidangService.updateDataForm(kdsidang);
            model.addAttribute("dto", sidangDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "akd_editpengajuansidang";
    }
//    

    @RequestMapping(value = "/editDataPengajuanSidang", method = RequestMethod.POST)
    public String editDataSidangBaru(SidangDto sidangDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        sidangService.doUpdateDataForm(sidangDto);
        return "redirect:akd_pengajuansidang.htm";
    }

    @RequestMapping(value = "/cariSidang", method = RequestMethod.POST)
    public String cariSidang(String cariBerdasarkan, String cariKey, ModelMap model) throws Exception {
        List<SidangDto> listDto = sidangService.searchSidang(cariBerdasarkan, cariKey);
        model.addAttribute("listDto", listDto);
//        return "redirect:akd_datauser.htm";
        return "akd_pengajuansidang";
    }

    //////////////////////////////////////// KELULUSAN /////////////////////////////////////////////////
    @RequestMapping(value = "/akd_datakelulusan", method = RequestMethod.GET)
    public String tampilanKelulusanAkd(ModelMap model) {
        List<KelulusanDto> listDto = kelulusanService.getListDataKelulusan();
        model.addAttribute("listDto", listDto);
        return "akd_datakelulusan";
    }

    @RequestMapping(value = "/hapusListKelulusan", method = RequestMethod.GET)
    public String hapusDataKelulusan(String kdkelulusan, ModelMap model) throws Exception {
        kelulusanService.deleteDataKelulusan(kdkelulusan);
        return "redirect:akd_datakelulusan.htm";
    }
////    

    @RequestMapping(value = "/tambahKelulusan", method = RequestMethod.GET)
    public String tampilanTambahKelulusan(ModelMap model) throws Exception {
        try {
            KelulusanDto dto = new KelulusanDto();
            model.addAttribute("dto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "akd_tambahdatakelulusan";
    }
////    

    @RequestMapping(value = "/simpanDataKelulusan", method = RequestMethod.POST)
    public String simpanDataKelulusan(KelulusanDto kelulusanDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        kelulusanService.saveDataKelulusan(kelulusanDto);
        return "redirect:akd_datakelulusan.htm";
    }
////    

    @RequestMapping(value = "/editKelulusan", method = RequestMethod.GET)
    public String editDataKelulusan(String kdkelulusan, ModelMap model) throws Exception {
        try {
            KelulusanDto kelulusanDto = kelulusanService.updateDataForm(kdkelulusan);
            model.addAttribute("dto", kelulusanDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "akd_editdatakelulusan";
    }
////    

    @RequestMapping(value = "/editDataKelulusan", method = RequestMethod.POST)
    public String editDataKelulusanBaru(KelulusanDto kelulusanDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        kelulusanService.doUpdateDataForm(kelulusanDto);
        return "redirect:akd_datakelulusan.htm";
    }

    @RequestMapping(value = "/cariKelulusan", method = RequestMethod.POST)
    public String cariKelulusan(String cariBerdasarkan, String cariKey, ModelMap model) throws Exception {
        List<KelulusanDto> listDto = kelulusanService.searchKelulusan(cariBerdasarkan, cariKey);
        model.addAttribute("listDto", listDto);
//        return "redirect:akd_datauser.htm";
        return "akd_datakelulusan";
    }

    //================================================= ALUMNI =======================================
    @RequestMapping(value = "/akd_dataalumni", method = RequestMethod.GET)
    public String tampilanAlumniAkd(ModelMap model) {
        List<AlumniDto> listDto = alumniService.getListDataAlumni();
        model.addAttribute("listDto", listDto);
        return "akd_dataalumni";
    }

    @RequestMapping(value = "/hapusListAlumni", method = RequestMethod.GET)
    public String hapusDataAlumni(String kdalumni, ModelMap model) throws Exception {
        alumniService.deleteDataAlumni(kdalumni);
        return "redirect:akd_dataalumni.htm";
    }

    @RequestMapping(value = "/tambahAlumni", method = RequestMethod.GET)
    public String tampilanTambahAlumni(ModelMap model) throws Exception {
        try {
            AlumniDto dto = new AlumniDto();
            model.addAttribute("dto", dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "akd_tambahdataalumni";
    }
//    

    @RequestMapping(value = "/simpanDataAlumni", method = RequestMethod.POST)
    public String simpanDataAlumni(AlumniDto alumniDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        alumniService.saveDataAlumni(alumniDto);
        return "redirect:akd_dataalumni.htm";
    }
//    

    @RequestMapping(value = "/editAlumni", method = RequestMethod.GET)
    public String editDataAlumni(String kdalumni, ModelMap model) throws Exception {
        try {
            AlumniDto alumniDto = alumniService.updateDataForm(kdalumni);
            model.addAttribute("dto", alumniDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "akd_editdataalumni";
    }
//    

    @RequestMapping(value = "/editDataAlumni", method = RequestMethod.POST)
    public String editDataAlumniBaru(AlumniDto alumniDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        alumniService.doUpdateDataForm(alumniDto);
        return "redirect:akd_dataalumni.htm";
    }
//    
//    @RequestMapping(value = "/createAkun", method = RequestMethod.GET)
//    public String buatAkunOtomatis(ProposalDto proposalDto, ModelMap model) throws Exception{                
//        ModelAndView mdl = new ModelAndView();
//        proposalService.createAkun(proposalDto);
//        return "redirect:akd_pengajuanproposal.htm";
//    }
//    

    @RequestMapping(value = "/cariAlumni", method = RequestMethod.POST)
    public String cariAlumni(String cariBerdasarkan, String cariKey, ModelMap model) throws Exception {
        List<AlumniDto> listDto = alumniService.searchAlumni(cariBerdasarkan, cariKey);
        model.addAttribute("listDto", listDto);
//        return "redirect:akd_datauser.htm";
        return "akd_dataalumni";
    }

    /////////=================================== LAPORAN PROPOSAL////////////////////////////////
    @RequestMapping(value = "/akd_laporanpengajuanproposal", method = RequestMethod.GET)
    public String tampilanlaporanProposalAkd(ModelMap model) {
        List<FakultasDto> listFakultas = fakultasService.getListDataFakultas();
        model.addAttribute("listFakultas", listFakultas);
        List<JurusanDto> listJurusan = jurusanService.getListDataJurusan();
        model.addAttribute("listJurusan", listJurusan);
//        List<MahasiswaDto> listAngkatan = mahasiswaService.getListDataMahasiswa();
//        model.addAttribute("listAngkatan", listAngkatan);
        return "akd_laporanpengajuanproposal";
    }

    @RequestMapping(value = "/laporanproposal", method = RequestMethod.GET)
    public org.springframework.web.servlet.ModelAndView downloadExcel(String fakultas_filter, String jurusan_filter, String jenis_filter, String angkatan_filter, String cetak_filter, ModelMap model) throws Exception {
        List<ProposalDto> listDtoProposal = proposalService.getListDataProposalByFilterForReport(fakultas_filter, jurusan_filter, jenis_filter, angkatan_filter);
        if (cetak_filter.equals("1")) {
            return new org.springframework.web.servlet.ModelAndView("excelProposal", "listDtoProposal", listDtoProposal);
        } else {
            return new org.springframework.web.servlet.ModelAndView("pdfView", "listDtoProposal", listDtoProposal);
        }

    }

    /////////////////////////////laporan sidang

    @RequestMapping(value = "/akd_laporanpengajuansidang", method = RequestMethod.GET)
    public String tampilanlaporanSidangAkd(ModelMap model) {
        List<FakultasDto> listFakultas = fakultasService.getListDataFakultas();
        model.addAttribute("listFakultas", listFakultas);
        List<JurusanDto> listJurusan = jurusanService.getListDataJurusan();
        model.addAttribute("listJurusan", listJurusan);
//        List<MahasiswaDto> listAngkatan = mahasiswaService.getListDataMahasiswa();
//        model.addAttribute("listAngkatan", listAngkatan);
        return "akd_laporanpengajuansidang";
    }

    @RequestMapping(value = "/laporansidang", method = RequestMethod.GET)
    public org.springframework.web.servlet.ModelAndView downloadReportSidang(String fakultas_filter, String jurusan_filter, String jenis_filter, String angkatan_filter, String urut_filter, String cetak_filter, ModelMap model) throws Exception {
        List<SidangDto> listDtoSidang = sidangService.getListDataSidangByFilterForReport(fakultas_filter, jurusan_filter, jenis_filter, angkatan_filter, urut_filter);
        if (cetak_filter.equals("1")) {
            return new org.springframework.web.servlet.ModelAndView("excelSidang", "listDtoSidang", listDtoSidang);
        } else {
            return new org.springframework.web.servlet.ModelAndView("pdfView", "listDtoProposal", listDtoSidang);
        }

    }

    /////////////////////////////laporan kelulusan
    @RequestMapping(value = "/akd_laporandatakelulusan", method = RequestMethod.GET)
    public String tampilanlaporanKelulusanAkd(ModelMap model) {
        List<FakultasDto> listFakultas = fakultasService.getListDataFakultas();
        model.addAttribute("listFakultas", listFakultas);
        List<JurusanDto> listJurusan = jurusanService.getListDataJurusan();
        model.addAttribute("listJurusan", listJurusan);
//        List<MahasiswaDto> listAngkatan = mahasiswaService.getListDataMahasiswa();
//        model.addAttribute("listAngkatan", listAngkatan);
        return "akd_laporandatakelulusan";
    }

    @RequestMapping(value = "/laporankelulusan", method = RequestMethod.GET)
    public org.springframework.web.servlet.ModelAndView downloadReportKelulusan(String fakultas_filter, String jurusan_filter, String angkatan_filter, String cetak_filter, ModelMap model) throws Exception {
        List<KelulusanDto> listDtoKelulusan = kelulusanService.getListDataKelulusanByFilterForReport(fakultas_filter, jurusan_filter, angkatan_filter);
        if (cetak_filter.equals("1")) {
            return new org.springframework.web.servlet.ModelAndView("excelKelulusan", "listDtoKelulusan", listDtoKelulusan);
        } else {
            return new org.springframework.web.servlet.ModelAndView("pdfView", "listDtoProposal", listDtoKelulusan);
        }

    }

    /////////////////////////////laporan alumni
    @RequestMapping(value = "/akd_laporandataalumni", method = RequestMethod.GET)
    public String tampilanlaporanAlumniAkd(ModelMap model) {
        List<FakultasDto> listFakultas = fakultasService.getListDataFakultas();
        model.addAttribute("listFakultas", listFakultas);
        List<JurusanDto> listJurusan = jurusanService.getListDataJurusan();
        model.addAttribute("listJurusan", listJurusan);
//        List<MahasiswaDto> listAngkatan = mahasiswaService.getListDataMahasiswa();
//        model.addAttribute("listAngkatan", listAngkatan);
        return "akd_laporandataalumni";
    }

    @RequestMapping(value = "/laporanalumni", method = RequestMethod.GET)
    public org.springframework.web.servlet.ModelAndView downloadReportAlumni(String fakultas_filter, String jurusan_filter, String angkatan_filter, String cetak_filter, ModelMap model) throws Exception {
        List<AlumniDto> listDtoAlumni = alumniService.getListDataAlumniByFilterForReport(fakultas_filter, jurusan_filter, angkatan_filter);
        if (cetak_filter.equals("1")) {
            return new org.springframework.web.servlet.ModelAndView("excelAlumni", "listDtoAlumni", listDtoAlumni);
        } else {
            return new org.springframework.web.servlet.ModelAndView("pdfView", "listDtoProposal", listDtoAlumni);
        }

    }

    //////////////////////////////////////////////////////////////////
    @RequestMapping(value = "/changeJurusanByFakultas", method = RequestMethod.POST)
    @ResponseBody
    public List<JurusanDto> ambilData(String param, ModelMap model) throws Exception {
        List<FakultasDto> listFakultas = fakultasService.getListDataFakultas();
        model.addAttribute("listFakultas", listFakultas);
        List<JurusanDto> listJurusan = jurusanService.getJurusanById(param);
        model.addAttribute("listJurusan", listJurusan);
        System.out.println("===========================" + param);
        System.out.println(listJurusan.size());
        System.out.println(listJurusan.get(0).getNamajurusan());
        System.out.println(listJurusan.get(1).getNamajurusan());
        return listJurusan;
    }

    ////////////////////////////NOTIF//////////////////////////////////////////

    @RequestMapping(value = "/akd_buatnotifikasi", method = RequestMethod.GET)
    public String tampilanNitifAkd(ModelMap model) {
        NotifDto dtoNotif = new NotifDto();
        model.addAttribute("dtoNotif", dtoNotif);
        return "akd_buatnotifikasi";
    }

    @RequestMapping(value = "/cariMahasiswa", method = RequestMethod.POST)
    @ResponseBody
    public String cariMahasiswa(String nim) throws Exception {
        List<MahasiswaDto> listDto = notifService.searchNotif(nim);
        String nim_nama = listDto.get(0).getNim() + " - " + listDto.get(0).getNamamahasiswa();
        System.out.println("=============================" + nim_nama);
        return nim_nama;
    }

    @RequestMapping(value = "/simpanNotifikasi", method = RequestMethod.GET)
    public String simpanNotif(String nim, String isinotif, String subjeknotif, String judulnotif, ModelMap model) throws Exception {
        notifService.saveNotif(nim, isinotif, subjeknotif, judulnotif);
        return "akd_buatnotifikasi";
    }
    
    @RequestMapping(value = "/akd_kirimemail", method = RequestMethod.GET)
    public String tampilanAkdKirimEmail(ModelMap model) {
        return "akd_kirimemail";
    }

    @RequestMapping(value = "/sendEmailFromDashboard", method = RequestMethod.POST)
    public String doSendEmail(HttpServletRequest request) {
        System.out.println("masuk doSendEmail");
        // takes input from e-mail form
        String recipientAddress = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        System.out.println("bawah ====================");
        // prints debug info
        System.out.println("To: " + recipientAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
        mailSender.send(new MimeMessagePreparator() {

            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper messageHelper = new MimeMessageHelper(
                        mimeMessage, true, "UTF-8");
                messageHelper.setTo(recipientAddress);
                messageHelper.setSubject(subject);
                messageHelper.setText(message);

            }
        });

        // forwards to the view named "Result"
        return "akd_kirimemail";
    }
    
    

}
