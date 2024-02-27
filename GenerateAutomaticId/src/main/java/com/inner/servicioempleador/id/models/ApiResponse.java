package com.inner.servicioempleador.id.models;

import lombok.Getter;
import lombok.Setter;

/*
* Model file to construct api response in json format.
*/

@Setter
@Getter
public class ApiResponse {

    private String id;

    public ApiResponse(String id) {
        this.id = id;
    }

}
