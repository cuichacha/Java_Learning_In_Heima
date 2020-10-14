package service;

import dao.SubwayDao;
import domain.Subway;

import java.util.ArrayList;

public class SubwayService {
    private SubwayDao subwayDao = new SubwayDao();
    private ArrayList<Subway> subways = subwayDao.invokeGetSubways();

    private boolean findSubway(String number) {
        for (Subway subway : subways) {
            if (number.equals(subway.getNumber())) {
                return true;
            }
        }
        return false;
    }

    public boolean invokeFindSubway(String number) {
        return findSubway(number);
    }

    private boolean isEmpty() {
        return subways.isEmpty();
    }

    public boolean invokeIsEmpty() {
        return isEmpty();
    }

    private void printSubways() {
        for (Subway subway : subways) {
            System.out.println(subway.getNumber() + "--" + subway.getName() + "--" + subway.getLine());
        }
    }

    public void invokePrintSubways() {
        printSubways();
    }

    private boolean addSubway(Subway subway) {
        String number = subway.getNumber();
        if (findSubway(number)) {
            return false;
        } else {
            subwayDao.invokeAddSubway(subway);
            return true;
        }
    }

    public boolean invokeAddSubway(Subway subway) {
        return addSubway(subway);
    }
}
