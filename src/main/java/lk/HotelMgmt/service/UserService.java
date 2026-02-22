package lk.HotelMgmt.service;

import lk.HotelMgmt.dto.AdminDTO;
import lk.HotelMgmt.dto.UserDTO;

import java.util.List;

public interface UserService {
    void addUser(UserDTO userDTO);
    void deleteUser(String userId);
    void updateUser(String userId,UserDTO userDTO);
    AdminDTO getSelectedUser(String userId);
    List<UserDTO> getAllUsers();
}


