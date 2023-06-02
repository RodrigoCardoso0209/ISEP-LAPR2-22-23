package pt.ipp.isep.dei.esoft.project.ui;

import pt.ipp.isep.dei.esoft.project.application.controller.PublishAnnouncementController;
import pt.ipp.isep.dei.esoft.project.application.controller.authorization.AuthenticationController;
import pt.ipp.isep.dei.esoft.project.domain.*;
import pt.ipp.isep.dei.esoft.project.repository.*;

import java.util.Date;

public class Bootstrap implements Runnable {
    private Employee agent = null;


    //Add some task categories to the repository as bootstrap
    public void run() {
        addRoles();
        addAgencies();
        addUsers();
        addEmployees();
        addProperties();
        addTypeBusiness();
        addPropertyTypes();
        addOwner();
        addRequests();
        //addAnnouncements();
        //addVisit();
    }

    private void addOwner() {
        OwnerRepository ownerRepository = Repositories.getInstance().getOwnerRepository();
        ownerRepository.add(new Owner("owner@this.app"));
    }

    private void addEmployees() {
        EmployeeRepository employeeRepository = Repositories.getInstance().getEmployeeRepository();
        employeeRepository.add(new Employee("admin@this.app"));
        employeeRepository.add(new Employee("storemanager@this.app"));
        employeeRepository.add(new Employee("agent@this.app"));
    }


    private void addAgencies() {
        //TODO: add bootstrap Agencies here

        //get agency repository
        AgencyRepository agencyRepository = Repositories.getInstance().getAgencyRepository();
        agencyRepository.add(new Agency(1234, "Agency Name", "Power Street", "realestateagency@gmail.com", "(567) 456-2345", new Employee("admin@this.app")));
    }

    private void addProperties() {
        // TODO: add boostrap Properties


        // get agency Proprety

        PropertyRepository propertyRepository = Repositories.getInstance().getPropertyRepository();
        propertyRepository.add(new Land(new PropertyType("Land"), 123, new Location("Lol Street", "Porto", "Portugal", 12345), 23, new Owner("owner@this.app")));
        propertyRepository.add(new Apartment(new PropertyType("Apartment"), 123, new Location("God Street", "Porto", "Portugal", 12345), 23, 3, 3, 1, false, true, new Owner("owner@this.app")));
        propertyRepository.add(new House(new PropertyType("House"), 90, new Location("Rua Professor Laurentino Monteiro", "Póvoa de Varzim", "Porto", 14490), 37, 3, 2, 1, true, true, true, true, "N", new Owner("owner@this.app")));
    }

    private void addRoles() {
        //TODO: add bootstrap Roles here

        //get role repository
        RoleRepository roleRepository = Repositories.getInstance().getRoleRepository();
        roleRepository.add(new Role("Agent"));
    }

    private void addUsers() {
        //TODO: add Authentication users here: should be created for each user in the organization
        AuthenticationRepository authenticationRepository = Repositories.getInstance().getAuthenticationRepository();
        authenticationRepository.addUserRole(AuthenticationController.ROLE_ADMIN, AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_AGENT, AuthenticationController.ROLE_AGENT);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_OWNER, AuthenticationController.ROLE_OWNER);
        authenticationRepository.addUserRole(AuthenticationController.ROLE_CLIENT, AuthenticationController.ROLE_CLIENT);


        authenticationRepository.addUserWithRole("Main Administrator", "admin@this.app", "admin", AuthenticationController.ROLE_ADMIN);
        authenticationRepository.addUserWithRole("Agent", "agent@this.app", "agent", AuthenticationController.ROLE_AGENT);
        authenticationRepository.addUserWithRole("Owner", "owner@this.app", "owner", AuthenticationController.ROLE_OWNER);
        authenticationRepository.addUserWithRole("Client", "client@this.app", "client", AuthenticationController.ROLE_CLIENT);

    }

    private void addTypeBusiness() {
        TypeBusinessRepository typeBusinessRepository = Repositories.getInstance().getTypeBusinessRepository();

        typeBusinessRepository.add(new TypeBusiness("Sell"));
        typeBusinessRepository.add(new TypeBusiness("Rent"));
    }

    private void addPropertyTypes() {
        PropertyTypeRepository propertyTypeRepository = Repositories.getInstance().getPropertyTypeRepository();

        propertyTypeRepository.add(new PropertyType("Land"));
        propertyTypeRepository.add(new PropertyType("Apartment"));
        propertyTypeRepository.add(new PropertyType("House"));
    }

    private void addRequests() {
        RequestRepository savedRequests = Repositories.getInstance().getRequestRepository();
       Owner owner = new Owner("owner@gmail.com");
        Property property = new Property(200);
        TypeBusiness typeBusiness = new TypeBusiness("Sale");


        Request request1 = new Request(property, typeBusiness, 500, owner);
        savedRequests.add(request1);
    }

    private void addAnnouncements() {
        AnnouncementRepository announcementRepository = Repositories.getInstance().getAnnouncementRepository();

        //AnnouncementRequest announcementRequest = new AnnouncementRequest( new House(( new PropertyType("House")) , 120, new Location("Rua Professor Laurentino Monteiro", "Póvoa de Varzim", "Porto", 12345), 12, 3, 2, 1, true, false, true, true, "N", new Owner("owner@this.app")) , 3000.0 , "Sell" );
        Repositories.getInstance().getAnnouncementRepository().addAnnouncement(new Announcement(new Request(new House( new PropertyType("House") , 120, new Location("Rua Professor Laurentino Monteiro", "Póvoa de Varzim", "Porto", 12345), 12, 3, 2, 1, true, false, true, true, "N", new Owner("owner@this.app")), new TypeBusiness("Sell") ,130000, new Owner("owner@this.app")), new Commission("percentage", 5), new Date(2023,05,31)));



        //announcement 1
        Announcement announcement = new Announcement(new Request(new House( new PropertyType("House") , 120, new Location("Rua Professor Laurentino Monteiro", "Póvoa de Varzim", "Porto", 12345), 12, 3, 2, 1, true, false, true, true, "N", new Owner("owner@this.app")), new TypeBusiness("Sell") ,130000, new Owner("owner@this.app")), new Commission("percentage" , 5), new Date(2023,05,31));
        announcementRepository.addAnnouncement(announcement);

        Repositories.getInstance().getAnnouncementRepository().addAnnouncement(announcement);
        //Repositories.getInstance().getRequestRepository().addRequests();

        //agent.addAnnouncements();

    }

    /*private void addVisit() {
        VisitRepository visitRepository = Repositories.getInstance().getVisitRepository();

        VisitRequest visitRequest;
        visitRequest = new VisitRequest( new Announcement(new Request(new House( new PropertyType("House") , 120, new Location("Rua Professor Laurentino Monteiro", "Póvoa de Varzim", "Porto", 12345), 12, 3, 2, 1, true, false, true, true, "N", new Owner("owner@this.app")), new TypeBusiness("Sell") ,130000, new Owner("owner@this.app")), new Commission("percentage" , 5), new Date(2023,05,31)),"Owner1" , "932414522", "31/05" , 15-16 , "I want to visit this porperty.");

        visitRepository.addRequests(visitRequest);
    }*/

}


