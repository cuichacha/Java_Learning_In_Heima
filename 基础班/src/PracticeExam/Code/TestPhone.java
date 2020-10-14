package PracticeExam.Code;

import java.util.ArrayList;
import java.util.Random;

public final class TestPhone {
    public static void main(String[] args) {
        TestPhone testPhone = new TestPhone();

        Phone phone1 = new Phone("大米手机", testPhone.generatePhonePrice(), "??");
        Phone phone2 = new Phone("橘子手机", testPhone.generatePhonePrice(), "??");
        Phone phone3 = new Phone("八星手机", testPhone.generatePhonePrice(), "??");

        ArrayList<Phone> listPhone = new ArrayList<>();
        listPhone.add(phone1);
        listPhone.add(phone2);
        listPhone.add(phone3);

        ArrayList<Phone> phoneArrayList = testPhone.filter(listPhone, 2000);
        for (int i = 0; i < phoneArrayList.size(); i++) {
            System.out.println(phoneArrayList.get(i).getName() + "..."+
                    "价格"+ phoneArrayList.get(i).getPrice() + "..." +
                    "信息" +phoneArrayList.get(i).getMessage());
        }
    }

    private ArrayList<Phone> filter(ArrayList<Phone> arrayList, double price) {
        ArrayList<Phone> phoneArrayList = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).getPrice() > price) {
                phoneArrayList.add(arrayList.get(i));
            }
        }
        return phoneArrayList;
    }

    private int generatePhonePrice() {
        Random random = new Random();
        int price = random.nextInt(1800) + 1800;
        return price;
    }
}
