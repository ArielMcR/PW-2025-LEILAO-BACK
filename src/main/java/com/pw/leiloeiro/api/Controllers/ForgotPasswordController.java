package com.pw.leiloeiro.api.Controllers;

import com.pw.leiloeiro.api.DTO.ResponseAnyDTO;
import com.pw.leiloeiro.api.Domains.User.ChangePasswordDTO;
import com.pw.leiloeiro.api.Domains.User.User;
import com.pw.leiloeiro.api.Repositories.UserRepository;
import com.pw.leiloeiro.api.Services.EmailService;
import com.pw.leiloeiro.api.Services.UserService;
import com.pw.leiloeiro.api.Infra.Security.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;

import java.util.Collections;

@RestController
@RequestMapping("/forgot-password")
@CrossOrigin(origins = "*")
public class ForgotPasswordController {

    private final UserRepository userRepository;
    private final EmailService emailService;
    private final UserService userService;
    private final TokenService tokenService;

    public ForgotPasswordController(UserRepository userRepository, EmailService emailService, UserService userService, TokenService tokenService) {
        this.userRepository = userRepository;
        this.emailService = emailService;
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @PostMapping("/verifyMail/{email}")
    public ResponseEntity<ResponseAnyDTO> verifyEmail(@PathVariable String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return new ResponseEntity<>(
                    new ResponseAnyDTO(404, "User not found", "Email não cadastrado", null),
                    HttpStatus.NOT_FOUND
            );
        }

        String token = tokenService.generateResetPasswordToken(user.getEmail());
        String resetLink = "http://localhost:3000/forgot-password?token=" + token;

        Context context = new Context();
        context.setVariable("link", resetLink);
        emailService.emailTemplate(user.getEmail(), "Redefinição de senha", context, "enviaCodigoRedefinicaoSenha");

        return ResponseEntity.ok(new ResponseAnyDTO(200, null, "Link de redefinição enviado com sucesso", null));
    }

    @PostMapping("/changePassword")
    public ResponseEntity<ResponseAnyDTO> changePasswordHandler(@RequestBody ChangePasswordDTO changePassword, @RequestParam String token) {
        String email = tokenService.validateToken(token);

        if (email == null || email.isBlank()) {
            return new ResponseEntity<>(
                    new ResponseAnyDTO(401, "Token inválido ou expirado", "Token expirado ou inválido", null),
                    HttpStatus.UNAUTHORIZED
            );
        }

        userService.updatePassword(email, changePassword);

        return ResponseEntity.ok(new ResponseAnyDTO(200, null, "Senha alterada com sucesso", null));
    }
}
