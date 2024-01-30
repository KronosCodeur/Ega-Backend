package tg.iai.ega.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tg.iai.ega.dto.AuthenticationRequest;
import tg.iai.ega.dto.AuthenticationResponse;
import tg.iai.ega.dto.RegisterRequest;
import tg.iai.ega.dto.RegisterResponse;
import tg.iai.ega.entities.Client;
import tg.iai.ega.repositories.ClientRepository;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthenticationService {
    private final JWTService jwtService;
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        UserDetails user = clientRepository.findClientByEmail(request.getEmail()).orElseThrow(() -> new EntityNotFoundException("aucun utilisateur n'est trouvé!"));
        String jwtToken = "";
        if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            jwtToken = jwtService.generateToken(user);
        }
        UserDetails user1 = clientRepository.findClientByEmail(request.getEmail()).orElseThrow(() -> new EntityNotFoundException("aucun utilisateur n'est trouvé!"));
        if (!StringUtils.hasLength(user1.getUsername())) {
            log.warn("l'email de ce utilisateur est null");
        }
        Client client = clientRepository.findClientByEmail(request.getEmail()).get();

        return AuthenticationResponse.builder()
                .token(jwtToken).
                id(client.getId()).
                gender(client.getGender()).
                firstName(client.getFirstName()).
                lastName(client.getLastName()).
                address(client.getAddress()).
                email(client.getEmail()).
                birthday(client.getBirthday()).
                phone(client.getPhone())
                .build();
    }

    public RegisterResponse register(RegisterRequest request) {
        var user = Client.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthday(request.getBirthday())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .phone(request.getPhone())
                .gender(request.getGender())
                .address(request.getAddress())
                .nationality(request.getNationality())
                .build();
        clientRepository.save(user);
        return RegisterResponse.builder().message("Account successfully created !!!").build();
    }
}