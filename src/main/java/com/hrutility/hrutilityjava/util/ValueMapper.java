package com.hrutility.hrutilityjava.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrutility.hrutilityjava.dto.HallRequestDTO;
import com.hrutility.hrutilityjava.dto.HallResponseDTO;
import com.hrutility.hrutilityjava.entity.HallEntity;

public class ValueMapper {
    public static HallEntity convertToEntity(HallRequestDTO hallRequestDTO){
        HallEntity hall = new HallEntity();
        hall.setName(hallRequestDTO.getName());
        hall.setDescription(hallRequestDTO.getDescription());
        hall.setImage(hallRequestDTO.getImage());
        return hall;
    }

    public static HallResponseDTO convertToDTO(HallEntity hall){
        HallResponseDTO hallResponseDTO = new HallResponseDTO();
        hallResponseDTO.setId(hall.getId());
        hallResponseDTO.setName(hall.getName());
        hallResponseDTO.setDescription(hall.getDescription());
        hallResponseDTO.setImage(hall.getImage());
        return hallResponseDTO;
    }

    public static String jsonAsString(Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return null;
    }
}
