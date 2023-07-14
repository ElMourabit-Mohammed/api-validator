package com.sqli.intern.api.validator.client.web;

import com.sqli.intern.api.validator.utilities.dtos.RequestDto;
import com.sqli.intern.api.validator.utilities.dtos.ResponseDto;
import com.sqli.intern.api.validator.services.OperationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;



@Controller
@Tag(name = "Api Controller", description = "Endpoints related to API operations")
public class OperationWebController {

    @Autowired
    private OperationService operationService;

    @GetMapping
    @Operation(summary = "Home Page", description = "Renders the home page")
    public String home(ModelMap model) {
        model.addAttribute("requestDto", new RequestDto());
        return "home";
    }

    @PostMapping("/home")
    @Operation(summary = "Handle API Request", description = "Handles an API request and returns the response which is the status code")
    @ApiResponse(responseCode = "200", description = "Response Dto with status code and actual Json",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ResponseDto.class)))
    public String handleApiRequest(@ModelAttribute RequestDto requestDto, ModelMap model) {
        ResponseDto responseDto = operationService.call(requestDto);
        model.addAttribute("requestDto", requestDto);
        model.addAttribute("responseDto", responseDto);
        return "details";
    }

}


