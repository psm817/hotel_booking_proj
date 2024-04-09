package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Dto {
    public int id;

    public Dto() {
        this(0);
    }

    public Dto(Map<String, Object> row) {
        this((int) row.get("id"));
    }
}
