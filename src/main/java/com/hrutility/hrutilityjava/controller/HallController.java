package com.hrutility.hrutilityjava.controller;

import com.hrutility.hrutilityjava.dto.APIResponse;
import com.hrutility.hrutilityjava.dto.HallRequestDTO;
import com.hrutility.hrutilityjava.dto.HallResponseDTO;
import com.hrutility.hrutilityjava.service.HallService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/hall")
@AllArgsConstructor
public class HallController {
    public static final String SUCCESS = "success";
    private HallService hallService;

    @GetMapping
    public ResponseEntity<APIResponse> getHalls() {
        List<HallResponseDTO> halls = hallService.getHalls();
//        Builder design patern
        APIResponse<List<HallResponseDTO>> responseDTO = APIResponse.<List<HallResponseDTO>>builder().status(SUCCESS).results(halls).build();

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<APIResponse> saveHall(@RequestBody @Valid HallRequestDTO hallRequestDTO){
        HallResponseDTO hallResponseDTO = hallService.createHall(hallRequestDTO);

//        builder design pattern
        APIResponse<HallResponseDTO> responseDTO = APIResponse.<HallResponseDTO>builder().
                status(SUCCESS).results(hallResponseDTO).build();

        return new ResponseEntity<>(responseDTO,HttpStatus.CREATED);

    }
}
