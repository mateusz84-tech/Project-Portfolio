package pl.matkoc.Approval_material.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static String username(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
