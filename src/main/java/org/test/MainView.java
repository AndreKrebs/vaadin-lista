package org.test;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.test.classes.Carro;

/**
 * The main view contains a button and a click listener.
 */
@Route
@PWA(name = "My Application", shortName = "My Application")
public class MainView extends VerticalLayout {

    public MainView() {
        H2 selecionado = new H2();
        selecionado.setVisible(false);

        Grid<Carro> grid = new Grid<>(Carro.class);
        grid.setItems(Carro.lista());
        grid.setColumns("marca", "modelo", "ano");
//        grid.removeColumnByKey("id");

//        grid.getColumnByKey("estado")
//                .setHeader("UF")
//                .setTextAlign(ColumnTextAlign.CENTER)
//                .setWidth("100px");

        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.addSelectionListener(event -> {
            Carro carro = event.getFirstSelectedItem().get();
            if (carro == null) {
                selecionado.setVisible(false);
            } else {
                selecionado.setText(carro.toString());
                selecionado.setVisible(true);
            }
        });

        add(new H1("Lista de carros"));
        add(grid, selecionado);
    }
}
