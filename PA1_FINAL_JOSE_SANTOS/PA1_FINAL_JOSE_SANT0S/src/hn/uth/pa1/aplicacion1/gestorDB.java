/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.aplicacion1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author uth
 */
public class gestorDB {

    /**
     * Retorna una conexion a la base de datos derby local
     *
     * @return objeto conexion
     */
    public static Connection getConexion() {
        try {
            String usuario = "uth";
            String contrasenia = "uth";
            String url = "jdbc:derby://localhost:1527/uth";

            return DriverManager.getConnection(url, usuario, contrasenia);
        } catch (Exception e) {
            System.out.println("Error getConexion: " + e.toString());
        }
        return null;
    }

    public static void guardarHumano(
            int id,
            String identidad,
            String nombre,
            String apellido,
            double peso,
            int A_nacimiento,
            double P_equipaje
                   
    ) {
        try {
            //1.- Obtener la conexion
            Connection con = getConexion();

            //2.- SQL de insert
            String sql = "insert into UTH.PASAJEROS "
                    + "(ID, IDENTIDAD, NOMBRE, APELLIDO, PESO, A_NACIMIENTO, P_EQUIPAJE)  "
                    + "values "
                    + "(?,?,?,?,?,?,?)";

            //3. Preparar el query
            PreparedStatement ps = con.prepareStatement(sql);

            //4. Asignar valores a los signos de interrogacion
            ps.setInt(1, id);
            ps.setString(2, identidad);
            ps.setString(3, nombre);
            ps.setString(4, apellido);
            ps.setDouble(5, peso);
            ps.setInt(6, A_nacimiento);
            ps.setDouble(7, P_equipaje);

            //5. Ejecutar el query
            ps.execute();

            //6. Cerrar la conexion
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error guardarPasajero: " + e.toString());
        }
    }

    public static void actualizarHumano(
            int id,
            String identidad,
            String nombre,
            String apellido,
            double peso,
            int A_nacimiento,
            double P_equipaje
    ) {
        try {
            //1.- Obtener la conexion
            Connection con = getConexion();

            //2.- SQL de Update
            String sql = "UPDATE UTH.PASAJEROS "
                    + "SET IDENTIDAD=?, "
                    + "    NOMBRE=?, "
                    + "    APELLIDO=?, "
                    + "    PESO=?, "
                    + "    A_NACIMIENTO=?, "
                    + "    P_EQUIPAJE=? "
                    + "WHERE ID=? ";

            //3. Preparar el query
            PreparedStatement ps = con.prepareStatement(sql);

            //4. Asignar valores a los signos de interrogacion
            ps.setInt(7, id);
            ps.setString(1, identidad);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setDouble(4, peso);
            ps.setInt(5, A_nacimiento);
            ps.setDouble(6, P_equipaje);
            

            //5. Ejecutar el query
            ps.executeUpdate();

            //6. Cerrar la conexion
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error actualizarPasajero: " + e.toString());
        }
    }

    public static void eliminarHumano(
            int id
    ) {
        try {
            //1.- Obtener la conexion
            Connection con = getConexion();

            //2.- SQL de Update
            String sql = 
                    "DELETE FROM UTH.PASAJEROS " +
                    "WHERE ID=?";

            //3. Preparar el query
            PreparedStatement ps = con.prepareStatement(sql);

            //4. Asignar valores a los signos de interrogacion
            ps.setInt(1, id);

            //5. Ejecutar el query
            ps.executeUpdate();

            //6. Cerrar la conexion
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error eliminarPasajero: " + e.toString());
        }
    }
    
    public static void getHumanos() {
        try {
            //1.- Obtener la conexion
            Connection con = getConexion();

            //2.- SQL de Update
            String sql = 
                    "SELECT * " +
                    "FROM UTH.PASAJEROS";

            //3. Preparar el query
            Statement st = con.createStatement();

            //4. Ejecutar el query
            ResultSet rs=st.executeQuery(sql);

            //5. Leer el resultado
            while(rs.next()){
                System.out.print(rs.getInt("ID"));
                System.out.print(rs.getString("NOMBRE"));
                System.out.print(rs.getString("APELLIDO"));
            }
            
            //6. Cerrar la conexion
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error getPasajero: " + e.toString());
        }
    }
    
    public static void getHumanos(
            int id
    ) {
        try {
            //1.- Obtener la conexion
            Connection con = getConexion();

            //2.- SQL de Update
            String sql = 
                    "SELECT * " +
                    "FROM UTH.PASAJEROS " +
                    "WHERE ID = ? ";

            //3. Preparar el query
            PreparedStatement ps = 
                    con.prepareStatement(sql);
            ps.setInt(1, id);
            
            //4. Ejecutar el query
            ResultSet rs=ps.executeQuery();

            //5. Leer el resultado
            while(rs.next()){
                System.out.print(rs.getInt("ID"));
                System.out.print(rs.getString("NOMBRE"));
                System.out.print(rs.getString("APELLIDO"));
            }
            
            //6. Cerrar la conexion
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error getHumanos: " + e.toString());
        }
    }    
}
