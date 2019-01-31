package com.cvc.challenge.service;

import javax.validation.Valid;

import com.cvc.challenge.dto.PriceDTO;
import com.cvc.challenge.dto.custom.NoIdPriceDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

public interface PriceService {

    public PriceDTO create(NoIdPriceDTO price);

    public PriceDTO read(Long id);

    public PriceDTO update(@Valid PriceDTO price);

    public void delete(Long id);

    public Page<PriceDTO> list(Integer pageNumber, Integer pageSize, Direction direction, String orderBy);

    public Page<PriceDTO> search(PriceDTO price, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy);

    public Page<PriceDTO> find(PriceDTO price, Integer pageNumber, Integer pageSize, Direction direction, String orderBy);


}