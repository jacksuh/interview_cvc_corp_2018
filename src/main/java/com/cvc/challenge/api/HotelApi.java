package com.cvc.challenge.api;

import java.util.List;

import com.cvc.challenge.dto.custom.HotelApiDTO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
 
@FeignClient(name = "hotelAPi", url = "https://cvcbackendhotel.herokuapp.com/hotels")
public interface HotelApi {
 
    @RequestMapping("/avail/{city_id}")
    List<HotelApiDTO> getHotelsByCity(@PathVariable("city_id") Long cityId);    
}