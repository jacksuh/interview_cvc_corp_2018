package com.cvc.challenge.dto.custom;

import com.cvc.challenge.enums.PriceType;

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
public class PriceNoIdDTO {

    private PriceType priceType;

    private Double price;

}