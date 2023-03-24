package com.lebedev.dao;

import com.lebedev.entity.Training;
import com.lebedev.exception.DaoException;
import com.lebedev.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.lebedev.util.SQLUtils.SELECT_ALL;

public class TrainingDaoImpl implements Dao<Training> {

    @Override
    public Optional<Training> get(int id) {
        return Optional.empty();
    }

    @Override
    public List<Training> getAll() {
        try (var connection = ConnectionManager.getConnection();
             var preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            var resultSet = preparedStatement.executeQuery();
            var trainings = new ArrayList<Training>();
            while (resultSet.next()) {
                trainings.add(buildTraining(resultSet));
            }
            return trainings;

        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }


    @Override
    public void save(Training training) {

    }

    @Override
    public void update(Training training, String[] params) {

    }

    @Override
    public void delete(Training training) {

    }

    private Training buildTraining(ResultSet resultSet) throws SQLException {
        return new Training(resultSet.getInt("id"),
                resultSet.getString("trainer_fullname"),
                resultSet.getString("client_fullname"),
                resultSet.getDouble("price"),
                resultSet.getInt("duration"));
    }
}
