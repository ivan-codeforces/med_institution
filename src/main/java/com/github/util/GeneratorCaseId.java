package com.github.util;

import com.github.model.CaseEntity;
import java.util.List;

public final class GeneratorCaseId {
    private GeneratorCaseId() {
    }

    public static String autoIncrement(List<CaseEntity> cases){

        CaseEntity medCase = cases.get(cases.size()-1);
        String str = medCase.getId();

        if (str==null || str.equals("ZZZ9999999")){
            return "AAA0000001";
        }

        String[] s =new String[]{str.substring(0,3),str.substring(3)};
        StringBuilder stringBuilder = new StringBuilder();
        int num  = Integer.parseInt(s[1]);
        char[] chars = s[0].toCharArray();

        if (num==9999999){
            if (chars[2]==90){
                if (chars[1]==90){
                    if (chars[0]==90){
                        chars[0]=64;
                    }
                    chars[0]+=1;
                    chars[1]=64;
                }
                chars[1]+=1;
                chars[2]=64;
            }
            stringBuilder.append(String.valueOf(chars)).append("0000001");
        } else {
            num+=1;
            stringBuilder.append(s[0]).append(num);
        }
        return stringBuilder.toString();
    }
}
