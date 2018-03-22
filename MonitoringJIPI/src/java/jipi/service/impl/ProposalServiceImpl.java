/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import jipi.dao.ProposalDao;
import jipi.dao.UserDao;
import jipi.dto.MahasiswaDto;
import jipi.dto.ProposalDto;
import jipi.dto.viewPengajuanProposalDto;
import jipi.model.JenisPengajuanModel;
import jipi.model.MahasiswaModel;
import jipi.model.ProposalModel;
import jipi.model.UserModel;
import jipi.model.viewDosenmodel;
import jipi.service.JenisPengajuanService;
import jipi.service.MahasiswaService;
import jipi.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class ProposalServiceImpl implements ProposalService{
    @Autowired
    ProposalDao proposalDao;
    
    @Autowired
    JenisPengajuanService jenisPengajuanService;
    
    @Autowired
    MahasiswaService mahasiswaService;
    
    @Autowired
    UserDao userDao;
    
    @Override
    public void saveDataProposal(ProposalDto proposalDto) throws Exception {
        ProposalModel dataModel = new ProposalModel();
        
        dataModel.setKdproposal("P"+generateKode());
        
        dataModel.setKdjenisproposal(proposalDto.getKdjenisproposal());
        
        dataModel.setNim(proposalDto.getNim());
        dataModel.setJudulproposal(proposalDto.getJudulproposal());
        dataModel.setPerubahanjudul(proposalDto.getPerubahanjudul());
        dataModel.setSkssudahtempuh(proposalDto.getSkssudahtempuh());
        dataModel.setSksproposal(proposalDto.getSksproposal());
        dataModel.setTglpengajuanproposal(proposalDto.getTglpengajuanproposal());
        dataModel.setIpk(proposalDto.getIpk());
        dataModel.setStatusproposal(proposalDto.getStatusproposal());
        dataModel.setDosenpembimbing(proposalDto.getDosenpembimbing());
        dataModel.setEmail(proposalDto.getEmail());
        proposalDao.saveDataProposal(dataModel);
    }

    @Override
    public List<ProposalDto> getListDataProposal() {
        List<ProposalDto> ListDto = new ArrayList<>();
        List<ProposalModel> data = proposalDao.getListDataProposal();
//        JenisPengajuanModel jm = null;
        
        if(data != null){
            for (ProposalModel ddm : data) {
                ProposalDto dto = new ProposalDto();
                JenisPengajuanModel jm = new JenisPengajuanModel();
                if(ddm.getKdproposal() != null){
                    dto.setKdproposal(ddm.getKdproposal());
                }
                if(ddm.getKdjenisproposal() !=null){
//                    jm = jenisPengajuanService.getJenisPengajuanById(dto.getKdjenisproposal());
                    jm = jenisPengajuanService.getJenisPengajuanById(ddm.getKdjenisproposal());
                    dto.setKdjenisproposal(jm.getNamajenispengajuan());
                    
//                    dto.setKdjenisproposal(ddm.getKdjenisproposal());
                }
                if(ddm.getNim() != null){
                    dto.setNim(ddm.getNim());
                }
                if(ddm.getJudulproposal() != null){
                    dto.setJudulproposal(ddm.getJudulproposal());
                }
                if(ddm.getPerubahanjudul() != null){
                    dto.setPerubahanjudul(ddm.getPerubahanjudul());
                }
                if(ddm.getSkssudahtempuh() != null){
                    dto.setSkssudahtempuh(ddm.getSkssudahtempuh());
                }
                if(ddm.getSksproposal() != null){
                    dto.setSksproposal(ddm.getSksproposal());
                }
                if(ddm.getTglpengajuanproposal() != null){
                    dto.setTglpengajuanproposal(ddm.getTglpengajuanproposal());
                }
//                if(ddm.getIpk() != null){
                    dto.setIpk(ddm.getIpk());
//                }
                if(ddm.getSksproposal() != null){
                    dto.setStatusproposal(ddm.getStatusproposal());
                }
                if(ddm.getDosenpembimbing() != null){
                    dto.setDosenpembimbing(ddm.getDosenpembimbing());
                }
                if(ddm.getEmail() != null){
                    dto.setEmail(ddm.getEmail());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }

    @Override
    public void deleteDataProposal(String kdproposal) throws Exception {
        try {
            proposalDao.deleteDataProposal(kdproposal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProposalModel getProposalById(String kdproposal) {
        ProposalModel proposalModel = null;
        try {
            proposalModel = proposalDao.getProposalById(kdproposal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return proposalModel;
    }

    @Override
    public ProposalDto updateDataForm(String kdproposal) throws Exception {
        List<ProposalModel> dataList = proposalDao.getListProposalUpdate(kdproposal);
         ProposalDto dto = new ProposalDto();
        if(dataList != null){
            for (ProposalModel ddm : dataList) {       
                if(ddm.getKdproposal() != null){
                    dto.setKdproposal(ddm.getKdproposal());
                }
                if(ddm.getKdjenisproposal() !=null){
                    dto.setKdjenisproposal(ddm.getKdjenisproposal());
                }
                if(ddm.getNim() != null){
                    dto.setNim(ddm.getNim());
                }
                if(ddm.getJudulproposal() != null){
                    dto.setJudulproposal(ddm.getJudulproposal());
                }
                if(ddm.getPerubahanjudul() != null){
                    dto.setPerubahanjudul(ddm.getPerubahanjudul());
                }
                if(ddm.getSkssudahtempuh() != null){
                    dto.setSkssudahtempuh(ddm.getSkssudahtempuh());
                }
                if(ddm.getSksproposal() != null){
                    dto.setSksproposal(ddm.getSksproposal());
                }
                if(ddm.getTglpengajuanproposal() != null){
                    dto.setTglpengajuanproposal(ddm.getTglpengajuanproposal());
                }
//                if(ddm.getIpk() != null){
                    dto.setIpk(ddm.getIpk());
//                }
                if(ddm.getSksproposal() != null){
                    dto.setStatusproposal(ddm.getStatusproposal());
                }
                if(ddm.getDosenpembimbing() != null){
                    dto.setEmail(ddm.getEmail());
                }
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataForm(ProposalDto proposalDto) throws Exception {
        ProposalModel ddm = new ProposalModel();
        try {
        
            ddm.setKdproposal(proposalDto.getKdproposal());
            ddm.setKdjenisproposal(proposalDto.getKdjenisproposal());
            ddm.setNim(proposalDto.getNim());
            ddm.setJudulproposal(proposalDto.getJudulproposal());
            ddm.setSkssudahtempuh(proposalDto.getSkssudahtempuh());
            ddm.setSksproposal(proposalDto.getSksproposal());
            ddm.setTglpengajuanproposal(proposalDto.getTglpengajuanproposal());
            ddm.setIpk(proposalDto.getIpk());
            ddm.setStatusproposal(proposalDto.getStatusproposal());
            ddm.setDosenpembimbing(proposalDto.getDosenpembimbing());
            ddm.setEmail(proposalDto.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
        proposalDao.updateProposal(ddm);
    }

    @Override
    public void createAkun(ProposalDto proposalDto) {
        UserModel dataModel = new UserModel();
        dataModel.setKduser("1000");
        MahasiswaModel mh = mahasiswaService.getMahasiswaById(proposalDto.getNim());
        dataModel.setUsername(mh.getNamamahasiswa().replaceAll(" ", "_"));
        dataModel.setPassword(mh.getNim());
        dataModel.setAkses("3");
        dataModel.setNim(mh.getNim());
        dataModel.setNip("");
        dataModel.setKeterangan("mahasiswa");
        userDao.saveDataUser(dataModel);
    }

    @Override
    public List<ProposalDto> searchProposal(String cariBerdasarkan, String cariKey) {
        List<ProposalDto> listProposalDto = new ArrayList();
        List<Object[]> listDataObject = proposalDao.getListCariDataProposalNativeQuery(cariBerdasarkan, cariKey);
        if (listDataObject != null){
            for (Object[] object : listDataObject){
                ProposalDto dto = new ProposalDto();
                JenisPengajuanModel jm = new JenisPengajuanModel();
                if (object[0] != null){
                    dto.setKdproposal(object[0].toString());
                }
                if (object[1] != null){
                    dto.setKdjenisproposal(object[1].toString());
                    jm = jenisPengajuanService.getJenisPengajuanById(object[1].toString());
                    dto.setKdjenisproposal(jm.getNamajenispengajuan());
                }
                if (object[2] != null){
                    dto.setNim(object[2].toString());
                }
                if (object[3] != null){
                    dto.setJudulproposal(object[3].toString());
                }
                if (object[4] != null){
                    dto.setPerubahanjudul(object[4].toString());
                }
                if (object[5] != null){
                    dto.setSkssudahtempuh(Integer.parseInt(object[5].toString()));
                }
                if (object[6] != null){
                    dto.setSksproposal(Integer.parseInt(object[6].toString()));
                }
                if (object[7] != null){
                    dto.setTglpengajuanproposal(object[7].toString());
                }
                if (object[8] != null){
                    dto.setIpk(Double.parseDouble(object[8].toString()));
                }
                if (object[9] != null){
                    dto.setStatusproposal(object[9].toString());
                }
                if (object[10] != null){
                    dto.setDosenpembimbing(object[10].toString());
                }
                if (object[11] != null){
                    dto.setEmail(object[11].toString());
                }
                
                
                listProposalDto.add(dto);
            }
        }
        return listProposalDto;
    }

    @Override
    public List<ProposalDto> getListDataProposalByFilterForReport(String fakultas_filter, String jurusan_filter, String jenis_filter, String angkatan_filter) {
        List<ProposalDto> listProposalDto = new ArrayList();
        List<Object[]> listDataObject = proposalDao.getListDataProposalForReport(fakultas_filter, jurusan_filter, jenis_filter, angkatan_filter);
        if (listDataObject != null){
            for (Object[] object : listDataObject){
                ProposalDto dto = new ProposalDto();
                JenisPengajuanModel jm = new JenisPengajuanModel();
                MahasiswaModel mm = new MahasiswaModel();
                if (object[0] != null){
                    dto.setKdproposal(object[0].toString());
                }
                if (object[1] != null){
                    dto.setKdjenisproposal(object[1].toString());
                    jm = jenisPengajuanService.getJenisPengajuanById(object[1].toString());
                    dto.setKdjenisproposal(jm.getNamajenispengajuan());
                }
                if (object[2] != null){
                    dto.setNim(object[2].toString());
                }
                if (object[3] != null){
                    dto.setJudulproposal(object[3].toString());
                }
                if (object[4] != null){
                    dto.setPerubahanjudul(object[4].toString());
                    try {
                        mm = mahasiswaService.getMahasiswaById(object[2].toString());
                    } catch (Exception ex) {
                        Logger.getLogger(ProposalServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dto.setPerubahanjudul(mm.getNamamahasiswa());
                }else{
                   mm = mahasiswaService.getMahasiswaById(object[2].toString());
                   dto.setPerubahanjudul(mm.getNamamahasiswa());
                }
                
                if (object[5] != null){
                    dto.setSkssudahtempuh(Integer.parseInt(object[5].toString()));
                }
                if (object[6] != null){
                    dto.setSksproposal(Integer.parseInt(object[6].toString()));
                }
                if (object[7] != null){
                    dto.setTglpengajuanproposal(object[7].toString());
                }
                if (object[8] != null){
                    dto.setIpk(Double.parseDouble(object[8].toString()));
                }
                if (object[9] != null){
                    dto.setStatusproposal(object[9].toString());
                }
                if (object[10] != null){
                    dto.setDosenpembimbing(object[10].toString());
                }
                if (object[11] != null){
                    dto.setEmail(object[11].toString());
                }
                listProposalDto.add(dto);
            }
        }
        return listProposalDto;
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
    
    @Override
    public List<viewPengajuanProposalDto> getDataForViewProposal(viewPengajuanProposalDto dataParam) {
         String filterPengajuan=dataParam.getJenisPengajuan();
         String filterjurusan=dataParam.getJurusan();
         Integer filterAngkatan=Integer.parseInt(dataParam.getAngkatan());
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
         
         List<viewDosenmodel> dataList = proposalDao.getListViewDataProposal(pengajuan,filterjurusan,filterAngkatan);
         List<viewPengajuanProposalDto> ListData = new ArrayList<>();
        if(dataList != null){
            for (viewDosenmodel ddm : dataList) { 
                viewPengajuanProposalDto dto= new viewPengajuanProposalDto();
                if(ddm.getNim()!= null){
                    dto.setNim((String) ddm.getNim());
                }
                if(ddm.getNamamahasiswa() !=null){
                    dto.setNama((String)ddm.getNamamahasiswa());
                }
                if(ddm.getJudulproposal() != null){
                    dto.setJudul((String) ddm.getJudulproposal());
                }
                if(ddm.getNamajenispengajuan()!=null){
                    dto.setJenisPengajuan((String) ddm.getNamajenispengajuan());
                }
                if(ddm.getPerubahanjudul() != null){
                    dto.setPerubahanJudul((String) ddm.getPerubahanjudul());
                }
                if(ddm.getSkssudahtempuh() !=null){
                    dto.setSks((Integer) ddm.getSkssudahtempuh());
                }
                if(ddm.getTglpengajuanproposal() != null){
                    dto.setTglPengajuan((String) ddm.getTglpengajuanproposal());
                }
                if(ddm.getDosenpembimbing() !=null){
                    dto.setPembimbing((String) ddm.getDosenpembimbing());
                }
                if(ddm.getNamajurusan() != null){
                    dto.setJurusan((String) ddm.getNamajurusan());
                }
                if(ddm.getNamafakultas() !=null){
                    dto.setFakultas((String) ddm.getNamafakultas());
                }
                ListData.add(dto);
            }
        }
        return ListData;
    }
}
