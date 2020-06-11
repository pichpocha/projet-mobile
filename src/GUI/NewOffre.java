/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import APP.CleanModern;

import Entities.Offre;

import Services.ServiceOffre;
import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import com.codename1.ui.Component;

/**
 *
 * @author Bechir Hassine
 */
public class NewOffre extends Form{
    
     final Resources res;
    private Offre offre;
    private Image img;
    private String imgPath;
    
    
    public NewOffre() throws IOException {
        
        super("New Offre", new BorderLayout());
        this.res = CleanModern.stheme;

        
        Container north = new Container(new FlowLayout(Component.CENTER));
        north.setUIID("MesDemandes");


        Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        center.setUIID("AutoCentre");
        //center.addComponent;
        
        
        
        //INPUT FIELDS 
        
        Label titre = new Label("Titre: ");
        titre.setUIID("NewDemInfo");
        center.addComponent(titre);
        
        TextField input_titre = new TextField();
        input_titre.setUIID("NewDemInfo");
        center.addComponent(input_titre);
        
       Label desc = new Label("Description : ");
        desc.setUIID("NewDemInfo");
        center.addComponent(desc);
        
        TextField input_desc = new TextField();
        input_desc.setUIID("NewDemInfo");
        center.addComponent(input_desc);
        
        Label emplacement = new Label("Emplacement : ");
        emplacement.setUIID("NewDemInfo");
        center.addComponent(emplacement);
        
        TextField input_emplacement = new TextField();
        input_desc.setUIID("NewDemInfo");
        center.addComponent(input_emplacement);
        
        Label prix = new Label("Prix : ");
        emplacement.setUIID("NewDemInfo");
        center.addComponent(prix);
        
        TextField input_prix = new TextField();
        input_desc.setUIID("NewDemInfo");
        center.addComponent(input_prix);
        
        Label pap1 = new Label("Document : ");
        pap1.setUIID("NewDemInfo");
        center.addComponent(pap1);
        
        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(this.getWidth()/2, this.getHeight() / 5, 0xFFFFFFFF), true);
        img = URLImage.createToStorage(placeholder, "placeholder.png", "http://localhost/untitled/web/Uploads/images/" + "placeholder.png", URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer iv = new ImageViewer();
        iv.setImage(img);
        center.addComponent(iv);
        iv.addPointerReleasedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    try {
                        imgPath = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
                        img = Image.createImage(imgPath);                      
                        iv.setImage(img);
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            });
        
        
        
        //END INPUT FIELS

        Button btnModifier = new Button("Ajouter Offre");
        center.addComponent(btnModifier);
       btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                offre= new Offre();
      System.out.print("Test Bouton Ajouter Offre ("+imgPath);
      offre.setTitre(input_titre.getText());
      offre.setDescription(input_desc.getText());
      offre.setImage(imgPath);
      offre.setId_user(9);
           ServiceOffre SO = new ServiceOffre();
              SO.addOffre(offre);
               Form demlist = new myOffres(res);
                  demlist.show();
               
            }
        }); 
        this.addComponent(BorderLayout.CENTER, center);
            this.addCommand(new Command("<-") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                Form bdfa = new OffreForm(res);
                    bdfa.show();
            }
        });

    }
    
}
