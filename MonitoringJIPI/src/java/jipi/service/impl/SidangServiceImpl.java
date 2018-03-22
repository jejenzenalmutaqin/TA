/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.transaction.Transactional;
import jipi.dao.SidangDao;
import jipi.dto.SidangDto;
import jipi.model.JenisPengajuanModel;
import jipi.model.MahasiswaModel;
import jipi.model.ProposalModel;
import jipi.model.SidangModel;
import jipi.service.JenisPengajuanService;
import jipi.service.MahasiswaService;
import jipi.service.ProposalService;
import jipi.service.SidangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class SidangServiceImpl implements SidangService{
    
    @Autowired
    SidangDao sidangDao;
    
    @Autowired
    JenisPengajuanService jenisPengajuanService;
    
    @Autowired
    MahasiswaService mahasiswaService;
    
    @Autowired
    ProposalService proposalService;
    

    @Override
    public void saveDataSidang(SidangDto sidangDto) throws Exception {
        SidangModel dataModel = new SidangModel();
        
        dataModel.setKdsidang("S"+generateKode());
        dataModel.setKdjenissidang(sidangDto.getKdjenissidang());
        dataModel.setNim(sidangDto.getNim());
        dataModel.setKdproposal(sidangDto.getKdproposal());
        dataModel.setTglpengajuansidang(sidangDto.getTglpengajuansidang());
        dataModel.setPenelaah1(sidangDto.getPenelaah1());
        dataModel.setPenelaah2(sidangDto.getPenelaah2());
        dataModel.setWakilfakultas(sidangDto.getWakilfakultas());
        dataModel.setJamsidang(sidangDto.getJamsidang());
        dataModel.setTglsidang(sidangDto.getTglsidang());
        dataModel.setRuangansidang(sidangDto.getRuangansidang());
        sidangDao.saveDataSidang(dataModel);    
    }

    @Override
    public List<SidangDto> getListDataSidang() {
        List<SidangDto> ListDto = new ArrayList<>();
        List<SidangModel> data = sidangDao.getListDataSidang();
        
        if(data != null){
            for (SidangModel ddm : data) {
                SidangDto dto = new SidangDto();
                JenisPengajuanModel jm = new JenisPengajuanModel();
                MahasiswaModel mm = new MahasiswaModel();
                ProposalModel pm = new ProposalModel();
                
                if(ddm.getKdsidang() != null){
                    dto.setKdsidang(ddm.getKdsidang());
                }
                if(ddm.getKdjenissidang() != null){
                    jm = jenisPengajuanService.getJenisPengajuanById(ddm.getKdjenissidang());
                    dto.setKdjenissidang(jm.getNamajenispengajuan());
                }
                if(ddm.getNim() != null){
                    dto.setNim(ddm.getNim());
                }
                if(ddm.getKdproposal() != null){
                    pm = proposalService.getProposalById(ddm.getKdproposal());
                    mm = mahasiswaService.getMahasiswaById(pm.getNim());
                    dto.setKdproposal(mm.getNamamahasiswa());
                }
                if(ddm.getTglpengajuansidang() != null){
                    dto.setTglpengajuansidang(ddm.getTglpengajuansidang());
                }
                if(ddm.getPenelaah1() != null){
                    dto.setPenelaah1(ddm.getPenelaah1());
                }
                if(ddm.getPenelaah2() != null){
                    dto.setPenelaah2(ddm.getPenelaah2());
                }
                if(ddm.getWakilfakultas() != null){
                    dto.setWakilfakultas(ddm.getWakilfakultas());
                }
                if(ddm.getJamsidang() != null){
                    dto.setJamsidang(ddm.getJamsidang());
                }
                if(ddm.getTglsidang()!= null){
                    dto.setTglsidang(ddm.getTglsidang());
                }
                if(ddm.getRuangansidang() != null){
                    dto.setRuangansidang(ddm.getRuangansidang());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }

    @Override
    public void deleteDataSidang(String kdsidang) throws Exception {
        try {
            sidangDao.deleteDataSidang(kdsidang);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public SidangModel getSidangById(String kdsidang) {
        SidangModel sidangModel = null;
        try {
            sidangModel = sidangDao.getSidangById(kdsidang);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sidangModel;
    }

    @Override
    public SidangDto updateDataForm(String kdsidang) throws Exception {
        List<SidangModel> data = sidangDao.getListDataSidang();
        SidangDto dto = new SidangDto();
        if(data != null){
            for (SidangModel ddm : data) {
                JenisPengajuanModel jm = new JenisPengajuanModel();
                MahasiswaModel mm = new MahasiswaModel();
                ProposalModel pm = new ProposalModel();
                
                if(ddm.getKdsidang() != null){
                    dto.setKdsidang(ddm.getKdsidang());
                }
                if(ddm.getKdjenissidang() != null){
                    jm = jenisPengajuanService.getJenisPengajuanById(ddm.getKdjenissidang());
                    dto.setKdjenissidang(jm.getNamajenispengajuan());
                }
                if(ddm.getNim() != null){
                    dto.setNim(ddm.getNim());
                }
                if(ddm.getKdproposal() != null){
                    dto.setKdproposal(ddm.getKdproposal());
                }
                if(ddm.getTglpengajuansidang() != null){
                    dto.setTglpengajuansidang(ddm.getTglpengajuansidang());
                }
                if(ddm.getPenelaah1() != null){
                    dto.setPenelaah1(ddm.getPenelaah1());
                }
                if(ddm.getPenelaah2() != null){
                    dto.setPenelaah2(ddm.getPenelaah2());
                }
                if(ddm.getWakilfakultas() != null){
                    dto.setWakilfakultas(ddm.getWakilfakultas());
                }
                if(ddm.getJamsidang() != null){
                    dto.setJamsidang(ddm.getJamsidang());
                }
                if(ddm.getTglsidang()!= null){
                    dto.setTglsidang(ddm.getTglsidang());
                }
                if(ddm.getRuangansidang() != null){
                    dto.setRuangansidang(ddm.getRuangansidang());
                }
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataForm(SidangDto sidangDto) throws Exception {
        SidangModel dataModel = new SidangModel();
        try{
        dataModel.setKdsidang(sidangDto.getKdsidang());
        dataModel.setKdjenissidang(sidangDto.getKdjenissidang());
        dataModel.setNim(sidangDto.getNim());
        dataModel.setKdproposal(sidangDto.getKdproposal());
        dataModel.setTglpengajuansidang(sidangDto.getTglpengajuansidang());
        dataModel.setPenelaah1(sidangDto.getPenelaah1());
        dataModel.setPenelaah2(sidangDto.getPenelaah2());
        dataModel.setWakilfakultas(sidangDto.getWakilfakultas());
        dataModel.setJamsidang(sidangDto.getJamsidang());
        dataModel.setTglsidang(sidangDto.getTglsidang());
        dataModel.setRuangansidang(sidangDto.getRuangansidang());
        } catch (Exception e) {
            e.printStackTrace();
        }
        sidangDao.updateSidang(dataModel);
    }

    @Override
    public List<SidangDto> searchSidang(String cariBerdasarkan, String cariKey) {
        List<SidangDto> listSidangDto = new ArrayList();
        List<Object[]> listDataObject = sidangDao.getListCariDataSidangNativeQuery(cariBerdasarkan, cariKey);
        if (listDataObject != null){
            for (Object[] object : listDataObject){
                SidangDto dto = new SidangDto();
                JenisPengajuanModel jm = new JenisPengajuanModel();
                MahasiswaModel mm = new MahasiswaModel();
                ProposalModel pm = new ProposalModel();
                if (object[0] != null){
                    dto.setKdsidang(object[0].toString());
                }
                if (object[1] != null){
                    dto.setKdjenissidang(object[1].toString());
                    jm = jenisPengajuanService.getJenisPengajuanById(object[1].toString());
                    dto.setKdjenissidang(jm.getNamajenispengajuan());
                }
                if (object[2] != null){
                    dto.setNim(object[2].toString());
                }
                if (object[3] != null){
                    pm = proposalService.getProposalById(object[3].toString());
                    mm = mahasiswaService.getMahasiswaById(pm.getNim());
                    dto.setKdproposal(mm.getNamamahasiswa());
                }
                if (object[4] != null){
                    dto.setTglpengajuansidang(object[4].toString());
                }
                if (object[5] != null){
                    dto.setPenelaah1(object[5].toString());
                }
                if (object[6] != null){
                    dto.setPenelaah2(object[6].toString());
                }
                if (object[7] != null){
                    dto.setWakilfakultas(object[7].toString());
                }
                if (object[8] != null){
                    dto.setJamsidang(object[8].toString());
                }
                if (object[9] != null){
                    dto.setTglsidang(object[9].toString());
                }
                if (object[10] != null){
                    dto.setRuangansidang(object[10].toString());
                }
                listSidangDto.add(dto);
            }
        }
        return listSidangDto;   
    }

    @Override
    public List<SidangDto> getListDataSidangByFilterForReport(String fakultas_filter, String jurusan_filter, String jenis_filter, String angkatan_filter, String urut_filter) {
        List<SidangDto> listSidangDto = new ArrayList();
        List<Object[]> listDataObject = sidangDao.getListDataSidangForReport(fakultas_filter, jurusan_filter, jenis_filter, angkatan_filter, urut_filter);
        if (listDataObject != null){
            for (Object[] object : listDataObject){
                SidangDto dto = new SidangDto();
                JenisPengajuanModel jm = new JenisPengajuanModel();
                MahasiswaModel mm = new MahasiswaModel();
                if (object[0] != null){
                    dto.setKdsidang(object[0].toString());
                }
                if (object[1] != null){
                    dto.setKdjenissidang(object[1].toString());
                    jm = jenisPengajuanService.getJenisPengajuanById(object[1].toString());
                    dto.setKdjenissidang(jm.getNamajenispengajuan());
                }
                if (object[2] != null){
                    dto.setNim(object[2].toString());
                }
                if (object[3] != null){
                    dto.setKdproposal(object[3].toString());
                        mm = mahasiswaService.getMahasiswaById(object[2].toString());
                    dto.setKdproposal(mm.getNamamahasiswa());
                }else{
                   mm = mahasiswaService.getMahasiswaById(object[2].toString());
                   dto.setKdproposal(mm.getNamamahasiswa());
                }
                
                if (object[4] != null){
                    dto.setTglpengajuansidang(object[4].toString());
                }
                
                if (object[5] != null){
                    dto.setPenelaah1(object[5].toString());
                }
                if (object[6] != null){
                    dto.setPenelaah2(object[6].toString());
                }
                if (object[7] != null){
                    dto.setWakilfakultas(object[7].toString());
                }
                if (object[8] != null){
                    dto.setJamsidang(object[8].toString());
                }
                if (object[9] != null){
                    dto.setTglsidang(object[9].toString());
                }
                if (object[10] != null){
                    dto.setRuangansidang(object[10].toString());
                }
                listSidangDto.add(dto);
            }
        }
        return listSidangDto;
    }
    
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
