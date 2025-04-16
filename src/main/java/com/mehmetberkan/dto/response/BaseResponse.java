package com.mehmetberkan.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BaseResponse<T> {
    Integer code;
    String message;
    T data;

}
