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
import static java.sql.Statement.RETURN_GENERATED_KEYS;

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
    public TrainingDTO save(TrainingDTO dto) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(INSERT, RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, dto.getCoachId());
            preparedStatement.setInt(2, dto.getSportId());
            preparedStatement.setInt(3, dto.getClientId());
            preparedStatement.setDouble(4, dto.getPrice());
            preparedStatement.setInt(5, dto.getScheduleId());
            preparedStatement.executeUpdate();
            var resultSet = preparedStatement.getGeneratedKeys();
            TrainingDTO resultDTO = null;
            if (resultSet.next()) {
                var id = resultSet.getInt("id");
                resultDTO = new TrainingDTO(id, dto.getCoachId(), dto.getSportId(), dto.getClientId(), dto.getPrice(), dto.getScheduleId());
            }
            return resultDTO;
        } catch (SQLException e) {
            throw new DaoException(e);
        }


    }

    @Override
    public void update(TrainingDTO dto) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, dto.getCoachId());
            preparedStatement.setInt(2, dto.getSportId());
            preparedStatement.setInt(3, dto.getClientId());
            preparedStatement.setDouble(4, dto.getPrice());
            preparedStatement.setInt(5, dto.getScheduleId());
            preparedStatement.setInt(6, dto.getId());
            var i = preparedStatement.executeUpdate();
            System.out.println(i);
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    @Override
    public boolean delete(int id) {
        try (var connection = ConnectionManager.get();
             var preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            var i = preparedStatement.executeUpdate();
            return i == 1;
        } catch (SQLException e) {
            throw new DaoException(e);
        }

    }

    private Training buildTraining(ResultSet resultSet) throws SQLException {
        return new Training(resultSet.getInt("id"),
                resultSet.getString("trainer_fullname"),
                resultSet.getString("client_fullname"),
                resultSet.getDouble("price"),
                resultSet.getInt("duration"));
    }
}
