package com.mehmetberkan.service;

import com.mehmetberkan.dto.request.DoLoginRequestDto;
import com.mehmetberkan.dto.request.DoRegisterRequestDto;
import com.mehmetberkan.entity.User;
import com.mehmetberkan.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void doRegister(DoRegisterRequestDto dto) {
        userRepository.save(User.builder()
                        .name(dto.name())
                        .password(dto.password())
                        .email(dto.email())
                        .address(dto.address())
                        .rePassword(dto.rePassword())
                        .balance(dto.balance())
                        .phone(dto.phone())
                .build());
    }

    public Optional<User> findByEmailPassword(DoLoginRequestDto dto) {
    return userRepository.findOptionalByEmailAndPassword(dto.email(),dto.password());
    }

    public Optional<User> findByUserId(Long userId) {
        return userRepository.findById(userId);
    }
}
