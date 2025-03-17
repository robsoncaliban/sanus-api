package com.dac.sanus_api.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomJwtAuthenticationConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

        @Override
        public Collection<GrantedAuthority> convert(Jwt jwt) {
                List<Map<String, String>> authorities = jwt.getClaim("authorities");

                if (authorities == null) {
                        return List.of();
                }

                return authorities.stream()
                                .map(auth -> new SimpleGrantedAuthority(auth.get("role")))
                                .collect(Collectors.toList());
        }

}
