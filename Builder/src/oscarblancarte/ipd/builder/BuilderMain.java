package oscarblancarte.ipd.builder;

import oscarblancarte.ipd.builder.dto.Employee;

/**
 * @author oblancarte
 */
public class BuilderMain {

    public static void main(String[] args) {
        Employee emp = new Employee.EmployeeBuilder()
                .setName("Oscar Javier Blancarte Iturralde")
                .setGender("Male")
                .setAge(29)
                .setAdress("Aragon 189 int 404 col. Alamos, delegacion Benito " 
                        + "Juarez", "Mexico D.F.", "Mexico", "03400")
                .addContacs("Rene Blancarte", "1122334455", "123", "Casa", 
                        "Chapultepect No. 123 Col. Militar", "Mexico"
                        , "Mexico", "10023")
                .addContacs("Jaime Blancarte", "3344556677", null, "Celular")
                .addPhones("4567890234", null, "Celular")
                .addPhones("7788990099", null, "Casa")
                .build();
        System.out.println(emp);
    }
}
