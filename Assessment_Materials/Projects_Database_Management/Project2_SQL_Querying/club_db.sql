-- -------------------------------------------------------
-- 1) Create and select the database
-- -------------------------------------------------------
DROP DATABASE IF EXISTS campus_club;
CREATE DATABASE campus_club;
USE campus_club;

-- -------------------------------------------------------
-- 2) Create Tables
-- -------------------------------------------------------

-- A) Clubs
CREATE TABLE clubs (
    club_id INT AUTO_INCREMENT PRIMARY KEY,
    club_name VARCHAR(100) NOT NULL,
    founding_date DATE,
    description VARCHAR(255),
    advisor_name VARCHAR(100),
    club_budget DECIMAL(10,2) DEFAULT 0.00
);

-- B) Members (Students)
CREATE TABLE members (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    major VARCHAR(100),
    email VARCHAR(100)
);

-- C) Membership (Associative entity: which student joins which club)
CREATE TABLE membership (
    membership_id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT NOT NULL,
    club_id INT NOT NULL,
    role VARCHAR(50),          -- e.g., President, Treasurer, etc.
    FOREIGN KEY (student_id) REFERENCES members(student_id),
    FOREIGN KEY (club_id) REFERENCES clubs(club_id)
);

-- D) Venues
CREATE TABLE venues (
    venue_id INT AUTO_INCREMENT PRIMARY KEY,
    venue_name VARCHAR(100) NOT NULL,
    capacity INT NOT NULL,
    location VARCHAR(100)
);

-- E) Events
CREATE TABLE events (
    event_id INT AUTO_INCREMENT PRIMARY KEY,
    event_name VARCHAR(100) NOT NULL,
    event_date DATE NOT NULL,
    event_time TIME,
    club_id INT NOT NULL,                -- hosting club
    venue_id INT NOT NULL,
    budget_allocated DECIMAL(10,2) DEFAULT 0.00,
    FOREIGN KEY (club_id) REFERENCES clubs(club_id),
    FOREIGN KEY (venue_id) REFERENCES venues(venue_id)
);

-- F) Attendance (who attended which event)
CREATE TABLE attendance (
    attendance_id INT AUTO_INCREMENT PRIMARY KEY,
    event_id INT NOT NULL,
    student_id INT NOT NULL,
    feedback_rating INT,             -- optional rating
    feedback_comment VARCHAR(255),   -- optional comment
    FOREIGN KEY (event_id) REFERENCES events(event_id),
    FOREIGN KEY (student_id) REFERENCES members(student_id)
);

-- G) Sponsors (entities that provide funds/resources to clubs)
CREATE TABLE sponsors (
    sponsor_id INT AUTO_INCREMENT PRIMARY KEY,
    sponsor_name VARCHAR(100) NOT NULL,
    contact_email VARCHAR(100),
    sponsor_type VARCHAR(50)         -- e.g., "Department", "Company"
);

-- H) Sponsorship (which sponsor supports which club, with how much)
CREATE TABLE sponsorship (
    sponsorship_id INT AUTO_INCREMENT PRIMARY KEY,
    sponsor_id INT NOT NULL,
    club_id INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (sponsor_id) REFERENCES sponsors(sponsor_id),
    FOREIGN KEY (club_id) REFERENCES clubs(club_id)
);

-- -------------------------------------------------------
-- 3) Insert Base Data
-- -------------------------------------------------------

-- A) Insert clubs (10 clubs as an example)
INSERT INTO clubs (club_name, founding_date, description, advisor_name, club_budget)
VALUES 
('Coding Club',       '2020-09-01', 'Focuses on programming projects and hackathons', 'Dr. Smith',  1000.00),
('Drama Society',     '2019-08-15', 'Organizes plays and theater workshops',          'Ms. Johnson', 800.00),
('Debate Team',       '2021-01-10', 'Competitive debates and public speaking',        'Dr. Turner',  500.00),
('Art & Design Club', '2022-03-05', 'Workshops on painting, sketching, digital art',   'Prof. Brooks',750.00),
('Music Club',        '2020-10-10', 'Jam sessions, band formation, and open mics',     'Mr. Lopez',   600.00),
('Eco Warriors',      '2021-04-22', 'Environmental awareness and sustainability',      'Dr. Green',   400.00),
('Robotics Society',  '2018-11-11', 'Robot building and competitions',                 'Dr. Millar',  1200.00),
('Math Club',         '2018-09-09', 'Math competitions and tutoring',                  'Ms. Clark',   300.00),
('Film Appreciation', '2019-07-20', 'Film screenings and discussions',                 'Prof. Nolan', 450.00),
('Entrepreneur Club', '2021-06-01', 'Business plan development and pitch events',       'Mr. Davis',   900.00);

-- B) Insert venues
INSERT INTO venues (venue_name, capacity, location)
VALUES
('Main Auditorium',   300, 'Building A'),
('Library Hall',      100, 'Library'),
('Outdoor Quad',      500, 'Central Campus'),
('Conference Room 1',  50, 'Building B'),
('Student Lounge',    120, 'Student Center');

-- C) Insert sponsors
INSERT INTO sponsors (sponsor_name, contact_email, sponsor_type)
VALUES
('Tech Corp',         'partner@techcorp.com',  'Company'),
('Local Bank',        'finance@localbank.org', 'Company'),
('Student Affairs',   'affairs@example.edu',   'Department'),
('Fine Arts Dept.',   'arts@example.edu',      'Department'),
('Green Initiative',  'info@greeninit.org',    'Company'),
('Media Group',       'media@example.org',     'Company'),
('CS Department',     'csdept@example.edu',    'Department'),
('Business School',   'bizschool@example.edu', 'Department'),
('Engineering Fund',  'engfund@example.org',   'Company'),
('Community Outreach','outreach@example.org',  'Company');

-- D) Optional: Sponsor–Club relationships
INSERT INTO sponsorship (sponsor_id, club_id, amount) VALUES
(1, 1,  200.00),  -- Tech Corp sponsors Coding Club
(1, 7,  300.00),  -- Tech Corp also sponsors Robotics Society
(2, 10, 500.00),  -- Local Bank sponsors Entrepreneur Club
(3, 2,  100.00),  -- Student Affairs supports Drama Society
(4, 4,  150.00),  -- Fine Arts Dept. sponsors Art & Design Club
(5, 6,  200.00),  -- Green Initiative sponsors Eco Warriors
(6, 9,  250.00),  -- Media Group supports Film Appreciation
(7, 1,  300.00),  -- CS Department also helps Coding Club
(8, 10, 400.00),  -- Business School for Entrepreneur Club
(9, 7,  600.00),  -- Engineering Fund for Robotics Society
(10,2,  100.00),  -- Community Outreach for Drama Society
(3, 3,  150.00);  -- Student Affairs for Debate Team

-- -------------------------------------------------------
-- 4) Bulk-Insert Large Sets of Rows
-- -------------------------------------------------------
--
-- We’ll generate a larger set of members and events using MySQL loops:
--  - 100 members
--  - 20 events
--  - 150 membership records (random distribution)
--  - 200 attendance records

-- Some MySQL environments require adjusting delimiter to allow procedural code
DELIMITER $$
 
-- Create a helper table of numbers (1..200) to drive inserts
DROP TABLE IF EXISTS num_seq;
CREATE TABLE num_seq (n INT PRIMARY KEY);

-- Fill num_seq with values 1 to 200
SET @counter = 1;
WHILE @counter <= 200 DO
  INSERT INTO num_seq (n) VALUES (@counter);
  SET @counter := @counter + 1;
END WHILE;

-- A) Insert 100 Members
DROP PROCEDURE IF EXISTS bulk_insert_members;
CREATE PROCEDURE bulk_insert_members()
BEGIN
  DECLARE v_first_name VARCHAR(50);
  DECLARE v_last_name  VARCHAR(50);
  DECLARE v_major      VARCHAR(100);
  DECLARE v_email      VARCHAR(100);
  
  -- Loop from 1 to 100 using num_seq
  DECLARE done INT DEFAULT FALSE;
  DECLARE cur CURSOR FOR SELECT n FROM num_seq WHERE n <= 100;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  
  OPEN cur;
  member_loop: LOOP
    FETCH cur INTO @i;
    IF done THEN
      LEAVE member_loop;
    END IF;
    
    SET v_first_name = CONCAT('Student', @i);
    SET v_last_name  = CONCAT('Last', @i);
    SET v_major      = (CASE 
                          WHEN @i % 3 = 0 THEN 'Computer Science'
                          WHEN @i % 3 = 1 THEN 'Business'
                          ELSE 'Art and Design'
                        END);
    SET v_email      = CONCAT('student', @i, '@example.edu');
    
    INSERT INTO members(student_id, first_name, last_name, major, email)
    VALUES(
      1000 + @i, 
      v_first_name, 
      v_last_name, 
      v_major, 
      v_email
    );
  END LOOP;
  CLOSE cur;
END$$

CALL bulk_insert_members();

-- B) Insert 20 Events
DROP PROCEDURE IF EXISTS bulk_insert_events;
CREATE PROCEDURE bulk_insert_events()
BEGIN
  DECLARE v_event_name VARCHAR(100);
  
  DECLARE done INT DEFAULT FALSE;
  DECLARE cur CURSOR FOR SELECT n FROM num_seq WHERE n <= 20;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  
  OPEN cur;
  event_loop: LOOP
    FETCH cur INTO @i;
    IF done THEN
      LEAVE event_loop;
    END IF;
    
    SET v_event_name = CONCAT('Event ', @i);
    
    -- We'll randomly pick a hosting club (between 1 and 10) and a venue (between 1 and 5)
    INSERT INTO events(event_name, event_date, event_time, club_id, venue_id, budget_allocated)
    VALUES(
      v_event_name,
      DATE_ADD('2024-01-01', INTERVAL @i DAY),         -- e.g., event on subsequent days
      ADDTIME('10:00:00', MAKETIME(FLOOR(RAND()*12), 0, 0)),  -- random time between 10:00 and 22:00
      FLOOR(1 + RAND()*10),                           -- random club_id between 1 and 10
      FLOOR(1 + RAND()*5),                            -- random venue_id between 1 and 5
      (50 + RAND()*300)                               -- random budget between 50 and 350
    );
  END LOOP;
  CLOSE cur;
END$$

CALL bulk_insert_events();

-- C) Insert 150 Membership records
DROP PROCEDURE IF EXISTS bulk_insert_membership;
CREATE PROCEDURE bulk_insert_membership()
BEGIN
  DECLARE done INT DEFAULT FALSE;
  DECLARE cur CURSOR FOR SELECT n FROM num_seq WHERE n <= 150;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  
  OPEN cur;
  membership_loop: LOOP
    FETCH cur INTO @i;
    IF done THEN
      LEAVE membership_loop;
    END IF;
    
    -- We'll pick a random student (IDs: 1001..1100) 
    -- and a random club (1..10). There's a chance of duplicates, 
    -- so for a real scenario you may want to handle that.
    INSERT INTO membership(student_id, club_id, role)
    VALUES(
      FLOOR(1001 + RAND()*100),           -- random student ID
      FLOOR(1 + RAND()*10),              -- random club ID
      CASE WHEN RAND() < 0.05 THEN 'President'
           WHEN RAND() < 0.1  THEN 'Treasurer'
           ELSE 'Member'
      END
    );
  END LOOP;
  CLOSE cur;
END$$

CALL bulk_insert_membership();

-- D) Insert 200 Attendance records
DROP PROCEDURE IF EXISTS bulk_insert_attendance;
CREATE PROCEDURE bulk_insert_attendance()
BEGIN
  DECLARE done INT DEFAULT FALSE;
  DECLARE cur CURSOR FOR SELECT n FROM num_seq WHERE n <= 200;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  
  OPEN cur;
  attendance_loop: LOOP
    FETCH cur INTO @i;
    IF done THEN
      LEAVE attendance_loop;
    END IF;
    
    -- We'll pick a random event (IDs: 1..20) 
    -- and a random student (IDs: 1001..1100)
    INSERT INTO attendance(event_id, student_id, feedback_rating, feedback_comment)
    VALUES(
      FLOOR(1 + RAND()*20),   -- random event
      FLOOR(1001 + RAND()*100), -- random student
      FLOOR(1 + RAND()*5),      -- rating 1..5
      CONCAT('Feedback #', @i)
    );
  END LOOP;
  CLOSE cur;
END$$

CALL bulk_insert_attendance();

DELIMITER ;
