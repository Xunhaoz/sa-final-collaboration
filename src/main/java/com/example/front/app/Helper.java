package com.example.front.app;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

import com.example.front.util.DBMgr;
import org.json.JSONArray;

public class Helper {
    private Helper() {
    }

    private static Helper helper;
    private Connection conn = null;
    private PreparedStatement pres = null;

    public static Helper getHelper() {
        if (helper == null) helper = new Helper();
        return helper;
    }

    public void createCourse(Course course) {
        try {
            conn = DBMgr.getConnection();
            String sql = "INSERT INTO `front`.`course`(`title`, `teacher`, `content`, `difficulty`, `midterm_time`, `final_time`) VALUES(?, ?, ?, ?, ?, ?)";
            pres = conn.prepareStatement(sql);
            pres.setString(1, course.getTitle());
            pres.setString(2, course.getTeacher());
            pres.setString(3, course.getContent());
            pres.setString(4, course.getDifficulty());
            pres.setDate(5, course.getMidtermTime());
            pres.setDate(6, course.getFinalTime());
            pres.execute();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void createUser(User user) {
        try {
            conn = DBMgr.getConnection();
            String sql = "INSERT INTO `front`.`user`(`first_name`, `last_name`, `email`, `password`, `identity`, `salt`) VALUES(?, ?, ?, ?, ?, ?)";
            pres = conn.prepareStatement(sql);
            pres.setString(1, user.getFirstName());
            pres.setString(2, user.getLastName());
            pres.setString(3, user.getEmail());
            pres.setString(4, user.getPassword());
            pres.setBoolean(5, user.getIdentity());
            pres.setString(6, user.getSalt());
            pres.execute();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void createStudentCourse(StudentCourse studentCourse) {
        try {
            conn = DBMgr.getConnection();
            String sql = "INSERT INTO `front`.`student_course`(`student_id`, `course_id`) VALUES(?, ?)";
            pres = conn.prepareStatement(sql);
            pres.setInt(1, studentCourse.getStudentId());
            pres.setInt(2, studentCourse.getCourseId());
            pres.execute();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void createLoginLog(LoginLog login_log) {
        try {
            conn = DBMgr.getConnection();
            String sql = "INSERT INTO `front`.`login_log`(`token`, `ip_address`, `browser`, `os`) VALUES(?, ?, ?, ?)";
            pres = conn.prepareStatement(sql);
            pres.setString(1, login_log.getToken());
            pres.setString(2, login_log.getIpAddress());
            pres.setString(3, login_log.getBrowser());
            pres.setString(4, login_log.getOs());
            pres.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void createAudio(Audio audio) {
        try {
            conn = DBMgr.getConnection();
            String sql = "INSERT INTO `front`.`audio`(`class_id`, `user_id`, `text`, `path`) VALUES(?, ?, ?, ?)";
            pres = conn.prepareStatement(sql);
            pres.setInt(1, audio.getClassId());
            pres.setInt(2, audio.getUserId());
            pres.setString(3, audio.getText());
            pres.setString(4, audio.getPath());
            pres.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void createScore(ScoreTable scoreTable) {
        try {
            conn = DBMgr.getConnection();
            String sql = "INSERT INTO `front`.`score`(`student_id`, `audio_id`, `final_score`, `intonation`, `loudness`, `phrasing`, `pronunciation`, `rhythm`, `speed`, `intonation_command`, `loudness_command`, `phrasing_command`, `pronunciation_command`, `rhythm_command`, `speed_command`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pres = conn.prepareStatement(sql);
            pres.setInt(1, scoreTable.getStudentId());
            pres.setInt(2, scoreTable.getAudioId());
            pres.setInt(3, scoreTable.getFinalScore());
            pres.setInt(4, scoreTable.getIntonation());
            pres.setInt(5, scoreTable.getLoudness());
            pres.setInt(6, scoreTable.getPhrasing());
            pres.setInt(7, scoreTable.getPronunciation());
            pres.setInt(8, scoreTable.getRhythm());
            pres.setInt(9, scoreTable.getSpeed());
            pres.setString(10, scoreTable.getIntonationCommand());
            pres.setString(11, scoreTable.getLoudnessCommand());
            pres.setString(12, scoreTable.getPhrasingCommand());
            pres.setString(13, scoreTable.getPronunciationCommand());
            pres.setString(14, scoreTable.getRhythmCommand());
            pres.setString(15, scoreTable.getSpeedCommand());
            pres.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void createStudentAudio(Audio audio) {
        try {
            conn = DBMgr.getConnection();
            String sql = "INSERT INTO `front`.`audio`(`class_id`, `user_id`, `audio_id`, `text`, `path`) VALUES(?, ?, ?, ?, ?)";
            pres = conn.prepareStatement(sql);
            pres.setInt(1, audio.getClassId());
            pres.setInt(2, audio.getUserId());
            pres.setInt(3, audio.getAudioId());
            pres.setString(4, audio.getText());
            pres.setString(5, audio.getPath());
            pres.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public User selectUserByEmail(String email) {
        ResultSet res = null;
        User user = null;

        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `front`.`user` WHERE `email`=?";
            pres = conn.prepareStatement(sql);
            pres.setString(1, email);
            res = pres.executeQuery();

            if (res.next()) {
                user = new User(res.getInt("id"), res.getString("first_name"), res.getString("last_name"), res.getString("email"), res.getString("password"), res.getBoolean("identity"), res.getString("salt"));
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
        return user;
    }

    public User selectUserById(int id) {
        ResultSet res = null;
        User user = null;

        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `front`.`user` WHERE `id`=?";
            pres = conn.prepareStatement(sql);
            pres.setInt(1, id);
            res = pres.executeQuery();

            if (res.next()) {
                user = new User(res.getInt("id"), res.getString("first_name"), res.getString("last_name"), res.getString("email"), res.getString("password"), res.getBoolean("identity"), res.getString("salt"));
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
        return user;
    }

    public JSONArray selectLoginLog() {
        ResultSet res = null;
        LoginLog loginLog = null;
        JSONArray ja = new JSONArray();
        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `front`.`login_log`";
            pres = conn.prepareStatement(sql);
            res = pres.executeQuery();

            while (res.next()) {
                loginLog = new LoginLog(res.getInt("id"), res.getString("token"), res.getString("ip_address"), res.getString("browser"), res.getString("os"), res.getTimestamp("login_time"));
                ja.put(loginLog.getObject());
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
        return ja;
    }

    public JSONArray selectCourse() {
        ResultSet res = null;
        Course course = null;
        JSONArray ja = new JSONArray();

        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `front`.`course`";
            pres = conn.prepareStatement(sql);
            res = pres.executeQuery();
            while (res.next()) {
                course = new Course(res.getInt("id"), res.getString("title"), res.getString("teacher"), res.getString("content"), res.getString("difficulty"), res.getDate("midterm_time"), res.getDate("final_time"), res.getTimestamp("create_time"));
                ja.put(course.getObject());
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }

        return ja;
    }

    public Set<Integer> selectStudentCourse() {
        ResultSet res = null;
        Set<Integer> s = new HashSet<>();

        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `front`.`student_course`";
            pres = conn.prepareStatement(sql);
            res = pres.executeQuery();
            while (res.next()) {
                s.add(res.getInt("course_id"));
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }

        return s;
    }

    public Course selectCourseById(int id) {
        ResultSet res = null;
        Course course = null;
        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `front`.`course` WHERE `id`=?";
            pres = conn.prepareStatement(sql);
            pres.setInt(1, id);
            res = pres.executeQuery();
            if (res.next()) {
                course = new Course(res.getInt("id"), res.getString("title"), res.getString("teacher"), res.getString("content"), res.getString("difficulty"), res.getDate("midterm_time"), res.getDate("final_time"), res.getTimestamp("create_time"));
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
        return course;
    }

    public JSONArray selectAudio(int classId) {
        ResultSet res = null;
        JSONArray jsa = new JSONArray();
        Audio audio = null;
        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `front`.`audio` WHERE audio_id IS NULL AND class_id=?";
            pres = conn.prepareStatement(sql);
            pres.setInt(1, classId);
            res = pres.executeQuery();
            while (res.next()) {
                audio = new Audio(res.getInt("id"), res.getInt("class_id"), res.getInt("audio_id"), res.getInt("user_id"), res.getString("text"), res.getString("path"), res.getString("feature_token"));
                jsa.put(audio.getJSONObject());
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
        return jsa;
    }

    public Audio selectAudioById(int id) {
        ResultSet res = null;
        Audio audio = null;
        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `front`.`audio` WHERE id=?";
            pres = conn.prepareStatement(sql);
            pres.setInt(1, id);
            res = pres.executeQuery();
            if (res.next()) {
                audio = new Audio(res.getInt("id"), res.getInt("class_id"), res.getInt("audio_id"), res.getInt("user_id"), res.getString("text"), res.getString("path"), res.getString("feature_token"));
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
        return audio;
    }

    public Audio selectAudioByPath(String path) {
        ResultSet res = null;
        Audio audio = null;
        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `front`.`audio` WHERE path=?";
            pres = conn.prepareStatement(sql);
            pres.setString(1, path);
            res = pres.executeQuery();
            if (res.next()) {
                audio = new Audio(res.getInt("id"), res.getInt("class_id"), res.getInt("audio_id"), res.getInt("user_id"), res.getString("text"), res.getString("path"), res.getString("feature_token"));
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
        return audio;
    }
    public JSONArray selectScoreById(int userId) {
        ResultSet res = null;
        ScoreTable scoreTable = null;
        JSONArray jsa = new JSONArray();
        try {
            conn = DBMgr.getConnection();
            String sql = "SELECT * FROM `front`.`score` WHERE student_id=?";
            pres = conn.prepareStatement(sql);
            pres.setInt(1, userId);
            res = pres.executeQuery();
            while (res.next()) {
                scoreTable = new ScoreTable(res.getInt("id"), res.getInt("final_score"), res.getDate("create_date"));
                jsa.put(scoreTable.getObject());
                System.out.println(scoreTable.getObject().toString());
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
        return jsa;
    }

    public void updateUser(User user) {
        try {
            conn = DBMgr.getConnection();
            String sql = "UPDATE `front`.`user` SET `first_name`=?, `last_name`=?, `email`=?, `password`=?, `identity`=? WHERE `id`=?";
            pres = conn.prepareStatement(sql);
            pres.setString(1, user.getFirstName());
            pres.setString(2, user.getLastName());
            pres.setString(3, user.getEmail());
            pres.setString(4, user.getPassword());
            pres.setBoolean(5, user.getIdentity());
            pres.setInt(6, user.getId());
            pres.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void updateAudio(Audio audio) {
        try {
            conn = DBMgr.getConnection();
            String sql = "UPDATE `front`.`audio` SET `text`=?, `path`=? WHERE `id`=?";
            pres = conn.prepareStatement(sql);
            pres.setString(1, audio.getText());
            pres.setString(2, audio.getPath());
            pres.setInt(3, audio.getId());
            pres.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void updateAudioFeature(int id, String token) {
        try {
            conn = DBMgr.getConnection();
            String sql = "UPDATE `front`.`audio` SET `feature_token`=? WHERE `id`=?";
            pres = conn.prepareStatement(sql);
            pres.setString(1, token);
            pres.setInt(2, id);
            pres.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void updateCourse(Course course) {
        try {
            conn = DBMgr.getConnection();
            String sql = "UPDATE `front`.`course` SET `title`=?, `teacher`=?, `content`=?, `difficulty`=?, `midterm_time`=?, `final_time`=? WHERE `id`=?";
            pres = conn.prepareStatement(sql);
            pres.setString(1, course.getTitle());
            pres.setString(2, course.getTeacher());
            pres.setString(3, course.getContent());
            pres.setString(4, course.getDifficulty());
            pres.setDate(5, course.getMidtermTime());
            pres.setDate(6, course.getFinalTime());
            pres.setInt(7, course.getId());
            pres.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void updateUserWithoutPassword(User user) {
        try {
            conn = DBMgr.getConnection();
            String sql = "UPDATE `front`.`user` SET `first_name`=?, `last_name`=?, `email`=?, `identity`=? WHERE `id`=?";
            pres = conn.prepareStatement(sql);
            pres.setString(1, user.getFirstName());
            pres.setString(2, user.getLastName());
            pres.setString(3, user.getEmail());
            pres.setBoolean(4, user.getIdentity());
            pres.setInt(5, user.getId());
            pres.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void deleteCourse(int id) {
        try {
            conn = DBMgr.getConnection();
            String sql = "DELETE FROM `front`.`course` WHERE `id`=?";
            pres = conn.prepareStatement(sql);
            pres.setInt(1, id);
            pres.execute();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void deleteStudentCourse(StudentCourse studentCourse) {
        try {
            conn = DBMgr.getConnection();
            String sql = "DELETE FROM `front`.`student_course` WHERE `student_id`=? AND `course_id`=?";
            pres = conn.prepareStatement(sql);
            pres.setInt(1, studentCourse.getStudentId());
            pres.setInt(2, studentCourse.getCourseId());
            pres.execute();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void deleteLoginLog(int id) {
        try {
            conn = DBMgr.getConnection();
            String sql = "DELETE FROM `front`.`login_log` WHERE `id`=?";
            pres = conn.prepareStatement(sql);
            pres.setInt(1, id);
            pres.executeUpdate();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }

    public void deleteAudio(int id) {
        try {
            conn = DBMgr.getConnection();
            String sql = "DELETE FROM `front`.`audio` WHERE `id`=?";
            pres = conn.prepareStatement(sql);
            pres.setInt(1, id);
            pres.execute();
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s\n%s", e.getErrorCode(), e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBMgr.close(pres, conn);
        }
    }


}
