package com.herison.cep.adapter.controller;

import com.herison.cep.adapter.inbound.response.EstablishmentsByZipcodeResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "zip code Controller", description = "search for establishment by zip code")
public interface ZipCodeControllerContract {

    @Operation(
            summary = "search for establishment",
            description = "Endpoint to search for establishment by zip code.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "content found successfully"),
                    @ApiResponse(responseCode = "400", description = "poorly formatted string", content = @Content),
                    @ApiResponse(responseCode = "404", description = "resource not found", content = @Content),
                    @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
            }
    )
    ResponseEntity<EstablishmentsByZipcodeResponse> searchEstablishment(String zipCode);

}
