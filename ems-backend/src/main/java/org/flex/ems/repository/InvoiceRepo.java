package org.flex.ems.repository;

import org.flex.ems.model.InvoiceModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepo extends MongoRepository<InvoiceModel, String> {

}
