package dao;

import domain.Manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ManagerDao {
    private static ArrayList<Manager> managerArrayList = new ArrayList<>();


    private ArrayList<Manager> readMangerInfo(ArrayList<Manager> managerArrayList) {
        BufferedReader bufferedReader = null;
        String str;

        try {
            bufferedReader = new BufferedReader(new FileReader("/Users/willdufresne/Documents/黑马Java/就业班考试1/src/mamagers.txt"));
            while ((str = bufferedReader.readLine()) != null) {
                String[] managerInfo = str.split(",");
                if (managerInfo.length == 4) {
                    Manager manager = new Manager(managerInfo[0], managerInfo[1], managerInfo[2], managerInfo[3]);
                    managerArrayList.add(manager);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return managerArrayList;
    }

    private ArrayList<Manager> getManagers() {
        return readMangerInfo(managerArrayList);
    }

    public ArrayList<Manager> invokeGetManagers() {
        return getManagers();
    }
}
