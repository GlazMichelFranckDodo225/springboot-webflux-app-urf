package com.dgmf.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeDto {    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
