/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.User;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import Entities.User;
import com.codename1.ui.TextField;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mega-PC
 */
public class UserService {
       
      public static UserService instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public User User = new User();

    public UserService() {
        req = new ConnectionRequest();
    }

    public static UserService getInstance() {

        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public User parseUser(String jsonText) {
   
        User UserL = new User();
        try {
            JSONParser j = new JSONParser();

            Map<String, Object> UserListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            
                float id = Float.parseFloat(UserListJson.get("id").toString());
                UserL.setId((int) (id));
                
                
                UserL.setUsername(UserListJson.get("username").toString());

                

           

        } catch (IOException ex) {
                ex.getMessage();
        }

        return UserL;
    }

    public User Login(String Username,String password) {
        String url ="http://localhost/untitled/web/app_dev.php/login/"+Username+"/"+password;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                User = parseUser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return User;
    
    }

    public User findby(TextField Username) {
          String url ="http://localhost/untitled/web/app_dev.php/offre/find/"+Username;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                User = parseUser(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return User;
    }
        
}
