
import com.incca.storegameapi.helper.ConnectionDB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Home
 */
public class Test {
    public static void main(String[] args) {
        ConnectionDB b = new ConnectionDB();
        b.getConnection();
        b.close();
    }
}
