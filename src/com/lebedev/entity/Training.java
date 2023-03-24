package com.lebedev.entity;

public record Training(int id,
                       String trainerFullName,
                       String clientFullName,
                       double price,
                       int duration) {
}
