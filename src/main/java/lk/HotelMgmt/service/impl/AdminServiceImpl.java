package lk.HotelMgmt.service.impl;

import lk.HotelMgmt.dao.AdminDao;
import lk.HotelMgmt.dto.AdminDTO;
import lk.HotelMgmt.entity.AdminEntity;
import lk.HotelMgmt.exceptions.AdminNotFoundException;
import lk.HotelMgmt.service.AdminService;
import lk.HotelMgmt.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminDao adminDao;
    @Override
    public void addAdmin(AdminDTO adminDTO) {
        adminDTO.setAdminId(UtilData.generateAdminId());
        adminDTO.setUserId(adminDTO.getAdminId());
        adminDTO.setAdminName(adminDTO.getAdminName());
        adminDTO.setEmail(adminDTO.getEmail());
        adminDTO.setPhone(adminDTO.getPhone());
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
        adminEntity.setEmail(adminDTO.getEmail());
        adminEntity.setPhone(adminDTO.getPhone());
        adminDao.save(adminEntity);


    }

    @Override
    public AdminDTO getSelectedAdmin(String adminId) {
        return null;

    }

    @Override
    public List<AdminDTO> getAllAdmins() {
        return List.of();
    }
}
