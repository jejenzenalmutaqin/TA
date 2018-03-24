/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import jipi.dto.AksesDto;
import jipi.dto.AlumniDto;
import jipi.dto.AlumniViewDto;
import jipi.dto.FakultasDto;
import jipi.dto.JenisPengajuanDto;
import jipi.dto.JurusanDto;
import jipi.dto.MahasiswaDto;
import jipi.dto.NotifDto;
import jipi.dto.ProposalDto;
import jipi.dto.UserDto;
import jipi.service.AlumniService;
import jipi.service.FakultasService;
import jipi.service.JenisPengajuanService;
import jipi.service.JurusanService;
import jipi.service.MahasiswaService;
import jipi.service.NotifService;
import jipi.service.ProposalService;
import jipi.service.UserService;
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
    

    @Autowired
    NotifService notifService;

	@Autowired
    UserService userService;
	

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
            List<NotifDto> listNotif = notifService.getNotifById(nim);
            model.addAttribute("listNotif", listNotif);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mhs_notifikasi";
    }
   
   

    @RequestMapping(value = "/hapusnotif", method = RequestMethod.GET)
    public String hapusNotifikasi(String nim, String kdnotif, ModelMap model) {
        try {
            MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(nim);
            model.addAttribute("dto", mahasiswaDto);
            notifService.deleteNotif(kdnotif);
            List<NotifDto> listNotif = notifService.getNotifById(nim);
            model.addAttribute("listNotif", listNotif);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mhs_notifikasi";
    }
    

    @RequestMapping(value = "/openAndEditNotif", method = RequestMethod.GET)
    public String tampilanDetailNotifikasi(String nim, String kdnotif, ModelMap model) {
        try {
            //untuk nim
            MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(nim);
            model.addAttribute("dto", mahasiswaDto);
            //buat untuk edit status baca
            notifService.updateStatusBaca(kdnotif);
            //get notif by kodenotif
            List<NotifDto> listNotifDto = notifService.getNotifByKodeNotif(kdnotif);
            model.addAttribute("listNotif", listNotifDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mhs_notifikasi_detail";
    }
    
    

    @RequestMapping(value = "/mhs_ubahakun", method = RequestMethod.GET)
    public String ubahAkun(String nim, ModelMap model) throws Exception {

        List<AksesDto> listAkses = null;
        try {
//            listAkses = aksesService.getListDataAkses();
//            System.out.println(listJenisPengajuan);
//            model.addAttribute("listAkses", listAkses);
            UserDto userDto = userService.updateDataFormMhs(nim);
            model.addAttribute("userDto", userDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mhs_ubahakun";
    }

	@RequestMapping(value = "/editDataBaru", method = RequestMethod.GET)
    public String editData(UserDto userDto, ModelMap model) throws Exception {
        MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(userDto.getNim());
        model.addAttribute("listMahasiswa", mahasiswaDto);
        System.out.println(mahasiswaDto.toString() + "===========================INI NIM " + mahasiswaDto.getNim());
        MahasiswaDto mahasiswaDto2 = mahasiswaService.getDtoMahasiswa(userDto.getNim());
        model.addAttribute("dto", mahasiswaDto2);
        System.out.println(mahasiswaDto.toString() + "===================================INI ININ 2"+mahasiswaDto2.getNim());
        userService.doUpdateDataFormMhs(userDto);
        return "mhs_profil";
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
		List<FakultasDto> listFakultas = fakultasService.getListDataFakultas();
        model.addAttribute("listFakultas", listFakultas);
        List<JurusanDto> listJurusan = jurusanService.getListDataJurusan();
        model.addAttribute("listJurusan", listJurusan);
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
            model.addAttribute("dto",mahasiswaDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "mhs_editdataalumni";
    }

    @RequestMapping(value = "/editAlumniMhs", method = RequestMethod.POST)
    public String editDataAlumni(AlumniDto alumniDto, ModelMap model) throws Exception {
        if (!alumniDto.getFile().isEmpty()) {
//            try {
                byte[] bytes = alumniDto.getFile().getBytes();

                // Creating the directory to store file
                String rootPath = "E:\\PROJECT TA\\180318\\MonitoringJIPI\\web\\img";
                File dir = new File(rootPath);//rootPath itu url nya..
                if (!dir.exists()) {
                    dir.mkdirs();//mkdirs() untuk membuat sebuah direktori baru, terdapat pd klas file
                }

                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + alumniDto.getFile().getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));//pembacaan data binary dari sebuah file
                stream.write(bytes);
                stream.close();
        }
        ModelAndView mdl = new ModelAndView();
        MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(alumniDto.getTampungannim());
        System.out.println("================================="+alumniDto.getTampungannim());
        model.addAttribute("dto",mahasiswaDto);
        alumniService.doUpdateDataForm(alumniDto);
        return "redirect:berandaalumni.htm";
    }

    @RequestMapping(value = "/mhs_viewAlumni", method = RequestMethod.GET)
    public String ViewAlumni(String nim, String kdalumni, ModelMap model) throws Exception {
        try {
            MahasiswaDto mahasiswaDto = mahasiswaService.getDtoMahasiswa(nim);
            model.addAttribute("dto",mahasiswaDto);
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
