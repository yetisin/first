import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by pyankov on 25.09.2019.
 */
public class Solution {
    public static void main(String[] args)
    {
        ArrayList<Integer> firstIP = new ArrayList<Integer>(4);
        ArrayList<Integer> secondIP = new ArrayList<Integer>(4);
        ArrayList<String> scopeIP = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String first="",second="";

        // Ввод 1-го IP
        System.out.println("Введите первый IP:");
        while ("".equals(first)) {
            try {
                first = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Проверка IP и распарс на 4 части
        firstIP = checkAndParseIP(first);
        //Если введенное значение не IP выводим информацию об этом
        if (firstIP.size()==0)
            System.out.println("введенное значение не является IP");
        else {
            //Ввод 2-го IP
            System.out.println("Введите второй IP:");
            while ("".equals(second)) {
                try {
                    second = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            secondIP = checkAndParseIP(second);
            //Если введенное значение не IP выводим информацию об этом
            if (secondIP.size()==0)
                System.out.println("введенное значение не является IP");
            else {
                //Поиск диапазона IP
                scopeIP = findScopeIP(firstIP,secondIP);
                //Вывод диапазона IP в консоль
                if (scopeIP.size()>0)
                {
                    System.out.println("Диапазон IP:");
                    for (String ip: scopeIP)
                        System.out.println(ip);
                }
                else
                    System.out.println("Диапазона IP нет");

            }

        }


    }
    public static ArrayList<Integer> checkAndParseIP(String stringIP){
        ArrayList<Integer> arrayListIntIP = new ArrayList<Integer>();
        Pattern pattern = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

        if (pattern.matcher(stringIP).matches()) {
            String ipes[] = stringIP.split("\\.");
            for (int i = 0; i < 4; i++) {
                arrayListIntIP.add(Integer.parseInt(ipes[i]));
            }
        }
        return arrayListIntIP;
    }

    public static ArrayList<String> findScopeIP(ArrayList<Integer> startIP,ArrayList<Integer> endIP ){
        ArrayList<String> scopeIP = new ArrayList<String> ();
        if (startIP.get(0)<endIP.get(0)||startIP.get(0)==endIP.get(0)&&startIP.get(1)<endIP.get(1)||startIP.get(0)==endIP.get(0)&&startIP.get(1)==endIP.get(1)&&startIP.get(2)<endIP.get(2)||startIP.get(0)==endIP.get(0)&&startIP.get(1)==endIP.get(1)&&startIP.get(2)==endIP.get(2)&&(startIP.get(3)+1)<endIP.get(3)){
            startIP.set(3,startIP.get(3)+1);
            while (!(startIP.get(0)==endIP.get(0)&&startIP.get(1)==endIP.get(1)&&startIP.get(2)==endIP.get(2)&&startIP.get(3)==endIP.get(3))) {
                scopeIP.add(startIP.get(0) + "." + startIP.get(1) + "." + startIP.get(2) + "." + startIP.get(3));
                startIP.set(3, startIP.get(3) + 1);
                if (startIP.get(3) == 256) {
                    startIP.set(2, startIP.get(2) + 1);
                    startIP.set(3, 0);
                }
                if (startIP.get(2) == 256) {
                    startIP.set(1, startIP.get(1) + 1);
                    startIP.set(2, 0);
                }
                if (startIP.get(1) == 256) {
                    startIP.set(0, startIP.get(0) + 1);
                    startIP.set(1, 0);
                }
            }
        }
        return scopeIP;
    }

}
