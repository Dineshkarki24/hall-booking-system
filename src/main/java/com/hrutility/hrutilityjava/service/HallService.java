package com.hrutility.hrutilityjava.service;

import com.hrutility.hrutilityjava.dto.HallRequestDTO;
import com.hrutility.hrutilityjava.dto.HallResponseDTO;
import com.hrutility.hrutilityjava.entity.HallEntity;
import com.hrutility.hrutilityjava.exception.HallServiceBusinessExecption;
import com.hrutility.hrutilityjava.repository.HallRepository;
import com.hrutility.hrutilityjava.util.FileUploadUtil;
import com.hrutility.hrutilityjava.util.ValueMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class HallService {

    private HallRepository hallRepository;

    public HallResponseDTO createHall(HallRequestDTO hallRequestDTO)  throws HallServiceBusinessExecption{
        HallResponseDTO hallResponseDTO;

        try {
            log.info("HallService.createHall execution start");
            HallEntity hall = ValueMapper.convertToEntity(hallRequestDTO);
            log.debug("hallService.createNewHall request parameters {}", ValueMapper.jsonAsString(hallRequestDTO));
            String fileName = FileUploadUtil.saveFile("hall",hallRequestDTO.getMultipartFile());
            hall.setImage(fileName);
            HallEntity hallCreatedData = hallRepository.save(hall);
            hallResponseDTO = ValueMapper.convertToDTO(hallCreatedData);
            log.debug("hallservice.createHall received response from database {}", ValueMapper.jsonAsString(hallRequestDTO));
        }catch (Exception ex){
            log.error("Exception occured while presisting hall to database, Exception message {}", ex.getMessage());
            throw new HallServiceBusinessExecption("Exception occured while create a new hall");
        }
        log.info("HallService.createHall execution ended");
        return hallResponseDTO;
    }

    @Cacheable(value = "hall_list")
    public List<HallResponseDTO> getHalls() throws HallServiceBusinessExecption {
        List<HallResponseDTO> hallResponseDTOs = null;

        try {
            log.info("HallService excution started.");
            List<HallEntity> hallList = hallRepository.findAll();
            if (!hallList.isEmpty()) {
            hallResponseDTOs = hallList.stream().map(ValueMapper::convertToDTO).collect(Collectors.toList());
            } else {
                hallResponseDTOs = Collections.emptyList();
            }

        } catch (Exception ex) {
            log.error("Execption occured while retriving hall list form database.");
        }

        return hallResponseDTOs;
    }
}