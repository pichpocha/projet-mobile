/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import APP.CleanModern;
import Entities.Offre;
import Services.ServiceOffre;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
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

/**
 *
 * @author Bechir Hassine
 */
public class EditOffre extends Form {
     final Resources res;
    private Offre Offre;
    static Offre Offres;
    private String assistant="";

    public EditOffre() {
        super("Edit Article", new BorderLayout());
        this.res = CleanModern.stheme;

        
        Container north = new Container(new FlowLayout(Component.CENTER));
        north.setUIID("EditArticleUID");


        Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        center.setUIID("AutoCentre");
        //center.addComponent;
        
        
        
        //INPUT FIELDS 
        
        
        Label titre = new Label("Nouveau Titre : ");
        titre.setUIID("NewDemInfo");
        center.addComponent(titre);
        
        TextField input_titre = new TextField();
       input_titre.setUIID("NewDemInfo");
        center.addComponent(input_titre);
        
         Label desc = new Label("Nouveau Description : ");
        desc.setUIID("NewDemInfo");
        center.addComponent(desc);
        
        TextField input_desc = new TextField();
       input_desc.setUIID("NewDemInfo");
        center.addComponent(input_desc);
        
        Label emplacement = new Label("Nouveau Emplacement : ");
        emplacement.setUIID("NewDemInfo");
        center.addComponent(emplacement);
        
        TextField input_emplacement = new TextField();
       input_emplacement.setUIID("NewDemInfo");
        center.addComponent(input_emplacement);
        
        Label Prix = new Label("Nouveau Prix : ");
        Prix.setUIID("NewDemInfo");
        center.addComponent(Prix);
        
        TextField input_Prix = new TextField();
       input_Prix.setUIID("NewDemInfo");
        center.addComponent(input_Prix);
        
        
        //END INPUT FIELS

        Button btnModifier = new Button("Modifier Article");
        center.addComponent(btnModifier);
       btnModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              Offre=Offres;
              Offre.setTitre(input_titre.getText());
              Offre.setDescription(input_desc.getText());
           ServiceOffre SA = new ServiceOffre();
              SA.editOffre(Offre);
               Form ff = new myOffres(res);
                  ff.show();
               
            }
        }); 
        
       Button btnAdd = new Button("Retour");
            btnAdd.addActionListener(cliqueEvent -> {
                Form bdf = new OffreForm(res);
                  bdf.show();
                });
            north.addComponent(btnAdd);
        this.addComponent(BorderLayout.CENTER, center);
            this.addCommand(new Command("Retour") {

            @Override
            public void actionPerformed(ActionEvent evt) {
                Form bdf = new myOffres(res);
                    bdf.show();
            }
        });

    }
    
}
