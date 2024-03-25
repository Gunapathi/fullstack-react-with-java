package org.flex.ems.controller;

import org.flex.ems.dto.InvoiceRequestDto;
import org.flex.ems.service.InvoiceService;
import org.flex.ems.utils.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<APIResponse> addInvoice(@RequestBody InvoiceRequestDto request) {

        invoiceService.addInvoice(request);

        APIResponse response = new APIResponse("success");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/fetch", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<APIResponse> fetchInvoice() {

        APIResponse response = new APIResponse(invoiceService.fetchInvoice());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
