package com.cvc.challenge.service;

import javax.validation.Valid;

import com.cvc.challenge.dto.HotelDTO;
import com.cvc.challenge.dto.custom.NoIdHotelDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

public interface HotelService {

    public HotelDTO create(NoIdHotelDTO hotel);

    public HotelDTO read(Long id);

    public HotelDTO update(@Valid HotelDTO hotel);

    public void delete(Long id);

    public Page<HotelDTO> list(Integer pageNumber, Integer pageSize, Direction direction, String orderBy);

    public Page<HotelDTO> search(HotelDTO hotel, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy);

    public Page<HotelDTO> find(HotelDTO hotel, Integer pageNumber, Integer pageSize, Direction direction, String orderBy);

}