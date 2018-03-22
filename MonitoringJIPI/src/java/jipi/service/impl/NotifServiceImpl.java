/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import static java.lang.Math.random;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.transaction.Transactional;
import jipi.dao.JurusanDao;
import jipi.dao.NotifDao;
import jipi.dto.MahasiswaDto;
import jipi.dto.NotifDto;
import jipi.model.NotifModel;
import jipi.service.NotifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class NotifServiceImpl implements NotifService {

    @Autowired
    NotifDao notifDao;

    @Autowired
    NotifService notifService;

    @Override
    public List<NotifDto> getNotifById(String nim) {
        List<NotifDto> listNotifDto = new ArrayList();
        List<Object[]> listDataObject = notifDao.getListNotifNativeQuery(nim);
        if (listDataObject != null) {
            for (Object[] object : listDataObject) {
                NotifDto dto = new NotifDto();
                if (object[0] != null) {
                    dto.setKdnotif(object[0].toString());
                }
                if (object[1] != null) {
                    dto.setKdakses(object[1].toString());
                }
                if (object[2] != null) {
                    dto.setNim(object[2].toString());
                }
                if (object[3] != null) {
                    dto.setTglnotif(object[3].toString());
                }

                if (object[4] != null) {
                    dto.setJudulnotif(object[4].toString());
                }
                if (object[5] != null) {
                    dto.setIsinotif(object[5].toString());
                }
                if (object[6] != null) {
                    dto.setSubjeknotif(object[6].toString());
                }
                if (object[7] != null) {
                    dto.setStatusbaca(object[7].toString());
                }
                listNotifDto.add(dto);
            }
        }
        return listNotifDto;
    }

    @Override
    public void updateStatusBaca(String kdnotif) throws Exception {
        NotifModel ddm = new NotifModel();
        List<NotifDto> notifDto = notifService.getNotifByKodeNotif(kdnotif);
        System.out.println("=====================" + notifDto);
        try {
            ddm.setKdnotif(notifDto.get(0).getKdnotif());
            ddm.setKdakses(notifDto.get(0).getKdakses());
            ddm.setNim(notifDto.get(0).getNim());
            ddm.setTglnotif(notifDto.get(0).getTglnotif());
            ddm.setIsinotif(notifDto.get(0).getIsinotif());
            ddm.setJudulnotif(notifDto.get(0).getJudulnotif());
            ddm.setSubjeknotif(notifDto.get(0).getSubjeknotif());
            ddm.setStatusbaca("panel-info");
        } catch (Exception e) {
            e.printStackTrace();
        }
        notifDao.updateNotif(ddm);

    }

    @Override
    public List<NotifDto> getNotifByKodeNotif(String kdnotif) {
        List<NotifDto> listNotifDto = new ArrayList();
        List<Object[]> listDataObject = notifDao.getListNotifByKodeNatifNativeQuery(kdnotif);
        if (listDataObject != null) {
            for (Object[] object : listDataObject) {
                NotifDto dto = new NotifDto();
                if (object[0] != null) {
                    dto.setKdnotif(object[0].toString());
                }
                if (object[1] != null) {
                    dto.setKdakses(object[1].toString());
                }
                if (object[2] != null) {
                    dto.setNim(object[2].toString());
                }
                if (object[3] != null) {
                    dto.setTglnotif(object[3].toString());
                }

                if (object[4] != null) {
                    dto.setJudulnotif(object[4].toString());
                }
                if (object[5] != null) {
                    dto.setIsinotif(object[5].toString());
                }
                if (object[6] != null) {
                    dto.setSubjeknotif(object[6].toString());
                }
                if (object[7] != null) {
                    dto.setStatusbaca(object[7].toString());
                }
                listNotifDto.add(dto);
            }
        }
        return listNotifDto;
    }

    @Override
    public void deleteNotif(String kdnotif) throws Exception {
        try {
            notifDao.deleteNotif(kdnotif);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<MahasiswaDto> searchNotif(String nim) {
        List<MahasiswaDto> listMahasiswaDto = new ArrayList();
        List<Object[]> listDataObject = notifDao.getListCariDataMahasiswaNativeQuery(nim);
        if (listDataObject != null) {
            for (Object[] object : listDataObject) {
                MahasiswaDto dto = new MahasiswaDto();
                if (object[0] != null) {
                    dto.setNim(object[0].toString());
                }
                if (object[1] != null) {
                    dto.setNamamahasiswa(object[1].toString());
                }

                listMahasiswaDto.add(dto);
            }
        }
        return listMahasiswaDto;
    }

    @Override
    public void saveNotif(String nim, String isinotif, String subjeknotif, String judulnotif) throws Exception {
        NotifModel nm = new NotifModel();
        nm.setKdnotif("N"+generateKode());
        nm.setKdakses("5");
        nm.setNim(nim.substring(0, 10));
        nm.setTglnotif(getTanggalFormat());
        nm.setIsinotif(isinotif);
        nm.setJudulnotif(judulnotif);
        nm.setSubjeknotif(subjeknotif);
        nm.setStatusbaca("panel-blue");
        notifDao.saveDataNotif(nm);
    }

    public String getTanggalFormat() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

//    public char buatKarakterAcak(char karakter1, char karakter2) {
//        return (char) (karakter1 + Math.random() * (karakter2 - karakter1 + 1));
//    }
//
//    public char digitAngka() {
//        return buatKarakterAcak('0', '9');
//    }
//
//    public char digitHurufKecil() {
//        return buatKarakterAcak('a', 'z');
//    }
//
//    public char digitHurufBesar() {
//        return buatKarakterAcak('A', 'Z');
//    }
    
    public String generateKode(){
        Random random = new Random();
        char[] kode = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        String tamp="";
        for (int lenght = 0; lenght < 7; lenght++) {
            tamp+= kode[random.nextInt(kode.length)];
        }
        return tamp;
    }

}
