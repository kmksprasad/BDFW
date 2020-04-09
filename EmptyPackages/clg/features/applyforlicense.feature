Feature: Apply for License

  # author: xxxx
  # written on: 14-11-2016
  # step_def file: NA
  
  @clg @TC-2
  Scenario: Apply for License from Constituent
    Given a user is logged into application with "clfcaseworker" and "rules"
    When Apply for license is initiated from Create Menu
    When user enters Applicant information as follows
      | Key                             | Value                         |
      | SALUTATION                      | Mr                            |
      | LASTNAME                        | Shankar                       |
      | FIRSTNAME                       | Sai                           |
      | MIDDLENAME                      | B                             |
      | MONTH                           | Jan                           |
      | DAY                             |                            21 |
      | YEAR                            |                          1991 |
      | GENDER                          | Male                          |
      | MARTIAL_STATUS                  | Single                        |
      | ADDRESSDETAILS$L1$PADDRESSLINE1 | 7960, Birchwood Avenue        |
      | COUNTRY                         | United States                 |
      | STATE                           | Virginia                      |
      | ADDRESSDETAILS$L1$PCITY         | Wasilla                       |
      | ADDRESSDETAILS$L1$PZIPCODE      |                         99654 |
      | MOBILE                          | (486) 168-1683                |
      | EMAIL                           | telerikautomation@outlook.com |
      | FAX                             | (254) 168-6584                |
    When user selects required category "Marine Harvesting"
    #And user enters some info on screen
    # And user selects required products"Commercial Fishing (Crew)"
    And logout from user portal
