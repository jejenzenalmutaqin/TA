/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao.impl;

import java.util.List;
import jipi.dao.UserDao;
import jipi.model.UserModel;
import org.hibernate.Query;

/**
 *
 * @author hp
 */
public class UserDaoImpl extends HibernateUtil implements UserDao{

    @Override
    public void saveDataUser(UserModel userModel) {
        getSession().save(userModel);
    }

    @Override
    public List<UserModel> getListDataUser() {
        List<UserModel> dataList = null;
        String sql = "select model from UserModel model";
        Query query = createQuery(sql);        
        dataList = query.list();
        return dataList;
    }

    @Override
    public void deleteDataUser(String kduser) {
        UserModel ddm = new UserModel();
        ddm.setKduser(kduser);
        getSession().delete(ddm);
    }

    @Override
    public UserModel getUserById(String kduser) throws Exception {
        UserModel user = new UserModel();
        Query query = null;
        try {
            String sql = "select model from UserModel model where kduser=:kduser";
            query = createQuery(sql).setParameter("kduser", kduser);                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (UserModel) query.uniqueResult(); 
    }

    @Override
    public List<UserModel> getListUserUpdate(String kduser) {
        List<UserModel> dataList = null;
        String sql = "select model from UserModel model where kduser=:kduseredit";
        Query query = createQuery(sql).setParameter("kduseredit", kduser);
        dataList = query.list();
        return dataList;
    }

    @Override
    public void updateUser(UserModel userModel) {
        getSession().saveOrUpdate(userModel);
    }

    @Override
    public String getLastNumberUser() {
        String sql = "select count(*) from UserModel model";
        Query query = createQuery(sql);
        return query.getQueryString();
    }

    @Override
    public List<UserModel> getListCariDataUser(String txt) {
        List<UserModel> dataList = null;
        String sql = "select kduser, username, password, akses, nim, nip, keterangan from user_tbl where kduser like '%"+txt+"%' or username like '%"+txt+"%' or password like '%"+txt+"%' or nip like '%"+txt+"%' or nim like '%"+txt+"%' or keterangan like '%"+txt+"%'";
        Query query = createQuery(sql); 
        dataList = query.list();
        return dataList;
    }

    @Override
    public List<Object[]> getListCariDataUserNativeQuery(String cariBerdasarkan, String cariKey) {
        List<Object[]> dataList = null;
//        String sql = "select kduser, username, password, akses, nim, nip, keterangan from user_tbl where kduser like '%"+cariKey+"%' or username like '%"+cariKey+"%' or password like '%"+cariKey+"%' or nip like '%"+cariKey+"%' or nim like '%"+cariKey+"%' or keterangan like '%"+cariKey+"%'";
        String sql="select kduser, username, password, akses, nim, nip, keterangan from user_tbl ";
        String where="";
        if(cariBerdasarkan.equals("1")){
            where = "where kduser like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("2")){
            where = "where username like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("3")){
            where = "where nim like '%"+cariKey+"%' or nip like '%"+cariKey+"%'";
        }else if(cariBerdasarkan.equals("4")){
            where = "where akses = '1' ";
        }else if(cariBerdasarkan.equals("5")){
            where = "where akses = '2' ";
        }else if(cariBerdasarkan.equals("6")){
            where = "where akses = '3' ";
        }else if(cariBerdasarkan.equals("7")){
            where = "where akses = '4' ";
        }else if(cariBerdasarkan.equals("8")){
            where = "where akses = '5' ";
        }else if(cariBerdasarkan.equals("9")){
            where = "where akses = '6' ";
        }else if(cariBerdasarkan.equals("10")){
            where = " ";
        }
        sql = sql + where;
        Query query = createNativeQuery(sql);
        dataList = query.list();
        return dataList;
    }
    
}
