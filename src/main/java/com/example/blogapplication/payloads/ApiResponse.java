package com.example.blogapplication.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse { // we make this class to give response of delete mapping (controller)
    private String message ;
    private boolean success;
}
