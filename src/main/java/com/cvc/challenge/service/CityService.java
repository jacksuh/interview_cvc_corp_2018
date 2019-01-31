package com.cvc.challenge.service;

import javax.validation.Valid;

import com.cvc.challenge.dto.CityDTO;
import com.cvc.challenge.dto.custom.CityNoIdDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

public interface CityService {

    public CityDTO create(CityNoIdDTO city);

    public CityDTO read(Long id);

    public CityDTO update(@Valid CityDTO city);

    public void delete(Long id);

    public Page<CityDTO> list(Integer pageNumber, Integer pageSize, Direction direction, String orderBy);

    public Page<CityDTO> search(CityDTO city, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy);

    public Page<CityDTO> find(CityDTO city, Integer pageNumber, Integer pageSize, Direction direction, String orderBy);

}