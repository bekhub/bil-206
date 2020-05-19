package mvc.controllers;

import mvc.models.FirstModel;
import mvc.utils.Action;
import mvc.utils.Function;
import mvc.utils.GraphPoints;
import mvc.utils.Method;
import mvc.views.FirstView;
import mvc.views.GraphPanel;

public class FirstController implements Controller {

    private final FirstModel model;
    private final FirstView view;
    private final GraphPanel panel;

    public FirstController(FirstModel model, FirstView view, GraphPanel panel) {
        this.model = model;
        this.view = view;
        this.panel = panel;
    }

    private void initModel() {
        model.setA(Float.parseFloat(view.getA().getText()));
        model.setB(Float.parseFloat(view.getB().getText()));
        model.setC(Float.parseFloat(view.getC().getText()));
        model.setE(Float.parseFloat(view.getE().getText()));
        model.setEndX(Float.parseFloat(view.getEndX().getText()));
        model.setStartX(Float.parseFloat(view.getStartX().getText()));
        model.setStep(Float.parseFloat(view.getStep().getText()));
    }

    @Override
    public void initController(){
        view.getCalculate().addActionListener(actionEvent -> draw(Action.DRAW));
        view.getFindRoots().addActionListener(actionEvent -> result());
        view.getReset().addActionListener(actionEvent -> reset());
    }

    private void draw(Action action) {
        initModel();
        for(int i = 0; i < view.getRadioButtons().length; i++)
            if(view.getRadioButtons()[i].isSelected()) model.setIndex(i);
        panel.setPreparePoints(() -> {
            panel.setScales();
            Function function = model.getFunction();
            GraphPoints gp = GraphPoints.copyOf(model.getPoints());
            float scaleX = panel.getScaleX();
            float scaleY = panel.getScaleY();
            GraphPoints points = panel.getPoints();
            points.clear();
            for(float i = gp.getX(0) * scaleX; i <= gp.getX(gp.size()-1) * scaleX; i++) {
                points.addXY(i, function.fun(i / scaleX) * scaleY);
            }
        });
        panel.setModel(model);
        panel.setAction(action);
        model.setUp();
    }

    private void result() {
        if (view.getBisectionMethod().isSelected()) {
            panel.setMethod(Method.BISECTION);
        } else {
            panel.setMethod(Method.SECANT);
        }
        draw(Action.RESULT);
    }

    private void reset() {
        panel.setAction(Action.RESET);
        panel.setModel(model);
        model.setUp();
    }
}
