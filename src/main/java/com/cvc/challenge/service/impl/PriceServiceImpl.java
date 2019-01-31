package com.cvc.challenge.service.impl;

import javax.validation.Valid;

import com.cvc.challenge.dto.PriceDTO;
import com.cvc.challenge.dto.custom.PriceNoIdDTO;
import com.cvc.challenge.model.Price;
import com.cvc.challenge.repository.PriceRepository;
import com.cvc.challenge.service.PriceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service("priceService")
public class PriceServiceImpl extends GenericServiceImpl<Price, Long> implements PriceService {

    @Autowired
    private PriceRepository repository;

    @Override
    public PriceDTO create(PriceNoIdDTO price) {
        return null;
    }

    @Override
    public PriceDTO read(Long id) {
        return null;
    }

    @Override
    public PriceDTO update(@Valid PriceDTO price) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<PriceDTO> list(Integer pageNumber, Integer pageSize, Direction direction, String orderBy) {
        return null;
    }

    @Override
    public Page<PriceDTO> search(PriceDTO price, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy) {
        return null;
    }

    @Override
    public Page<PriceDTO> find(PriceDTO price, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy) {
        return null;
    }

}