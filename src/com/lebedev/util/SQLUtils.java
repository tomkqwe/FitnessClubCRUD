package com.lebedev.util;

public final class SQLUtils {
    public static final String SELECT_ALL = """
                                    SELECT t.id,
                   c.last_name||' '||c.first_name as trainer_fullname,
                   c2.last_name||' '||c2.first_name as client_fullname,
                   price as price,
                   s.duration_hours as duration
            FROM fitness_club_db.traning AS t
            join  fitness_club_db.coach c on c.id = t.coach_id
            join  fitness_club_db.client c2 on t.client_id = c2.id
            join  fitness_club_db.schedule s on c.id = s.coach_id
                                    """;

    public static final String SELECT_BY_ID = SELECT_ALL + """
            WHERE t.id = ?;
            """;

    private SQLUtils() {
    }
}
