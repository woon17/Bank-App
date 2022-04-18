# Bank-App

The Bank App is an application where customers can perform banking activities on a regular basis 24/7. It consists of the front-end, which is built using html,css and jsp files where users interact with. The application interacts with the Oracle database via Java Servlets, which is mainly used for logic processing purposes such as performing CRUD operations. Main features of the application include registering and logging in of account, withdrawal of money, checking balance, applying for loan and viewing of statements.

## Table of Contents

- [Bank-App](#bank-app)
  - [Table of Contents](#table-of-contents)
    - [Tools Required](#tools-required)
    - [MVC Design pattern:](#mvc-design-pattern)
    - [Frameworks:](#frameworks)
    - [Database setup](#database-setup)
    - [Feature 1: Registration](#feature-1-registration)
      - [Failure condition:](#failure-condition)
    - [Feature 2: Login](#feature-2-login)
      - [Failure condition:](#failure-condition-1)
    - [Feature 3: Change password](#feature-3-change-password)
      - [Failure condition:](#failure-condition-2)
    - [Feature 4: Check Account Balance](#feature-4-check-account-balance)
    - [Feature 5: View Transaction History](#feature-5-view-transaction-history)
      - [Failure condition:](#failure-condition-3)
    - [Feature 6: Apply Loan: (DEBIT)](#feature-6-apply-loan-debit)
      - [Validation:](#validation)
    - [Feature 7: Withdrawal (CREDIT)](#feature-7-withdrawal-credit)
      - [Validation:](#validation-1)

### Tools Required

All tools required go here. You would require the following tools to develop and run the project:

- A text editor or an IDE (like Eclipse)
- Tomcat v7.0 Server

### MVC Design pattern:

- The Model defines the business layer of the application, the Controller manages the flow of the application, and the View defines the presentation layer of the application.

### Frameworks:

- Hibernate
  - used Hibernate Java-based configuration without using hibernate.cfg.xml to connect oracle database.
  - Reason to choose: Hibernate provides an implementation of the Java Persistence API, that makes it a great choice as an ORM tool with benefits of loose coupling.
- Annotation:

  - Eliminate the need to create mapping (hbm) file. Here, hibernate annotations are used to provide the meta data.
  - @Entity annotation marks this class as an entity.

    ```
    @Entity
    ```

  - @Table annotation specifies the table name where data of this entity is to be persisted. If you don't use @Table annotation, hibernate will use the class name as the table name by default.

    ```
    @Table(name = "CUSTOMERDB")
    ```

  - @Id annotation marks the identifier for this entity

  ```
  @Id // primary key
  ```

  - @Column annotation specifies the details of the column for this property or field. If @Column annotation is not specified, property name will be used as the column name by default.

  ```
  @Column(name = "USERNAME ")
  private String cusUserName;
  ```

  ```
  @Column(name = "NAME")
  private String cusName;
  ```

### Database setup

- CUSTOMERDB

  - | NAME: `varchar` | USERNAME (p_key): `varchar` | PASSWORD: `varchar` | BALANCE: `number` |
    | :-------------: | :-------------------------: | :-----------------: | :---------------: |
    |    WEN SHUFA    |            shufa            |         pwd         |       1000        |

- TRANSACTIONDB
  - | TID: `number` (p_key) | USERNAME:(F_Key) `varchar` | TX_DATE: `date` | TYPE: `varchar` | AMOUNT: `number` | NOTES: `varchar` | STATUS: `varchar` |
    | :-------------------: | :------------------------: | :-------------: | :-------------: | :--------------: | :--------------: | :---------------: |
    |           1           |           shufa            |   14-APR-2022   |      DEBIT      |       1000       |   LOAN REQUEST   |     APPROVED      |

### Feature 1: Registration

> register a new customer and saved to CUSTOMERDB

#### Failure condition:

- Username exist
- Confirm password not match
- Empty fields

### Feature 2: Login

> customer login to choose further action

#### Failure condition:

- Non-existing username
- Invalid username
- Invalid password

### Feature 3: Change password

> customer can change password after login successfully

#### Failure condition:

- Confirm New password not matched
- Old password is wrong
- Old password and new password are the same

### Feature 4: Check Account Balance

> display balance after login as well as displaying updated balance after successful loan & withdrawal

### Feature 5: View Transaction History

> Show Transaction History within the selected Start/End, Date range (inclusive), including “Empty” Transaction History

#### Failure condition:

- Invalid Date Range (E.g. From 29/4/2022 to 1/4/2022)

### Feature 6: Apply Loan: (DEBIT)

> Show Transaction History within the selected Start/End, Date range (inclusive), including “Empty” Transaction History

#### Validation:

- Enter $1 and above as valid loan amount
- Handle negative & zero values

### Feature 7: Withdrawal (CREDIT)

#### Validation:

- Check withdraw amount less than bank balance
- Handle negative values and zero values

## Team Members

#### Wen Shu Fa , See Yu Xiang, Audrey Wong
