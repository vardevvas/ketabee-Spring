package mxd.ketabee.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import mxd.ketabee.service.RefreshTokenService;

@Slf4j
@RestController
public class RefreshTokenController {

    @Autowired
    RefreshTokenService serviceInstance;

    @GetMapping("/refreshtoken")
    void refreshTheToken(HttpServletRequest request, HttpServletResponse response)
            throws StreamWriteException, DatabindException, IOException {
        try {
            serviceInstance.refreshTheToken(request, response);
        } catch (Exception exception) {
            log.error("Error logging in {}", exception.getMessage());
            response.setHeader("Error", exception.getMessage());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            Map<String, String> error = new HashMap<>();
            error.put("Error", exception.getMessage());
            new ObjectMapper().writeValue(response.getOutputStream(), error);
        }
    }
}