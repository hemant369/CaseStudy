use cars;

CREATE TABLE Incidents (
    IncidentID INT PRIMARY KEY,
    IncidentType VARCHAR(255),
    IncidentDate DATE,
    Latitude DECIMAL(9,6),
    Longitude DECIMAL(9,6),
    Descriptions TEXT,
    Statusof VARCHAR(50),
    VictimID INT ,
    SuspectID INT,
    FOREIGN KEY (VictimID) REFERENCES Victims(VictimID),
    FOREIGN KEY (SuspectID) REFERENCES Suspects(SuspectID)
);
CREATE TABLE Victims (
    VictimID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DateOfBirth DATE,
    Gender CHAR(1),
    ContactInformation TEXT
);
CREATE TABLE Suspects (
    SuspectID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DateOfBirth DATE,
    Gender CHAR(1),
    ContactInformation TEXT
);
 (
    AgencyID INT PRIMARY KEY,
    AgencyName VARCHAR(100),
    Jurisdiction VARCHAR(255),
    ContactInformation TEXT
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
)
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
    ReportDate DATE,
    ReportDetails TEXT,
    Statusof VARCHAR(50),
    FOREIGN KEY (IncidentID) REFERENCES Incidents(IncidentID),
    FOREIGN KEY (OfficerID) REFERENCES Officers(OfficerID)
);

create table casedetails (
	caseid INT PRIMARY KEY,
    IncidentID int,
    descriptions text
    )
    
