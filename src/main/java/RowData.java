import java.util.List;

public class RowData {
    private int number;
    private String id;
    private String firstName;
    private String lastName;
    private int birthYear;
    private boolean male;
    private String city;
    private int value;

    public RowData (List<String> tokens) {
        this.number = Integer.valueOf(tokens.get(0));
        this.id = tokens.get(1);
        this.firstName = tokens.get(2);
        this.lastName = tokens.get(3);
        this.birthYear = Integer.parseInt(tokens.get(4));
        this.male = tokens.get(5).equals("Male");
        this.city = tokens.get(6);
        this.value = Integer.parseInt(tokens.get(7));
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
