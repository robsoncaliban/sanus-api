package com.dac.sanus_api.services.security;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TokenService {

        private final JwtEncoder jwtEncoder;

        private static final int HOURS_EXPIRATION_TOKEN = 20;
        private static final ZoneId ZONE_ID = ZoneId.systemDefault();

        public String generateToken(String email, List<Object> roles) {

                var claims = JwtClaimsSet.builder()
                                .issuer("sanus-api")
                                .subject(email)
                                .issuedAt(getCreationTime())
                                .expiresAt(getExpirationTime())
                                .claim("roles", roles )
                                .build();

                return jwtEncoder
                                .encode(JwtEncoderParameters.from(claims))
                                .getTokenValue();
        }

        private Instant getCreationTime() {
                return ZonedDateTime.now(ZONE_ID).toInstant();
        }

        private Instant getExpirationTime() {
                return ZonedDateTime.now(ZONE_ID).plusHours(HOURS_EXPIRATION_TOKEN)
                                .toInstant();
        }


}