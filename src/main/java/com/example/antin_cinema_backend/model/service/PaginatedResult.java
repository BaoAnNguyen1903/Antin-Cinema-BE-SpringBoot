package com.example.antin_cinema_backend.model.service;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PaginatedResult<T> {
    private List<T> result;
    private int total;

    // public PaginatedResult(List<T> result, int total) {
    // this.result = result;
    // this.total = total;
    // }
}
