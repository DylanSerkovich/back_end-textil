package com.guianella.backend_textil.domain.model.dto;

import java.util.List;

public record ListDto(int status, int count, List<?> items) {
}
