package com.cvc.challenge.service;

import java.util.Date;
import java.util.List;

import com.cvc.challenge.dto.custom.BrokerHotelDTO;

public interface BrokerService {

    
    public List<BrokerHotelDTO> hotelListByCity (Long cityId);

    public List<BrokerHotelDTO> hotelById (Long id);

	public List<BrokerHotelDTO> hotelListPriceByCity(Long cityCode, Date checkIn, Date checkOut, Integer adult,
			Integer child);


}