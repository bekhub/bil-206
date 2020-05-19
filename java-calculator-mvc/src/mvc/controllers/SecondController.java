package mvc.controllers;

import mvc.models.Model;
import mvc.utils.Action;
import mvc.views.GraphPanel;
import mvc.views.SecondView;

public class SecondController implements Controller {

    private final Model model;
    private final SecondView view;
    private final GraphPanel panel;

    public SecondController(Model model, SecondView view, GraphPanel panel) {
        this.model = model;
        this.view = view;
        this.panel = panel;
    }

    @Override
    public void initController() {
        view.getButtonReset().addActionListener(actionEvent -> reset());
    }

    private void reset() {
        panel.setModel(model);
        panel.setAction(Action.RESET);
        model.setUp();
    }
}
