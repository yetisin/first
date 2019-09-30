import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Solution {


    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fio="";
        PhoneBook phoneBook = new PhoneBook();
        ArrayList<String> phoneList = new ArrayList<String>();
        //ввод ФИО
        System.out.println("Введите ФИО:");
        try {
            while ("".equals(fio)) {
                fio = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e) {
                e.printStackTrace();
        }
        //Поиск ФИО в телефонной книге
        phoneList=phoneBook.findFio(fio);
        //вывод результата
        for (String phone: phoneList)
            System.out.println(phone);

    }

}