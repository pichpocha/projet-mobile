/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import Entities.Offre;
import Utils.Statics;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Bechir Hassine
 */
public class ServiceOffre {
     public ArrayList<Offre> tasks;
    public static ServiceOffre instance=null;
    public boolean resultOK;
   private ConnectionRequest req;
   double tmestampDate,tmestampDate1;
     public ServiceOffre() {
         req = new ConnectionRequest();
    }
        public static ServiceOffre getInstance() {
        if (instance == null) {
            instance = new ServiceOffre();
        }
        return instance;
    }
        
    public ArrayList<Offre> parseTasks(String jsonText){
        try {
            tasks=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            
         
         
            for(Map<String,Object> obj : list){
                int idu=8;
               
                Offre t = new Offre();
                System.out.println(t);
                       
                float idoffre = Float.parseFloat(obj.get("idOffre").toString());
                t.setId_offre((int)idoffre);
                t.setPrix(((int)Float.parseFloat(obj.get("prix").toString())));
                t.setDescription(obj.get("description").toString());
                t.setTitre(obj.get("titre").toString());
                t.setEmplacement(obj.get("emplacement").toString());
                t.setImage(obj.get("image").toString());
                t.setId_user((int)idu);
        
           
 
                
                
                
                //Ajouter la tâche extraite de la réponse Json à la liste
                tasks.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
         /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        return tasks;
    }
    
    public ArrayList<Offre> RecupererOffres(){
        String url = Statics.BASE_URL+"/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                tasks = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
    public ArrayList<Offre> GetMyOffre(int user){
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/untitled/web/app_dev.php/offre/Get/"+user);
         con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                tasks = parseTasks(new String(con.getResponseData()));
                con.removeResponseListener(this);
                System.out.println(tasks);                      
            }
         });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return tasks;
    }
    
    public void addOffre(Offre offre) {
        System.out.println(offre.getImage());
        String url = "http://localhost/untitled/web/app_dev.php/offre/Add?titre="+offre.getTitre()+"&userid="+offre.getId_user()+"&desc="+offre.getDescription()+"&empla="+offre.getEmplacement()+"&prix="+offre.getPrix()+"&img="+offre.getImage();
        ConnectionRequest con = new ConnectionRequest(url, true);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
    }
    
    public void editOffre(Offre o) {
       String url = "http://localhost/untitled/web/app_dev.php/offre/Edit?titre="+o.getTitre()+"&desc="+o.getDescription()+"&empla="+o.getEmplacement()+"&prix="+o.getPrix();
        ConnectionRequest con = new ConnectionRequest(url, true);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con); 
    }
    public void DeleteOffre(int id){
       
        String url = "http://localhost/untitled/web/app_dev.php/offre/Delete/"
                + id;
        ConnectionRequest con = new ConnectionRequest(url, true);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }

    
        
    
}
