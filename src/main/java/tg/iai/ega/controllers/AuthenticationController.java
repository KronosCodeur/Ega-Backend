package tg.iai.ega.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tg.iai.ega.dto.AuthenticationRequest;
import tg.iai.ega.dto.AuthenticationResponse;
import tg.iai.ega.dto.RegisterRequest;
import tg.iai.ega.dto.RegisterResponse;
import tg.iai.ega.services.AuthenticationService;

import static tg.iai.ega.config.SecurityConfiguration.APP_ROOT;


@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping(APP_ROOT + "auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

}