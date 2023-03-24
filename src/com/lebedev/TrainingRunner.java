package com.lebedev;

import com.lebedev.dao.TrainingDaoImpl;
import com.lebedev.dto.TrainingDTO;

public class TrainingRunner {
    public static void main(String[] args) {
        var trainingDao = new TrainingDaoImpl();
        testGetAll(trainingDao);
        testGetById(trainingDao);
        testUpdate(trainingDao);
        testDelete(trainingDao);
        testInsert(trainingDao);

    }

    private static void testInsert(TrainingDaoImpl trainingDao) {
        var save = trainingDao.save(new TrainingDTO(3, 3, 24, 8888, 3));
        System.out.println(save);
    }

    private static void testDelete(TrainingDaoImpl trainingDao) {
        var delete = trainingDao.delete(10);
        System.out.println(delete);
    }

    private static void testUpdate(TrainingDaoImpl trainingDao) {
        var trainingDTO = new TrainingDTO(1, 3, 2, 21, 7777, 3);
        trainingDao.update(trainingDTO);

    }

    private static void testGetById(TrainingDaoImpl trainingDao) {
        var training = trainingDao.get(32);
        System.out.println(training);
    }

    private static void testGetAll(TrainingDaoImpl trainingDao) {
        var all = trainingDao.getAll();
        System.out.println(all);
    }
}
