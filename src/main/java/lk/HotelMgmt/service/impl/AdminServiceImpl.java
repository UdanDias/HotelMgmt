package lk.HotelMgmt.service.impl;

import jakarta.transaction.Transactional;
import lk.HotelMgmt.dao.AdminDao;
import lk.HotelMgmt.dao.UserDao;
import lk.HotelMgmt.dto.AdminDTO;
import lk.HotelMgmt.entity.AdminEntity;
import lk.HotelMgmt.entity.UserEntity;
import lk.HotelMgmt.exceptions.AdminNotFoundException;
import lk.HotelMgmt.exceptions.UserNotFoundException;
import lk.HotelMgmt.service.AdminService;
import lk.HotelMgmt.util.EntityDTOConvert;
import lk.HotelMgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AdminServiceImpl implements AdminService {
    private final AdminDao adminDao;
    private final EntityDTOConvert entityDTOConvert;
    private final UserDao userDao;

    @Override
    public void addAdmin(AdminDTO adminDTO) {

//        UserEntity user = userDao.findById(adminDTO.getUserId()).orElseThrow(()->new UserNotFoundException("User not found"));
        adminDTO.setAdminId(UtilData.generateAdminId());

        AdminEntity adminEntity=entityDTOConvert.convertAdminDTOToAdminEntity(adminDTO);
//        adminEntity.setUser(user);
        adminDao.save(adminEntity);
    }

    @Override
    public void deleteAdmin(String adminId) {
       AdminEntity adminEntity= adminDao.findById(adminId).orElseThrow(()-> new AdminNotFoundException("Admin not found"));
        adminDao.delete(adminEntity);

    }

    @Override
    public void updateAdmin(String adminId, AdminDTO adminDTO) {
        AdminEntity adminEntity =adminDao.findById(adminId).orElseThrow(()-> new AdminNotFoundException("Admin not found"));
        adminEntity.setAdminName(adminDTO.getAdminName());
        adminEntity.setPhone(adminDTO.getPhone());
        adminDao.save(adminEntity);


    }

    @Override
    public AdminDTO getSelectedAdmin(String adminId) {
        return entityDTOConvert.convertAdminEntityToAdminDTO(adminDao.findById(adminId).orElseThrow(()-> new AdminNotFoundException("Admin not found")));

    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        return entityDTOConvert.convertAdminEntityListToAdminDTOList(adminDao.findAll());
    }
}
