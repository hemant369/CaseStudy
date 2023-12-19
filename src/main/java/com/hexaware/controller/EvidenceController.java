package com.hexaware.controller;

import com.hexaware.dao.EvidenceDao;
import com.hexaware.entity.Evidence;
import java.util.Scanner;

public class EvidenceController implements EvidenceInterface {
     Evidence evidence;
     Scanner sc = new Scanner(System.in);
     EvidenceDao evidenceDao = new EvidenceDao();

     public void addEvidence() {
          evidence = new Evidence();

          System.out.println("Add Evidence ID:");
          int evidenceid = sc.nextInt();
          evidence.setEvidenceID(evidenceid);

          sc.nextLine();
          System.out.println("Add Description:");
          String description = sc.nextLine();
          evidence.setDescription(description);

          System.out.println("Add Location Found:");
          String location = sc.next();
          evidence.setLocationFound(location);

          System.out.println("Add Incident ID:");
          int incidentid = sc.nextInt();
          evidence.setIncidentID(incidentid);

          evidenceDao.insertEvidence(evidence);
     }

     public void getEvidence() {
          System.out.println("Enter Evidence ID");
          int evidenceid = sc.nextInt();

          evidenceDao.insertEvidence(evidenceid);
     }
}