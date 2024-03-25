package org.flex.ems.service.impl;

import org.flex.ems.repository.InvoiceRepo;
import org.flex.ems.dto.InvoiceRequestDto;
import org.flex.ems.model.InvoiceModel;
import org.flex.ems.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private InvoiceRepo invoiceRepo;

    @Override
    public void addInvoice(InvoiceRequestDto request) {

        InvoiceModel invoiceModel = new InvoiceModel();
        invoiceModel.setUserName(request.getUserName());
        invoiceModel.setInvoiceId(request.getInvoiceId());

        invoiceRepo.save(invoiceModel);
    }

    @Override
    public List<InvoiceRequestDto> fetchInvoice() {
        List<InvoiceRequestDto> responseDto = new ArrayList<>();
        List<InvoiceModel> invoiceModels = invoiceRepo.findAll();

        for (InvoiceModel invoiceModel : invoiceModels) {
            InvoiceRequestDto requestDto = new InvoiceRequestDto();
            requestDto.setUserName(invoiceModel.getUserName());
            requestDto.setInvoiceId(invoiceModel.getInvoiceId());

            responseDto.add(requestDto);
        }

        return responseDto;
    }

}
