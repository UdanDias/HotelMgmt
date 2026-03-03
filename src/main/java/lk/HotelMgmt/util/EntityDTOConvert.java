package lk.HotelMgmt.util;

import lk.HotelMgmt.dto.AdminDTO;
import lk.HotelMgmt.entity.AdminEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EntityDTOConvert {
    private final ModelMapper modelMapper;

    public AdminEntity convertAdminDTOToAdminEntity(AdminDTO adminDTO){
        return modelMapper.map(adminDTO, AdminEntity.class);
    }
    public AdminDTO convertAdminEntityToAdminDTO(AdminEntity adminEntity){
        return modelMapper.map(adminEntity, AdminDTO.class);
    }
    public List<AdminDTO> convertAdminEntityListToAdminDTOList(List<AdminEntity> adminEntityList){
        return modelMapper.map(adminEntityList, new TypeToken<AdminEntity>(){}.getType());
    }
}
