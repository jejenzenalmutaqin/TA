/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jipi.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import jipi.dao.UserDao;
import jipi.dto.UserDto;
import jipi.model.UserModel;
import jipi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    
    @Override
    public void saveDataUser(UserDto userDto) throws Exception {
        UserModel dataModel = new UserModel();
        dataModel.setKduser(userDto.getKduser());
        dataModel.setUsername(userDto.getUsername());
        dataModel.setPassword(userDto.getPassword());
        dataModel.setAkses(userDto.getAkses());
        dataModel.setNim(userDto.getNim());
        dataModel.setNip(userDto.getNip());
        dataModel.setKeterangan(userDto.getKeterangan());
        userDao.saveDataUser(dataModel);
    }

    @Override
    public List<UserDto> getListDataUser() {
        List<UserDto> ListDto = new ArrayList<>();
        List<UserModel> data = userDao.getListDataUser();
        if(data != null){
            for (UserModel ddm : data) {
                UserDto dto = new UserDto();
                if(ddm.getKduser() != null){
                    dto.setKduser(ddm.getKduser());
                }
                if(ddm.getUsername() != null){
                    dto.setUsername(ddm.getUsername());
                }
                if(ddm.getPassword() != null){
                    dto.setPassword(ddm.getPassword());
                }
                if(ddm.getAkses() != null){
                    dto.setAkses(ddm.getAkses());
                }
                if(ddm.getNim() != null){
                    dto.setNim(ddm.getNim());
                }
                if(ddm.getNip() != null){
                    dto.setNip(ddm.getNip());
                }
                if(ddm.getKeterangan() != null){
                    dto.setKeterangan(ddm.getKeterangan());
                }
                ListDto.add(dto);
            }
        }
        return ListDto;
    }

    @Override
    public void deleteDataUser(String kduser) throws Exception {
        try {
            userDao.deleteDataUser(kduser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserModel getUserById(String kduser) {
        UserModel userModel = null;
        try {
            userModel = userDao.getUserById(kduser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userModel;
    }

    @Override
    public UserDto updateDataForm(String kduser) throws Exception {
        List<UserModel> dataList = userDao.getListUserUpdate(kduser);
         UserDto dto = new UserDto();
        if(dataList != null){
            for (UserModel ddm : dataList) {  
                if(ddm.getKduser() != null){
                    dto.setKduser(ddm.getKduser());
                }
                if(ddm.getUsername() != null){
                    dto.setUsername(ddm.getUsername());
                }
                if(ddm.getPassword() != null){
                    dto.setPassword(ddm.getPassword());
                }
                if(ddm.getAkses() != null){
                    dto.setAkses(ddm.getAkses());
                }
                if(ddm.getNim() != null){
                    dto.setNim(ddm.getNim());
                }
                if(ddm.getNip() != null){
                    dto.setNip(ddm.getNip());
                }
                if(ddm.getKeterangan() != null){
                    dto.setKeterangan(ddm.getKeterangan());
                }
                
            }
        }
        return dto;
    }

    @Override
    public void doUpdateDataForm(UserDto userDto) throws Exception {
        UserModel ddm = new UserModel();
        try {
            ddm.setKduser(userDto.getKduser());
            ddm.setUsername(userDto.getUsername());
            ddm.setPassword(userDto.getPassword());
            ddm.setAkses(userDto.getAkses());
            ddm.setNim(userDto.getNim());
            ddm.setNip(userDto.getNip());
            ddm.setKeterangan(userDto.getKeterangan());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        userDao.updateUser(ddm);
    }
    
}
