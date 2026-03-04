package lk.HotelMgmt.service.impl;

import jakarta.transaction.Transactional;
import lk.HotelMgmt.dao.UserDao;
import lk.HotelMgmt.dto.AdminDTO;
import lk.HotelMgmt.dto.UserDTO;
import lk.HotelMgmt.entity.UserEntity;
import lk.HotelMgmt.exceptions.UserNotFoundException;
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
        UserEntity userEntity=userDao.findById(userId).orElseThrow(()->new UserNotFoundException("User not found"));
        userDao.delete(userEntity);

    }

    @Override
    public void updateUser(String userId, UserDTO userDTO) {
        UserEntity userEntity = userDao.findById(userId).orElseThrow(()->new UserNotFoundException("User not found"));
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setEmail(userDTO.getEmail());


    }

    @Override
    public UserDTO getSelectedUser(String userId) {
        UserEntity userEntity = userDao.findById(userId).orElseThrow(()->new UserNotFoundException("User not found"));
        return entityDTOConvert.convertUserEntityToUserDTO(userEntity);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return List.of();
    }
}
