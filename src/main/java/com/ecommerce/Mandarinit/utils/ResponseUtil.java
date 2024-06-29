package com.ecommerce.Mandarinit.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static Map<String, Object> responseMap(Object mensagem) {
        Map<String, Object> response = new HashMap<>();
        response.put("mensagens", mensagem);

        return response;
    }

}
