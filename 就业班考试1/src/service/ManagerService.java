package service;

import dao.ManagerDao;
import domain.Manager;

import java.util.ArrayList;

public class ManagerService {
    private ManagerDao managerDao = new ManagerDao();
    private ArrayList<Manager> managers = managerDao.invokeGetManagers();

    private boolean findManager(String id, String name) {
        for (Manager manager : managers) {
            if (id.equals(manager.getId()) && name.equals(manager.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean invokeFindManager(String id, String name) {
        return findManager(id, name);
    }

}
