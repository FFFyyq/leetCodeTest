package CVTE;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Company {
    private String name = "CVTE";
    public String getName() {
        return name;
    }

    public static void main(String[] args) throws Exception {
        Company company = new Company();
        Field field = company.getClass().getField("name");
        String nameFromField =(String) field.get(company);
        Method method = company.getClass().getMethod("qetName");
        String nameFromMethod =(String)method.invoke(company);
        System.out.println(nameFromField.equals(nameFromMethod));

    }
}
