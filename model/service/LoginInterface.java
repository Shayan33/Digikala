package model.service;

import java.rmi.Remote;

public interface LoginInterface extends Remote {
    public Boolean validateUser(String username, String password) throws Exception;

}

