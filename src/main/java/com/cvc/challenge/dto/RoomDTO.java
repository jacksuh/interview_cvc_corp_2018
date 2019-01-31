package com.cvc.challenge.dto;

import com.cvc.challenge.enums.Category;

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
public class RoomDTO {
    
    private Long id;

    private Category category;

    private PriceDTO price;
}