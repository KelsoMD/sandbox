package com.nesterenok.sandbox.api.rest;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nesterenok.sandbox.core.converter.ReceiptConverter;
import com.nesterenok.sandbox.core.entity.Receipt;
import com.nesterenok.sandbox.core.repository.ReceiptRepository;

@RestController
@RequestMapping("/receipts")
public class ReceiptResource {

    private final ReceiptRepository receiptRepository;
    private final ReceiptConverter receiptConverter;

    @Autowired
    public ReceiptResource(final ReceiptRepository receiptRepository, final ReceiptConverter receiptConverter) {
        this.receiptRepository = receiptRepository;
        this.receiptConverter = receiptConverter;
    }

    @GetMapping
    public ResponseEntity<?> getReceipts() {
        return new ResponseEntity<>(receiptRepository.findAll(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReceipt(@PathVariable final Long id) {
        final Receipt receipt = receiptRepository.getOne(id);
        return new ResponseEntity<>(receiptConverter.convertToDto(receipt), OK);
    }

    @PostMapping
    public ResponseEntity<?> saveReceipt(@RequestBody final Receipt receipt) {
        return new ResponseEntity<>(receiptRepository.save(receipt), CREATED);
    }

    @DeleteMapping
    public void deleteReceipt(@RequestBody final Receipt receipt) {
        receiptRepository.delete(receipt);
    }
}
