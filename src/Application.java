import controller.DrawController;
import frames.DrawFrame;
import model.DrawModel;

/**
 * @author hemantj
 * @version 0.1
 * @since 15.04.2019.
 */
public class Application {
    public static void main(String[] args) {
        DrawFrame frame = new DrawFrame();
        frame.setVisible(true);
        frame.setTitle("Hemant Joshi Drawing");
        DrawModel model = new DrawModel();
        frame.getView().setModel(model);
        frame.setController(new DrawController(model, frame));
    }
}
