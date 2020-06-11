/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import APP.CleanModern;
import Entities.Offre;
import Services.ServiceOffre;
import com.codename1.facebook.FBObject;
import com.codename1.facebook.FaceBookAccess;
import com.codename1.messaging.Message;
import com.codename1.share.FacebookShare;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author Bechir Hassine
 */
public class mesOffresdForm extends Form {
     final Resources res;
    static Offre Offres;
    private Offre Offre;
   

    public mesOffresdForm() {
        super("Details Offre", new BorderLayout());
        this.res = CleanModern.stheme;
        this.Offre = Offres;
     

        
        Container north = new Container(new FlowLayout(Component.CENTER));
        north.setUIID("BoutiqueAuto");

        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(this.getWidth() / 2, this.getHeight() / 5, 0xFFFFFFFF), true);
        Image img = URLImage.createToStorage(placeholder, Offre.getImage(), "http://localhost/untitled/web/Uploads/images/" + Offre.getImage(),
                URLImage.RESIZE_SCALE_TO_FILL);
        north.add(img);


        this.addComponent(BorderLayout.NORTH, north);

        Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        center.setUIID("AutoCentre");
        
        Label titre = new Label("Titre : "+Offre.getTitre());
        titre.setUIID("AutoInfo");
        center.addComponent(titre);
        
      
        Label iduser = new Label("Auteur ID : "+Offre.getId_user());
        iduser.setUIID("AutoInfo");
        center.addComponent(iduser);

        Label descr = new Label("Description: ");
        descr.setUIID("AutoInfo");
        center.addComponent(descr);
        
        TextArea desc = new TextArea(Offre.getDescription());
        desc.setUIID("AutoInfo");
        center.addComponent(desc);
        
        Label Emplacement = new Label("Emplacement: ");
        descr.setUIID("AutoInfo");
        center.addComponent(Emplacement);
        
        TextArea Emplacementi = new TextArea(Offre.getEmplacement());
        desc.setUIID("AutoInfo");
        center.addComponent(Emplacementi);
        
         Label Prix = new Label("Prix: ");
        descr.setUIID("AutoInfo");
        center.addComponent(Prix);
        
        String s=String.valueOf(Offre.getPrix());  
        TextArea prixi = new TextArea(s);
        desc.setUIID("AutoInfo");
        center.addComponent(prixi);
        

        Button btnModifier = new Button("Modifier Article");
        center.addComponent(btnModifier);
       btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                EditOffre.Offres=Offre;
                Form bdf = new EditOffre();
                bdf.show();
            }
        }); 
       
       Button btnSupp = new Button("Supprimer Offre");
        center.addComponent(btnSupp);
       btnSupp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ServiceOffre SO = new ServiceOffre();
                SO.DeleteOffre(Offre.getId_offre());
                Form bdf = new myOffres(res);
                bdf.show();
               
            }
        });
        Button btnshare = new Button("Share Offre");
        center.addComponent(btnshare);
       btnshare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Message m = new Message("<html><body>Check out <a href=\"https://www.codenameone.com/\">Codename One</a></body></html>");
               //File imageAttachmentUri= new File("http://localhost/untitled/web/Uploads/images/" + Offre.getImage());
                 m.setMimeType(Message.MIME_HTML);
                m.getAttachments().put("http://localhost/untitled/web/Uploads/images/" + Offre.getImage(), "image/png");
                Display.getInstance().sendMessage(new String[] {"pichpocha@gmail.com"}, Offre.getTitre(), m);
                
               
               
            }
        });
       Button btnAdd = new Button("share");
            btnAdd.addActionListener(cliqueEvent -> {
                Form bdf = new myOffres(res);
                  bdf.show();
                });
            north.addComponent(btnAdd);
        
        this.addComponent(BorderLayout.CENTER, center);
            this.addCommand(new Command("Retour") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                Form bdfa = new myOffres(res);
                    bdfa.show();
            }
        });
            
           

    }
    
   
    
    
}
