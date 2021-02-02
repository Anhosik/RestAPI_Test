package kdjsystem.mllink.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class Result<T> {
    private T result;
}