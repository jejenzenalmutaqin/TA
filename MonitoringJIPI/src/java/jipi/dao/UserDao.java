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
    public List<UserModel> getListCariDataUser(String txt);
    public void deleteDataUser(String kduser);
    public UserModel getUserById(String kduser) throws Exception;
    public List<UserModel> getListUserUpdate(String kduser);
    public void updateUser(UserModel userModel);
    public String getLastNumberUser();
    public List<Object[]> getListCariDataUserNativeQuery(String cariBerdasarkan, String cariKey);
    public List<Object[]> getCountUsername(String username);
    public List<Object[]> getCountUsernameAndPassword(String username, String password);
    public List<Object[]> getCountUsernameAndPasswordAndAkses(String username, String password, String akses);
    public List<Object[]> getListDataUserByLogin(String username, String password, String akses);
    public List<UserModel> getListUserUpdateMhs(String kduser);
    public void updateUserMhs(UserModel userModel);
}
