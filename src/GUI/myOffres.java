/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Offre;
import Services.ServiceOffre;
import com.codename1.ui.util.Resources;


import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;
import java.util.List;
import com.codename1.ui.events.ActionListener;

/**
 *
 * @author Bechir Hassine
 */
public class myOffres extends BaseForm {
    
     public myOffres(Resources res) {
        

        super("Offre", new BorderLayout());

        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Mes Offres");
        getContentPane().setScrollVisible(false);

        super.addSideMenu(res);
        tb.addSearchCommand(e -> {
        });

        Container Blog = new Container(BoxLayout.y());
        Blog.setUIID("List");
        Blog.setScrollableY(true);
        ArrayList<Offre> off = ServiceOffre.getInstance().GetMyOffre(8);
        System.out.println(off);
        Image img = res.getImage("ezezezezezz.jpg");
        if (img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 8);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        Blog.add(LayeredLayout.encloseIn(sl));
        if (off != null) {
            for (Offre o : off) {
                EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(this.getWidth()/2, this.getHeight() / 5, 0xFFFFFFFF), true);
                Image image = URLImage.createToStorage(placeholder, o.getImage(), "http://localhost/untitled/web/Uploads/images/" + o.getImage(), URLImage.RESIZE_SCALE_TO_FILL);
                Container imgC = new Container();
                imgC.add(image);
                MultiButton mb = new MultiButton(o.getTitre());

                mb.setUIID("ListItem");
                mb.setTextLine2("By User Id :"+o.getId_user());
              
              mb.add(LEFT,image);
              mb.addActionListener(new ActionListener()
              { 
              @Override
              public void actionPerformed(ActionEvent evt){
                  mesOffresdForm.Offres=o;
                  
                  Form bdf = new mesOffresdForm();
                  bdf.show();
                  
              }
              });
             
                Blog.add(FlowLayout.encloseCenter(mb));

            }

            this.add(CENTER, Blog);
        }

        // special case for rotation
        /* addButton(res.getImage("news-item-1.jpg"), "Morbi per tincidunt tellus sit of amet eros laoreet.", false, 26, 32);
        addButton(res.getImage("news-item-2.jpg"), "Fusce ornare cursus masspretium tortor integer placera.", true, 15, 21);
        addButton(res.getImage("news-item-3.jpg"), "Maecenas eu risus blanscelerisque massa non amcorpe.", false, 36, 15);
        addButton(res.getImage("news-item-4.jpg"), "Pellentesque non lorem diam. Proin at ex sollicia.", false, 11, 9*/
    }
    
}
