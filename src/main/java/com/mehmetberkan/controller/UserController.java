package com.mehmetberkan.controller;

import com.mehmetberkan.config.JwtManager;
import com.mehmetberkan.dto.request.AddRoleRequestDto;
import com.mehmetberkan.dto.request.DoLoginRequestDto;
import com.mehmetberkan.dto.request.DoRegisterRequestDto;
import com.mehmetberkan.dto.response.BaseResponse;
import com.mehmetberkan.entity.User;
import com.mehmetberkan.exception.BudgetMateException;
import com.mehmetberkan.exception.ErrorType;
import com.mehmetberkan.service.UserRoleService;
import com.mehmetberkan.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.mehmetberkan.config.RestApis.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
@CrossOrigin("*")
@SecurityRequirement(name = "bearerAuth")
public class UserController {
    private final UserService userService;
    private final JwtManager jwtManager;
    private final UserRoleService userRoleService;

    @PostMapping(DO_REGISTER)
    public ResponseEntity<BaseResponse<Boolean>> doRegister(@RequestBody DoRegisterRequestDto dto){
    if (!dto.password().equals(dto.rePassword()))
        throw new BudgetMateException(ErrorType.SIFREHATASI);
    userService.doRegister(dto);
    return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                    .code(200)
                    .message("Success")
                    .data(true)
            .build());
    }

    @PostMapping(LOGIN)
    public ResponseEntity<BaseResponse<String>> login(@RequestBody DoLoginRequestDto dto){
        Optional<User> userOptional = userService.findByEmailPassword(dto);
        if (userOptional.isEmpty())
            throw new BudgetMateException(ErrorType.EMAIL_SIFRE_HATASI);
        return ResponseEntity.ok(BaseResponse.<String>builder()
                        .code(200)
                        .message("Success")
                        .data(jwtManager.createToken(userOptional.get().getId()))
                .build());
    }
    @PostMapping(ADD_ROLE)
    public ResponseEntity<BaseResponse<Boolean>> addRole(@RequestBody AddRoleRequestDto dto){
        userRoleService.addRole(dto.roleName(), dto.userId());
        return ResponseEntity.ok(BaseResponse.<Boolean>builder()
                .code(200)
                .message("Ok")
                .data(true)
                .build());
    }

}
