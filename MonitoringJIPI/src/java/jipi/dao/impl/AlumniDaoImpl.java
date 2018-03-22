/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.AlumniDao;
import jipi.model.AlumniModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class AlumniDaoImpl extends HibernateUtil implements AlumniDao {

    @Override
    public void saveDataAlumni(AlumniModel alumniModel) {
        getSession().save(alumniModel);
    }

    @Override
    public List<AlumniModel> getListDataAlumni() {
        List<AlumniModel> dataList = null;
        String sql = "select model from AlumniModel model";
        Query query = createQuery(sql);
        dataList = query.list();
        return dataList;
    }

    @Override
    public void deleteDataAlumni(String kdalumni) {
        AlumniModel ddm = new AlumniModel();
        ddm.setKdalumni(kdalumni);
        getSession().delete(ddm);
    }

    @Override
    public AlumniModel getAlumniById(String kdalumni) throws Exception {
        AlumniModel alumni = new AlumniModel();
        Query query = null;
        try {
            String sql = "select model from AlumniModel model where kdalumni=:kdalumni";
            query = createQuery(sql).setParameter("kdalumni", kdalumni);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (AlumniModel) query.uniqueResult();
    }

    @Override
    public List<AlumniModel> getListAlumniUpdate(String kdalumni) {
        List<AlumniModel> dataList = null;
        String sql = "select model from AlumniModel model where kdalumni=:kdalumniedit";
        Query query = createQuery(sql).setParameter("kdalumniedit", kdalumni);
        dataList = query.list();
        return dataList;
    }

    @Override
    public void updateAlumni(AlumniModel alumniModel) {
        getSession().saveOrUpdate(alumniModel);
    }

    @Override
    public List<Object[]> getListCariDataAlumniNativeQuery(String cariBerdasarkan, String cariKey) {
        List<Object[]> dataList = null;
        String sql = "select * from alumni_tbl ";
        String where = "";
        if (cariBerdasarkan.equals("1")) {
            where = "where kdalumni like '%" + cariKey + "%'";
        } else if (cariBerdasarkan.equals("2")) {
            where = "where nim like '%" + cariKey + "%'";
        } else if (cariBerdasarkan.equals("3")) {
            where = "where nim in (select nim from mst_mahasiswa where namamahasiswa like '%" + cariKey + "%')";
        } else if (cariBerdasarkan.equals("4")) {
            where = "where kdkelulusan like '%" + cariKey + "%'";
        } else if (cariBerdasarkan.equals("5")) {
            where = "where daerahkerja like '%" + cariKey + "%'";
        } else if (cariBerdasarkan.equals("6")) {
            where = "where sektor like '%" + cariKey + "%'";
        } else if (cariBerdasarkan.equals("7")) {
            where = "where profesi like '%" + cariKey + "%'";
        } else if (cariBerdasarkan.equals("8")) {
            where = " ";
        }
        sql = sql + where;
        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }

    @Override
    public List<Object[]> getListDataAlumniNativeQuery(String kdalumni) {
        List<Object[]> dataList = null;
        String sql = "SELECT a.kdalumni, a.nim, a.kdkelulusan,a.perusahaan, a.alamatperusahaan, a.daerahkerja, a.sektor,a.profesi,a.testimoni,a.foto, f.*, j.kdjurusan,j.namajurusan, m.namamahasiswa , m.daerahasal,m.tempatlahir, m.tgllahir \n"
                + "FROM alumni_tbl a INNER JOIN mst_fakultas f INNER JOIN mst_jurusan j INNER JOIN mst_mahasiswa m \n"
                + "ON a.nim=m.nim AND m.kdjurusan=j.kdjurusan AND j.kdfakultas=f.kdfakultas AND a.kdalumni='" + kdalumni + "'";

        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }

    @Override
    public List<Object[]> getListCariDataAlumniByJurusan(String fakultas, String jurusan, String angkatan) {
        List<Object[]> dataList = null;
        String fakultaswhere = "";
        String jurusanwhere = "";
        String angkatanwhere = "";
        
        if(fakultas.equals("0")){
            fakultaswhere = " ";
        }else{
            fakultaswhere = " AND fak.kdfakultas='"+fakultas+"'";
        }
        if(jurusan.equals("0")){
            jurusanwhere = " ";
        }else{
            jurusanwhere = " AND m.kdjurusan = '"+jurusan+"'";
        }
        if(angkatan.equals("0")){
            angkatanwhere = " ";
        }else{
            angkatanwhere = " AND m.angkatan = '"+angkatan+"'";
        }
        String sql = "SELECT a.* FROM alumni_tbl a INNER JOIN mst_mahasiswa m \n"
                + "INNER JOIN mst_fakultas fak INNER JOIN mst_jurusan jur \n"
                + "ON a.nim = m.nim AND m.kdjurusan = jur.kdjurusan AND jur.kdfakultas = fak.kdfakultas \n"
                + jurusanwhere+fakultaswhere+angkatanwhere;
        System.out.println(sql);
        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }

    @Override
    public List<Object[]> getListDataAlumniForReport(String fakultas_filter, String jurusan_filter, String angkatan_filter) {
        List<Object[]> dataList = null;
        String sql = "select p.kdalumni, p.nim, p.kdkelulusan, p.perusahaan, p.alamatperusahaan, p.daerahkerja, p.sektor, p.profesi, p.testimoni, p.tglmulaikerja, p.emailperusahaan, p.integritas, p.keahlian, p.inggris, p.teknologi, p.komunikasi, p.kerjasama,p.pengembangan from alumni_tbl p inner join mst_mahasiswa m inner join mst_jurusan j inner join mst_fakultas f \n" +
                     "on p.nim = m.nim and m.kdjurusan = j.kdjurusan and j.kdfakultas = f.kdfakultas ";
        String where="";
        if(fakultas_filter.equals("seluruh")){
            where =" ";
        }else{
            where = " and j.kdfakultas='"+fakultas_filter+"' ";
            sql = sql + where;
        }
        if(jurusan_filter.equals("seluruh")){
            where =" ";
        }else{
            where = " and m.kdjurusan='"+jurusan_filter+"' ";
            sql = sql + where;
        }
        if(angkatan_filter.equals("seluruh")){
            where =" ";
        }else{
            where = " and m.angkatan='"+angkatan_filter+"' ";
            sql = sql + where;
        }
        sql = sql + where;
        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }
}
