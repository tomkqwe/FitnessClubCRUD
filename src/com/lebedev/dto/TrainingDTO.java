package com.lebedev.dto;

public record TrainingDTO(int id,
                          int coachId,
                          int sportId,
                          int clientId,
                          double price,
                          int scheduleId) {
}
