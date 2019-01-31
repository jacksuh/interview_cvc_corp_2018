package com.cvc.challenge.service.impl;

import javax.validation.Valid;

import com.cvc.challenge.dto.HotelDTO;
import com.cvc.challenge.dto.custom.HotelNoIdDTO;
import com.cvc.challenge.model.Hotel;
import com.cvc.challenge.repository.HotelRepository;
import com.cvc.challenge.service.HotelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

public class HotelServiceImpl extends GenericServiceImpl<Hotel, Long> implements HotelService {

    @Autowired
    private HotelRepository repository;

    @Override
    public HotelDTO create(HotelNoIdDTO hotel) {
        return null;
    }

    @Override
    public HotelDTO read(Long id) {
        return null;
    }

    @Override
    public HotelDTO update(@Valid HotelDTO hotel) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<HotelDTO> list(Integer pageNumber, Integer pageSize, Direction direction, String orderBy) {
        return null;
    }

    @Override
    public Page<HotelDTO> search(HotelDTO hotel, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy) {
        return null;
    }

    @Override
    public Page<HotelDTO> find(HotelDTO hotel, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy) {
        return null;
    }

}