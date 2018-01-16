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
    
}
