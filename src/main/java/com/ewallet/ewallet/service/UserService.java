package com.ewallet.ewallet.service;

import com.ewallet.ewallet.model.User;
import com.ewallet.ewallet.model.Wallet;
import com.ewallet.ewallet.repository.UserRepository;
import com.ewallet.ewallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private WalletRepository walletRepo;

    public User register(User user) {

        User savedUser = userRepo.save(user);

        Wallet wallet = new Wallet();
        wallet.setUserId(savedUser.getId());
        wallet.setBalance(0);

        walletRepo.save(wallet);

        return savedUser;
    }
}