package com.mine.docdemo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 *
 * @author weapon
 * @date 2020/05/07
 */
@Data
@NoArgsConstructor
public class Supplier {

    private Long id;
    
    /**
     * 
     */
    private String code;

    /**
     * 
     */
    private String name;
}