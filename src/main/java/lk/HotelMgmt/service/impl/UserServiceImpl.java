package lk.HotelMgmt.service.impl;

import jakarta.transaction.Transactional;
import lk.HotelMgmt.dao.UserDao;
import lk.HotelMgmt.dto.AdminDTO;
import lk.HotelMgmt.dto.UserDTO;
import lk.HotelMgmt.entity.UserEntity;
import lk.HotelMgmt.service.UserService;
import lk.HotelMgmt.util.EntityDTOConvert;
import lk.HotelMgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final EntityDTOConvert entityDTOConvert;


    @Override
    public void addUser(UserDTO userDTO) {
        userDTO.setUserId(UtilData.generateUserId());
        var userEntity = entityDTOConvert.convertUserDTOToUserEntity(userDTO);
        userDao.save(userEntity);
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
