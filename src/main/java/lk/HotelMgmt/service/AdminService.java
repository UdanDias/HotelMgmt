package lk.HotelMgmt.service;

import lk.HotelMgmt.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    void addAdmin(AdminDTO adminDTO);
    void deleteAdmin(String adminId);
    void updateAdmin(String adminId,AdminDTO adminDTO);
    AdminDTO getSelectedAdmin(String adminId);
    List<AdminDTO> getAllAdmins();
}
