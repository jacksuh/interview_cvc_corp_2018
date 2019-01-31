package com.cvc.challenge.service.impl;

import java.util.Date;
import java.util.List;

import com.cvc.challenge.api.BrokerApi;
import com.cvc.challenge.dto.custom.BrokerHotelDTO;
import com.cvc.challenge.service.BrokerService;
import com.cvc.challenge.utils.CalcUtils;
import com.cvc.challenge.utils.DateUtils;

import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service("brokerService")
public class BrokerServiceImpl implements BrokerService {

    private final BrokerApi api;

    @Override
    public List<BrokerHotelDTO> hotelListByCity(Long cityId) {
        return api.hotelListByCity(cityId);
    }

    @Override
    public List<BrokerHotelDTO> hotelById(Long id) {
        return api.hotelById(id);
    }

    @Override
    public List<BrokerHotelDTO> hotelListPriceByCity(Long cityCode, Date checkIn, Date checkOut, Integer adult,
            Integer child) {

        int days = DateUtils.diffBetweenDates(checkIn, checkOut);

        List<BrokerHotelDTO> myHotels = api.hotelListByCity(cityCode);

        myHotels.forEach(h -> {
            h.getRooms().forEach(r -> {
                r.getPrice()
                        .setAdult(DoubleRounder.round(CalcUtils.stay(r.getPrice().getAdult(), days, 0.7, adult), 2));
                r.getPrice()
                        .setChild(DoubleRounder.round(CalcUtils.stay(r.getPrice().getChild(), days, 0.7, child), 2));
            });
        });

        return myHotels;
    }

}
