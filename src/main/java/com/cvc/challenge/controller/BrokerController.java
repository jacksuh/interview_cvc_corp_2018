package com.cvc.challenge.controller;

import java.util.Date;
import java.util.List;

import com.cvc.challenge.dto.custom.BrokerHotelDTO;
import com.cvc.challenge.service.BrokerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * This Controller access Broker'a Api Data Simple Math and Report operations
 * 
 * @author Rodrigo Dantas - rodrigodantas.91@gmail.com
 * @since 2019.01.30
 * 
 */
@Api(value = "Broker")
@RestController
@RequestMapping("/broker")
public class BrokerController {
    private final BrokerService service;

    @Autowired
    public BrokerController(BrokerService service) {
        this.service = service;
    }

    /**
     * Get a List of Hotels on the City with price (per day)
     * 
     * @param cityCode - Unique Identifier of a city
     * @return A List of Hotels from broker's api
     * 
     */
    @ApiOperation(value = "List of Hotels on the City with price (per day)")
    @RequestMapping(value = "/hotel/city/{city_code}", method = RequestMethod.GET)
    public List<BrokerHotelDTO> hotelListByCity(
            @ApiParam(value = "City Code", required = true) @PathVariable Long cityCode) {
        return (service.hotelListByCity(cityCode));
    }

    /**
     * Get a Single Hotel details
     * 
     * @param id - Unique Identifier of a Hotel
     * @return A requested Hotel from broker's api
     * 
     */
    @ApiOperation(value = "Hotel details")
    @RequestMapping(value = "/hotel/{id}", method = RequestMethod.GET)
    public List<BrokerHotelDTO> hotelById(@ApiParam(value = "Id", required = true) @PathVariable Long id) {
        return (service.hotelById(id));
    }

    /**
     * List of prices of all hotels based on user's data
     * 
     * @param cityCode   - Unique Identifier of a city
     * @param checkIn    - CheckIn date
     * @param checkOut   - CheckOut date
     * @param adultCount - Number of Adults per reservation
     * @param childCount - Number of Childres per reservation
     * @return A list containing all Hotels of the city and the prices based on
     *         client's given information
     * 
     */
    @ApiOperation(value = "List of prices of all hotels based on user's data")
    @RequestMapping(value = "/hotel/price/all", method = RequestMethod.GET)
    public List<BrokerHotelDTO> hotelListPriceByCity(@RequestParam(value = "CityCode", required = true) Long cityCode,
            @RequestParam(value = "CheckIn", defaultValue = "01/01/1900", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date checkIn,
            @RequestParam(value = "CheckOut", defaultValue = "31/12/2900", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date checkOut,
            @RequestParam(value = "Adults", defaultValue = "0", required = true) Integer adultCount,
            @RequestParam(value = "Child", defaultValue = "0", required = true) Integer childCount) {
        return (service.hotelListPriceByCity(cityCode, checkIn, checkOut, adultCount, childCount));
    }

     /**
     * Prices of single hotel based on user's data
     * 
     * @param hotelId   - Unique Identifier of a city
     * @param checkIn    - CheckIn date
     * @param checkOut   - CheckOut date
     * @param adultCount - Number of Adults per reservation
     * @param childCount - Number of Childres per reservation
     * @return A list containing all Hotels of the city and the prices based on
     *         client's given information
     * 
     */
    @ApiOperation(value = "Prices of single hotel based on user's data")
    @RequestMapping(value = "/hotel/price", method = RequestMethod.GET)
    public List<BrokerHotelDTO> hotelPriceById(@RequestParam(value = "HotelId", required = true) Long hotelId,
            @RequestParam(value = "CheckIn", defaultValue = "01/01/1900", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date checkIn,
            @RequestParam(value = "CheckOut", defaultValue = "31/12/2900", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date checkOut,
            @RequestParam(value = "Adults", defaultValue = "0", required = true) Integer adultCount,
            @RequestParam(value = "Child", defaultValue = "0", required = true) Integer childCount) {
        return (service.hotelPriceById(hotelId, checkIn, checkOut, adultCount, childCount));
    }

}