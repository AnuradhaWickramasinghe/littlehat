package com.mit.sample;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.HasValue;
import com.vaadin.data.provider.ConfigurableFilterDataProvider;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.data.provider.ListDataProvider;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.*;
import com.vaadin.ui.components.grid.SingleSelectionModel;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Stream;

/**
 * This UI is the application entry point. A UI may either represent a browser window
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@PreserveOnRefresh
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        Label logoLable = new Label();
        logoLable.setIcon(new ThemeResource("Pyxle.logo_small.png"));

        logoLable.setWidth("20%");
        logoLable.setWidth("10px");
        VerticalLayout logos = new VerticalLayout(logoLable);
        logos.setWidth("100%");
        logos.setHeight("10px");
        TextField filter = new TextField("search from test number 4 Host Name");
        VerticalLayout actions = new VerticalLayout();

        GridLayout action = new GridLayout(2, 1);
        action.setColumnExpandRatio(0, 0.99f);
        action.setColumnExpandRatio(1, 0.01f);

        action.setSizeFull();
        actions.setWidth("100%");
        actions.setHeight("15px");
        filter.setWidth("100%");        // actions.setExpandRatio(filter, 1);

        Grid<ServerDetailsNew> grid = new Grid<>();
        VerticalLayout gridContent = new VerticalLayout(grid);
        gridContent.setWidth("100%");
        grid.setWidth("100%");
        grid.setHeight("600px");


        grid.setSelectionMode(Grid.SelectionMode.SINGLE);

        VerticalLayout mainLayout = new VerticalLayout();


        LoadData loadData = new LoadData();
        try {
            List<ServerDetailsNew> load = loadData.load();
            grid.setData(load);
            try {
                grid.setItems(loadData.load());
            } catch (SQLException e) {
                e.printStackTrace();
            }


            Button refresh = new Button("reload");
            refresh.addClickListener(event -> {

                grid.setData(load);
                try {
                    grid.setItems(loadData.load());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                grid.getDataProvider().refreshAll();
                filter.clear();
            });

            filter.addValueChangeListener(event -> {

                //grid.setData(loadS);
                System.out.println(filter.getValue());
                if(filter.getValue().isEmpty()) {
                    grid.setData(load);
                    try {
                        grid.setItems(loadData.load());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    grid.getDataProvider().refreshAll();
                }
                else{
                    try{
                        grid.setItems(loadData.loadSingle(filter.getValue()));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                //grid.getDataProvider().refreshAll();

            });


            action.addComponent(filter);
            action.addComponent(refresh);
            action.setComponentAlignment(refresh, Alignment.BOTTOM_RIGHT);
            actions.addComponent(action);
            /*actions.addComponent(filter);
            actions.addComponent(refresh);*/
            grid.addColumn(ServerDetailsNew::getIp).setCaption("IP Address").setId("IP");
            grid.addColumn(ServerDetailsNew::getServer_memory_used).setCaption("Memory Usage").setId("memory");
            grid.addColumn(ServerDetailsNew::getDisk_used_root).setCaption("Root Mount").setId("root");
            grid.addColumn(ServerDetailsNew::getDisk_used_part1).setCaption("Mount 1 X01").setId("mount1");
            grid.addColumn(ServerDetailsNew::getServer_load_local).setCaption("CPU load").setId("cpuload");
            grid.addColumn(ServerDetailsNew::getServer_ststus).setCaption("Status").setId("status");
            grid.addColumn(ServerDetailsNew::getHostname).setCaption("Host Name").setId("hostname");
            grid.addColumn(ServerDetailsNew::getPt_tomcat_deployment_status).setCaption("FE deployment").setId("fe_status");
            grid.sort("status", SortDirection.DESCENDING);
            System.out.println(grid.getColumn("status").toString());


            grid.setColumnOrder("hostname", "IP", "memory", "root", "mount1", "cpuload","fe_status" ,"status");
            SingleSelectionModel selection = (SingleSelectionModel) grid.getSelectionModel();
            selection.select(grid.getColumn("status"));

            grid.setStyleGenerator(t -> {
                if (t.getServer_ststus().trim().equals("Not Healthy")) {
                    return "error_row";
                } else {
                    return "cool_row";
                }
            });


        } catch (SQLException e) {
            e.printStackTrace();
        }

        mainLayout.addComponent(logos);
        mainLayout.addComponent(actions);
        mainLayout.addComponent(gridContent);

        setContent(mainLayout);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
