package com.cvc.challenge.service.impl;

import javax.validation.Valid;

import com.cvc.challenge.dto.CityDTO;
import com.cvc.challenge.dto.custom.CityNoIdDTO;
import com.cvc.challenge.service.CityService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

public class CityServiceImpl implements CityService {

    @Override
    public CityDTO create(CityNoIdDTO city) {
        return null;
    }

    @Override
    public CityDTO read(Long id) {
        return null;
    }

    @Override
    public CityDTO update(@Valid CityDTO city) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<CityDTO> list(Integer pageNumber, Integer pageSize, Direction direction, String orderBy) {
        return null;
    }

    @Override
    public Page<CityDTO> search(CityDTO city, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy) {
        return null;
    }

    @Override
    public Page<CityDTO> find(CityDTO city, Integer pageNumber, Integer pageSize, Direction direction, String orderBy) {
        return null;
    }

}