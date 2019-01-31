package com.cvc.challenge.service;

import java.util.List;

import com.cvc.challenge.dto.custom.HotelApiDTO;

public interface PartnerService {

    
    public List<HotelApiDTO> hotelListByCity (Long cityId);

    public List<HotelApiDTO> hotelById (Long id);


}