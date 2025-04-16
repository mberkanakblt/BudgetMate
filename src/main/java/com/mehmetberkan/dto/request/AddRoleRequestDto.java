package com.mehmetberkan.dto.request;

public record AddRoleRequestDto(
        String roleName,
        Long userId
) {
}
