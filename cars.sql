use cars;

CREATE TABLE Incidents (
    IncidentID INT PRIMARY KEY,
    IncidentType VARCHAR(255),
    IncidentDate varchar(255),
    LocationLatitude DECIMAL(9,6),
    LocationLongitude DECIMAL(9,6),
    Descriptions TEXT,
    Status VARCHAR(50),
    VictimID INT ,
    SuspectID INT,
    FOREIGN KEY (VictimID) REFERENCES Victims(VictimID),
    FOREIGN KEY (SuspectID) REFERENCES Suspects(SuspectID)
);
CREATE TABLE Victims (
    VictimID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DateOfBirth varchar(255),
    Gender CHAR(1),
    ContactInformation TEXT
);
CREATE TABLE Suspects (
    SuspectID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DateOfBirth varchar(255),
    Gender CHAR(1),
    ContactInformation TEXT
);
CREATE TABLE LawEnforcementAgencies
 (
    AgencyID INT PRIMARY KEY,
    AgencyName VARCHAR(100),
    Jurisdiction VARCHAR(255),
    ContactInformation TEXT,
    officers varchar(255)
);
CREATE TABLE Officers (
    OfficerID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    BadgeNumber VARCHAR(20),
    Ranks VARCHAR(50),
    ContactInformation TEXT,
    AgencyID INT,
    FOREIGN KEY (AgencyID) REFERENCES LawEnforcementAgencies(AgencyID)
);
CREATE TABLE Evidence (
    EvidenceID INT PRIMARY KEY,
    Descriptions TEXT,
    LocationFound VARCHAR(255),
    IncidentID INT,
    FOREIGN KEY (IncidentID) REFERENCES Incidents(IncidentID)
);
CREATE TABLE Reports (
    ReportID INT PRIMARY KEY,
    IncidentID INT,
    OfficerID INT,
    ReportDate varchar(255),
    ReportDetails TEXT,
    Status VARCHAR(50),
    FOREIGN KEY (IncidentID) REFERENCES Incidents(IncidentID),
    FOREIGN KEY (OfficerID) REFERENCES Officers(OfficerID)
);

create table casedetails (
    caseid INT PRIMARY KEY,
    IncidentID int,
    descriptions text
    )
    
