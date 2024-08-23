package com.example.__7.controller;

import java.text.ParseException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.__7.dto.respon.AuthenRepon;
import com.example.__7.dto.respon.IntrospectResponse;
import com.example.__7.dto.resquest.AuthenRespuest;
import com.example.__7.dto.resquest.IntrospectRequest;
import com.example.__7.dto.resquest.ResponsiData;
import com.example.__7.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {
    AuthenticationService athenticationService;

    @PostMapping("/log-in")
    public ResponsiData<AuthenRepon> authenticate(@RequestBody AuthenRespuest respuest) {
        var result = athenticationService.authenticated(respuest);
        return ResponsiData.<AuthenRepon>builder().data(result).build();
    }

    @PostMapping("/introspect")
    public ResponsiData<IntrospectResponse> introspecate(@RequestBody IntrospectRequest respuest)
            throws ParseException, JOSEException {
        var result = athenticationService.introspect(respuest);
        return ResponsiData.<IntrospectResponse>builder().data(result).build();
    }
}
