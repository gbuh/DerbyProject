package dao.impl;

import dao.UserMDao;
import entity.UserM;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserMDaoImpl extends BaseDaoImpl implements UserMDao {

    @Override
    public void create(UserM userM) {// if returned value Long then resultset needed
        String sql =
                "INSERT INTO userm (user_id, user_name, user_email, user_password, user_role) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            Long id = null;
            rs = ps.getGeneratedKeys();
            if (rs != null && rs.next()) {
                id = rs.getLong(1);
            } else {
                id = userM.getId();
            }
            ps.setLong(1, id);
            ps.setString(2, userM.getName());
            ps.setString(3, userM.getEmail());
            ps.setString(4, userM.getPassword());
            ps.setString(5, userM.getRole());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public UserM read(Long id) {
        String sql = "SELECT * FROM userm WHERE user_id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserM userM = null;
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                userM = new UserM();
                userM.setId(id);
                userM.setName(rs.getString("user_name"));
                userM.setEmail(rs.getString("user_email"));
                userM.setPassword(rs.getString("user_password"));
                userM.setRole(rs.getString("user_role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userM;
    }

    @Override
    public void update(UserM userM) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM userm WHERE user_id = ?";
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<UserM> readAll() {
        String sql = "SELECT * FROM userm";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserM> userMs = new ArrayList<>();
        try {
            ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UserM user = new UserM();
                user.setId(rs.getLong("user_id"));
                user.setName(rs.getString("user_name"));
                user.setEmail(rs.getString("user_email"));
                user.setPassword(rs.getString("user_password"));
                user.setRole(rs.getString("user_role"));
                userMs.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userMs;
    }
}
