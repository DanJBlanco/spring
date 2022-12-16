package com.bolsadeideas.springboot.app.util.paginator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageItem {

    private int num;
    private boolean actual;

}
