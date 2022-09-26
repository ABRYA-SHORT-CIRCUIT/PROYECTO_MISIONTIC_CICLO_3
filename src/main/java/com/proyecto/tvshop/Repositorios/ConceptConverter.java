package com.proyecto.tvshop.Repositorios;

import com.proyecto.tvshop.modelos.Concept;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ConceptConverter implements AttributeConverter<Concept, String> {
    @Override
    public String convertToDatabaseColumn(Concept concepto) {
        if (concepto == null) {
            return null;
        }
        return concepto.getNombre();
    }

    @Override
    public Concept convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Concept.values())
                .filter(c -> c.getNombre().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
