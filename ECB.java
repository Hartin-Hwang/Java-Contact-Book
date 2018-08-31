package ECB18S1;

public class ECB {
    public static void main(String[] args){
        ContactProcess cp = new ContactProcess(args);
        cp.readPhoneBook();
        cp.readInstruction();
        cp.saveResult();
        cp.saveQuery();
    }
}
