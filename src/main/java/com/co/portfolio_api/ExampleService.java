package com.co.portfolio_api;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public void getList() {
        System.out.println(userRepository.findAll());
//        return userRepository.findAll();
    }

    @Transactional  // default : readOnly = false
    public void insertExample() {

        Hello user = new Hello(null, "홍길동", 30);
        userRepository.save(user);

    }
}
