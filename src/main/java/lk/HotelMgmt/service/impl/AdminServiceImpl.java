package lk.HotelMgmt.service.impl;

import lk.HotelMgmt.dto.AdminDTO;
import lk.HotelMgmt.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public void addAdmin(AdminDTO adminDTO) {

    }

    @Override
    public void deleteAdmin(String adminId) {

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
