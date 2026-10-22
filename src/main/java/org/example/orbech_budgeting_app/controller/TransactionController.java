package org.example.orbech_budgeting_app.controller;

import jakarta.validation.Valid;
import org.example.orbech_budgeting_app.model.Transaction;
import org.example.orbech_budgeting_app.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@Validated
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // GET - Read
    @GetMapping
    public List<Transaction> getAll(){
        return transactionService.findAll();
    }
    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    // POST - Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Transaction createTransaction(@Valid @RequestBody Transaction transaction) {
        return transactionService.create(transaction);
    }

    // PUT - Update
    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @Valid @RequestBody Transaction transaction) {
        return transactionService.update(id, transaction);
    }

    // DELETE - delete
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        transactionService.deleteById(id);
    }
}
