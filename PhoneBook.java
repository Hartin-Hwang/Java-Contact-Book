package ECB18S1;
import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<Person> personList;
    private ArrayList<Person> queryList;

    public PhoneBook() {
        personList = new ArrayList<Person>();
        queryList = new ArrayList<Person>();
    }

    public void addPerson(String s) {
        Person p = new Person(s);
        if (p.isValidToAdd()) {
        personList.add(p);
        System.out.println("the size is " + personList.size());
        }
    }

    public void removePerson(String n) {
        String[] temp = n.trim().split("\\;");
        if (temp.length == 1) {
            int i = 0;
            while (i < personList.size()) {
                if (personList.get(i).getName().equalsIgnoreCase(temp[0])) {
                    personList.remove(i);
                } else {
                    ++i;
                }
            }
        } else if (temp.length == 2){
            int i = 0;
            while (i < personList.size()) {
                if (personList.get(i).getName().equalsIgnoreCase(temp[0])) {
                    personList.remove(i);
                }

                if (personList.get(i).getBirthday().equalsIgnoreCase(temp[1].trim())) {
                    personList.remove(i);
                }
                else {
                    ++i;
                }
            }
        }
    }

    public void queryPerson(String information){
        String[] temp = information.trim().split("\\s");

        //String array transfer to String
        StringBuffer sb = new StringBuffer();
        for(int j = 1; j < temp.length; j++){
            sb.append(temp[j] + " ");
        }
        String integralInf = sb.toString();
        String Inf = integralInf.trim();

        if(temp[0].equalsIgnoreCase("name")){
            for(int i = 0; i < personList.size(); i++){
                if(personList.get(i).getName().equalsIgnoreCase(Inf)){
                    queryList.add(personList.get(i));
                }
            }
        }else if (temp[0].equalsIgnoreCase("birthday")){
            for(int i = 0; i < personList.size(); i++){
                if(personList.get(i).getBirthday().equalsIgnoreCase(temp[1])){
                    queryList.add(personList.get(i));
                }
            }
        }else if (temp[0].equalsIgnoreCase("phone")){
            for(int i = 0; i < personList.size(); i++){
                if(personList.get(i).getPhone().equalsIgnoreCase(temp[1])){
                    queryList.add(personList.get(i));
                }
            }
        }// yiwen
    }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            for (Person p : personList) {
                sb.append(p.toString());
                sb.append("\n\n");
            }
            return sb.toString();
        }

        public String queryToString(){
            StringBuilder sb = new StringBuilder();
            for (Person p : queryList) {
                sb.append(p.toString());
                sb.append("\n\n" + "-----------------------------------------" + "\n\n");
            }
            return sb.toString();
        }

        public ArrayList<Person> getPersonList () {
            return personList;
        }

        public void setPersonList (ArrayList < Person > personList) {
            this.personList = personList;
        }
    }
