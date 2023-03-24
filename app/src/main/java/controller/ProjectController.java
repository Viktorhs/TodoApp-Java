/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author victor
 */
public class ProjectController {
     public void save(Project project) throws SQLException{
        
        String sql = "INSERT INTO projects (name, "
                + "description, "
                + "created_at, "
                + "updated_at) values (?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.execute();
            
        }catch(Exception ex){
            throw new RuntimeException("Erro ao salvar o projeto " + 
                    ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
    public void update(Project project){
        
        String sql = "UPDATE projects SET "
                + "name = ?, "
                + "description = ?, "
                + "created_at = ?, "
                + "updated_at = ? "
                + "WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date(project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();
            
        }catch(Exception ex){
            throw new RuntimeException("Erro ao atualizar o projeto " + 
                    ex.getMessage(), ex);
        }finally{
            ConnectionFactory.closeConnection(conn, statement);
        }
    }
    
    public void removeById(int projectId) throws SQLException{
        
        String sql = "DELETE FROM projects WHERE id = ?";
        
        Connection conn = null;
        PreparedStatement statement = null;
        
        try{
            
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, projectId);
            statement.execute();
            
        }catch (Exception ex){
            throw new RuntimeException("Erro ao deletar o projeto " + 
                    ex.getMessage(), ex);
        }finally {
            ConnectionFactory.closeConnection(conn, statement);
        }
        
    }
    
    public List<Project> getAll(){
        
        String sql = "SELECT * FROM projects";
        
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Project> projects = new ArrayList<Project>();
        
        try{
            
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("created_at"));
                project.setUpdatedAt(resultSet.getDate("updated_at"));
                
                projects.add(project);
            }
            
            
            return projects;
            
        }catch (Exception ex){
            throw new RuntimeException("Erro ao obter as tarefas " + 
                    ex.getMessage(), ex);
        }finally {
            ConnectionFactory.closeConnection(conn, statement, resultSet);
        }
        
        
    }
}
