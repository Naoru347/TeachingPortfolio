# Project 1: Campus Club & Event Management

## Overview
In this project, you will practice designing a conceptual data model for a system that manages campus clubs, their members, and the events they organize. Your primary deliverable will be an **Entity-Relationship (ER) diagram** that captures the major entities, their attributes, and the relationships among them.

## Scenario
A community college wants to create a database system to keep track of:

- Multiple student clubs on campus (e.g., coding club, drama club, debate team)  
- Club memberships and leadership roles  
- Planned events (guest lectures, workshops, social gatherings)  
- Event resources (venues, budgets, sponsors)  
- Attendance and feedback from event participants  

You are tasked with designing the conceptual data model for this system. Think about who uses the system, what data is captured, and how the data interrelates.

## Requirements / Business Rules
Use the following requirements to guide your design. If you make additional assumptions not listed here, note them clearly in your documentation.

1. **Clubs**  
   - Each club has a unique name, a founding date, and a short description of its focus.  
   - A club can have zero (especially if it’s newly formed) or many members, and a student can belong to multiple clubs.  
   - Each club has exactly one faculty or staff advisor.  
   - Some clubs also manage a small budget provided by the college for their activities.

2. **Members**  
   - Each member is a student with a unique student ID, name, major, and email address.  
   - A member can be a regular member or hold a specific office/leadership role (President, Treasurer, etc.).  
   - Members may earn “membership points” or similar records for recognition (optional detail you can incorporate).

3. **Events**  
   - Clubs organize events that have a title, date, time, and location.  
   - Each event is linked to exactly one club as its host, but other clubs can be co-sponsors (optional, if you want to model co-sponsorship).  
   - Some events require a budget allocation; others may have zero cost or be covered by sponsors.  
   - Students can sign up to attend events, and attendance is tracked in the system.

4. **Venues**  
   - The campus has multiple venues (rooms, auditoriums, or outdoor spaces).  
   - Each event has exactly one primary venue (though you can note assumptions for multi-location events, if desired).  
   - Venues can be reserved by clubs for specific time slots. The system must ensure no double-bookings.

5. **Sponsorship and Budget**  
   - Clubs can have sponsors (departments, external organizations) providing funds or resources for events.  
   - The database should allow for tracking total sponsorship amounts, if relevant to your design.  
   - Each club’s total expenditures for events should be trackable.

6. **Feedback (Optional)**  
   - After each event, attendees can leave feedback (a rating, short comment, etc.).  
   - This feature is optional and can be included if you want to showcase additional many-to-one or one-to-many relationships.

## What to Deliver

1. **ER Diagram**  
   - **Notation**: You can use either Chen’s or Crow’s Foot notation. Be consistent.  
   - **Entities**: Identify each entity clearly with a name and relevant attributes.  
   - **Relationships**: Show all relationships between entities, label them clearly, and specify cardinalities (e.g., 1-to-M, M-to-N).  
   - **Keys**: Indicate primary keys for each entity. Show foreign keys only if you are comfortable doing so at this stage (though typically we show these in the relational schema).

2. **Assumptions & Explanations**  
   - Provide a short (one-page) explanation of your design choices.  
   - List any assumptions you had to make beyond the stated requirements (e.g., “An event can only have one sponsor,” if that’s how you chose to model it).

3. **Optional**: If time permits or if required by your instructor, you may also:
   - Include sample data for each entity (small data set).  
   - Translate the ER diagram into a preliminary relational schema (table definitions).

## Tools & Format
- **Diagramming Software**: Use any preferred tool (erdplus, Lucidchart, or Visio). Export or embed the final diagram in a PDF/Word document. 
  -  Note: *sample_erd.png* used ERDPlus for its creation and follows **Chen's notation**. 
- **Submission**: Submit your ER diagram in a PDF or image format along with your written assumptions and explanations.  
- **File Naming**: Use a clear file name convention, e.g., `Lastname_Firstname_Project1.pdf`.

## Evaluation Criteria
Your work will be assessed on:

1. **Completeness (40%)** – Have you addressed all key requirements (clubs, members, events, venues, etc.)?  
2. **Accuracy (30%)** – Are the relationships and cardinalities logically correct based on the scenario?  
3. **Clarity & Readability (20%)** – Is the ER diagram easy to read, with clear labels and notations?  
4. **Documentation (10%)** – Did you clearly state assumptions and justify design choices?

## Tips for Success
- Start by listing the entities, their attributes, and relationships in text form before drawing.  
- Double-check cardinalities (1-to-many, many-to-many, etc.)—especially for membership and event attendance.  
- Ensure that every entity has a **primary key**.  
- If you discover a many-to-many relationship (e.g., a student can join multiple clubs, a club can have multiple members), introduce an associative entity (join table) where needed.  
- Ask questions or request clarifications for anything ambiguous. Use logical, real-world assumptions to fill gaps.

**Have fun designing your system, and remember that the goal is to model the information in a clear, logical way that can be implemented later.**
