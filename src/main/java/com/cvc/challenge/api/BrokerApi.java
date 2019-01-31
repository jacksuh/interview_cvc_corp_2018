package com.cvc.challenge.api;

import java.util.List;

import com.cvc.challenge.dto.custom.BrokerHotelDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * External APIs access point
 * 
 * @author Rodrigo Dantas - rodrigodantas.91@gmail.com
 * @since 2019.01.30
 * 
 */
@FeignClient(name = "brokerApi", url = "https://cvcbackendhotel.herokuapp.com/hotels")
public interface BrokerApi {

    @RequestMapping("/avail/{city_id}")
    List<BrokerHotelDTO> hotelListByCity(@PathVariable("city_id") Long cityId);

    @RequestMapping("/{id}")
    List<BrokerHotelDTO> hotelById(@PathVariable("id") Long id);
}