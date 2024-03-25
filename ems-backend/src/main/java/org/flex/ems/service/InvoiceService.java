package org.flex.ems.service;

import org.flex.ems.dto.InvoiceRequestDto;

import java.util.List;

public interface InvoiceService {

    void addInvoice(InvoiceRequestDto request);

    List<InvoiceRequestDto> fetchInvoice();

}
