package com.ewallet.ewallet.service;

import com.ewallet.ewallet.model.Wallet;
import com.ewallet.ewallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepository repo;

    public Wallet getWallet(Long userId) {
        return repo.findByUserId(userId);
    }

    public String addMoney(Long userId, double amount) {
        Wallet wallet = repo.findByUserId(userId);
        wallet.setBalance(wallet.getBalance() + amount);
        repo.save(wallet);
        return "Money added";
    }
}