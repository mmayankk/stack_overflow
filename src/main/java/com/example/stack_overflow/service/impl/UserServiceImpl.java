package com.example.stack_overflow.service.impl;

import com.example.stack_overflow.collection.User;
import com.example.stack_overflow.dto.UserPageDto;
import com.example.stack_overflow.repository.UserRecommendedQuestionRepository;
import com.example.stack_overflow.repository.UserRepository;
import com.example.stack_overflow.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public UserPageDto getUserPageDetails(String userId) {
        try {
            Optional<User> userOptional = userRepository.findById(userId);

            if (userOptional.isPresent()) {
                User user = userOptional.get();
                UserPageDto userPageDto = new UserPageDto();
                userPageDto.setUsername(user.getUsername());
                userPageDto.setBadge(user.getBadge());
                return userPageDto;
            } else {
                throw new Exception("User not found");
            }
        } catch (Exception e) {
            log.error("Something went wrong {}",e);
            return null;
        }
    }
}
