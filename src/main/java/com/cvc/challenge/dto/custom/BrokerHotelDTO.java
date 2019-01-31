package com.cvc.challenge.dto.custom;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class BrokerHotelDTO {

    private Long id;

    private String name;

    private Long cityCode;

    private String cityName;

    private List<RoomApiDTO> rooms;

}