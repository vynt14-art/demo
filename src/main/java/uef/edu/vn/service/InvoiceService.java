package uef.edu.vn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uef.edu.vn.model.Invoice;
import uef.edu.vn.repository.InvoiceRepository;

@Service
public class InvoiceService {


@Autowired
private InvoiceRepository invoiceRepository;

public List<Invoice> findAll() {

    return invoiceRepository.findAll();
}

public Invoice findById(
        int invoiceId) {

    return invoiceRepository.findById(
            invoiceId);
}

public int save(
        Invoice invoice) {

    return invoiceRepository.save(
            invoice);
}

public int delete(
        int invoiceId) {

    return invoiceRepository.delete(
            invoiceId);
}

public Invoice findByOrderId(
        int orderId) {

    return invoiceRepository.findByOrderId(
            orderId);
}

public Double getTodayRevenue() {

    return invoiceRepository.getTodayRevenue();
}

public Double getMonthRevenue() {

    return invoiceRepository.getMonthRevenue();
}

public Integer countInvoices() {

    return invoiceRepository.countInvoices();
}


}
