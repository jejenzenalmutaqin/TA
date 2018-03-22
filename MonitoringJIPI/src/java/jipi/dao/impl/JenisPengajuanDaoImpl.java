/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.JenisPengajuanDao;
import jipi.model.JenisPengajuanModel;
import jipi.model.ViewPengajuanSidangModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class JenisPengajuanDaoImpl extends HibernateUtil implements JenisPengajuanDao{

    @Override
    public void saveDataJenisPengajuan(JenisPengajuanModel jenisPengajuanModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<JenisPengajuanModel> getListDataJenisPengajuan() {
        List<JenisPengajuanModel> dataList = null;
        String sql = "select model from JenisPengajuanModel model";
        Query query = createQuery(sql);        
        dataList = query.list();
        return dataList;
    }

    @Override
    public void deleteDataJenisPengajuan(String kdjenispengajuan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JenisPengajuanModel getJenisPengajuanById(String kdjenispengajuan) throws Exception {
        JenisPengajuanModel jenispengajuan = new JenisPengajuanModel();
        Query query = null;
        try {
            String sql = "select model from JenisPengajuanModel model where kdjenispengajuan=:kdjenispengajuan";
            query = createQuery(sql).setParameter("kdjenispengajuan", kdjenispengajuan);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (JenisPengajuanModel) query.uniqueResult(); 
    }
    
    @Override
    public List<ViewPengajuanSidangModel> getListDataPengajuanSidang(String kdjenis,String kdjurusan,Integer angkatan) {
        List<ViewPengajuanSidangModel> data=null;
        String sql="select mhs.nim,mhs.namamahasiswa,jenis.namajenispengajuan,proposal.judulproposal,sidang.*,jur.namajurusan " +
                    "from mst_mahasiswa mhs " +
                    "	inner join pengajuansidang_tbl sidang " +
                    "		on mhs.nim = sidang.nim " +
                    "	inner join mst_jurusan jur " +
                    "		on mhs.kdjurusan=jur.kdjurusan " +
                    "	inner join pengajuanproposal_tbl proposal " +
                    "		on proposal.kdproposal=sidang.kdproposal " +
                    "	inner join jenispengajuan_tbl jenis " +
                    "		on jenis.kdjenispengajuan=sidang.kdjenissidang " +
                    "		where  mhs.kdjurusan=? " +
                    "			and proposal.kdjenisproposal=? " +
                    "			and mhs.angkatan=?";
        Query query = createNativeQuery(sql).setString(0, kdjurusan)
                .setString(1, kdjenis)
                .setParameter(2, angkatan);        
        
        System.out.println("______________________+++++++++++-------------"+query.toString()+
                "--------------++++++++++++++++++++__________________________________");
        data = query.list();
        return data;
    }
}
