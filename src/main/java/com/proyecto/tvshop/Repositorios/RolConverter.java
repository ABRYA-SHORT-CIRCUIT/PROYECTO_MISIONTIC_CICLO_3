package com.proyecto.tvshop.Repositorios;


import com.proyecto.tvshop.modelos.Roles;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class RolConverter implements AttributeConverter<Roles, String> {
    @Override
    public String convertToDatabaseColumn(Roles roles) {
        if (roles == null) {
            return null;
        }
        return roles.getRol();
    }

    @Override
    public Roles convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Roles.values())
                .filter(c -> c.getRol().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
