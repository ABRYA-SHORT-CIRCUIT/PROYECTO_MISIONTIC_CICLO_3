package com.proyecto.tvshop.Repositorios;

import com.proyecto.tvshop.modelos.Concept;
import com.proyecto.tvshop.modelos.State;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class StateConverter implements AttributeConverter<State, String> {
    @Override
    public String convertToDatabaseColumn(State estado) {
        if (estado == null) {
            return null;
        }
        return estado.getEstado();
    }

    @Override
    public State convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(State.values())
                .filter(c -> c.getEstado().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
