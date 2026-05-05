package com.ewallet.ewallet.controller;

import com.ewallet.ewallet.model.Wallet;
import com.ewallet.ewallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallet")
public class WalletController {

    @Autowired
    private WalletService service;

    @GetMapping("/{userId}")
    public Wallet getWallet(@PathVariable Long userId) {
        return service.getWallet(userId);
    }

    @PostMapping("/add")
    public String addMoney(@RequestParam Long userId,
                           @RequestParam double amount) {
        return service.addMoney(userId, amount);
    }
}