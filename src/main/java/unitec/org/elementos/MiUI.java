
package unitec.org.elementos;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;



@SpringUI
@Theme ("valo")
public class MiUI extends UI {

    @Autowired RepositorioMensajitos repoMensa;
    @Override
    protected void init(VaadinRequest request) {
        //Agregaremos un layout vertical y dentro de el las componentes
        //que quedaran en order decendete
        VerticalLayout layout=new VerticalLayout();
        Label e1 = new Label("Label");
        e1.addStyleName(ValoTheme.LABEL_H1);
        
        //boton 
        Button b1 = new Button("Guardar");
        b1.addStyleName(ValoTheme.BUTTON_DANGER);
        
        //vamos a programar el evento del boton b1 
        //usando programacion funcional
        b1.addClickListener(algo->{
        //aqui ponemos el envento
        e1.setValue("Programacion funcional"); 
        });
        
        //agregamos los componentes al layout
        layout.addComponent(e1);
        layout.addComponent(b1);
        //Esto solo se hace una vez
        //agregar el layout a la pagina index
        
        List<Mensajitos> mensajitos = (List<Mensajitos>) repoMensa.findAll();
// Create a grid bound to the list
Grid<Mensajitos> grid = new Grid<>();
grid.setItems(mensajitos);
grid.addColumn(Mensajitos::getId).setCaption("ID");
grid.addColumn(Mensajitos::getTitulo).setCaption("Titulo del mensaje");
grid.addColumn(Mensajitos::getCuerpo).setCaption("Puerco del mensaje");
layout.addComponent(grid);
        
        setContent(layout);
    }
    
}
