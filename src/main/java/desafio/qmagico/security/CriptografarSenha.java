package desafio.qmagico.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;


public class CriptografarSenha {
	
	
	
	
	public static String criptografar(String senha) {
		
		String sha256 = DigestUtils.sha256Hex(senha);
		return sha256;
	}

}
