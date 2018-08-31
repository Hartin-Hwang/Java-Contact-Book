package ECB18S1;

public class Person {
    private String name; // Name of contacts
    private String birthday; // Birthday of contacts
    private String phone; // phone of telephone
    private String email; //Email of contacts
    private String address;// Address of contacts

    public Person(String s){
        String[] temp = s.trim().split("\\;");
        for(int i = 0; i < temp.length; i++){
            String[] word = temp[i].trim().split(" ");
            if (word[0].equalsIgnoreCase("name")){
                StringBuffer sb = new StringBuffer();
                for(int j = 1; j < word.length; j++){
                    sb.append(word[j] + " ");
                }
                String integralName = sb.toString();
                name = integralName.trim();

            }else if(word[0].equalsIgnoreCase("birthday")){
                birthday = word[1].trim();
            }else if(word[0].equalsIgnoreCase("phone")){
               String testPhone = word[1].trim();
               int integralPhone = Integer.parseInt(testPhone);
               phone = Integer.toString(integralPhone);
            }else if(word[0].equalsIgnoreCase("email")){
                email = word[1].trim();
            }else if(word[0].equalsIgnoreCase("address")){
                StringBuffer sb = new StringBuffer();
                for(int j = 1; j < word.length; j++){
                    sb.append(word[j] + " ");
                }
                String integralAddress = sb.toString();
                address = integralAddress.trim();
            }
        }
    }

    public boolean isValidToAdd() {
        return validName() && validBirthday() && validPhone() &&
                validEmail();
    }

    public boolean validName() {
        String newName = name.replaceAll(" ","");
        if (newName != null && newName.matches("[a-zA-Z]+")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validBirthday() {
        if (birthday != null && birthday.matches("\\d+\\D\\d+\\D\\d+")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validPhone() {
        if (phone == null || phone.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validEmail() {
        if (email == null || email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return String.format("name  %s\nbirthday  %s\nphone  %s\nemail  %s\naddress  %s ", name,birthday,phone,email,address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setNumber(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
