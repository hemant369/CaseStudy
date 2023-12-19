package com.hexaware.main;

import java.util.Scanner;

import com.hexaware.controller.EvidenceController;
import com.hexaware.controller.EvidenceInterface;
import com.hexaware.controller.IncidentsController;
import com.hexaware.controller.IncidentsInterface;
import com.hexaware.controller.VictimsController;
import com.hexaware.controller.VictimsInterface;
import com.hexaware.controller.CaseDetailsInterface;
import com.hexaware.exception.AuthorizationException;
import com.hexaware.controller.LawEnforcementAgenciesInterface;
import com.hexaware.controller.OfficersController;
import com.hexaware.controller.OfficersInterface;
import com.hexaware.controller.ReportsController;
import com.hexaware.controller.ReportsInterface;
import com.hexaware.controller.SuspectsController;
import com.hexaware.controller.CaseDetailsController;
import com.hexaware.controller.SuspectsInterface;
import com.hexaware.controller.LawEnforcementAgenciesController;

public class MainModule {

    public static void main(String[] args) {

        System.out.println("Welcome to Crime Analysis and Reporting System");
        System.out.println("----------------------------------------------");
        Scanner sc = new Scanner(System.in);
        String username = "";
        String password = "";
        System.out.println("Enter Admin Username: ");
        username = sc.next();
        System.out.println("Enter Admin Password: ");
        password = sc.next();

        try {
            if (username.equals("hemant") && password.equals("hemant")) {
                IncidentsInterface incidentInterface = new IncidentsController();
                VictimsInterface victimsInterface = new VictimsController();
                LawEnforcementAgenciesInterface lawenforcementagenciesInterface = new LawEnforcementAgenciesController();
                SuspectsInterface suspectsInterface = new SuspectsController();
                OfficersInterface officersInterface = new OfficersController();
                EvidenceInterface evidenceInterface = new EvidenceController();
                ReportsInterface reportsInterface = new ReportsController();
                CaseDetailsInterface casedetailsInterface = new CaseDetailsController();
                String ch = null;

                do {

                    System.out.println("Select an Option: ");
                    System.out.println("1. Incidents: ");
                    System.out.println("2. Victims: ");
                    System.out.println("3. Suspects: ");
                    System.out.println("4. Law Enforcement Agnecies: ");
                    System.out.println("5. Officers: ");
                    System.out.println("6. Evidence: ");
                    System.out.println("7. Reports: ");
                    System.out.println("8. Case Details: ");

                    int m = sc.nextInt();
                    switch (m) {
                        case 0:
                            break;
                        case 1:
                            System.out.println("0. Exit: ");
                            System.out.println("1. Add Incidents: ");
                            System.out.println("2. Get Incidents Details: ");
                            System.out.println("3. Update Incident Status: ");
                            System.out.println("4. Incident Report: ");
                            System.out.println("5. Get Incident Within Date Range: ");
                            int o1 = sc.nextInt();
                            switch (o1) {
                                case 1:
                                    incidentInterface.addIncident();
                                    break;
                                case 2:
                                    incidentInterface.getIncident();
                                    break;
                                case 3:
                                    incidentInterface.updateIncidentStatus();
                                    break;
                                case 4:
                                    incidentInterface.generateIncidentReport();
                                    break;
                                case 5:
                                    incidentInterface.getIncidentsInDate();
                                    break;
                                case 0:
                                    System.out.println("Exiting the Incidents Section");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("0. Exit: ");
                            System.out.println("1. Add Victims Details: ");
                            System.out.println("2. Get Victims Details: ");

                            int o2 = sc.nextInt();
                            switch (o2) {
                                case 1:
                                    victimsInterface.addVictims();
                                    break;
                                case 2:
                                    victimsInterface.getVictims();
                                    break;
                                case 0:
                                    System.out.println("Exiting the Victims Section");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                                    break;
                            }
                            break;
                        case 3:
                            System.out.println("0. Exit: ");
                            System.out.println("1. Add Suspects Details: ");
                            System.out.println("2. Get Suspects Details: ");

                            int o3 = sc.nextInt();
                            switch (o3) {
                                case 1:
                                    suspectsInterface.addSuspects();
                                    break;
                                case 2:
                                    suspectsInterface.getSuspects();
                                    break;
                                case 0:
                                    System.out.println("Exiting Suspects Section");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                                    break;
                            }
                            break;
                        case 4:
                            System.out.println("0. Exit: ");
                            System.out.println("1. Add in Law Agency: ");
                            System.out.println("2. Get Law Agency Details: ");
                            int o4 = sc.nextInt();
                            switch (o4) {
                                case 1:
                                    lawenforcementagenciesInterface.addLawEnforcementAgencies();
                                    break;
                                case 2:
                                    lawenforcementagenciesInterface.getLawEnforcementAgencies();
                                    break;
                                case 0:
                                    System.out.println("Exiting the Law Agency Section");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                                    break;
                            }
                            break;
                        case 5:
                            System.out.println("0. Exit: ");
                            System.out.println("1. Add Officers Details: ");
                            System.out.println("2. Get officers Details: ");

                            int o5 = sc.nextInt();
                            switch (o5) {
                                case 1:
                                    officersInterface.addOfficers();
                                    break;
                                case 2:
                                    officersInterface.getOfficers();
                                    break;
                                case 0:
                                    System.out.println("Exiting Officers Section");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                                    break;
                            }
                            break;
                        case 6:
                            System.out.println("0. Exit: ");
                            System.out.println("1. Add Evidence Details: ");
                            System.out.println("2. Get Evidence Details: ");

                            int o6 = sc.nextInt();
                            switch (o6) {
                                case 1:
                                    evidenceInterface.addEvidence();
                                    break;
                                case 2:
                                    evidenceInterface.getEvidence();
                                    break;
                                case 0:
                                    System.out.println("Exiting Evidence Section");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                                    break;
                            }
                            break;
                        case 7:
                            System.out.println("0. Exit: ");
                            System.out.println("1. Add Reports Details: ");
                            System.out.println("2. Get Reports Details: ");

                            int o7 = sc.nextInt();
                            switch (o7) {
                                case 1:
                                    reportsInterface.addReports();
                                    break;
                                case 2:
                                    reportsInterface.getReports();
                                    break;
                                case 0:
                                    System.out.println("Exiting Reports Section");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                                    break;
                            }
                            break;
                        case 8:
                            System.out.println("0. Exit: ");
                            System.out.println("1. Add Case Details: ");
                            System.out.println("2. Get Case Details: ");
                            System.out.println("3. Update Case Details: ");
                            System.out.println("4. Get All Case Details: ");

                            int o8 = sc.nextInt();
                            switch (o8) {
                                case 1:
                                    casedetailsInterface.addCaseDetails();
                                    break;
                                case 2:
                                    casedetailsInterface.getCaseDetails();
                                    break;
                                case 3:
                                    casedetailsInterface.updateCaseDetails();
                                    break;
                                case 4:
                                    casedetailsInterface.getAllCaseDetails();
                                    break;
                                case 0:
                                    System.out.println("Exiting the Victims Section");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please enter a valid option.");
                                    break;
                            }
                            break;
                    }
                    System.out.println("Do you want to continue? Y | y ");
                    ch = sc.next();
                } while (ch.equals("Y") || ch.equals("y"));
                System.out.println("Thank You for Using Our System!!!");
            } else {
                throw new AuthorizationException();
            }
            
        } catch (AuthorizationException e) {
            System.out.println(e);
        }
    }
}