package com.pw.leiloeiro.api.Controllers;

import com.pw.leiloeiro.api.DTO.ResponseAnyDTO;
import com.pw.leiloeiro.api.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<ResponseAnyDTO> allUser() {
        try {
            return ResponseEntity.ok().body(new ResponseAnyDTO(200, null, "", userService.allUser()));
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
