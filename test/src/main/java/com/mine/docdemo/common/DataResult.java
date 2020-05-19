package com.mine.docdemo.common;

import lombok.Data;
import java.io.Serializable;

/**
 * @author weapon
 * @date 2020/5/7 14:21
 */
@Data
public class DataResult<T> implements Serializable {

    private static final long serialVersionUID = -7118763280007217053L;

    private T data;
    private String code;

}
