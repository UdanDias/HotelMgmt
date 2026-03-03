package lk.HotelMgmt.service.impl;

import lk.HotelMgmt.dao.AdminDao;
import lk.HotelMgmt.dto.AdminDTO;
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
        adminDao.findById(adminId).orElseThrow(()-> new AdminNotFoundException("Admin not found"));
        adminDao.deleteById(adminId);

    }

    @Override
    public void updateAdmin(String adminId, AdminDTO adminDTO) {

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
