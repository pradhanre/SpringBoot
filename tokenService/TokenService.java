package com.tcs.tokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.token.Token;
import com.tcs.tokenRepository.TokenRepo;

@Service
public class TokenService {

	@Autowired
	private TokenRepo tokenRepo;

	public void saveToken(Token token) {
		// TODO Auto-generated method stub
		tokenRepo.save(token);

	}

}
