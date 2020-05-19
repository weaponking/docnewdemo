package com.mine.docdemo.elk.mock;

import lombok.Data;
import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 7787088717576162822L;

    private long id;
    private String name;
}
