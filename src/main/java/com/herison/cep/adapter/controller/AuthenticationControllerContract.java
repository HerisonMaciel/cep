package com.herison.cep.adapter.controller;

import com.herison.cep.adapter.authentication.AuthenticationDTO;
import com.herison.cep.adapter.authentication.RegisterDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthenticationControllerContract {

    @Operation(
            summary = "Authentication",
            description = "endpoint to authenticate.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "content found successfully"),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "resource not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
            }
    )
    ResponseEntity login(@RequestBody @Valid AuthenticationDTO data);


    @Operation(
            summary = "Authentication",
            description = "endpoint to register.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "content found successfully"),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
                    @ApiResponse(responseCode = "404", description = "resource not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
            }
    )
    ResponseEntity register(@RequestBody @Valid RegisterDTO data);
}
