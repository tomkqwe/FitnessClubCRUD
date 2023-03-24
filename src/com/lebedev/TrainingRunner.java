package com.lebedev;

import com.lebedev.dao.TrainingDaoImpl;

public class TrainingRunner {
    public static void main(String[] args) {
        testGetAll();
    }

    private static void testGetAll() {
        var trainingDao = new TrainingDaoImpl();
        var all = trainingDao.getAll();
        System.out.println(all);
    }
}
