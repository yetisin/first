import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String,ArrayList<String>> phoneBook = new HashMap<String,ArrayList<String>>();
    public PhoneBook() {
        phoneBook.put("Иванов И.И.",new ArrayList(Arrays.asList("+8 800 2000 500", "+8 800 2000 600")));
        phoneBook.put("Петров П.П.",new ArrayList(Arrays.asList("+8 800 2000 700")));
        phoneBook.put("Сидоров С.С.",new ArrayList(Arrays.asList("+8 800 2000 800", "+8 800 2000 900","+8 800 2000 000")));
    }
    public ArrayList<String> findFio(String fio){
        ArrayList<String> phoneList = new ArrayList<String>();
        if (phoneBook.containsKey(fio))
        {
            ArrayList phones=phoneBook.get(fio);
            for (int i=0;i<phones.size();i++)
                phoneList.add((i+1) + ". "+phones.get(i));
        }
        else phoneList.add("В БД нет ФИО: "+fio);
        return phoneList;
    }

}