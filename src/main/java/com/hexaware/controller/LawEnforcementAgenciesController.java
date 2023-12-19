package com.hexaware.controller;

import com.hexaware.dao.LawEnforcementAgenciesDao;
import com.hexaware.entity.LawEnforcementAgencies;
import java.util.Scanner;

public class LawEnforcementAgenciesController implements LawEnforcementAgenciesInterface {
     LawEnforcementAgencies lawenforcementagencies;
     Scanner sc = new Scanner(System.in);
     LawEnforcementAgenciesDao lawenforcementagenciesDao = new LawEnforcementAgenciesDao();

     public void addLawEnforcementAgencies() {
          lawenforcementagencies = new LawEnforcementAgencies();

          System.out.println("Add Agency ID:");
          int agencyid = sc.nextInt();
          lawenforcementagencies.setAgencyID(agencyid);

          sc.nextLine();
          System.out.println("Add Agency Name:");
          String agencyname = sc.nextLine();
          lawenforcementagencies.setAgencyName(agencyname);

          System.out.println("Add Jurisdiction:");
          String jurisdiction = sc.next();
          lawenforcementagencies.setJurisdiction(jurisdiction);

          System.out.println("Add Contact Information:");
          String contact = sc.next();
          lawenforcementagencies.setContactInformation(contact);

          System.out.println("Add Officers:");
          String officers = sc.next();
          lawenforcementagencies.setOfficers(officers);

          lawenforcementagenciesDao.insertLawEnforcementAgencies(lawenforcementagencies);
     }

     public void getLawEnforcementAgencies() {
          System.out.println("Enter Agency ID");
          int agencyid = sc.nextInt();

          lawenforcementagenciesDao.showlawenforcementagenciesDao(agencyid);
     }
}
