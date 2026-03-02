package lk.HotelMgmt.service.impl;

import lk.HotelMgmt.dto.AdminDTO;
import lk.HotelMgmt.dto.UserDTO;
import lk.HotelMgmt.service.UserService;
import lk.HotelMgmt.util.UtilData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void addUser(UserDTO userDTO) {
        userDTO.setUserId(UtilData.generateUserId());
    }

    @Override
    public void deleteUser(String userId) {

    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {

    }

    @Override
    public AdminDTO getSelectedUser(String userId) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }
}
