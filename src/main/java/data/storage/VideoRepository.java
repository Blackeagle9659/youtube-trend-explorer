package data.storage;

import data.model.VideoData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VideoRepository {
    
    private final String DB_URL = "jdbc:sqlite:trends.db";

    public VideoRepository() {
        
        String createTableQuery = "CREATE TABLE IF NOT EXISTS videos ("
                       + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                       + "title TEXT, "
                       + "publish_date TEXT, "
                       + "views TEXT, "
                       + "likes TEXT, "
                       + "labels TEXT)";
        
        try (Connection connection = DriverManager.getConnection(DB_URL); // Java ile SQL iletişimini bağlıyor.
             Statement statement = connection.createStatement()) {
            
            statement.execute(createTableQuery);
            System.out.println("[DATABASE] The table is ready.");
            
        } catch (SQLException e) {
            System.out.println("[DB ERROR] Failed to create table: " + e.getMessage());
        }
    }

    public void videoRecord(VideoData newVideo) {
        
        String insertQuery = "INSERT INTO videos (title, publish_date, views, likes, labels) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection connection = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {
            
            pstmt.setString(1, newVideo.getTextVideo());
            pstmt.setString(2, newVideo.getDate());
            pstmt.setString(3, newVideo.getView());
            pstmt.setString(4, newVideo.getLike());
            pstmt.setString(5, newVideo.getLabelElement());
            
            pstmt.executeUpdate(); 
            System.out.println("[DATABASE] New video successfully logged.");
            
        } catch (SQLException e) {
            System.out.println("[DB ERROR] Failed to insert record: " + e.getMessage());
        }
    }

    public int numberOfVideo() {
        
        String countQuery = "SELECT COUNT(*) AS total FROM videos";
        
        try (Connection connection = DriverManager.getConnection(DB_URL);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(countQuery)) {
            
            return resultSet.getInt("total"); 
            
        } catch (SQLException e) {
            return 0; 
        }
    }
}