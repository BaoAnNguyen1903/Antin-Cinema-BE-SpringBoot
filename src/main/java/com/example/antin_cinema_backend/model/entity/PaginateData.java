package com.example.antin_cinema_backend.model.entity;

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
public class PaginateData<T> {
    private Paginate paginate;
    private List<T> result;

    // public PaginatedData(Paginate paginate, List<T> result) {
    //     this.paginate = paginate;
    //     this.result = result;
    // }
}
