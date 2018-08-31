package ECB18S1;

import java.io.*;
import java.util.Scanner;

public class ContactProcess {
    private File phoneSample;
    private File instructionSample;
    private File outputFile;
    private File reportFile;
    private PhoneBook phonebook;

    public ContactProcess(String[] s) {
        phoneSample = new File(s[0]);
        instructionSample = new File(s[1]);
        outputFile = new File(s[2]);
        reportFile = new File(s[3]);
        phonebook = new PhoneBook();
    }

    public void saveResult() {
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(outputFile));
            out.println(phonebook.toString());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveQuery(){
        try{
            PrintWriter out = new PrintWriter(new FileOutputStream(reportFile));
            out.println(phonebook.queryToString());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("There are some wrong to query");
        }
    }

    public void readInstruction() {
        try {
            Scanner in = new Scanner(instructionSample);
            while (in.hasNextLine()) {
                String instruction = in.nextLine();
                Scanner sc = new Scanner(instruction);
                String firstWord, restInf;
                if (sc.hasNext()) {
                    firstWord = sc.next();
                    if (sc.hasNextLine()) {
                        restInf = sc.nextLine();
                        if (firstWord.equalsIgnoreCase("add")) {
                            phonebook.addPerson(restInf);
                        } else if (firstWord.equalsIgnoreCase("remove")) {
                            phonebook.removePerson(restInf);
                        } else if  (firstWord.equalsIgnoreCase("query")){
                            phonebook.queryPerson(restInf);
                        }
                    } else {
                        continue;
                    }
                    sc.close();
                } else {
                    continue;
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readPhoneBook(){
        try{
            int j = 0;
            String[] detailedInf = new String[6];
            Scanner in = new Scanner(phoneSample);
            while (in.hasNextLine()){
                String Line = in.nextLine();
                Scanner sc1 = new Scanner(Line);
                String firstWord;
                if(sc1.hasNext()){
                    //scan a contact
                    firstWord = sc1.next();
                    if(in.hasNextLine()){
                        StringBuilder result = new StringBuilder();
                        if (firstWord.equalsIgnoreCase("end")){
                            StringBuffer sb = new StringBuffer();
                            for(int i = 0; i < detailedInf.length; i++){
                                sb.append(detailedInf[i]);
                                sb.append(";");
                            }
                            String integral = sb.toString();

                            if(detailedInf[0] != null) {
                              phonebook.addPerson(integral);
                                System.out.println("int " + integral);
                            }

                        } else if (firstWord.equalsIgnoreCase("name")) {
                            StringBuffer sb = new StringBuffer();
                            for(int i = 0; i < detailedInf.length; i++){
                                sb.append(detailedInf[i]);
                                sb.append(";");
                            }
                            String integralInf = sb.toString();
                            System.out.println("int " + integralInf);
                            if(detailedInf[0] != null && detailedInf[1] != null) {
                                phonebook.addPerson(integralInf);
                            }

                            for(int i = 0; i < detailedInf.length; i++){
                                detailedInf[i] = null;
                            }
                            j = 0;
                            result.append(Line);
                        } else if (firstWord.equalsIgnoreCase("birthday")) {
                            result.append(Line);
                        } else if (firstWord.equalsIgnoreCase("phone")) {
                            result.append(Line);
                        } else if (firstWord.equalsIgnoreCase("email")) {
                            result.append(Line);
                        } else if (firstWord.equalsIgnoreCase("address")) {
                            result.append(Line);
                        }
                        detailedInf[j] = result.toString();
                        System.out.println("the result " + detailedInf[j]);
                        j++;
                    } else {
                        continue;
                    }
                    sc1.close();
                } else {
                   continue;
                }
            }
            in.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("wrong");
        }
    }
}

