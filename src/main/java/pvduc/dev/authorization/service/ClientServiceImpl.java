package pvduc.dev.authorization.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.stereotype.Service;
import pvduc.dev.authorization.dto.ClientDto;
import pvduc.dev.authorization.dto.CreateClientDto;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClientServiceImpl implements ClientService {
    private final OAuth2AuthorizationService oAuth2AuthorizationService;

    private final ModelMapper modelMapper;
}
