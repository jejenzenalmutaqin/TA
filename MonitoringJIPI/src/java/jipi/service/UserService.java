/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service;

import java.util.List;
import jipi.dto.UserDto;
import jipi.model.UserModel;

/**
 *
 * @author hp
 */
public interface UserService {
    public void saveDataUser(UserDto userDto) throws Exception;
    public List<UserDto> getListDataUser();
    public void deleteDataUser(String kduser) throws Exception;
    public UserModel getUserById(String kduser);
    public UserDto updateDataForm(String kduser) throws Exception;
    public void doUpdateDataForm(UserDto userDto) throws Exception;
    public List<UserDto> searchUser(String cariBerdasarkan, String cariKey);
    public List<Object[]> getCountUsernameService(String username);
    public List<Object[]> getCountUsernameAndPasswordService(String username, String password);
    public List<Object[]> getCountUsernameAndPasswordAndAksesService(String username, String password, String akses);
    public List<UserDto> getListDataUserByLogin(String username, String password, String akses);
    public UserDto updateDataFormMhs(String nim) throws Exception;
    public void doUpdateDataFormMhs(UserDto userDto) throws Exception;
    public List<UserDto> saveDataUserOtomatis(String nim, String nama) throws Exception;
    
}
