package com.lucas.clean.architecture.dominio.escola.infra.aluno;

import com.lucas.clean.architecture.dominio.escola.dominio.aluno.CriptografiaSenha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaComMD5 implements CriptografiaSenha {
    @Override
    public String criptografia(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Erro ao gerar hash da senha");
        }
    }

    @Override
    public boolean validarCriptografia(String senhaCriptografada, String senha) {
        return senha.equals(criptografia(senha));
    }
}
