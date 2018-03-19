/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.controller;

import java.util.List;
import jipi.dto.AlumniDto;
import jipi.dto.AlumniViewDto;
import jipi.dto.FakultasDto;
import jipi.dto.JenisPengajuanDto;
import jipi.dto.JurusanDto;
import jipi.dto.MahasiswaDto;
import jipi.dto.ProposalDto;
import jipi.dto.UserDto;
import jipi.service.AlumniService;
import jipi.service.FakultasService;
import jipi.service.JenisPengajuanService;
import jipi.service.JurusanService;
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

    @Autowired
    FakultasService fakultasService;

    @Autowired
    JurusanService jurusanService;

    @RequestMapping(value = "/mhs_index", method = RequestMethod.GET)
    public String tampilanIndexMhs(String nim, ModelMap model) {
        try {
            MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(nim);
            model.addAttribute("dto", mahasiswaDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mhs_index";
    }

    @RequestMapping(value = "/mhs_profil", method = RequestMethod.GET)
    public String tampilanProfil(String nim, ModelMap model) throws Exception {
        System.out.println("=======================================");
//        nim="0204151015";
        try {
            MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(nim);
            model.addAttribute("listMahasiswa", mahasiswaDto);
            System.out.println(mahasiswaDto.toString() + "===========================");
            MahasiswaDto mahasiswaDto2 = mahasiswaService.getDtoMahasiswa(nim);
            model.addAttribute("dto", mahasiswaDto2);
            System.out.println(mahasiswaDto.toString() + "===================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mhs_profil";
    }

    @RequestMapping(value = "/mhs_notifikasi", method = RequestMethod.GET)
    public String tampilanNotifikasi(String nim, ModelMap model) {
        try {
            MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(nim);
            model.addAttribute("dto", mahasiswaDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mhs_notifikasi";
    }

    @RequestMapping(value = "/mhs_ubahakun", method = RequestMethod.GET)
    public String ubahAkun(ModelMap model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "mhs_ubahakun";
    }

    @RequestMapping(value = "/berandaalumni", method = RequestMethod.GET)
    public String tampilanAlumni(String nim, ModelMap model) {
        try {
            MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(nim);
            model.addAttribute("dto", mahasiswaDto);
            List<AlumniDto> listDto = alumniService.getListDataAlumniView();
            model.addAttribute("listDto", listDto);
            List<FakultasDto> listFakultas = fakultasService.getListDataFakultas();
            model.addAttribute("listFakultas", listFakultas);
            List<JurusanDto> listJurusan = jurusanService.getListDataJurusan();
            model.addAttribute("listJurusan", listJurusan);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "mhs_berandaalumni";
    }

//    @RequestMapping(value = "/berandaalumni", method = RequestMethod.GET)
//    public String tampilanAlumni(ModelMap model){
//        List<AlumniDto> listDto = alumniService.getListDataAlumni();
//        model.addAttribute("listDto", listDto);
//        List<FakultasDto> listFakultas = fakultasService.getListDataFakultas();
//        model.addAttribute("listFakultas", listFakultas);
//        List<JurusanDto> listJurusan = jurusanService.getListDataJurusan();
//        model.addAttribute("listJurusan", listJurusan);
//        return "mhs_berandaalumni";
//    }
    @RequestMapping(value = "/caridataalumni", method = RequestMethod.POST)
    public String cariAlumni(String nim, String cariBerdasarkan, String cariKey, ModelMap model) throws Exception {
        List<AlumniDto> listDto = alumniService.searchAlumni(cariBerdasarkan, cariKey);
        model.addAttribute("listDto", listDto);
        MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(nim);
        model.addAttribute("dto", mahasiswaDto);
//        return "redirect:akd_datauser.htm";
        return "mhs_berandaalumni";
    }

    @RequestMapping(value = "/editMhsAlumni", method = RequestMethod.GET)
    public String editAlumni(String nim, String kdalumni, ModelMap model) throws Exception {
        try {
            AlumniDto alumniDto = alumniService.updateDataForm(kdalumni);
            model.addAttribute("alumniDto", alumniDto);
            MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(nim);
            model.addAttribute("dto", mahasiswaDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mhs_editdataalumni";
    }

    @RequestMapping(value = "/editAlumniMhs", method = RequestMethod.POST)
    public String editDataAlumni(String nim, AlumniDto alumniDto, ModelMap model) throws Exception {
        ModelAndView mdl = new ModelAndView();
        MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(alumniDto.getTampungannim());
        System.out.println("=================================" + alumniDto.getTampungannim());
        model.addAttribute("dto", mahasiswaDto);
        alumniService.doUpdateDataForm(alumniDto);
        return "redirect:berandaalumni.htm";
    }

    @RequestMapping(value = "/mhs_viewAlumni", method = RequestMethod.GET)
    public String ViewAlumni(String nim, String kdalumni, ModelMap model) throws Exception {
        try {
            MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(nim);
            model.addAttribute("dto", mahasiswaDto);
            List<AlumniViewDto> listDto = alumniService.viewDataAlumni(kdalumni);
            System.out.println("sout : " + listDto.toString());
            model.addAttribute("listDto", listDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mhs_viewAlumni";
    }

    @RequestMapping(value = "/caridataalumnibyjurusan", method = RequestMethod.POST)
    public String cariAlumniByJurusan(String nim, String jurusan, String fakultas, String angkatan, ModelMap model) throws Exception {
        List<AlumniDto> listDto = alumniService.searchAlumniByJurusan(jurusan, fakultas, angkatan);
        model.addAttribute("listDto", listDto);
        MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(nim);
        model.addAttribute("dto", mahasiswaDto);
        List<FakultasDto> listFakultas = fakultasService.getListDataFakultas();
        model.addAttribute("listFakultas", listFakultas);
        List<JurusanDto> listJurusan = jurusanService.getListDataJurusan();
        model.addAttribute("listJurusan", listJurusan);
//        return "redirect:akd_datauser.htm";
        return "mhs_berandaalumni";
    }
}
