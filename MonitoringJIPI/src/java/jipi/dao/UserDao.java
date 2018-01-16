/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.dao;

import java.util.List;
import jipi.model.UserModel;

/**
 *
 * @author hp
 */
public interface UserDao {
    public void saveDataUser(UserModel userModel);
    public List<UserModel> getListDataUser();
    public void deleteDataUser(String kduser);
    public UserModel getUserById(String kduser) throws Exception;
    public List<UserModel> getListUserUpdate(String kduser);
    public void updateUser(UserModel userModel);
}