package com.dac.sanus_api.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomJwtAuthenticationConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

        @Override
        public Collection<GrantedAuthority> convert(Jwt jwt) {
                List<String> authorities = jwt.getClaimAsStringList("authorities");
                if (authorities == null) {
                        return List.of();
                }
                return authorities.stream()
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toList());
        }

}
