package com.ecommerce.Mandarinit.utils;

import java.util.Objects;

public class SenhaUtil {

//    public static String criprografarSenha(String senha) throws MandarinException {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//        if(Objects.nonNull(senha)){
//            return passwordEncoder.encode(senha);
//        }
//
//        throw new MandarinException("Senha não pode ser null");
//    }

    public static boolean validarSenha(String senha, String senhaBanco) throws MandarinException {

        if(Objects.nonNull(senha)) {
            if(senha.equals(senhaBanco)){
                return true;
            }
            return false;
        }

        throw new MandarinException("senha não pode ser null");
    }

}
