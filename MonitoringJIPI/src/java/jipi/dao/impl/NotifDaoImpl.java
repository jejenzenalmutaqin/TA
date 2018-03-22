/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.NotifDao;
import jipi.model.NotifModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class NotifDaoImpl extends HibernateUtil implements NotifDao{

    @Override
    public List<Object[]> getListNotifNativeQuery(String nim) {
        List<Object[]> dataList = null;
        String sql="select kdnotif, kdakses, nim, tglnotif, judulnotif, isinotif, subjeknotif, statusbaca from notif_tbl where nim='"+nim+"' order by tglnotif desc";
        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }

    @Override
    public List<Object[]> getListNotifByKodeNatifNativeQuery(String kdnotif) {
        List<Object[]> dataList = null;
        String sql="select kdnotif, kdakses, nim, tglnotif, judulnotif, isinotif, subjeknotif, statusbaca from notif_tbl where kdnotif='"+kdnotif+"'";
        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }

    @Override
    public void updateNotif(NotifModel notifModel) {
        getSession().saveOrUpdate(notifModel);
    }

    @Override
    public void deleteNotif(String kdnotif) {
        NotifModel ddm = new NotifModel();
        ddm.setKdnotif(kdnotif);
        getSession().delete(ddm);
    }

    @Override
    public List<Object[]> getListCariDataMahasiswaNativeQuery(String nim) {
        List<Object[]> dataList = null;
        String sql = "select nim, namamahasiswa from mst_mahasiswa where namamahasiswa like '%"+nim+"%' or nim like '%"+nim+"%'";
        
        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }

    @Override
    public void saveDataNotif(NotifModel notifModel) {
        getSession().save(notifModel);
    }

    
    
}
