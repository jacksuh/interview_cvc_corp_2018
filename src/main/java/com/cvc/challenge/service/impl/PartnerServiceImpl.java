package com.cvc.challenge.service.impl;

import java.util.List;

import com.cvc.challenge.api.PartnerApi;
import com.cvc.challenge.dto.custom.HotelApiDTO;
import com.cvc.challenge.service.PartnerService;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service("partnerService")
public class PartnerServiceImpl implements PartnerService {

    private final PartnerApi api;

    @Override
    public List<HotelApiDTO> hotelListByCity(Long cityId) {
        return api.hotelListByCity(cityId);
    }

    @Override
    public List<HotelApiDTO> hotelById(Long id) {
        return api.hotelById(id);
    }

}