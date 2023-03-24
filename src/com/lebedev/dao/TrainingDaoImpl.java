package com.lebedev.dao;

import com.lebedev.dto.TrainingDTO;
import com.lebedev.entity.Training;
import com.lebedev.exception.DaoException;
import com.lebedev.util.ConnectionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.lebedev.util.SQLUtils.*;

public class TrainingDaoImpl implements Dao<Training> {

    @Override
    public Optional<Training> get(int id) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(SELECT_BY_ID)) {
            preparedStatement.setInt(1, id);
            var resultSet = preparedStatement.executeQuery();
            Training training = null;
            if (resultSet.next()) {
                training = buildTraining(resultSet);
            }
            return Optional.ofNullable(training);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Training> getAll() {
        try (var connection = ConnectionManager.get();
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
    public void update(TrainingDTO dto) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, dto.coachId());
            preparedStatement.setInt(2, dto.sportId());
            preparedStatement.setInt(3, dto.clientId());
            preparedStatement.setDouble(4, dto.price());
            preparedStatement.setInt(5, dto.scheduleId());
            preparedStatement.setInt(6, dto.id());
            var i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            throw new DaoException(e);
        }

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
