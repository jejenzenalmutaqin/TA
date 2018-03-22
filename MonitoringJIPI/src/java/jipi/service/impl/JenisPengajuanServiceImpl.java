/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import jipi.dao.JenisPengajuanDao;
import jipi.dto.JenisPengajuanDto;
import jipi.dto.ViewPengajuanSidangDosenDto;
import jipi.model.JenisPengajuanModel;
import jipi.model.ViewPengajuanSidangModel;
import jipi.service.JenisPengajuanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class JenisPengajuanServiceImpl implements JenisPengajuanService{
    @Autowired
    JenisPengajuanDao jenisPengajuanDao;
    @Override
    public void saveDataJenisPengajuan(JenisPengajuanDto jenisPengajuanDto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<JenisPengajuanDto> getListDataJenisPengajuan() {
        List<JenisPengajuanDto> ListDto = new ArrayList<>();
        List<JenisPengajuanModel> data = jenisPengajuanDao.getListDataJenisPengajuan();
        if(data != null){
            for (JenisPengajuanModel ddm : data) {
                JenisPengajuanDto dto = new JenisPengajuanDto();
                if(ddm.getKdjenispengajuan()!= null){
                    dto.setKdjenispengajuan(ddm.getKdjenispengajuan());
                }
                if(ddm.getNamajenispengajuan() != null){
                    dto.setNamajenispengajuan(ddm.getNamajenispengajuan());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }

    @Override
    public void deleteDataJenisPengajuan(String kdjenispengajuan) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JenisPengajuanModel getJenisPengajuanById(String kdjenispengajuan) {
        JenisPengajuanModel jenisPengajuanModel = null;
        try {
            jenisPengajuanModel = jenisPengajuanDao.getJenisPengajuanById(kdjenispengajuan);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jenisPengajuanModel;
    }

    @Override
    public String getNamaJenisPengajuan(String kdjenispengajuan) {
        JenisPengajuanModel jenisPengajuanModel = null;
        String tamp="";
        try {
            jenisPengajuanModel = jenisPengajuanDao.getJenisPengajuanById(kdjenispengajuan);
            tamp= jenisPengajuanModel.getNamajenispengajuan();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tamp;
    }
    
    @Override
    public List<ViewPengajuanSidangDosenDto> getListPengajuanSidang(ViewPengajuanSidangDosenDto dataFilter) {
        
         String filterPengajuan=dataFilter.getKdproposal();
         String filterjurusan=dataFilter.getKdjurusan();
         Integer filterAngkatan=(dataFilter.getAngkatan());
         String pengajuan="";
         
         if(filterPengajuan.equals("1")){
             pengajuan = "Tugas Akhir";
         }else if(filterPengajuan.equals("2")){
             pengajuan= "Skripsi";
         }else if(filterPengajuan.equals("3")){
             pengajuan= "Usulan penelitian";
         }else if(filterPengajuan.equals("")){
             pengajuan= "";
         }
        
        List<ViewPengajuanSidangModel> dataList = jenisPengajuanDao.getListDataPengajuanSidang(pengajuan,filterjurusan,filterAngkatan);
        List<ViewPengajuanSidangDosenDto> ListData = new ArrayList<>();
        if(dataList != null){
            for (ViewPengajuanSidangModel ddm : dataList) { 
                ViewPengajuanSidangDosenDto dto= new ViewPengajuanSidangDosenDto();
                if(ddm.getNim()!= null){
                    dto.setNim((String) ddm.getNim());
                }
                if(ddm.getNamamahasiswa() !=null){
                    dto.setNamamahasiswa((String)ddm.getNamamahasiswa());
                }
                if(ddm.getJudulproposal() != null){
                    dto.setJudulproposal((String) ddm.getJudulproposal());
                }
                if(ddm.getNamajenispengajuan()!=null){
                    dto.setNamajenispengajuan((String) ddm.getNamajenispengajuan());
                }
                if(ddm.getTglpengajuansidang()!= null){
                    dto.setTglpengajuansidang((String) ddm.getTglpengajuansidang());
                }
                if(ddm.getTglsidang()!=null){
                    dto.setTglsidang((String) ddm.getTglsidang());
                }
                if(ddm.getPenelaah1()!= null){
                    dto.setPenelaah1((String) ddm.getPenelaah1());
                }
                if(ddm.getPenelaah2() !=null){
                    dto.setPenelaah2((String) ddm.getPenelaah2());
                }
                if(ddm.getNamajurusan() != null){
                    dto.setNamajurusan((String) ddm.getNamajurusan());
                }
                if(ddm.getWakilfakultas()!=null){
                    dto.setWakilfakultas((String) ddm.getWakilfakultas());
                }
                if(ddm.getJamsidang()!= null){
                    dto.setJamsidang((String) ddm.getJamsidang());
                }
                if(ddm.getRuangansidang()!=null){
                    dto.setRuangansidang((String) ddm.getRuangansidang());
                }
                ListData.add(dto);
            }
        }
        return ListData;
    }
    
}
