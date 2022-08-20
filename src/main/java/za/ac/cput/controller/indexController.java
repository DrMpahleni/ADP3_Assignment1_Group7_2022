package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.contact.ContactType;
import za.ac.cput.domain.contact.EmployeeContact;
import za.ac.cput.domain.employee.Employee;
import za.ac.cput.domain.employee.Job;
import za.ac.cput.domain.employee.Position;
import za.ac.cput.domain.gender.EmployeeGender;
import za.ac.cput.domain.gender.Gender;
import za.ac.cput.domain.menu.Menu;
import za.ac.cput.domain.menu.MenuItem;
import za.ac.cput.domain.race.EmployeeRace;
import za.ac.cput.domain.race.Race;
import za.ac.cput.domain.restaurant.*;
import za.ac.cput.domain.role.*;
import za.ac.cput.domain.supplier.Ingredients;
import za.ac.cput.domain.supplier.Supplier;

import javax.validation.Valid;

@RestController
@RequestMapping("index/")
@Slf4j
public class indexController {

    @RequestMapping("restaurant/employee/")
    public String toEmployee (@Valid @ModelAttribute Employee employee) {
        return "forward:restaurant/employee/";
    }

    @RequestMapping("restaurant/job/")
    public String toEmployee (@Valid @ModelAttribute Job job) {
        return "forward:restaurant/job/";
    }

    @RequestMapping("restaurant/payment/")
    public String toEmployee (@Valid @ModelAttribute Payment payment) {
        return "forward:restaurant/payment/";
    }

    @RequestMapping("restaurant/")
    public String toEmployee (@Valid @ModelAttribute Restaurant restaurant) {
        return "forward:restaurant/";
    }

    @RequestMapping("restaurant/contactType/")
    public String toEmployee (@Valid @ModelAttribute ContactType contactType) {
        return "forward:restaurant/contactType/";
    }

    @RequestMapping("restaurant/employeeContact/")
    public String toEmployee (@Valid @ModelAttribute EmployeeContact employeeContact) {
        return "forward:restaurant/employeeContact/";
    }

    @RequestMapping("restaurant/gender/")
    public String toEmployee (@Valid @ModelAttribute Gender gender) {
        return "forward:restaurant/gender/";
    }

    @RequestMapping("restaurant/employeeGender/")
    public String toEmployee (@Valid @ModelAttribute EmployeeGender employeeGender) {
        return "forward:restaurant/employeeGender/";
    }

    @RequestMapping("restaurant/menu/")
    public String toEmployee (@Valid @ModelAttribute Menu menu) {
        return "forward:restaurant/menu/";
    }

    @RequestMapping("restaurant/menuItem/")
    public String toEmployee (@Valid @ModelAttribute MenuItem menuItem) {
        return "forward:restaurant/menuItem/";
    }

    @RequestMapping("restaurant/supplier/")
    public String toEmployee (@Valid @ModelAttribute Supplier supplier) {
        return "forward:restaurant/supplier/";
    }

    @RequestMapping("restaurant/manager/")
    public String toEmployee (@Valid @ModelAttribute Manager manager) {
        return "forward:restaurant/manager/";
    }

    @RequestMapping("restaurant/receptionist/")
    public String toEmployee (@Valid @ModelAttribute Receptionist receptionist) {
        return "forward:restaurant/receptionist/";
    }

    @RequestMapping("restaurant/customer/")
    public String toEmployee (@Valid @ModelAttribute Customer customer ) {
        return "forward:restaurant/customer/";
    }

    @RequestMapping("restaurant/reservation/")
    public String toEmployee (@Valid @ModelAttribute Reservation reservation) {
        return "forward:restaurant/reservation/";
    }

    @RequestMapping("restaurant/table/")
    public String toEmployee (@Valid @ModelAttribute Table table) {
        return "forward:restaurant/table/";
    }

    @RequestMapping("restaurant/waiter/")
    public String toEmployee (@Valid @ModelAttribute Waiter waiter) {
        return "forward:restaurant/waiter/";
    }

    @RequestMapping("restaurant/chef/")
    public String toEmployee (@Valid @ModelAttribute Chef chef) {
        return "forward:restaurant/chef/";
    }

    @RequestMapping("restaurant/position/")
    public String toEmployee (@Valid @ModelAttribute Position position) {
        return "forward:restaurant/position/";
    }

    @RequestMapping("restaurant/employeeRace/")
    public String toEmployee (@Valid @ModelAttribute EmployeeRace employeeRace) {
        return "forward:restaurant/employeeRace/";
    }

    @RequestMapping("restaurant/race/")
    public String toEmployee (@Valid @ModelAttribute Race race) {
        return "forward:restaurant/race/";
    }

    @RequestMapping("restaurant/ingredients/")
    public String toEmployee (@Valid @ModelAttribute Ingredients ingredients) {
        return "forward:restaurant/ingredients/";
    }

    @RequestMapping("restaurant/order/")
    public String toEmployee (@Valid @ModelAttribute Order order) {
        return "forward:restaurant/order/";
    }

}
