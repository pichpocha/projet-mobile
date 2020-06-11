/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Offre;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import APP.CleanModern;
import Services.ServiceOffre;
import com.codename1.ui.Button;

import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionListener;

/**
 *
 * @author Bechir Hassine
 */
public class OffresdForm extends Form {
    final Resources res;
    static Offre Offres;
    private Offre Offre;

    public OffresdForm() {
        super("Details Autorisation", new BorderLayout());
        this.res = CleanModern.stheme;
        this.Offre = Offres;
        System.out.println(Offre);

        
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
        

        

        Label iduser = new Label("ID : "+Offre.getId_user());
        iduser.setUIID("AutoInfo");
        center.addComponent(iduser);

        Label descr = new Label("Description: ");
        descr.setUIID("AutoInfo");
        center.addComponent(descr);
        
        TextArea desc = new TextArea(Offre.getDescription());
        desc.setUIID("AutoInfo");
        center.addComponent(desc);
        
        Label emplacement = new Label("Emplacement: ");
        emplacement.setUIID("AutoInfo");
        center.addComponent(emplacement);
        
        TextArea emplacementi = new TextArea(Offre.getEmplacement());
        emplacementi.setUIID("AutoInfo");
        center.addComponent(emplacementi);
        
        Label prix = new Label("Prix: ");
        prix.setUIID("AutoInfo");
        center.addComponent(prix);
        String s=String.valueOf(Offre.getPrix());  
        TextArea input_prix = new TextArea(s);
        input_prix.setUIID("AutoInfo");
        center.addComponent(input_prix);
         Button btnAdd = new Button("Retour");
            btnAdd.addActionListener(cliqueEvent -> {
                Form bdf = new OffreForm(res);
                  bdf.show();
                });
            north.addComponent(btnAdd);
            
//             Button btnshare = new Button("Share Offre");
//        center.addComponent(btnshare);
//       btnshare.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                ServiceOffre SO = new ServiceOffre();
//               SO.ShareFaceBook(Offre.getId_offre(),Offre.getTitre(),Offre.getImage());
//               
//               
//            }
//        });
          
        
        this.addComponent(BorderLayout.CENTER, center);
            this.addCommand(new Command("Retour") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                Form bdfa = new OffreForm(res);
                    bdfa.show();
            }
        });

    }
    
}
