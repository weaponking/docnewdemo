package com.mine.docdemo.strategy;

import lombok.Data;
import java.io.Serializable;

@Data
public class TestVo implements Serializable {

    private static final long serialVersionUID = -5557094345869959841L;

    private Long id;
    private String name;
    private States states;

}
