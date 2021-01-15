package com.tcs.tokenRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.token.Token;

public interface TokenRepo extends JpaRepository<Token,String>{

}
