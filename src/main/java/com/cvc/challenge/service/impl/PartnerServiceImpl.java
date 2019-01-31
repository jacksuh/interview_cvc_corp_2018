package com.cvc.challenge.service.impl;

import java.util.Date;
import java.util.List;

import com.cvc.challenge.api.PartnerApi;
import com.cvc.challenge.dto.custom.HotelApiDTO;
import com.cvc.challenge.service.PartnerService;
import com.cvc.challenge.utils.CalcUtils;
import com.cvc.challenge.utils.DateUtils;

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

    @Override
    public List<HotelApiDTO> hotelListPriceByCity(Long cityCode, Date checkIn, Date checkOut, Integer adult,
            Integer child) {

        int days = DateUtils.diffBetweenDates(checkIn, checkOut);

        List<HotelApiDTO> myHotels = api.hotelListByCity(cityCode);
        for(int i = 0; i < myHotels.size(); i++){
            for(int j = 0; j < myHotels.get(i).getRooms().size(); j++){
                myHotels.get(i).getRooms().get(j).getPrice().setAdult(
                    CalcUtils.stay(myHotels.get(i).getRooms().get(j).getPrice().getAdult(), days, 0.7)
                );
                myHotels.get(i).getRooms().get(j).getPrice().setChild(
                    CalcUtils.stay(myHotels.get(i).getRooms().get(j).getPrice().getChild(), days, 0.7)
                );
            }
        }

        return myHotels;
    }

   
}
