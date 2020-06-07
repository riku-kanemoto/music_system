package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.MusicSite;

public class SiteValidator {
    public static List<String> validate(MusicSite s){
        List<String> errors=new ArrayList<String>();

        String name_error=_validateName(s.getName());
        if(!name_error.equals("")){
            errors.add(name_error);
        }
        String url_error=_validateUrl(s.getUrl());
        if(!name_error.equals("")){
            errors.add(url_error);
        }
        return errors;
    }

    private static String _validateName(String name){
        if(name==null || name.equals("")){
            return "サイト名を入力してください。";
        }
        return "";
    }
    private static String _validateUrl(String url){
        if(url==null || url.equals("")){
            return "URLを入力してください。";
        }
        return "";
    }
}
