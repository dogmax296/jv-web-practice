package mate.controller.car;

import mate.lib.Injector;
import mate.model.Car;
import mate.service.CarService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllCarsController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Injector injector = Injector.getInstance("mate");
        CarService carService = (CarService) injector.getInstance(CarService.class);
        List<Car> cars = carService.getAll();
        req.setAttribute("cars",cars);
        req.getRequestDispatcher("/WEB-INF/views/cars/all.jsp").forward(req,resp);
    }
}
