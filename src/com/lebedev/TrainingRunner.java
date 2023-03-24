package com.lebedev;

import com.lebedev.dao.TrainingDaoImpl;

public class TrainingRunner {
    public static void main(String[] args) {
        testGetAll();
        testGetById();

    }

    private static void testGetById() {
        var trainingDao = new TrainingDaoImpl();
        var training = trainingDao.get(10);
        System.out.println(training);
    }

    private static void testGetAll() {
        var trainingDao = new TrainingDaoImpl();
        var all = trainingDao.getAll();
        System.out.println(all);
    }
}
