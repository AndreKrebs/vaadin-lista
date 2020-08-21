package org.test;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.CheckboxGroup;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.radiobutton.RadioGroupVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.test.classes.Carro;
import org.test.classes.Marca;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The main view contains a button and a click listener.
 */
@Route
@PWA(name = "My Application", shortName = "My Application")
public class MainView extends VerticalLayout {

    private FormLayout form;
    private Button salvar;
    List<Carro> carros;
    Grid<Carro> grid;

    public MainView() {
        carros = Carro.lista();

        Button addNewButton = new Button("Cadastrar novo carro", VaadinIcon.ADD_DOCK.create());
        salvar = new Button("Salvar");

        H2 selecionado = new H2();
        selecionado.setVisible(false);



        grid = new Grid<>(Carro.class);
        grid.setItems(carros);
        grid.setColumns("marca", "modelo", "ano");

        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.addSelectionListener(event -> {

            Carro carro = event.getFirstSelectedItem().get();
            if (carro == null) {
                selecionado.setVisible(false);
            } else {
                selecionado.setText(carro.getModelo() + " / " + carro.getMarca());
                selecionado.setVisible(true);
                loadDataForm(carro);
            }
        });

        addNewButton.addClickListener(click -> {
            loadDataForm(null);
        });

        add(new H1("Lista de carros"));
        add(grid, selecionado, addNewButton);
    }

    private void loadDataForm(Carro carro) {


        TextField campoModelo = new TextField();
        campoModelo.setLabel("Modelo: ");

        ComboBox<String> campoMarca = new ComboBox<>();
        campoMarca.setLabel("Marca: ");
        campoMarca.setItems(Marca.lista());

        IntegerField campoAno = new IntegerField();
        campoAno.setLabel("Ano: ");

        RadioButtonGroup<String> campoCor = new RadioButtonGroup<>();
        campoCor.setLabel("Cor: ");
        campoCor.setItems("Vermelho", "Branco", "Preto", "Amarelo", "Azul");
        campoCor.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);

        CheckboxGroup<String> campoOpcionais = new CheckboxGroup<>();
        campoOpcionais.setLabel("Opcionais: ");
        campoOpcionais.setItems(listaDeOpcionais());


        if (carro != null) {
            campoModelo.setValue(carro.getModelo());
            campoMarca.setValue(carro.getMarca());
            campoAno.setValue(carro.getAno());
            campoCor.setValue(carro.getCor());

            if (carro.getOpcionais().size() > 0) {
                campoOpcionais.setValue(new HashSet<>(
                    carro.getOpcionais().stream()
                        .collect(Collectors.toList())
                ));
            }
            this.remove(salvar);
        } else {
            salvar.addClickListener(click -> {
                Carro novoCarro = new Carro();
                novoCarro.setModelo(campoModelo.getValue());
                novoCarro.setMarca(campoMarca.getValue());
                novoCarro.setCor(campoCor.getValue());
                novoCarro.setAno(campoAno.getValue());

                novoCarro.setOpcionais(campoOpcionais.getValue());

                carros.add(novoCarro);
                grid.setItems(carros);
                grid.getDataProvider().refreshAll();
            });

        }

        if (form != null) {
            this.remove(form);
        }

        form = new FormLayout();
        form.add(campoModelo, campoMarca, campoAno, campoCor, campoOpcionais);
        this.add(form);

        if (carro == null)
            this.add(salvar);

    }

    private List<String> listaDeOpcionais() {
        return Arrays.asList("Farol de neblina", "Teto solar", "Câmera de ré", "Rodas de liga leve");
    }
}
