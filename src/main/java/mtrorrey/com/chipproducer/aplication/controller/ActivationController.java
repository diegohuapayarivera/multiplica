package mtrorrey.com.chipproducer.aplication.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import mtrorrey.com.chipproducer.aplication.service.ActivationService;
import mtrorrey.com.chipproducer.domain.models.ActivationDTO;
import mtrorrey.com.chipproducer.domain.util.EndpointLogger;
import mtrorrey.com.chipproducer.domain.util.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chip-card")
@Tag(name = "Chip Card API", description = "API for chip card activation")
public class ActivationController {


    @Autowired
    ActivationService activationService;

    @Operation(summary = "Activate chip card", description = "Activates a chip card.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            @ApiResponse(responseCode = "400", description = "Invalid activation data")
    })
    @EndpointLogger(endpointName = "/chip-card/activation")
    @PostMapping("/activation")
    @CircuitBreaker(name = "activationService", fallbackMethod = "fallbackActivation")
    public ResponseEntity<String> activation(@RequestBody @Validated ActivationDTO activationDTO) {
        activationService.activation(activationDTO);
        return new ResponseEntity<>("Mensaje enviado",HttpStatus.OK);
    }

    /**
     * Fallback method for activation
     *
     * @param activationDTO the activation DTO
     * @param throwable the throwable
     * @return HTTP 500 Internal Server Error
     */
    public ResponseEntity<String> fallbackActivation(ActivationDTO activationDTO) {
        return new ResponseEntity<>("Fallback Response", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    /**
     * Handles InvalidDataException
     *
     * @param e the exception
     * @return HTTP 400 Bad Request
     */
    @ExceptionHandler(value = InvalidDataException.class)
    public ResponseEntity<String> handleInvalidDataException(InvalidDataException e) {
        return ResponseEntity.badRequest().body("Invalid activation data");
    }

}
